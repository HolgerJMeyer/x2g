lexer grammar x2gLexer;

@header {
//package x2g;
}

tokens {
	BOOL,
	STR,
	NEQ
}

// Integers and Numbers
NUMBER:	[+-]? (POSITIV_INTEGER | POSITIV_DECIMAL | POSITIV_FLOAT);
POSITIV_INTEGER: DIGIT+;
POSITIV_DECIMAL: (DIGIT+ '.' DIGIT* | '.' DIGIT+);
POSITIV_FLOAT: (DIGIT+ '.' DIGIT* EXPONENT | '.' DIGIT+ EXPONENT | DIGIT+ EXPONENT);

EXPONENT:		('e'|'E') ('+'|'-')? DIGIT+;
fragment DIGIT:			[0-9];
DATETIME:		DIGIT DIGIT DIGIT DIGIT '-'[01] DIGIT '-'[0-3] DIGIT ([0-2] DIGIT ':' [0-5] DIGIT)?;
 
// SECTION: String literals
// single line strings: 'string' "string"
SINGLEQSTR: '\'' (~('\''|'\\'|'\r'|'\n') | ESCCHAR)* '\'' {
		setText(getText().substring(1, getText().length()-1));
	} -> type(STR);
DOUBLEQSTR: '"'  (~('"'|'\\'|'\r'|'\n') | ESCCHAR)* '"' {
		setText(getText().substring(1, getText().length()-1));
	} -> type(STR);
// triple quoted python-like multi-line strings: '''...''' """..."""
TRIPLEQSSTR: '\'\'\'' (('\''|'\'\'')? (~('\''|'\\') | ESCCHAR))* '\'\'\'' {
		setText(getText().substring(3, getText().length()-3));
	} -> type(STR);
TRIPLEQDSTR: '"""' (('"'|'""')? ( ~('\''|'\\') | ESCCHAR ))* '"""' {
		setText(getText().substring(3, getText().length()-3));
	} -> type(STR);

ESCCHAR: '\\'('t'|'b'|'n'|'r'|'f'|'"'|'\'');

// SECTION: Comments
LINE_COMMENT:	'//' .*? '\r'?'\n'	-> skip;
SQL_COMMENT:	'--' .*? '\r'?'\n'	-> skip;
XML_COMMENT:	'(:' .*? ':)'			-> skip;
C_COMMENT:  	'/*' .*? '*/'			-> skip;
WS:				[ \t\r\n]+				->	skip;

// SECTION: reserved words
ADD:			'ADD' | 'add';
AND:			'AND' | 'and' | '&&';
BOOLEAN:		'BOOLEAN' | 'boolean';
CREATE:		'CREATE' | 'create';
DATE:			'DATE' | 'date';
EDGESET:		'EDGESET' | 'edgeset';
EDGE:			'EDGE' | 'edge';
ELSE:			'ELSE' | 'else';
FALSE:		('FALSE' | 'false')		-> type(BOOL);
FOR:			'FOR' | 'for';
FROM:			'FROM' | 'from';
IF:			'IF'| 'if';
INTEGER:		'INTEGER' | 'integer';
JPATH:		'JPATH'| 'jpath';
LABEL:		'LABEL'| 'label';
MATCH:		'MATCH'| 'match';
NODESET:		'NODESET' | 'nodeset';
NODE:			'NODE' | 'node';
NOT:			'NOT' | 'not';
NUMERIC:		'NUMERIC' | 'numeric';
OR:			'OR' | 'or' | '||';
ORDERBY:		'ORDER' 'BY' | 'order' 'by';
SETOF:		'SETOF' | 'setof';
SQL:			'SQL' | 'sql';
STRING:		'STRING' | 'string';
TO:			'TO' | 'to';
TRUE:			('TRUE' | 'true')			-> type(BOOL);
TUPLEOF:		'TUPLEOF' | 'tupleof';
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
MULT:			'*';
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
ASSIGN:		'=';
EQ:			'==';
LPAREN:		'(';
RPAREN:		')';
LBRACE:		'{';
RBRACE:		'}';
//LBRACKET:	'[';
//RBRACKET:	']';

// vim: ff=unix ts=3 sw=3 sts=3 noet
