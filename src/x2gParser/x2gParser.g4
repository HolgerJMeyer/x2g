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
	: x2g_rule+
	;

x2g_rule
	: MATCH bind_expr {
		// sorry, nontrivial access to sub-rule token, but here is the right place to show the nesting
		symtab.newScope("match", $bind_expr.ctx.v.getText());
	  } '{' body '}' {
		symtab.endScope();
	  }
	;

bind_expr
	: ('$' c=ID '.')? b=(XPATH|JPATH|SQL|NODE|EDGE) '(' e=string_expr ')' USING '$' v=ID {
		if ($c != null) {
			if (symtab.resolve($c.text) == null) {
				notifyErrorListeners("context variable $" + $c.text + " is undefined!");
			}
		}
		if (verbose) {
			notifyErrorListeners($b.text + " variable $" + $v.text + " bound to " + $e.text);
		}
		if (symtab.resolve($v.text) != null) {
			notifyErrorListeners("binding $" + $v.text + " hides earlier one!");
		}
		/* TODO: Maybe simplify be replacing VarType by x2gParser.<Token> */
		switch ($b.type) {
		case XPATH:
			symtab.define($v.text, VarType.XPATH, $e.text);
			break;
		case JPATH:
			symtab.define($v.text, VarType.JPATH, $e.text);
			break;
		case SQL:
			symtab.define($v.text, VarType.SQL, $e.text);
			break;
		case NODESET:
			symtab.define($v.text, VarType.NODESET, $e.text);
			break;
		case EDGESET:
			symtab.define($v.text, VarType.EDGESET, $e.text);
			break;
		}
	  }
	;

body
	: body_action (',' body_action)* #bodyActionList
	;

body_action
	: create_node
	| create_edge
	| if_stmt
	| x2g_rule
	;

create_node
	: CREATE NODE '$' ID LABEL e=string_expr {
		if (verbose) {
			notifyErrorListeners("nodeset variable $" + $ID.text + " labeled " + $e.text);
		}
		if (symtab.resolve($ID.text) != null) {
			notifyErrorListeners("binding $" + $ID.text + " hides earlier one!");
		}
		Variable node = symtab.define($ID.text, VarType.NODESET);
		Scope propscope = symtab.newScope("node.properties", $ID.text);
		node.setPropScope(propscope);
		symtab.define("__label", VarType.PROPERTY, $e.text);
	  } '{' property_statement_list '}' {
		symtab.endScope();
	  }
	;

create_edge
	: CREATE EDGE '$' e=ID FROM '$' n1=ID TO '$' n2=ID LABEL l=string_expr {
		/* TODO:  FROM $ID TO $ID  -> FROM eval_expr TO eval_expr */
		/* FROM node_ref TO node_ref */
		if (verbose) {
			notifyErrorListeners("edgeset variable $" + $e.text + " labeled " + $l.text);
		}
		if (symtab.resolve($e.text) != null) {
			notifyErrorListeners("binding $" + $e.text + " hides earlier one!");
		}
		
		Variable from = symtab.resolve($n1.text);
		if (from == null || from.getType() != VarType.NODESET) {
			notifyErrorListeners("nodeset variable $" + $n1.text + " undefined!");
		}
		Variable to = symtab.resolve($n2.text);
		if (to == null || to.getType() != VarType.NODESET) {
			notifyErrorListeners("nodeset variable $" + $n2.text + " undefined!");
		}
		Variable edge = symtab.define($e.text, VarType.EDGESET);
		Scope propscope = symtab.newScope("edge.properties", $e.text);
		edge.setPropScope(propscope);
		symtab.define("__label", VarType.PROPERTY, $l.text);
	  } '{' property_statement_list '}' {
		symtab.endScope();
	  }
	;

node_ref
	: '$' ID {
		Variable node = symtab.resolve($ID.text);
		if (node == null || node.getType() != VarType.NODESET) {
			notifyErrorListeners("nodeset variable $" + $ID.text + " undefined!");
		}
	  }
	;

if_stmt
	: IF '(' boolean_expr ')' '{' body '}' (ELSE '{' body '}')?
	;

property_statement_list
	: property_statement (',' property_statement)*
	;

property_statement
	: property_assignment
	| property_unique
	| property_if
	;

property_assignment
	: ID '=' expr {
		if (verbose) {
			notifyErrorListeners("property " + $ID.text + "=" + $expr.text);
		}
		if (symtab.resolveCurrent($ID.text) != null) {
			notifyErrorListeners("property " + $ID.text + " maybe overridden!");
		}
		symtab.define($ID.text, VarType.PROPERTY, $expr.text);
	  }
	;

property_unique
	: UNIQUE '(' property_name_list ')' {
		if (verbose) {
			notifyErrorListeners("unique constraint found: " + $property_name_list.text);
		}
		if (symtab.resolveCurrent("__unique") != null) {
			notifyErrorListeners("unique constraint (" + $property_name_list.text + ") redefines earlier one!");
		}
		String[] keyprops = $property_name_list.text.split(",");
		Set<Object> propset = new HashSet<Object>();
		for (String prop : keyprops) {
			propset.add(prop);
			if (symtab.resolveCurrent(prop) == null) {
				notifyErrorListeners("unique constraint: property " + prop + " unknown!");
			}
		}
		symtab.define("__unique", VarType.PROPERTY, propset);
	  }
	;

property_if
	: IF '(' boolean_expr ')' '{' property_statement_list '}' (ELSE '{' property_statement_list '}')?
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
	| var_ref								#varRef
	| literal_expr							#literalExpr
	; 

var_ref
	: '$' v=ID ('.' a=ID)? {
		// CASE v
		//		v can be path, sql, node, or edge variable
		// CASE v.a
		//		v can be sql, node, or edge variable
		// TODO: optionales .<property>, wenn nicht, dann implizit .__label?
		Variable v = symtab.resolve($v.text);
		if (v == null) {
			notifyErrorListeners("variable $" + $v.text + " is unbound!");
		}
		if ($a != null) {
			Variable a;
			if (v.getType() == VarType.NODESET || v.getType() == VarType.EDGESET || v.getType() == VarType.SQL) {
				a = v.getPropScope().resolve($a.text);
			}
			else {
				a = symtab.resolve($a.text);
			}
			if (a == null) {
				notifyErrorListeners("attribute/property " + $a.text + " is undefined!");
			}
		}
	  }
	| '$' v=ID '.' p=(XPATH|JPATH) '(' e=string_expr ')' {
		Variable v = symtab.resolve($v.text);
		if (v == null) {
			notifyErrorListeners($p.text.toLowerCase() + " variable $" + $v.text + " is unbound!");
		}
		else if (v.getType() != VarType.XPATH && v.getType() != VarType.JPATH) {
			notifyErrorListeners("wrong variable type for $" + $v.text + ", XPATH or JPATH expected!");
		}
	  }
	;

literal_expr
	: STR				#literalString
	| DATETIME		#literalDate
	| NUMBER			#literalNumber
	| BOOL			#literalBool
	;

/*
 * TODO: string_expr ausdifferenzieren, string-expr als parameter in xpath() anders als evaluierung string
 */
string_expr
	: string_expr PLUS string_expr	#stringConcat
	| var_ref								#stringVar
	| STR										#stringSTR
	;

// vim: ff=unix ts=3 sw=3 sts=3 noet
