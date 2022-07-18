//XPath-Grammar
expr
	: locpath
	| bexpr
	| nexpr
	;

locpath
	: '/' locpath
	| locpath '/' locpath
	| locpath '|' locpath
	| locstep
	;

locstep
	: AXIS '::' ntst ('[' bexpr ']')*
	/*TODO:
	| '@'ntst -> attribute::ntst
	| ntst -> child::ntst
	| ...'//'... -> .../descendant-or-self::node()/...
	| '.' -> context-node
	*/
	;

bexpr
	: bexpr AND bexpr
	| bexpr OR bexpr
	| NOT '(' bexpr ')'
	| locpath
	| nexpr relop nexpr
	;

ntst
	: '*'
	| ID':'ID
	| ID
	| 'comment()'
	| 'node()'
	| 'processing-instruction()'
	| 'text()'
	;

nexpr
	: 'position()'
	| 'last()'
	| NUMBER
	| nexpr arithop nexpr
	;

arithop
	: '+' | '-' | '*' | DIV | MOD
	;

relop
	: '=' | '!=' | '<' | '<=' | '>' | '>='
	;

