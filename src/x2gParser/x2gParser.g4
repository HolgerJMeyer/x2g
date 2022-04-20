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
	: x2g_rule* {
		if (verbose) System.err.println("Symtab[[" + symtab + "]]");
	  }
	;

x2g_rule
	: MATCH {
		symtab.newScope("match-" + $MATCH.line);
	  } bind_expr_list '{' body '}' {
		if (verbose) notifyErrorListeners("ending scope: " + symtab.getCurrentScope().toString());
		symtab.endScope();
	  }
	;

bind_expr_list
	: bind_expr (',' bind_expr)*
	;

bind_expr
	: XPATH '(' string_expr ')' USING '$' ID {
		if (verbose) notifyErrorListeners("xpath variable $" + $ID.text + " bound to " + $string_expr.text);
		if (symtab.resolve($ID.text) != null)
			notifyErrorListeners("binding $" + $ID.text + " hides earlier one!");
		symtab.define($ID.text, VarType.XPATH, $string_expr.text);
	  }
	| NODE '(' string_expr ')' USING '$' ID {
		if (verbose) notifyErrorListeners("node variable $" + $ID.text + " bound to " + $string_expr.text);
		if (symtab.resolve($ID.text) != null)
			notifyErrorListeners("binding $" + $ID.text + " hides earlier one!");
		symtab.define($ID.text, VarType.NODE, $string_expr.text);
	  }
	| EDGE '(' string_expr ')' USING '$' ID {
		if (verbose) notifyErrorListeners("edge variable $" + $ID.text + " bound to " + $string_expr.text);
		if (symtab.resolve($ID.text) != null)
			notifyErrorListeners("binding $" + $ID.text + " hides earlier one!");
		symtab.define($ID.text, VarType.EDGE, $string_expr.text);
	  } 
	;

body
	: body_action (',' body_action)*
	;

body_action
	: CREATE NODE '$' ID LABEL string_expr {
		if (verbose) notifyErrorListeners("node set variable $" + $ID.text + " labeled " + $string_expr.text);
		if (symtab.resolve($ID.text) != null)
			notifyErrorListeners("binding $" + $ID.text + " hides earlier one!");
		symtab.define($ID.text, VarType.NODE);
		symtab.newScope("node.properties");
		symtab.define("__label", VarType.PROPERTY, $string_expr.text);
	  } '{' property_assignment_list '}' {
		Scope scope = symtab.getCurrentScope();
		symtab.define("__binding", VarType.PROPERTY, scope);
		if (verbose) notifyErrorListeners("ending scope: " + scope.toString());
		symtab.endScope();
	  }
	| CREATE EDGE '$' ID FROM '$' n1=ID TO '$'n2=ID LABEL string_expr {
		if (verbose) notifyErrorListeners("edgeset variable $" + $ID.text + " labeled " + $string_expr.text);
		if (symtab.resolve($ID.text) != null)
			notifyErrorListeners("binding $" + $ID.text + " hides earlier one!");
		if (symtab.resolve($n1.text) == null)
			notifyErrorListeners("nodeset variable  " + $n1.text + " undefined!");
		if (symtab.resolve($n2.text) == null)
			notifyErrorListeners("nodeset variable  " + $n1.text + " undefined!");
		symtab.newScope("edge.properties");
		symtab.define("__label", VarType.PROPERTY, $string_expr.text);
		symtab.define("__from", VarType.PROPERTY, $n1.text);
		symtab.define("__to", VarType.PROPERTY, $n2.text);
	  } '{' property_assignment_list '}' {
		Scope scope = symtab.getCurrentScope();
		symtab.define("__binding", VarType.PROPERTY, scope);
		if (verbose) notifyErrorListeners("ending scope: " + scope.toString());
		symtab.endScope();
	  }
	// TODO: body_action
	//| IF boolean_expr '{' body_action '}'
	| x2g_rule /* nested match */
	| /* epsilon */
	;

property_assignment_list
	: property_assignment (',' property_assignment)*
	;

property_assignment
	: property_name_expr
	| property_unique_stmt
	| property_if_stmt
	;

property_name_expr
	: property_name '=' expr {
		if (verbose) notifyErrorListeners("property " + $property_name.text + "=" + $expr.text);
		if (symtab.resolveOnly($property_name.text) != null)
			notifyErrorListeners("property " + $property_name.text + " overidden!");
		symtab.define($property_name.text, VarType.PROPERTY, $expr.text);
	  }
	;

property_unique_stmt
	: UNIQUE '(' property_name_list ')' {
		if (verbose) notifyErrorListeners("unique constraint found: " + $property_name_list.text);
		if (symtab.resolveOnly("__unique") != null)
			notifyErrorListeners("unique constraint (" + $property_name_list.text + ") redefines earlier one!");
		symtab.define("__unique", VarType.PROPERTY, $property_name_list.text);
	  }
		// TODO:
		//for (String prop : $property_name_list)
		//	if (symtab.resolveOnly(prop) == null)
		//		notifyErrorListeners("unique constraint: property " + prop + " unknown!");
	;

property_if_stmt
	: IF boolean_expr '{' property_assignment_list '}'
	;
	
property_name_list
	: property_name (',' property_name)*
	;

property_type			// TODO: not used
	: STRING
	| DATE
	| NUMERIC
	| BOOLEAN
	;

// SECTION: expressions
boolean_expr
	: boolean_expr AND boolean_expr
	| boolean_expr OR boolean_expr
	| NOT boolean_expr
	| '(' boolean_expr ')'
	| boolean_literal
	| expr relop expr
	;

expr
	: unaryop expr
	| expr arithop expr
	| '(' expr ')'
	| eval_expr
	| literal_expr
	; 

eval_expr
	: '$' ID ('.' XPATH '(' string_expr ')')? {
		if (symtab.resolve($ID.text) == null)
			notifyErrorListeners("xml fragment variable $" + $ID.text + " is unbound!");
	  }
	| '$' ID '.' property_name {
		if (symtab.resolve($ID.text) == null)
			notifyErrorListeners("node or edge variable $" + $ID.text + " is unbound!");
	  }
	;

literal_expr
	: string_literal
	| date_literal
	| numeric_literal
	| boolean_literal
	;


string_literal: STR;

date_literal: DATETIME;

numeric_literal: NUMBER;

boolean_literal: (TRUE|FALSE);

string_expr
	: string_expr '+' string_expr
	| eval_expr
	| string_literal
	;

// SECTION: Operators
relop: '<' | '>' | '<=' | '>=' | '=' | '==' | '<>' | '!=';

unaryop: '-' | '!';  // unary MINUS

arithop: '+' | '-' | '*' | DIV | MOD; // binary MINUS

// SECTION: Property names
property_name:	ID;

// vim: ff=unix ts=3 sw=3 sts=3 noet
