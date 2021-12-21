parser grammar graflParser;

@header {
import java.util.*;
}

options {
	tokenVocab = graflLexer;
}

@members {
	Map<String, String> nodeSetVars = new HashMap<String, String>();
	Map<String, String> edgeSetVars = new HashMap<String, String>();
}

/*
 * Expression types
 * <node>, <nodeset>, <edge>, <edgeset>, <scalar>, <boolean>
 * Value types
 * <nodeType>, <edgeType>, <roleType>, <attrType>
 *
 *
 *
 *
 *
 *
 */
grafl
	: grafl_statement*
	;

grafl_statement
	: ddl_statement
	| dml_statement
	| query_statement
	;

// SECTION: Data Definition Language
ddl_statement
	: create_node_type
	| alter_node_type
	| drop_node_type
	| create_edge_type
	| alter_edge_type
	| drop_edge_type
	;

create_node_type
	: CREATE NODETYPE node_type super_node_type? attr_type_list? {
		System.out.println("NODETYPE:" + $text);
	  }
	;

super_node_type
	: UNDER node_type
	;

alter_node_type
	: ALTER NODETYPE node_type alter_attr_list
	;

drop_node_type
	: DROP NODETYPE node_type
	;

create_edge_type
	: CREATE EDGETYPE edge_type_definition {
		System.out.println("EDGETYPE:" + $text);
	  }
	;

edge_type_definition
	: edge_type super_edge_type? attr_type_list? content_model?
	;
	
content_model
	: MODEL '(' role_node_type_list ')'
	;

role_node_type_list
	: role_node_type
	| role_node_type ',' role_node_type_list // tuple
	| role_node_type '|' role_node_type_list // alternative
	| '(' role_node_type_list ')' quantifier? // group
	;

role_node_type
	: role_name ':' node_type quantifier? // bi-directional
	| role_name INOUT node_type quantifier? // bi-directional
	| role_name '<' node_type quantifier? // b-arc
	| role_name IN node_type quantifier? // b-arc
	| role_name '>' node_type quantifier? // f-arc
	| role_name OUT node_type quantifier? // f-arc
	;

quantifier
	: '?'
	| '*'
	| '+'
	;

super_edge_type
	: UNDER edge_type
	;

alter_edge_type
	: ALTER EDGETYPE edge_type alter_attr_list
	;

drop_edge_type
	: DROP EDGETYPE edge_type
	;

// SECTION: Data Manipulation Language
dml_statement
	: create_node
	| update_node
	| delete_node
	| create_edge
	| update_edge
	| delete_edge
	;

create_node
	: CREATE NODE node_type '(' attr_value_list ')' returns_clause?
	;

update_node
	: UPDATE NODE node_type SET attr_value_list where_clause?
	;
	
delete_node
	: DELETE NODE node_type where_clause?
	;
	
returns_clause
	: RETURNS NID
	| RETURNS EID
	;

create_edge
	: CREATE EDGE edge_type '(' attr_value_list ')' returns_clause?
	;

update_edge
	: UPDATE EDGE edge_type SET attr_value_list where_clause?
	| UPDATE EDGE edge_type ADD ROLE role_name ':' node_expr where_clause?
	| UPDATE EDGE edge_type DEL ROLE role_name ':' node_expr where_clause?
	;
	
delete_edge
	: DELETE EDGE edge_type where_clause?
	;
	
attr_list
	: attr_name (',' attr_name)*
	;

alter_attr_list
	: alter_attr (',' alter_attr)*
	;

alter_attr
	: ADD attr_name attr_type
	| DEL attr_name
	;

// SECTION: Retrieval Language

query_statement
	: variable_assignments? where_clause? order_by_clause? return_clause
	;

variable_assignments
	: FOR itervar_assignment_list
	| LET setvar_assignment_list
	;

itervar_assignment_list
	: itervar_assignment (',' itervar_assignment_list)*
	;

itervar_assignment
	: '$' ID IN (nodeset_expr | edgeset_expr) {
		if ($nodeset_expr.text!=null)
			nodeSetVars.put($ID.text, $nodeset_expr.text);
		else
			edgeSetVars.put($ID.text, $edgeset_expr.text);
		notifyErrorListeners("iterator variable assignment");
	  }
	;

setvar_assignment_list
	: setvar_assignment (',' setvar_assignment_list)*
	;

setvar_assignment
	: '$' ID ':=' (nodeset_expr | edgeset_expr) {
		if ($nodeset_expr.text!=null)
			nodeSetVars.put($ID.text, $nodeset_expr.text);
		else
			edgeSetVars.put($ID.text, $edgeset_expr.text);
		notifyErrorListeners("set variable assignment");
	  }
	;

set_expr
	: nodeset_expr
	| edgeset_expr
	;

where_clause
	: WHERE boolean_expr
	;

order_by_clause
	: ORDERBY attr_list
	;
	
return_clause
	: RETURN edgeset_expr
	;

// SECTION: Scalar values
scalar_expr
	: literal_value
	| scalar_func
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

// SECTION: Literal values
string_literal: STR;
datespan_literal: VALUE;
point_literal: VALUE;
linestring_literal: VALUE;
region_literal: VALUE;
numeric_literal: NUMBER;
boolean_literal: TRUE | FALSE;

// SECTION: Attributes
// TODO: better built-in type data dictionary
attr_type			// just a starting point
	: STRING
	| DATESPAN
	| POINT
	| LINESTRING
	| REGION
	| NUMERIC
	| BOOLEAN
	;

// TODO: attr_value_constructor
attr_value
	: scalar_expr
	;

attr_type_list
	: '(' attr_definition (',' attr_definition)* ')'
	;

attr_definition
	: attr_name attr_type
	;

attr_value_list
	: attr_assignment (',' attr_assignment)*
	;

attr_assignment
	: attr_name '=' attr_value
	;

// SECTION: Functions
/*
 * graph-functions:
 *		Connectivity of two nodes
 *		k-neighbourhood
 *		Graph manipulation, union
 *		Hyperedge contraction
 *		k-shortest path
 *		Node contraction as generalization of two node types, dynamic typing problem
 *		Hyperedge contraction is a union of all (link, node)-pairs of the two Hyperedges.
 */
func_expr
	: (namespace ':')? func_name '(' func_param_list? ')' {
			System.out.println("CALL " + $func_name.text);
	  }
	;

func_param_list
	: func_param (',' func_param)*
	;

func_param
	: node_expr
	| nodeset_expr
	| edge_expr
	| edgeset_expr
	| scalar_expr
	;

// possible return types of functions: <node>, set<node>, edge, set<edge>, <scalar>
scalar_func
	: func_expr
	;

// node and edge IDs
nid:	POSITIV_INTEGER;
eid:	POSITIV_INTEGER;

// SECTION: Node[set] expression
node_expr
	: nid
	| node_var
	| node_constructor
	;

nodeset_expr
	: '(' node_expr (',' node_expr)* ')'
	| nodeset_var
	| node_constructor
	;

// TODO: vereinheitlichen mit CREATE NODE
node_constructor
	: NODE attr_sequence?  // unnamed node type
	| NODE '::' node_type attr_sequence?  // named node type
	;


// SECTION: Edge[set] expression
edge_expr
	: eid
	| edge_var
	| edge_constructor
	;

edgeset_expr
	: '(' edge_expr (',' edge_expr)* ')'
	| edgeset_var
	| edge_constructor
	;

// TODO: vereinheitlichen mit CREATE EDGE
edge_constructor
	: EDGE role_node_sequence? // unnamed edge type
	| EDGE '::' edge_type role_node_sequence? // named edge type
	;

// SECTION: Sequences of atoms [TODO]
role_node_sequence
	: '(' scalar_expr (',' scalar_expr)* ')'
	;

attr_sequence
	: '(' scalar_expr (',' scalar_expr)* ')'
	;

scalar_sequence
	: '(' scalar_expr (',' scalar_expr)* ')'
	;

// SECTION: Boolean expression
boolean_expr
	: boolean_attr_expr
	| boolean_node_expr
	| boolean_edge_expr
	| boolean_expr AND boolean_expr
	| boolean_expr OR boolean_expr
	| NOT boolean_expr
	| '(' boolean_expr ')'
	;

boolean_attr_expr
	: qual_attr_name comp_op value_expr
	| qual_attr_name comp_op qual_attr_name
	;

qual_attr_name
	: node_var '.' attr_name
	| nodeset_var '.' attr_name
	| node_type  '::' attr_name
	| edge_var '.' attr_name
	| edgeset_var '.' attr_name
	| edge_type  '::' attr_name
	;

// TODO: 
value_expr
	: unary_op value_expr
	| value_expr binary_op value_expr
	| '(' value_expr ')'
	| attr_value
	; 

boolean_node_expr
	: node_var
	| nodeset_var
	| node_var '.' attr_name
	| nodeset_var '.' attr_name
	| node_var IN nodeset_expr
	| node_var IN edge_expr
	| node_var IN edgeset_expr
	;

boolean_edge_expr
	: edge_var
	| edgeset_var
	| edge_var '.' attr_name
	| edgeset_var '.' attr_name
	| edge_var IN edgeset_expr
	| edge_var IN edge_expr
	| edge_var IN edgeset_expr
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
attr_name:	ID;
func_name:	ID;

// SECTION: Bound and unbound variables
node_var:		'$' ID { if (!nodeSetVars.containsKey($ID.text))	notifyErrorListeners("node variable $"+$ID.text+" is unbound"); };
nodeset_var:	'$' ID { if (!nodeSetVars.containsKey($ID.text))   notifyErrorListeners("node variable $"+$ID.text+" is unbound"); };
edge_var:		'$' ID { if (!edgeSetVars.containsKey($ID.text))   notifyErrorListeners("edge variable $"+$ID.text+" is unbound"); };
edgeset_var:	'$' ID { if (!edgeSetVars.containsKey($ID.text))   notifyErrorListeners("edge variable $"+$ID.text+" is unbound"); };

// vim: ts=3 sw=3 sts=3 noet
