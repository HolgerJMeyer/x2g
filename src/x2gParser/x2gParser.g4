parser grammar x2gParser;

@header {
import java.util.*;
}

options {
	tokenVocab = x2gLexer;
}

@members {
	Map<String, String> xmlFragVars = new HashMap<String, String>();
	Map<String, String> nodeSetVars = new HashMap<String, String>();
	Map<String, String> edgeSetVars = new HashMap<String, String>();
}

/*
 * Expression types
 */
x2g
	: x2g_rule*
	;

x2g_rule
	: MATCH head '{' body '}'
	;

head
	: match_expression (',' match_expression)*
	;

match_expression
	: XPATH '(' string_literal ')' USING '$' ID {
		// var to xml fragment binding
		xmlFragVars.put($ID.text, $string_literal.text);
		notifyErrorListeners("xpath variable $" + $ID.text + " bound to " + $string_literal.text);
	  } 
	| NODE '(' string_literal ')' USING '$' ID {
		// var to node type binding
		nodeSetVars.put($ID.text, $string_literal.text);
		notifyErrorListeners("node set variable $" + $ID.text + " bound to " + $string_literal.text);
	  } 
	| EDGE '(' string_literal ')' USING '$' ID {
		// var to edge type binding
		edgeSetVars.put($ID.text, $string_literal.text);
		notifyErrorListeners("edge set variable $" + $ID.text + " bound to " + $string_literal.text);
	  } 
	;

body
	: body_action (',' body_action)*
	;

body_action
	: CREATE NODE '$' ID LABEL string_expr '{' property_assignment_list '}'
	| CREATE EDGE '$' ID FROM nodeset_var TO nodeset_var LABEL string_expr '{' property_assignment_list '}'
	| IF boolean_expr '{' body_action '}'
	| x2g_rule
	| /* epsilon */
	;

property_assignment_list
	: property_assignment ',' property_assignment_list
	| property_assignment
	;

property_assignment
	: property_name '=' value_expr
	| UNIQUE '(' property_name_list ')'
	| /* null assignment */
	;

	
property_name_list
	: property_name (',' property_name)*
	;

literal_value
	: string_literal
	| datespan_literal
	| point_literal
	| linestring_literal
	| region_literal
	| numeric_literal
	| boolean_literal
	;

// SECTION: Expressions
string_expr
	: string_value '+' string_expr
	| string_value
	;

string_value
	: string_literal
	;

// SECTION: Literal values
string_literal: STR;
datespan_literal: VALUE;
point_literal: VALUE;
linestring_literal: VALUE;
region_literal: VALUE;
numeric_literal: NUMBER;
boolean_literal: TRUE | FALSE;

property_type			// just a starting point
	: STRING
	| DATESPAN
	| POINT
	| LINESTRING
	| REGION
	| NUMERIC
	| BOOLEAN
	;

// TODO: property_value_constructor
property_value
	: string_value
	;

property_type_list
	: '(' property_definition (',' property_definition)* ')'
	;

property_definition
	: property_type property_name
	;

property_value_list
	: property_assignment (',' property_assignment)*
	;

// node and edge IDs
nid:	POSITIV_INTEGER;
eid:	POSITIV_INTEGER;

// SECTION: Boolean expression
boolean_expr
	: boolean_property_expr
	| boolean_node_expr
	| boolean_edge_expr
	| boolean_expr AND boolean_expr
	| boolean_expr OR boolean_expr
	| NOT boolean_expr
	| '(' boolean_expr ')'
	;

boolean_property_expr
	: qual_property_name comp_op value_expr
	| qual_property_name comp_op qual_property_name
	;

qual_property_name
	: xmlfrag_var '.' property_name
	| nodeset_var '.' property_name
	| edgeset_var '.' property_name
	;

// TODO: 
value_expr
	: unary_op value_expr
	| value_expr binary_op value_expr
	| '(' value_expr ')'
	| property_value
	; 

boolean_node_expr
	: nodeset_expr
	;

nodeset_expr
	: nodeset_var
	| nodeset_var '.' property_name
	;

boolean_edge_expr
	: edgeset_expr
	;

edgeset_expr
	: edgeset_var
	| edgeset_var '.' property_name
	;

// comparison operators
comp_op:		'<' | '>' | '<=' | '>=' | '=' | '==' | '<>' | '!=';

unary_op:	'-' | '!';  // unary MINUS

binary_op:	'+' | '-' | '*' | '/' | '%'; // binary MINUS

// Namespace
namespace:	ID;

// Typed Tokens
node_type:	ID;
edge_type:	ID;
role_name:	ID;
property_name:	ID;
func_name:	ID;

// SECTION: Bound and unbound variables
xmlfrag_var:	'$' ID { if (!xmlFragVars.containsKey($ID.text))   notifyErrorListeners("xml fragment variable $"+$ID.text+" is unbound"); };
nodeset_var:	'$' ID { if (!nodeSetVars.containsKey($ID.text))   notifyErrorListeners("node variable $"+$ID.text+" is unbound"); };
edgeset_var:	'$' ID { if (!edgeSetVars.containsKey($ID.text))   notifyErrorListeners("edge variable $"+$ID.text+" is unbound"); };

// vim: ts=3 sw=3 sts=3 noet
