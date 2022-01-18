lexer grammar x2gLexer;

@header {
//package x2g;
}

tokens {
	STR,
	AXIS,
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
TIMESTAMP:		[0-9][0-9][0-9][0-9]'-'[01][0-9]'-'[0123][0-9];
 
// SECTION: String literals
// single line strings: 'ssssstrinnnng' "ssssstrinnnng"
SINGLEQSTR: '\'' (~('\''|'\\'|'\r'|'\n') | ESCCHAR)* '\'' -> type(STR);
DOUBLEQSTR: '"'  (~('"'|'\\'|'\r'|'\n') | ESCCHAR)* '"' -> type(STR);
// triple quoted python-like multi-line strings: '''...''' """..."""
TRIPLEQSSTR: '\'\'\'' (('\''|'\'\'')? (~('\''|'\\') | ESCCHAR))* '\'\'\'' -> type(STR);
TRIPLEQDSTR: '"""' (('"'|'""')? ( ~('\''|'\\') | ESCCHAR ))* '"""' -> type(STR);

ESCCHAR: '\\'('t'|'b'|'n'|'r'|'f'|'"'|'\'');

// SECTION: Comments
LINE_COMMENT:	'//' .*? '\r'?'\n'	{ System.out.println("found comment"); } -> skip;
SQL_COMMENT:	'--' .*? '\r'?'\n'	{ System.out.println("found comment"); } -> skip;
XML_COMMENT:	'(:' .*? ':)'			{ System.out.println("found comment"); } -> skip;
C_COMMENT:  	'/*' .*? '*/'			{ System.out.println("found comment"); } -> skip;
WS:				[ \t\r\n]+				->	skip;

// SECTION: reserved words
ADD:			'ADD' | 'add';
AND:			'AND' | 'and';
BOOLEAN:		'BOOLEAN' | 'boolean';
CREATE:		'CREATE' | 'create';
DATE:			'DATE' | 'date';
EDGE:			'EDGE' | 'edge';
FALSE:		'FALSE' | 'false';
FOR:			'FOR' | 'for';
FROM:			'FROM' | 'from';
IF:			'IF'| 'if';
INTEGER:		'INTEGER' | 'integer';
LABEL:		'LABEL'| 'label';
MATCH:		'MATCH'| 'match';
NODE:			'NODE' | 'node';
NOT:			'NOT' | 'not';
NUMERIC:		'NUMERIC' | 'numeric';
OR:			'OR' | 'or';
ORDERBY:		'ORDERBY' | 'ORDER' 'BY' | 'orderby' | 'order' 'by';
STRING:		'STRING' | 'string';
TO:			'TO' | 'to';
TRUE:			'TRUE' | 'true';
UNIQUE:		'UNIQUE'| 'unique';
USING:		'USING'| 'using';
XPATH:		'XPATH'| 'xpath';

// SECTION: Identifiers
ID:				LETTER(LETTER|DIGIT)*;
fragment
LETTER:			[a-zA-Z\u0080-\u00FF_];

// 
COMMA:		',';
//DBLCOLON:	'::';
//COLON:		':';
//SEMICOLON:	';';
DOT:			'.';
PLUS:			'+';
MINUS:		'-';
TIMES:		'*';
DIV:			'/'|'div'|'DIV';
MOD:			'%'|'mod'|'MOD';
//BITOR:		'|';
BANG:			'!';
//QMARK:		'?';
DOLLAR:		'$';
LT:			'<';
LE:			'<=';
GT:			'>';
GE:			'>=';
BANGNOT:		'!='	-> type(NEQ);
UNEQ:			'<>'	-> type(NEQ);
EQ:			'=';
IDENT:		'==';
ASSIGN:		':=';
LPAREN:		'(';
RPAREN:		')';
LBRACE:		'{';
RBRACE:		'}';
//LBRACKET:	'[';
//RBRACKET:	']';

// vim: ts=3 sw=3 sts=3 noet
