parser grammar x2gParser;

@header {
//package x2g;
import java.util.*;
}

options {
	tokenVocab = x2gLexer;
}

@members {
	AbstractList<String> registeredProps = new LinkedList<String>();

	SymbolTable symtab;

	// overload costructor
	public x2gParser(TokenStream input, SymbolTable symtab) {
		this(input);
		this.symtab = symtab;
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
		symtab.newScope("match#" + _localctx.start.getLine());
	  } bind_expr_list '{' body '}' {
		notifyErrorListeners("ending scope: " + symtab.getCurrentScope().toString());
		symtab.endScope();
	  }
	;

bind_expr_list
	: bind_expr (',' bind_expr)*
	;

bind_expr
	: xpath_expr USING '$' ID {
		// var to xml fragment binding
		notifyErrorListeners("xpath variable $" + $ID.text + " bound to " + $xpath_expr.text);
		symtab.define($ID.text, VarType.XPATH, $xpath_expr.text);
	  } 
	| node_expr USING '$' ID {
		// var to node type binding
		notifyErrorListeners("node set variable $" + $ID.text + " bound to " + $node_expr.text);
		symtab.define($ID.text, VarType.NODE, $node_expr.text);
	  } 
	| edge_expr USING '$' ID {
		// var to edge type binding
		notifyErrorListeners("edge set variable $" + $ID.text + " bound to " + $edge_expr.text);
		symtab.define($ID.text, VarType.EDGE, $edge_expr.text);
	  } 
	;

xpath_expr
	: XPATH '(' string_expr ')'
	;

node_expr
	: NODE '(' string_expr ')'
	;

edge_expr
	: EDGE '(' string_expr ')'
	;

body
	: body_action ',' body
	| body_action
	;

body_action
	: CREATE NODE '$' ID LABEL string_expr {
		notifyErrorListeners("node set variable $" + $ID.text + " bound to " + $string_expr.text);
		symtab.define($ID.text, VarType.NODESET, $string_expr.text);
		symtab.newScope("node.properties");
	  } '{' property_assignment_list '}' {
		notifyErrorListeners("ending scope: " + symtab.getCurrentScope().toString());
		symtab.endScope();
	  }
	| CREATE EDGE '$' ID FROM nodeset_var TO nodeset_var LABEL string_expr {
		notifyErrorListeners("edge set variable $" + $ID.text + " bound to " + $string_expr.text);
		symtab.define($ID.text, VarType.EDGESET, $string_expr.text);
		symtab.newScope("edge.properties");
	  } '{' property_assignment_list '}' {
		notifyErrorListeners("ending scope: " + symtab.getCurrentScope().toString());
		symtab.endScope();
	  }
	// TODO: body_action
	//| IF boolean_expr '{' body_action '}'
	| x2g_rule /* nested match */
	| /* epsilon */
	;

property_assignment_list
	: property_assignment ',' property_assignment_list
	| property_assignment
	| IF boolean_expr '{' property_assignment_list '}'
		// if ($b.value == true) {
		//		$props = $l.props;
		// } */
	| /* epsilon */
	;

property_assignment
	: property_name '=' expr {
		notifyErrorListeners("property " + $property_name.text + "=" + $expr.text);
		symtab.define($property_name.text, VarType.PROPERTY, $expr.text);
	  }
	| UNIQUE '(' property_name_list ')' {
		notifyErrorListeners("unique constraint found: " + $property_name_list.text);
		symtab.define("__unique", VarType.PROPERTY, $property_name_list.text);
	  }
	;
	
property_name_list
	: property_name (',' property_name)*
	;

property_type			// just a starting point
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
	: xmlfrag_var ('.' xpath_expr)?
	| nodeset_var ('.' property_name)?
	| edgeset_var ('.' property_name)?
	;

literal_expr
	: string_literal
	| date_literal
	| numeric_literal
	| boolean_literal
	;


string_literal
	: STR
	;

date_literal
	: DATETIME
	;

numeric_literal
	: NUMBER
	;

boolean_literal: (TRUE|FALSE);

string_expr
	: string_expr '+' string_expr
	| eval_expr
	| string_literal
	;


// SECTION: Operators
relop:	'<' | '>' | '<=' | '>=' | '=' | '==' | '<>' | '!=';

unaryop:	'-' | '!';  // unary MINUS

arithop:	'+' | '-' | '*' | DIV | MOD; // binary MINUS

// SECTION: Property names
property_name:	ID;

// SECTION: Bound and unbound variables
xmlfrag_var:
	'$' ID {
		if (symtab.resolve($ID.text) == null)
			notifyErrorListeners("xml fragment variable $"+$ID.text+" is unbound");
	};
nodeset_var:
	'$' ID {
		if (symtab.resolve($ID.text) == null)
			notifyErrorListeners("node variable $"+$ID.text+" is unbound");
	};
edgeset_var:
	'$' ID {
		if (symtab.resolve($ID.text) == null)
			notifyErrorListeners("edge variable $"+$ID.text+" is unbound");
	};

// vim: ff=unix ts=3 sw=3 sts=3 noet
