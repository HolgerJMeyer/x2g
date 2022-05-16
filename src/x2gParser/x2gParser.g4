parser grammar x2gParser;

@header {
//package x2g;
import java.util.*;
}

options {
	tokenVocab = x2gLexer;
}

@members {
	SymbolTable symtab;
	boolean verbose;

	// overload costructor
	public x2gParser(TokenStream input, SymbolTable symtab, boolean verbose) {
		this(input);
		this.symtab = symtab;
		this.verbose = verbose;
	}

	public x2gParser(TokenStream input, SymbolTable symtab) {
		this(input, symtab, false);
	}
}

/*
 * Expression types
 */
x2g
	: x2g_rule*
	;

x2g_rule
	: MATCH {
		symtab.newScope("match");
	  } bind_expr_list '{' body '}' {
		symtab.endScope();
	  }
	;

bind_expr_list
	: bind_expr (',' bind_expr)*
	;

bind_expr
	: b=(XPATH|NODE|EDGE) '(' string_expr ')' USING '$' ID {
		if (verbose) notifyErrorListeners($b.text + " variable $" + $ID.text + " bound to " + $string_expr.text);
		if (symtab.resolve($ID.text) != null)
			notifyErrorListeners("binding $" + $ID.text + " hides earlier one!");
		switch ($b.text) {
		case "XPATH":
			symtab.define($ID.text, VarType.XPATH, $string_expr.text);
			break;
		case "NODE":
			symtab.define($ID.text, VarType.NODE, $string_expr.text);
			break;
		case "EDGE":
			symtab.define($ID.text, VarType.EDGE, $string_expr.text);
			break;
		}
	  }
	;

body
	: body_action (',' body_action)*
	;

body_action
	: create_node
	| create_edge
	| if_stmt
	| x2g_rule
	| /* epsilon */
	;

create_node
	: CREATE NODE '$' ID LABEL string_expr {
		if (verbose) notifyErrorListeners("node set variable $" + $ID.text + " labeled " + $string_expr.text);
		if (symtab.resolve($ID.text) != null)
			notifyErrorListeners("binding $" + $ID.text + " hides earlier one!");
		symtab.define($ID.text, VarType.NODE);
		symtab.newScope("node.properties");
		symtab.define("__label", VarType.PROPERTY, $string_expr.text);
	  } '{' property_assignment_list '}' {
		symtab.endScope();
	  }
	;

create_edge
	: CREATE EDGE '$' n0=ID FROM '$' n1=ID TO '$'n2=ID LABEL string_expr {
		if (verbose) notifyErrorListeners("edgeset variable $" + $n0.text + " labeled " + $string_expr.text);
		if (symtab.resolve($n0.text) != null)
			notifyErrorListeners("binding $" + $n0.text + " hides earlier one!");
		if (symtab.resolve($n1.text) == null)
			notifyErrorListeners("nodeset variable  " + $n1.text + " undefined!");
		if (symtab.resolve($n2.text) == null)
			notifyErrorListeners("nodeset variable  " + $n1.text + " undefined!");
		symtab.define($n0.text, VarType.EDGE);
		symtab.newScope("edge.properties");
		symtab.define("__label", VarType.PROPERTY, $string_expr.text);
		symtab.define("__from", VarType.PROPERTY, $n1.text);
		symtab.define("__to", VarType.PROPERTY, $n2.text);
	  } '{' property_assignment_list '}' {
		symtab.endScope();
	  }
	;

if_stmt
	: IF '(' boolean_expr ')' '{' body_action '}'
	;

property_assignment_list
	: property_assignment (',' property_assignment)*
	;

property_assignment
	: property_name_expr
	| property_unique
	| property_if
	;

property_name_expr
	: ID '=' expr {
		if (verbose) notifyErrorListeners("property " + $ID.text + "=" + $expr.text);
		if (symtab.resolveOnly($ID.text) != null)
			notifyErrorListeners("property " + $ID.text + " overidden!");
		symtab.define($ID.text, VarType.PROPERTY, $expr.text);
	  }
	;

property_unique
	: UNIQUE '(' property_name_list ')' {
		if (verbose) notifyErrorListeners("unique constraint found: " + $property_name_list.text);
		if (symtab.resolveOnly("__unique") != null)
			notifyErrorListeners("unique constraint (" + $property_name_list.text + ") redefines earlier one!");
		symtab.define("__unique", VarType.PROPERTY, $property_name_list.text);
		for (String prop : $property_name_list.text.split(","))
			if (symtab.resolveOnly(prop) == null)
				notifyErrorListeners("unique constraint: property " + prop + " unknown!");
	  }
	;

property_if
	: IF '(' boolean_expr ')' '{' property_assignment_list '}'
	;
	
property_name_list
	: ID (',' ID)*
	;

// TODO: not used at the moment, untyped properties
property_type
	: STRING
	| DATE
	| NUMERIC
	| BOOLEAN
	| SETOF '(' property_type ')'
	| TUPLEOF '(' property_type ')'
	;

// SECTION: expressions
boolean_expr
	: boolean_expr op=AND boolean_expr		#boolAndOr
	| boolean_expr op=OR boolean_expr		#boolAndOr
	| NOT '(' boolean_expr ')'					#boolNot
	| '(' boolean_expr ')'						#boolParens
	| BOOL											#boolLiteral
	| expr op=(LT|GT|LE|GE|EQ|NEQ) expr		#boolRelop
	;

expr
	: MINUS expr							#unaryExpr
	| expr op=(MULT|DIV) expr			#arithExpr
	| expr op=(PLUS|MINUS) expr		#arithExpr
	| '(' expr ')'							#parensExpr
	| eval_expr								#evalExpr
	| literal_expr							#literalExpr
	; 


eval_expr
	: xpath_expr
	| prop_expr
	;

xpath_expr
	: '$' v=ID ('.' XPATH '(' x=string_expr ')')? {
		// TODO: optionalen teil .xpath(...) testen!
		if (symtab.resolve($v.text) == null)
			notifyErrorListeners("xml fragment variable $" + $v.text + " is unbound!");
	  }
	;

prop_expr
	: '$' v=ID '.' p=ID {
		// TODO: optionales .<property>, wenn nicht, dann implizit .__label?
		if (symtab.resolve($v.text) == null)
			notifyErrorListeners("node or edge variable $" + $v.text + " is unbound!");
	  }
	;

literal_expr
	: STR				#literalString
	| DATETIME		#literalDate
	| NUMBER			#literalNumber
	| BOOL			#literalBool
	;

/*
 * string_expr ausdifferenzieren, string-expr als parameter in xpath() anders als evaluierung string
 */
string_expr
	: string_expr PLUS string_expr	#stringConcat
	| eval_expr								#stringEval
	| STR										#stringSTR
	;

// vim: ff=unix ts=3 sw=3 sts=3 noet
