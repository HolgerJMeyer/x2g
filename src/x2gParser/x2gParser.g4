parser grammar x2gParser;

@header {
//package x2g;
import java.util.*;
}

options {
	tokenVocab = x2gLexer;
}

@members {
	Map<String, String> xmlFragVars = new HashMap<String, String>();
	Map<String, String> nodeSetVars = new HashMap<String, String>();
	Map<String, String> edgeSetVars = new HashMap<String, String>();
	AbstractList<String> bindExprList = new LinkedList<String>();
}

/*
 * Expression types
 */
x2g
	: x2g_rule*
	;

x2g_rule
	: MATCH bind_expr_list '{' body '}' {
		notifyErrorListeners("bindings: " + bindExprList.toString());
		bindExprList.clear(); // bindings not used anymore
	  }
	;

bind_expr_list
	: bind_expr ',' bind_expr_list {
		bindExprList.add($bind_expr.text);
	  }
	| bind_expr {
		bindExprList.add($bind_expr.text);
	  }
	;

bind_expr
	: xpath_expr USING '$' ID {
		// var to xml fragment binding
		xmlFragVars.put($ID.text, $xpath_expr.text);
		notifyErrorListeners("xpath variable $" + $ID.text + " bound to " + $xpath_expr.text);
	  } 
	| node_expr USING '$' ID {
		// var to node type binding
		nodeSetVars.put($ID.text, $node_expr.text);
		notifyErrorListeners("node set variable $" + $ID.text + " bound to " + $node_expr.text);
	  } 
	| edge_expr USING '$' ID {
		// var to edge type binding
		edgeSetVars.put($ID.text, $edge_expr.text);
		notifyErrorListeners("edge set variable $" + $ID.text + " bound to " + $edge_expr.text);
	  } 
	;

xpath_expr
	: XPATH '(' string_literal ')'
	;

node_expr
	: NODE '(' string_literal ')'
	;

edge_expr
	: EDGE '(' string_literal ')'
	;

body
	: body_action ',' body
	| body_action
	;

body_action
	: CREATE NODE '$' ID LABEL string_literal '{' property_assignment_list '}' {
		nodeSetVars.put($ID.text, $string_literal.text);
		notifyErrorListeners("node set variable $" + $ID.text + " bound to " + $string_literal.text);
	  }
	| CREATE EDGE '$' ID FROM nodeset_var TO nodeset_var LABEL string_literal '{' property_assignment_list '}' {
		edgeSetVars.put($ID.text, $string_literal.text);
		notifyErrorListeners("edge set variable $" + $ID.text + " bound to " + $string_literal.text);
	  }
	// TODO: body_action
	//| IF boolean_expr '{' body_action '}'
	| x2g_rule /* nested match */
	| /* epsilon */
	;

property_assignment_list returns [AbstractList<Map<String, String>> props = new ArrayList<Map<String,String>>()]
	: p=property_assignment ',' l=property_assignment_list {
		$l.props.add($p.prop);
		$props = $l.props;
	  }
	| p=property_assignment {
		$props.add($p.prop);
	  }
	| IF b=boolean_expr '{' l=property_assignment_list '}'{ // conditional assignment
			$props = $l.props;
	  }
		// if ($b.value == true) {
		//		$props = $l.props;
		// } */
	;

property_assignment returns [Map<String, String> prop = new HashMap<String, String>()]
	: property_name '=' expr {
		notifyErrorListeners("property " + $property_name.text + "=" + $expr.text);
		$prop.put($property_name.text, $expr.text);
	  }
	| UNIQUE '(' property_name_list ')' {
		notifyErrorListeners("unique constraint found: " + $property_name_list.text);
		$prop.put("__unique", $property_name_list.text);
	  }
	| /* epsilon */
	;
	
property_name_list
	: property_name ',' property_name_list
	| property_name
	;

property_type			// just a starting point
	: STRING
	| DATE
	| NUMERIC
	| BOOLEAN
	;

property_definition_list
	: property_definition ',' property_definition_list
	| property_definition
	;

property_definition
	: property_type property_name
	;

// SECTION: expressions
boolean_expr
	: boolean_expr AND boolean_expr
	| boolean_expr OR boolean_expr
	| NOT boolean_expr
	| '(' boolean_expr ')'
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
	: xmlfrag_expr
	| nodeset_expr
	| edgeset_expr
	;

xmlfrag_expr
	: xmlfrag_var
	| xmlfrag_var '.' xpath_expr
	;

nodeset_expr
	: nodeset_var
	| nodeset_var '.' property_name
	;

edgeset_expr
	: edgeset_var
	| edgeset_var '.' property_name
	;

literal_expr
	: string_literal
	| date_literal
	| numeric_literal
	| boolean_literal
	;

string_expr returns [String str]
	: s1=string_expr '+' s2=string_expr {
		$str = $s1.str + $s2.str;
	  }
	| eval_expr
	| string_literal
	;

// SECTION: Literal values
string_literal: STR;
date_literal: TIMESTAMP;
numeric_literal: NUMBER;
boolean_literal: TRUE | FALSE;

// SECTION: Operators
relop:		'<' | '>' | '<=' | '>=' | '=' | '==' | '<>' | '!=';

unaryop:	'-' | '!';  // unary MINUS

arithop:	'+' | '-' | '*' | DIV | MOD; // binary MINUS

// SECTION: Typed Tokens
node_type:	ID;
edge_type:	ID;
property_name:	ID;

// SECTION: Bound and unbound variables
xmlfrag_var:	'$' ID { if (!xmlFragVars.containsKey($ID.text))   notifyErrorListeners("xml fragment variable $"+$ID.text+" is unbound"); };
nodeset_var:	'$' ID { if (!nodeSetVars.containsKey($ID.text))   notifyErrorListeners("node variable $"+$ID.text+" is unbound"); };
edgeset_var:	'$' ID { if (!edgeSetVars.containsKey($ID.text))   notifyErrorListeners("edge variable $"+$ID.text+" is unbound"); };

// vim: ts=3 sw=3 sts=3 noet
