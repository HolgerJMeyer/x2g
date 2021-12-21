lexer grammar graflLexer;

tokens {
	STR,
	NEQ
}

// Integers and Numbers
NUMBER:	[+-]? (POSITIV_INTEGER | POSITIV_DECIMAL | POSITIV_DOUBLE);
POSITIV_INTEGER: DIGIT+;
POSITIV_DECIMAL: (DIGIT+ '.' DIGIT* | '.' DIGIT+);
POSITIV_DOUBLE: (DIGIT+ '.' DIGIT* EXPONENT | '.' DIGIT+ EXPONENT | DIGIT+ EXPONENT);

EXPONENT:		('e'|'E') ('+'|'-')? DIGIT+;
fragment
DIGIT:			[0-9];

// SECTION: String literals
// single line strings: 'ssssstrinnnng' "ssssstrinnnng"
SINGLEQSTR: '\'' (~('\''|'\\'|'\r'|'\n') | ESCCHAR)* '\'' -> type(STR);
DOUBLEQSTR: '"'  (~('"'|'\\'|'\r'|'\n') | ESCCHAR)* '"' -> type(STR);
// triple quoted python-like multi-line strings: '''...''' """..."""
TRIPLEQSSTR: '\'\'\'' (('\''|'\'\'')? (~('\''|'\\') | ESCCHAR))* '\'\'\'' -> type(STR);
TRIPLEQDSTR: '"""' (('"'|'""')? ( ~('\''|'\\') | ESCCHAR ))* '"""' -> type(STR);

ESCCHAR: '\\'('t'|'b'|'n'|'r'|'f'|'"'|'\'');

LINE_COMMENT:	'//' .*? '\r'?'\n'	{ System.out.println("found comment"); } -> skip;
SQL_COMMENT:	'--' .*? '\r'?'\n'	-> skip;
XML_COMMENT:	'(:' .*? ':)'			-> skip;
C_COMMENT:  	'/*' .*? '*/'			-> skip;
WS:				[ \t\r\n]+				->	skip;

// SECTION: reserved words
ADD:			'ADD' | 'add';
AND:			'AND' | 'and';
ALTER:		'ALTER' | 'alter';
BOOLEAN:		'BOOLEAN' | 'boolean';
CREATE:		'CREATE' | 'create';
DATESPAN:	'DATESPAN' | 'datespan';
DEL:			'DEL' | 'del';
DELETE:		'DELETE' | 'delete';
DROP:			'DROP' | 'drop';
EDGE:			'EDGE' | 'edge';
EDGETYPE:	'EDGETYPE' | 'edgetype';
EID:			'EID' | 'eid';
FALSE:		'FALSE' | 'false';
FOR:			'FOR' | 'for';
FROM:			'FROM' | 'from';
IN:			'IN' | 'in';
INOUT:		'INOUT' | 'inout';
INTEGER:		'INTEGER' | 'integer';
LET:			'LET' | 'let';
LINESTRING:	'LINESTRING' | 'linestring';
MODEL:		'MODEL' | 'model';
NID:			'NID' | 'nid';
NODE:			'NODE' | 'node';
NODETYPE:	'NODETYPE' | 'nodetype';
NOT:			'NOT' | 'not';
NUMERIC:		'NUMERIC' | 'numeric';
OR:			'OR' | 'or';
OUT:			'OUT' | 'out';
ORDERBY:		'ORDERBY' | 'ORDER' 'BY' | 'orderby' | 'order' 'by';
POINT:		'POINT' | 'point';
REGION:		'REGION' | 'region';
RETURN:		'RETURN' | 'return';
RETURNS:		'RETURNS' | 'returns';
ROLE:			'ROLE' | 'role';
SELECT:		'SELECT' | 'select';
SET:			'SET' | 'set';
STRING:		'STRING' | 'string';
TRUE:			'TRUE' | 'true';
UNDER:		'UNDER' | 'under';
UPDATE:		'UPDATE' | 'update';
VALUE:		'VALUE' | 'value';
WHERE:		'WHERE' | 'where';

// SECTION: Identifiers
ID:				LETTER(LETTER|DIGIT)*;
fragment
LETTER:			[a-zA-Z\u0080-\u00FF_];

// 
COMMA:		',';
DBLCOLON:	'::';
COLON:		':';
SEMICOLON:	';';
DOT:			'.';
PLUS:			'+';
MINUS:		'-';
MULT:			'*';
DIV:			'/';
PERCENT:		'%';
BITOR:		'|';
BANG:			'!';
QMARK:		'?';
DOLLAR:		'$';
LT:			'<';
LE:			'<=';
GT:			'>';
GE:			'>=';
EQ:			'=';
BANGNOT:		'!='	-> type(NEQ);
UNEQ:			'<>'	-> type(NEQ);
IDENT:		'==';
ASSIGN:		':=';
LPAREN:		'(';
RPAREN:		')';
LBRACE:		'{';
RBRACE:		'}';
LBRACKET:	'[';
RBRACKET:	']';

// vim: ts=3 sw=3 sts=3 noet
