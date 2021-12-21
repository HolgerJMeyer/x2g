// Generated from x2gParser.g4 by ANTLR 4.7

//package x2g;

import java.util.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class x2gParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		STR=1, NEQ=2, NUMBER=3, POSITIV_INTEGER=4, POSITIV_DECIMAL=5, POSITIV_DOUBLE=6, 
		EXPONENT=7, ESCCHAR=8, LINE_COMMENT=9, SQL_COMMENT=10, XML_COMMENT=11, 
		C_COMMENT=12, WS=13, ADD=14, AND=15, ALTER=16, BOOLEAN=17, CREATE=18, 
		DATESPAN=19, DEL=20, DELETE=21, DROP=22, EDGE=23, EDGETYPE=24, EID=25, 
		FALSE=26, FOR=27, FROM=28, IN=29, INOUT=30, INTEGER=31, LET=32, LINESTRING=33, 
		MODEL=34, NID=35, NODE=36, NODETYPE=37, NOT=38, NUMERIC=39, OR=40, OUT=41, 
		ORDERBY=42, POINT=43, REGION=44, RETURN=45, RETURNS=46, ROLE=47, SELECT=48, 
		SET=49, STRING=50, TRUE=51, UNDER=52, UPDATE=53, VALUE=54, WHERE=55, ID=56, 
		COMMA=57, DBLCOLON=58, COLON=59, SEMICOLON=60, DOT=61, PLUS=62, MINUS=63, 
		MULT=64, DIV=65, PERCENT=66, BITOR=67, BANG=68, QMARK=69, DOLLAR=70, LT=71, 
		LE=72, GT=73, GE=74, EQ=75, IDENT=76, ASSIGN=77, LPAREN=78, RPAREN=79, 
		LBRACE=80, RBRACE=81, LBRACKET=82, RBRACKET=83, BANGNOT=84, UNEQ=85;
	public static final int
		RULE_x2g = 0, RULE_x2g_statement = 1, RULE_ddl_statement = 2, RULE_create_node_type = 3, 
		RULE_super_node_type = 4, RULE_alter_node_type = 5, RULE_drop_node_type = 6, 
		RULE_create_edge_type = 7, RULE_edge_type_definition = 8, RULE_content_model = 9, 
		RULE_role_node_type_list = 10, RULE_role_node_type = 11, RULE_quantifier = 12, 
		RULE_super_edge_type = 13, RULE_alter_edge_type = 14, RULE_drop_edge_type = 15, 
		RULE_dml_statement = 16, RULE_create_node = 17, RULE_update_node = 18, 
		RULE_delete_node = 19, RULE_returns_clause = 20, RULE_create_edge = 21, 
		RULE_update_edge = 22, RULE_delete_edge = 23, RULE_attr_list = 24, RULE_alter_attr_list = 25, 
		RULE_alter_attr = 26, RULE_query_statement = 27, RULE_variable_assignments = 28, 
		RULE_itervar_assignment_list = 29, RULE_itervar_assignment = 30, RULE_setvar_assignment_list = 31, 
		RULE_setvar_assignment = 32, RULE_set_expr = 33, RULE_where_clause = 34, 
		RULE_order_by_clause = 35, RULE_return_clause = 36, RULE_scalar_expr = 37, 
		RULE_literal_value = 38, RULE_string_literal = 39, RULE_datespan_literal = 40, 
		RULE_point_literal = 41, RULE_linestring_literal = 42, RULE_region_literal = 43, 
		RULE_numeric_literal = 44, RULE_boolean_literal = 45, RULE_attr_type = 46, 
		RULE_attr_value = 47, RULE_attr_type_list = 48, RULE_attr_definition = 49, 
		RULE_attr_value_list = 50, RULE_attr_assignment = 51, RULE_func_expr = 52, 
		RULE_func_param_list = 53, RULE_func_param = 54, RULE_scalar_func = 55, 
		RULE_nid = 56, RULE_eid = 57, RULE_node_expr = 58, RULE_nodeset_expr = 59, 
		RULE_node_constructor = 60, RULE_edge_expr = 61, RULE_edgeset_expr = 62, 
		RULE_edge_constructor = 63, RULE_role_node_sequence = 64, RULE_attr_sequence = 65, 
		RULE_scalar_sequence = 66, RULE_boolean_expr = 67, RULE_boolean_attr_expr = 68, 
		RULE_qual_attr_name = 69, RULE_value_expr = 70, RULE_boolean_node_expr = 71, 
		RULE_boolean_edge_expr = 72, RULE_comp_op = 73, RULE_unary_op = 74, RULE_binary_op = 75, 
		RULE_namespace = 76, RULE_node_type = 77, RULE_edge_type = 78, RULE_role_name = 79, 
		RULE_attr_name = 80, RULE_func_name = 81, RULE_node_var = 82, RULE_nodeset_var = 83, 
		RULE_edge_var = 84, RULE_edgeset_var = 85;
	public static final String[] ruleNames = {
		"x2g", "x2g_statement", "ddl_statement", "create_node_type", "super_node_type", 
		"alter_node_type", "drop_node_type", "create_edge_type", "edge_type_definition", 
		"content_model", "role_node_type_list", "role_node_type", "quantifier", 
		"super_edge_type", "alter_edge_type", "drop_edge_type", "dml_statement", 
		"create_node", "update_node", "delete_node", "returns_clause", "create_edge", 
		"update_edge", "delete_edge", "attr_list", "alter_attr_list", "alter_attr", 
		"query_statement", "variable_assignments", "itervar_assignment_list", 
		"itervar_assignment", "setvar_assignment_list", "setvar_assignment", "set_expr", 
		"where_clause", "order_by_clause", "return_clause", "scalar_expr", "literal_value", 
		"string_literal", "datespan_literal", "point_literal", "linestring_literal", 
		"region_literal", "numeric_literal", "boolean_literal", "attr_type", "attr_value", 
		"attr_type_list", "attr_definition", "attr_value_list", "attr_assignment", 
		"func_expr", "func_param_list", "func_param", "scalar_func", "nid", "eid", 
		"node_expr", "nodeset_expr", "node_constructor", "edge_expr", "edgeset_expr", 
		"edge_constructor", "role_node_sequence", "attr_sequence", "scalar_sequence", 
		"boolean_expr", "boolean_attr_expr", "qual_attr_name", "value_expr", "boolean_node_expr", 
		"boolean_edge_expr", "comp_op", "unary_op", "binary_op", "namespace", 
		"node_type", "edge_type", "role_name", "attr_name", "func_name", "node_var", 
		"nodeset_var", "edge_var", "edgeset_var"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, "','", "'::'", "':'", 
		"';'", "'.'", "'+'", "'-'", "'*'", "'/'", "'%'", "'|'", "'!'", "'?'", 
		"'$'", "'<'", "'<='", "'>'", "'>='", "'='", "'=='", "':='", "'('", "')'", 
		"'{'", "'}'", "'['", "']'", "'!='", "'<>'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "STR", "NEQ", "NUMBER", "POSITIV_INTEGER", "POSITIV_DECIMAL", "POSITIV_DOUBLE", 
		"EXPONENT", "ESCCHAR", "LINE_COMMENT", "SQL_COMMENT", "XML_COMMENT", "C_COMMENT", 
		"WS", "ADD", "AND", "ALTER", "BOOLEAN", "CREATE", "DATESPAN", "DEL", "DELETE", 
		"DROP", "EDGE", "EDGETYPE", "EID", "FALSE", "FOR", "FROM", "IN", "INOUT", 
		"INTEGER", "LET", "LINESTRING", "MODEL", "NID", "NODE", "NODETYPE", "NOT", 
		"NUMERIC", "OR", "OUT", "ORDERBY", "POINT", "REGION", "RETURN", "RETURNS", 
		"ROLE", "SELECT", "SET", "STRING", "TRUE", "UNDER", "UPDATE", "VALUE", 
		"WHERE", "ID", "COMMA", "DBLCOLON", "COLON", "SEMICOLON", "DOT", "PLUS", 
		"MINUS", "MULT", "DIV", "PERCENT", "BITOR", "BANG", "QMARK", "DOLLAR", 
		"LT", "LE", "GT", "GE", "EQ", "IDENT", "ASSIGN", "LPAREN", "RPAREN", "LBRACE", 
		"RBRACE", "LBRACKET", "RBRACKET", "BANGNOT", "UNEQ"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "x2gParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


		Map<String, String> nodeSetVars = new HashMap<String, String>();
		Map<String, String> edgeSetVars = new HashMap<String, String>();

	public x2gParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class X2gContext extends ParserRuleContext {
		public List<X2g_statementContext> x2g_statement() {
			return getRuleContexts(X2g_statementContext.class);
		}
		public X2g_statementContext x2g_statement(int i) {
			return getRuleContext(X2g_statementContext.class,i);
		}
		public X2gContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_x2g; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterX2g(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitX2g(this);
		}
	}

	public final X2gContext x2g() throws RecognitionException {
		X2gContext _localctx = new X2gContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_x2g);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ALTER) | (1L << CREATE) | (1L << DELETE) | (1L << DROP) | (1L << FOR) | (1L << LET) | (1L << ORDERBY) | (1L << RETURN) | (1L << UPDATE) | (1L << WHERE))) != 0)) {
				{
				{
				setState(172);
				x2g_statement();
				}
				}
				setState(177);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class X2g_statementContext extends ParserRuleContext {
		public Ddl_statementContext ddl_statement() {
			return getRuleContext(Ddl_statementContext.class,0);
		}
		public Dml_statementContext dml_statement() {
			return getRuleContext(Dml_statementContext.class,0);
		}
		public Query_statementContext query_statement() {
			return getRuleContext(Query_statementContext.class,0);
		}
		public X2g_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_x2g_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterX2g_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitX2g_statement(this);
		}
	}

	public final X2g_statementContext x2g_statement() throws RecognitionException {
		X2g_statementContext _localctx = new X2g_statementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_x2g_statement);
		try {
			setState(181);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(178);
				ddl_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(179);
				dml_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(180);
				query_statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Ddl_statementContext extends ParserRuleContext {
		public Create_node_typeContext create_node_type() {
			return getRuleContext(Create_node_typeContext.class,0);
		}
		public Alter_node_typeContext alter_node_type() {
			return getRuleContext(Alter_node_typeContext.class,0);
		}
		public Drop_node_typeContext drop_node_type() {
			return getRuleContext(Drop_node_typeContext.class,0);
		}
		public Create_edge_typeContext create_edge_type() {
			return getRuleContext(Create_edge_typeContext.class,0);
		}
		public Alter_edge_typeContext alter_edge_type() {
			return getRuleContext(Alter_edge_typeContext.class,0);
		}
		public Drop_edge_typeContext drop_edge_type() {
			return getRuleContext(Drop_edge_typeContext.class,0);
		}
		public Ddl_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ddl_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterDdl_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitDdl_statement(this);
		}
	}

	public final Ddl_statementContext ddl_statement() throws RecognitionException {
		Ddl_statementContext _localctx = new Ddl_statementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_ddl_statement);
		try {
			setState(189);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(183);
				create_node_type();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(184);
				alter_node_type();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(185);
				drop_node_type();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(186);
				create_edge_type();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(187);
				alter_edge_type();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(188);
				drop_edge_type();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Create_node_typeContext extends ParserRuleContext {
		public TerminalNode CREATE() { return getToken(x2gParser.CREATE, 0); }
		public TerminalNode NODETYPE() { return getToken(x2gParser.NODETYPE, 0); }
		public Node_typeContext node_type() {
			return getRuleContext(Node_typeContext.class,0);
		}
		public Super_node_typeContext super_node_type() {
			return getRuleContext(Super_node_typeContext.class,0);
		}
		public Attr_type_listContext attr_type_list() {
			return getRuleContext(Attr_type_listContext.class,0);
		}
		public Create_node_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_node_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterCreate_node_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitCreate_node_type(this);
		}
	}

	public final Create_node_typeContext create_node_type() throws RecognitionException {
		Create_node_typeContext _localctx = new Create_node_typeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_create_node_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			match(CREATE);
			setState(192);
			match(NODETYPE);
			setState(193);
			node_type();
			setState(195);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==UNDER) {
				{
				setState(194);
				super_node_type();
				}
			}

			setState(198);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(197);
				attr_type_list();
				}
			}


					System.out.println("NODETYPE:" + _input.getText(_localctx.start, _input.LT(-1)));
				  
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Super_node_typeContext extends ParserRuleContext {
		public TerminalNode UNDER() { return getToken(x2gParser.UNDER, 0); }
		public Node_typeContext node_type() {
			return getRuleContext(Node_typeContext.class,0);
		}
		public Super_node_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_super_node_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterSuper_node_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitSuper_node_type(this);
		}
	}

	public final Super_node_typeContext super_node_type() throws RecognitionException {
		Super_node_typeContext _localctx = new Super_node_typeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_super_node_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			match(UNDER);
			setState(203);
			node_type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Alter_node_typeContext extends ParserRuleContext {
		public TerminalNode ALTER() { return getToken(x2gParser.ALTER, 0); }
		public TerminalNode NODETYPE() { return getToken(x2gParser.NODETYPE, 0); }
		public Node_typeContext node_type() {
			return getRuleContext(Node_typeContext.class,0);
		}
		public Alter_attr_listContext alter_attr_list() {
			return getRuleContext(Alter_attr_listContext.class,0);
		}
		public Alter_node_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alter_node_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterAlter_node_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitAlter_node_type(this);
		}
	}

	public final Alter_node_typeContext alter_node_type() throws RecognitionException {
		Alter_node_typeContext _localctx = new Alter_node_typeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_alter_node_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			match(ALTER);
			setState(206);
			match(NODETYPE);
			setState(207);
			node_type();
			setState(208);
			alter_attr_list();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Drop_node_typeContext extends ParserRuleContext {
		public TerminalNode DROP() { return getToken(x2gParser.DROP, 0); }
		public TerminalNode NODETYPE() { return getToken(x2gParser.NODETYPE, 0); }
		public Node_typeContext node_type() {
			return getRuleContext(Node_typeContext.class,0);
		}
		public Drop_node_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drop_node_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterDrop_node_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitDrop_node_type(this);
		}
	}

	public final Drop_node_typeContext drop_node_type() throws RecognitionException {
		Drop_node_typeContext _localctx = new Drop_node_typeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_drop_node_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			match(DROP);
			setState(211);
			match(NODETYPE);
			setState(212);
			node_type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Create_edge_typeContext extends ParserRuleContext {
		public TerminalNode CREATE() { return getToken(x2gParser.CREATE, 0); }
		public TerminalNode EDGETYPE() { return getToken(x2gParser.EDGETYPE, 0); }
		public Edge_type_definitionContext edge_type_definition() {
			return getRuleContext(Edge_type_definitionContext.class,0);
		}
		public Create_edge_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_edge_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterCreate_edge_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitCreate_edge_type(this);
		}
	}

	public final Create_edge_typeContext create_edge_type() throws RecognitionException {
		Create_edge_typeContext _localctx = new Create_edge_typeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_create_edge_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			match(CREATE);
			setState(215);
			match(EDGETYPE);
			setState(216);
			edge_type_definition();

					System.out.println("EDGETYPE:" + _input.getText(_localctx.start, _input.LT(-1)));
				  
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Edge_type_definitionContext extends ParserRuleContext {
		public Edge_typeContext edge_type() {
			return getRuleContext(Edge_typeContext.class,0);
		}
		public Super_edge_typeContext super_edge_type() {
			return getRuleContext(Super_edge_typeContext.class,0);
		}
		public Attr_type_listContext attr_type_list() {
			return getRuleContext(Attr_type_listContext.class,0);
		}
		public Content_modelContext content_model() {
			return getRuleContext(Content_modelContext.class,0);
		}
		public Edge_type_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_edge_type_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterEdge_type_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitEdge_type_definition(this);
		}
	}

	public final Edge_type_definitionContext edge_type_definition() throws RecognitionException {
		Edge_type_definitionContext _localctx = new Edge_type_definitionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_edge_type_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			edge_type();
			setState(221);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==UNDER) {
				{
				setState(220);
				super_edge_type();
				}
			}

			setState(224);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(223);
				attr_type_list();
				}
			}

			setState(227);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MODEL) {
				{
				setState(226);
				content_model();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Content_modelContext extends ParserRuleContext {
		public TerminalNode MODEL() { return getToken(x2gParser.MODEL, 0); }
		public Role_node_type_listContext role_node_type_list() {
			return getRuleContext(Role_node_type_listContext.class,0);
		}
		public Content_modelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_content_model; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterContent_model(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitContent_model(this);
		}
	}

	public final Content_modelContext content_model() throws RecognitionException {
		Content_modelContext _localctx = new Content_modelContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_content_model);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			match(MODEL);
			setState(230);
			match(LPAREN);
			setState(231);
			role_node_type_list();
			setState(232);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Role_node_type_listContext extends ParserRuleContext {
		public Role_node_typeContext role_node_type() {
			return getRuleContext(Role_node_typeContext.class,0);
		}
		public Role_node_type_listContext role_node_type_list() {
			return getRuleContext(Role_node_type_listContext.class,0);
		}
		public QuantifierContext quantifier() {
			return getRuleContext(QuantifierContext.class,0);
		}
		public Role_node_type_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_role_node_type_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterRole_node_type_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitRole_node_type_list(this);
		}
	}

	public final Role_node_type_listContext role_node_type_list() throws RecognitionException {
		Role_node_type_listContext _localctx = new Role_node_type_listContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_role_node_type_list);
		int _la;
		try {
			setState(249);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(234);
				role_node_type();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(235);
				role_node_type();
				setState(236);
				match(COMMA);
				setState(237);
				role_node_type_list();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(239);
				role_node_type();
				setState(240);
				match(BITOR);
				setState(241);
				role_node_type_list();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(243);
				match(LPAREN);
				setState(244);
				role_node_type_list();
				setState(245);
				match(RPAREN);
				setState(247);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 62)) & ~0x3f) == 0 && ((1L << (_la - 62)) & ((1L << (PLUS - 62)) | (1L << (MULT - 62)) | (1L << (QMARK - 62)))) != 0)) {
					{
					setState(246);
					quantifier();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Role_node_typeContext extends ParserRuleContext {
		public Role_nameContext role_name() {
			return getRuleContext(Role_nameContext.class,0);
		}
		public Node_typeContext node_type() {
			return getRuleContext(Node_typeContext.class,0);
		}
		public QuantifierContext quantifier() {
			return getRuleContext(QuantifierContext.class,0);
		}
		public TerminalNode INOUT() { return getToken(x2gParser.INOUT, 0); }
		public TerminalNode IN() { return getToken(x2gParser.IN, 0); }
		public TerminalNode OUT() { return getToken(x2gParser.OUT, 0); }
		public Role_node_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_role_node_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterRole_node_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitRole_node_type(this);
		}
	}

	public final Role_node_typeContext role_node_type() throws RecognitionException {
		Role_node_typeContext _localctx = new Role_node_typeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_role_node_type);
		int _la;
		try {
			setState(287);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(251);
				role_name();
				setState(252);
				match(COLON);
				setState(253);
				node_type();
				setState(255);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 62)) & ~0x3f) == 0 && ((1L << (_la - 62)) & ((1L << (PLUS - 62)) | (1L << (MULT - 62)) | (1L << (QMARK - 62)))) != 0)) {
					{
					setState(254);
					quantifier();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(257);
				role_name();
				setState(258);
				match(INOUT);
				setState(259);
				node_type();
				setState(261);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 62)) & ~0x3f) == 0 && ((1L << (_la - 62)) & ((1L << (PLUS - 62)) | (1L << (MULT - 62)) | (1L << (QMARK - 62)))) != 0)) {
					{
					setState(260);
					quantifier();
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(263);
				role_name();
				setState(264);
				match(LT);
				setState(265);
				node_type();
				setState(267);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 62)) & ~0x3f) == 0 && ((1L << (_la - 62)) & ((1L << (PLUS - 62)) | (1L << (MULT - 62)) | (1L << (QMARK - 62)))) != 0)) {
					{
					setState(266);
					quantifier();
					}
				}

				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(269);
				role_name();
				setState(270);
				match(IN);
				setState(271);
				node_type();
				setState(273);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 62)) & ~0x3f) == 0 && ((1L << (_la - 62)) & ((1L << (PLUS - 62)) | (1L << (MULT - 62)) | (1L << (QMARK - 62)))) != 0)) {
					{
					setState(272);
					quantifier();
					}
				}

				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(275);
				role_name();
				setState(276);
				match(GT);
				setState(277);
				node_type();
				setState(279);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 62)) & ~0x3f) == 0 && ((1L << (_la - 62)) & ((1L << (PLUS - 62)) | (1L << (MULT - 62)) | (1L << (QMARK - 62)))) != 0)) {
					{
					setState(278);
					quantifier();
					}
				}

				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(281);
				role_name();
				setState(282);
				match(OUT);
				setState(283);
				node_type();
				setState(285);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 62)) & ~0x3f) == 0 && ((1L << (_la - 62)) & ((1L << (PLUS - 62)) | (1L << (MULT - 62)) | (1L << (QMARK - 62)))) != 0)) {
					{
					setState(284);
					quantifier();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuantifierContext extends ParserRuleContext {
		public QuantifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quantifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterQuantifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitQuantifier(this);
		}
	}

	public final QuantifierContext quantifier() throws RecognitionException {
		QuantifierContext _localctx = new QuantifierContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_quantifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289);
			_la = _input.LA(1);
			if ( !(((((_la - 62)) & ~0x3f) == 0 && ((1L << (_la - 62)) & ((1L << (PLUS - 62)) | (1L << (MULT - 62)) | (1L << (QMARK - 62)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Super_edge_typeContext extends ParserRuleContext {
		public TerminalNode UNDER() { return getToken(x2gParser.UNDER, 0); }
		public Edge_typeContext edge_type() {
			return getRuleContext(Edge_typeContext.class,0);
		}
		public Super_edge_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_super_edge_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterSuper_edge_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitSuper_edge_type(this);
		}
	}

	public final Super_edge_typeContext super_edge_type() throws RecognitionException {
		Super_edge_typeContext _localctx = new Super_edge_typeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_super_edge_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
			match(UNDER);
			setState(292);
			edge_type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Alter_edge_typeContext extends ParserRuleContext {
		public TerminalNode ALTER() { return getToken(x2gParser.ALTER, 0); }
		public TerminalNode EDGETYPE() { return getToken(x2gParser.EDGETYPE, 0); }
		public Edge_typeContext edge_type() {
			return getRuleContext(Edge_typeContext.class,0);
		}
		public Alter_attr_listContext alter_attr_list() {
			return getRuleContext(Alter_attr_listContext.class,0);
		}
		public Alter_edge_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alter_edge_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterAlter_edge_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitAlter_edge_type(this);
		}
	}

	public final Alter_edge_typeContext alter_edge_type() throws RecognitionException {
		Alter_edge_typeContext _localctx = new Alter_edge_typeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_alter_edge_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			match(ALTER);
			setState(295);
			match(EDGETYPE);
			setState(296);
			edge_type();
			setState(297);
			alter_attr_list();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Drop_edge_typeContext extends ParserRuleContext {
		public TerminalNode DROP() { return getToken(x2gParser.DROP, 0); }
		public TerminalNode EDGETYPE() { return getToken(x2gParser.EDGETYPE, 0); }
		public Edge_typeContext edge_type() {
			return getRuleContext(Edge_typeContext.class,0);
		}
		public Drop_edge_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drop_edge_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterDrop_edge_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitDrop_edge_type(this);
		}
	}

	public final Drop_edge_typeContext drop_edge_type() throws RecognitionException {
		Drop_edge_typeContext _localctx = new Drop_edge_typeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_drop_edge_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(299);
			match(DROP);
			setState(300);
			match(EDGETYPE);
			setState(301);
			edge_type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Dml_statementContext extends ParserRuleContext {
		public Create_nodeContext create_node() {
			return getRuleContext(Create_nodeContext.class,0);
		}
		public Update_nodeContext update_node() {
			return getRuleContext(Update_nodeContext.class,0);
		}
		public Delete_nodeContext delete_node() {
			return getRuleContext(Delete_nodeContext.class,0);
		}
		public Create_edgeContext create_edge() {
			return getRuleContext(Create_edgeContext.class,0);
		}
		public Update_edgeContext update_edge() {
			return getRuleContext(Update_edgeContext.class,0);
		}
		public Delete_edgeContext delete_edge() {
			return getRuleContext(Delete_edgeContext.class,0);
		}
		public Dml_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dml_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterDml_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitDml_statement(this);
		}
	}

	public final Dml_statementContext dml_statement() throws RecognitionException {
		Dml_statementContext _localctx = new Dml_statementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_dml_statement);
		try {
			setState(309);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(303);
				create_node();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(304);
				update_node();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(305);
				delete_node();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(306);
				create_edge();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(307);
				update_edge();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(308);
				delete_edge();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Create_nodeContext extends ParserRuleContext {
		public TerminalNode CREATE() { return getToken(x2gParser.CREATE, 0); }
		public TerminalNode NODE() { return getToken(x2gParser.NODE, 0); }
		public Node_typeContext node_type() {
			return getRuleContext(Node_typeContext.class,0);
		}
		public Attr_value_listContext attr_value_list() {
			return getRuleContext(Attr_value_listContext.class,0);
		}
		public Returns_clauseContext returns_clause() {
			return getRuleContext(Returns_clauseContext.class,0);
		}
		public Create_nodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_node; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterCreate_node(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitCreate_node(this);
		}
	}

	public final Create_nodeContext create_node() throws RecognitionException {
		Create_nodeContext _localctx = new Create_nodeContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_create_node);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(311);
			match(CREATE);
			setState(312);
			match(NODE);
			setState(313);
			node_type();
			setState(314);
			match(LPAREN);
			setState(315);
			attr_value_list();
			setState(316);
			match(RPAREN);
			setState(318);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RETURNS) {
				{
				setState(317);
				returns_clause();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Update_nodeContext extends ParserRuleContext {
		public TerminalNode UPDATE() { return getToken(x2gParser.UPDATE, 0); }
		public TerminalNode NODE() { return getToken(x2gParser.NODE, 0); }
		public Node_typeContext node_type() {
			return getRuleContext(Node_typeContext.class,0);
		}
		public TerminalNode SET() { return getToken(x2gParser.SET, 0); }
		public Attr_value_listContext attr_value_list() {
			return getRuleContext(Attr_value_listContext.class,0);
		}
		public Where_clauseContext where_clause() {
			return getRuleContext(Where_clauseContext.class,0);
		}
		public Update_nodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_update_node; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterUpdate_node(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitUpdate_node(this);
		}
	}

	public final Update_nodeContext update_node() throws RecognitionException {
		Update_nodeContext _localctx = new Update_nodeContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_update_node);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			match(UPDATE);
			setState(321);
			match(NODE);
			setState(322);
			node_type();
			setState(323);
			match(SET);
			setState(324);
			attr_value_list();
			setState(326);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(325);
				where_clause();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Delete_nodeContext extends ParserRuleContext {
		public TerminalNode DELETE() { return getToken(x2gParser.DELETE, 0); }
		public TerminalNode NODE() { return getToken(x2gParser.NODE, 0); }
		public Node_typeContext node_type() {
			return getRuleContext(Node_typeContext.class,0);
		}
		public Where_clauseContext where_clause() {
			return getRuleContext(Where_clauseContext.class,0);
		}
		public Delete_nodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delete_node; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterDelete_node(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitDelete_node(this);
		}
	}

	public final Delete_nodeContext delete_node() throws RecognitionException {
		Delete_nodeContext _localctx = new Delete_nodeContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_delete_node);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			match(DELETE);
			setState(329);
			match(NODE);
			setState(330);
			node_type();
			setState(332);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(331);
				where_clause();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Returns_clauseContext extends ParserRuleContext {
		public TerminalNode RETURNS() { return getToken(x2gParser.RETURNS, 0); }
		public TerminalNode NID() { return getToken(x2gParser.NID, 0); }
		public TerminalNode EID() { return getToken(x2gParser.EID, 0); }
		public Returns_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returns_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterReturns_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitReturns_clause(this);
		}
	}

	public final Returns_clauseContext returns_clause() throws RecognitionException {
		Returns_clauseContext _localctx = new Returns_clauseContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_returns_clause);
		try {
			setState(338);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(334);
				match(RETURNS);
				setState(335);
				match(NID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(336);
				match(RETURNS);
				setState(337);
				match(EID);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Create_edgeContext extends ParserRuleContext {
		public TerminalNode CREATE() { return getToken(x2gParser.CREATE, 0); }
		public TerminalNode EDGE() { return getToken(x2gParser.EDGE, 0); }
		public Edge_typeContext edge_type() {
			return getRuleContext(Edge_typeContext.class,0);
		}
		public Attr_value_listContext attr_value_list() {
			return getRuleContext(Attr_value_listContext.class,0);
		}
		public Returns_clauseContext returns_clause() {
			return getRuleContext(Returns_clauseContext.class,0);
		}
		public Create_edgeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_edge; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterCreate_edge(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitCreate_edge(this);
		}
	}

	public final Create_edgeContext create_edge() throws RecognitionException {
		Create_edgeContext _localctx = new Create_edgeContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_create_edge);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(340);
			match(CREATE);
			setState(341);
			match(EDGE);
			setState(342);
			edge_type();
			setState(343);
			match(LPAREN);
			setState(344);
			attr_value_list();
			setState(345);
			match(RPAREN);
			setState(347);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RETURNS) {
				{
				setState(346);
				returns_clause();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Update_edgeContext extends ParserRuleContext {
		public TerminalNode UPDATE() { return getToken(x2gParser.UPDATE, 0); }
		public TerminalNode EDGE() { return getToken(x2gParser.EDGE, 0); }
		public Edge_typeContext edge_type() {
			return getRuleContext(Edge_typeContext.class,0);
		}
		public TerminalNode SET() { return getToken(x2gParser.SET, 0); }
		public Attr_value_listContext attr_value_list() {
			return getRuleContext(Attr_value_listContext.class,0);
		}
		public Where_clauseContext where_clause() {
			return getRuleContext(Where_clauseContext.class,0);
		}
		public TerminalNode ADD() { return getToken(x2gParser.ADD, 0); }
		public TerminalNode ROLE() { return getToken(x2gParser.ROLE, 0); }
		public Role_nameContext role_name() {
			return getRuleContext(Role_nameContext.class,0);
		}
		public Node_exprContext node_expr() {
			return getRuleContext(Node_exprContext.class,0);
		}
		public TerminalNode DEL() { return getToken(x2gParser.DEL, 0); }
		public Update_edgeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_update_edge; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterUpdate_edge(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitUpdate_edge(this);
		}
	}

	public final Update_edgeContext update_edge() throws RecognitionException {
		Update_edgeContext _localctx = new Update_edgeContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_update_edge);
		try {
			setState(379);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(349);
				match(UPDATE);
				setState(350);
				match(EDGE);
				setState(351);
				edge_type();
				setState(352);
				match(SET);
				setState(353);
				attr_value_list();
				setState(355);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(354);
					where_clause();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(357);
				match(UPDATE);
				setState(358);
				match(EDGE);
				setState(359);
				edge_type();
				setState(360);
				match(ADD);
				setState(361);
				match(ROLE);
				setState(362);
				role_name();
				setState(363);
				match(COLON);
				setState(364);
				node_expr();
				setState(366);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(365);
					where_clause();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(368);
				match(UPDATE);
				setState(369);
				match(EDGE);
				setState(370);
				edge_type();
				setState(371);
				match(DEL);
				setState(372);
				match(ROLE);
				setState(373);
				role_name();
				setState(374);
				match(COLON);
				setState(375);
				node_expr();
				setState(377);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
				case 1:
					{
					setState(376);
					where_clause();
					}
					break;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Delete_edgeContext extends ParserRuleContext {
		public TerminalNode DELETE() { return getToken(x2gParser.DELETE, 0); }
		public TerminalNode EDGE() { return getToken(x2gParser.EDGE, 0); }
		public Edge_typeContext edge_type() {
			return getRuleContext(Edge_typeContext.class,0);
		}
		public Where_clauseContext where_clause() {
			return getRuleContext(Where_clauseContext.class,0);
		}
		public Delete_edgeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delete_edge; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterDelete_edge(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitDelete_edge(this);
		}
	}

	public final Delete_edgeContext delete_edge() throws RecognitionException {
		Delete_edgeContext _localctx = new Delete_edgeContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_delete_edge);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(381);
			match(DELETE);
			setState(382);
			match(EDGE);
			setState(383);
			edge_type();
			setState(385);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(384);
				where_clause();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Attr_listContext extends ParserRuleContext {
		public List<Attr_nameContext> attr_name() {
			return getRuleContexts(Attr_nameContext.class);
		}
		public Attr_nameContext attr_name(int i) {
			return getRuleContext(Attr_nameContext.class,i);
		}
		public Attr_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attr_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterAttr_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitAttr_list(this);
		}
	}

	public final Attr_listContext attr_list() throws RecognitionException {
		Attr_listContext _localctx = new Attr_listContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_attr_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(387);
			attr_name();
			setState(392);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(388);
				match(COMMA);
				setState(389);
				attr_name();
				}
				}
				setState(394);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Alter_attr_listContext extends ParserRuleContext {
		public List<Alter_attrContext> alter_attr() {
			return getRuleContexts(Alter_attrContext.class);
		}
		public Alter_attrContext alter_attr(int i) {
			return getRuleContext(Alter_attrContext.class,i);
		}
		public Alter_attr_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alter_attr_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterAlter_attr_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitAlter_attr_list(this);
		}
	}

	public final Alter_attr_listContext alter_attr_list() throws RecognitionException {
		Alter_attr_listContext _localctx = new Alter_attr_listContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_alter_attr_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(395);
			alter_attr();
			setState(400);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(396);
				match(COMMA);
				setState(397);
				alter_attr();
				}
				}
				setState(402);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Alter_attrContext extends ParserRuleContext {
		public TerminalNode ADD() { return getToken(x2gParser.ADD, 0); }
		public Attr_nameContext attr_name() {
			return getRuleContext(Attr_nameContext.class,0);
		}
		public Attr_typeContext attr_type() {
			return getRuleContext(Attr_typeContext.class,0);
		}
		public TerminalNode DEL() { return getToken(x2gParser.DEL, 0); }
		public Alter_attrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alter_attr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterAlter_attr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitAlter_attr(this);
		}
	}

	public final Alter_attrContext alter_attr() throws RecognitionException {
		Alter_attrContext _localctx = new Alter_attrContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_alter_attr);
		try {
			setState(409);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ADD:
				enterOuterAlt(_localctx, 1);
				{
				setState(403);
				match(ADD);
				setState(404);
				attr_name();
				setState(405);
				attr_type();
				}
				break;
			case DEL:
				enterOuterAlt(_localctx, 2);
				{
				setState(407);
				match(DEL);
				setState(408);
				attr_name();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Query_statementContext extends ParserRuleContext {
		public Return_clauseContext return_clause() {
			return getRuleContext(Return_clauseContext.class,0);
		}
		public Variable_assignmentsContext variable_assignments() {
			return getRuleContext(Variable_assignmentsContext.class,0);
		}
		public Where_clauseContext where_clause() {
			return getRuleContext(Where_clauseContext.class,0);
		}
		public Order_by_clauseContext order_by_clause() {
			return getRuleContext(Order_by_clauseContext.class,0);
		}
		public Query_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterQuery_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitQuery_statement(this);
		}
	}

	public final Query_statementContext query_statement() throws RecognitionException {
		Query_statementContext _localctx = new Query_statementContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_query_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(412);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FOR || _la==LET) {
				{
				setState(411);
				variable_assignments();
				}
			}

			setState(415);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(414);
				where_clause();
				}
			}

			setState(418);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ORDERBY) {
				{
				setState(417);
				order_by_clause();
				}
			}

			setState(420);
			return_clause();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Variable_assignmentsContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(x2gParser.FOR, 0); }
		public Itervar_assignment_listContext itervar_assignment_list() {
			return getRuleContext(Itervar_assignment_listContext.class,0);
		}
		public TerminalNode LET() { return getToken(x2gParser.LET, 0); }
		public Setvar_assignment_listContext setvar_assignment_list() {
			return getRuleContext(Setvar_assignment_listContext.class,0);
		}
		public Variable_assignmentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_assignments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterVariable_assignments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitVariable_assignments(this);
		}
	}

	public final Variable_assignmentsContext variable_assignments() throws RecognitionException {
		Variable_assignmentsContext _localctx = new Variable_assignmentsContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_variable_assignments);
		try {
			setState(426);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(422);
				match(FOR);
				setState(423);
				itervar_assignment_list();
				}
				break;
			case LET:
				enterOuterAlt(_localctx, 2);
				{
				setState(424);
				match(LET);
				setState(425);
				setvar_assignment_list();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Itervar_assignment_listContext extends ParserRuleContext {
		public Itervar_assignmentContext itervar_assignment() {
			return getRuleContext(Itervar_assignmentContext.class,0);
		}
		public List<Itervar_assignment_listContext> itervar_assignment_list() {
			return getRuleContexts(Itervar_assignment_listContext.class);
		}
		public Itervar_assignment_listContext itervar_assignment_list(int i) {
			return getRuleContext(Itervar_assignment_listContext.class,i);
		}
		public Itervar_assignment_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_itervar_assignment_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterItervar_assignment_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitItervar_assignment_list(this);
		}
	}

	public final Itervar_assignment_listContext itervar_assignment_list() throws RecognitionException {
		Itervar_assignment_listContext _localctx = new Itervar_assignment_listContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_itervar_assignment_list);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(428);
			itervar_assignment();
			setState(433);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(429);
					match(COMMA);
					setState(430);
					itervar_assignment_list();
					}
					} 
				}
				setState(435);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Itervar_assignmentContext extends ParserRuleContext {
		public Token ID;
		public Nodeset_exprContext nodeset_expr;
		public Edgeset_exprContext edgeset_expr;
		public TerminalNode ID() { return getToken(x2gParser.ID, 0); }
		public TerminalNode IN() { return getToken(x2gParser.IN, 0); }
		public Nodeset_exprContext nodeset_expr() {
			return getRuleContext(Nodeset_exprContext.class,0);
		}
		public Edgeset_exprContext edgeset_expr() {
			return getRuleContext(Edgeset_exprContext.class,0);
		}
		public Itervar_assignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_itervar_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterItervar_assignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitItervar_assignment(this);
		}
	}

	public final Itervar_assignmentContext itervar_assignment() throws RecognitionException {
		Itervar_assignmentContext _localctx = new Itervar_assignmentContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_itervar_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(436);
			match(DOLLAR);
			setState(437);
			((Itervar_assignmentContext)_localctx).ID = match(ID);
			setState(438);
			match(IN);
			setState(441);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				{
				setState(439);
				((Itervar_assignmentContext)_localctx).nodeset_expr = nodeset_expr();
				}
				break;
			case 2:
				{
				setState(440);
				((Itervar_assignmentContext)_localctx).edgeset_expr = edgeset_expr();
				}
				break;
			}

					if ((((Itervar_assignmentContext)_localctx).nodeset_expr!=null?_input.getText(((Itervar_assignmentContext)_localctx).nodeset_expr.start,((Itervar_assignmentContext)_localctx).nodeset_expr.stop):null)!=null)
						nodeSetVars.put((((Itervar_assignmentContext)_localctx).ID!=null?((Itervar_assignmentContext)_localctx).ID.getText():null), (((Itervar_assignmentContext)_localctx).nodeset_expr!=null?_input.getText(((Itervar_assignmentContext)_localctx).nodeset_expr.start,((Itervar_assignmentContext)_localctx).nodeset_expr.stop):null));
					else
						edgeSetVars.put((((Itervar_assignmentContext)_localctx).ID!=null?((Itervar_assignmentContext)_localctx).ID.getText():null), (((Itervar_assignmentContext)_localctx).edgeset_expr!=null?_input.getText(((Itervar_assignmentContext)_localctx).edgeset_expr.start,((Itervar_assignmentContext)_localctx).edgeset_expr.stop):null));
					notifyErrorListeners("iterator variable assignment");
				  
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Setvar_assignment_listContext extends ParserRuleContext {
		public Setvar_assignmentContext setvar_assignment() {
			return getRuleContext(Setvar_assignmentContext.class,0);
		}
		public List<Setvar_assignment_listContext> setvar_assignment_list() {
			return getRuleContexts(Setvar_assignment_listContext.class);
		}
		public Setvar_assignment_listContext setvar_assignment_list(int i) {
			return getRuleContext(Setvar_assignment_listContext.class,i);
		}
		public Setvar_assignment_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setvar_assignment_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterSetvar_assignment_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitSetvar_assignment_list(this);
		}
	}

	public final Setvar_assignment_listContext setvar_assignment_list() throws RecognitionException {
		Setvar_assignment_listContext _localctx = new Setvar_assignment_listContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_setvar_assignment_list);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(445);
			setvar_assignment();
			setState(450);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(446);
					match(COMMA);
					setState(447);
					setvar_assignment_list();
					}
					} 
				}
				setState(452);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Setvar_assignmentContext extends ParserRuleContext {
		public Token ID;
		public Nodeset_exprContext nodeset_expr;
		public Edgeset_exprContext edgeset_expr;
		public TerminalNode ID() { return getToken(x2gParser.ID, 0); }
		public Nodeset_exprContext nodeset_expr() {
			return getRuleContext(Nodeset_exprContext.class,0);
		}
		public Edgeset_exprContext edgeset_expr() {
			return getRuleContext(Edgeset_exprContext.class,0);
		}
		public Setvar_assignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setvar_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterSetvar_assignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitSetvar_assignment(this);
		}
	}

	public final Setvar_assignmentContext setvar_assignment() throws RecognitionException {
		Setvar_assignmentContext _localctx = new Setvar_assignmentContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_setvar_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(453);
			match(DOLLAR);
			setState(454);
			((Setvar_assignmentContext)_localctx).ID = match(ID);
			setState(455);
			match(ASSIGN);
			setState(458);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				{
				setState(456);
				((Setvar_assignmentContext)_localctx).nodeset_expr = nodeset_expr();
				}
				break;
			case 2:
				{
				setState(457);
				((Setvar_assignmentContext)_localctx).edgeset_expr = edgeset_expr();
				}
				break;
			}

					if ((((Setvar_assignmentContext)_localctx).nodeset_expr!=null?_input.getText(((Setvar_assignmentContext)_localctx).nodeset_expr.start,((Setvar_assignmentContext)_localctx).nodeset_expr.stop):null)!=null)
						nodeSetVars.put((((Setvar_assignmentContext)_localctx).ID!=null?((Setvar_assignmentContext)_localctx).ID.getText():null), (((Setvar_assignmentContext)_localctx).nodeset_expr!=null?_input.getText(((Setvar_assignmentContext)_localctx).nodeset_expr.start,((Setvar_assignmentContext)_localctx).nodeset_expr.stop):null));
					else
						edgeSetVars.put((((Setvar_assignmentContext)_localctx).ID!=null?((Setvar_assignmentContext)_localctx).ID.getText():null), (((Setvar_assignmentContext)_localctx).edgeset_expr!=null?_input.getText(((Setvar_assignmentContext)_localctx).edgeset_expr.start,((Setvar_assignmentContext)_localctx).edgeset_expr.stop):null));
					notifyErrorListeners("set variable assignment");
				  
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Set_exprContext extends ParserRuleContext {
		public Nodeset_exprContext nodeset_expr() {
			return getRuleContext(Nodeset_exprContext.class,0);
		}
		public Edgeset_exprContext edgeset_expr() {
			return getRuleContext(Edgeset_exprContext.class,0);
		}
		public Set_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterSet_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitSet_expr(this);
		}
	}

	public final Set_exprContext set_expr() throws RecognitionException {
		Set_exprContext _localctx = new Set_exprContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_set_expr);
		try {
			setState(464);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(462);
				nodeset_expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(463);
				edgeset_expr();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Where_clauseContext extends ParserRuleContext {
		public TerminalNode WHERE() { return getToken(x2gParser.WHERE, 0); }
		public Boolean_exprContext boolean_expr() {
			return getRuleContext(Boolean_exprContext.class,0);
		}
		public Where_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_where_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterWhere_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitWhere_clause(this);
		}
	}

	public final Where_clauseContext where_clause() throws RecognitionException {
		Where_clauseContext _localctx = new Where_clauseContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_where_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(466);
			match(WHERE);
			setState(467);
			boolean_expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Order_by_clauseContext extends ParserRuleContext {
		public TerminalNode ORDERBY() { return getToken(x2gParser.ORDERBY, 0); }
		public Attr_listContext attr_list() {
			return getRuleContext(Attr_listContext.class,0);
		}
		public Order_by_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_order_by_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterOrder_by_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitOrder_by_clause(this);
		}
	}

	public final Order_by_clauseContext order_by_clause() throws RecognitionException {
		Order_by_clauseContext _localctx = new Order_by_clauseContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_order_by_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(469);
			match(ORDERBY);
			setState(470);
			attr_list();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Return_clauseContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(x2gParser.RETURN, 0); }
		public Edgeset_exprContext edgeset_expr() {
			return getRuleContext(Edgeset_exprContext.class,0);
		}
		public Return_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterReturn_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitReturn_clause(this);
		}
	}

	public final Return_clauseContext return_clause() throws RecognitionException {
		Return_clauseContext _localctx = new Return_clauseContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_return_clause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(472);
			match(RETURN);
			setState(473);
			edgeset_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Scalar_exprContext extends ParserRuleContext {
		public Literal_valueContext literal_value() {
			return getRuleContext(Literal_valueContext.class,0);
		}
		public Scalar_funcContext scalar_func() {
			return getRuleContext(Scalar_funcContext.class,0);
		}
		public Scalar_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scalar_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterScalar_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitScalar_expr(this);
		}
	}

	public final Scalar_exprContext scalar_expr() throws RecognitionException {
		Scalar_exprContext _localctx = new Scalar_exprContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_scalar_expr);
		try {
			setState(477);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STR:
			case NUMBER:
			case FALSE:
			case TRUE:
			case VALUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(475);
				literal_value();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(476);
				scalar_func();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Literal_valueContext extends ParserRuleContext {
		public String_literalContext string_literal() {
			return getRuleContext(String_literalContext.class,0);
		}
		public Datespan_literalContext datespan_literal() {
			return getRuleContext(Datespan_literalContext.class,0);
		}
		public Point_literalContext point_literal() {
			return getRuleContext(Point_literalContext.class,0);
		}
		public Linestring_literalContext linestring_literal() {
			return getRuleContext(Linestring_literalContext.class,0);
		}
		public Region_literalContext region_literal() {
			return getRuleContext(Region_literalContext.class,0);
		}
		public Numeric_literalContext numeric_literal() {
			return getRuleContext(Numeric_literalContext.class,0);
		}
		public Boolean_literalContext boolean_literal() {
			return getRuleContext(Boolean_literalContext.class,0);
		}
		public Literal_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterLiteral_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitLiteral_value(this);
		}
	}

	public final Literal_valueContext literal_value() throws RecognitionException {
		Literal_valueContext _localctx = new Literal_valueContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_literal_value);
		try {
			setState(486);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(479);
				string_literal();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(480);
				datespan_literal();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(481);
				point_literal();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(482);
				linestring_literal();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(483);
				region_literal();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(484);
				numeric_literal();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(485);
				boolean_literal();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class String_literalContext extends ParserRuleContext {
		public TerminalNode STR() { return getToken(x2gParser.STR, 0); }
		public String_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterString_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitString_literal(this);
		}
	}

	public final String_literalContext string_literal() throws RecognitionException {
		String_literalContext _localctx = new String_literalContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_string_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(488);
			match(STR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Datespan_literalContext extends ParserRuleContext {
		public TerminalNode VALUE() { return getToken(x2gParser.VALUE, 0); }
		public Datespan_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datespan_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterDatespan_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitDatespan_literal(this);
		}
	}

	public final Datespan_literalContext datespan_literal() throws RecognitionException {
		Datespan_literalContext _localctx = new Datespan_literalContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_datespan_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(490);
			match(VALUE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Point_literalContext extends ParserRuleContext {
		public TerminalNode VALUE() { return getToken(x2gParser.VALUE, 0); }
		public Point_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_point_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterPoint_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitPoint_literal(this);
		}
	}

	public final Point_literalContext point_literal() throws RecognitionException {
		Point_literalContext _localctx = new Point_literalContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_point_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(492);
			match(VALUE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Linestring_literalContext extends ParserRuleContext {
		public TerminalNode VALUE() { return getToken(x2gParser.VALUE, 0); }
		public Linestring_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_linestring_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterLinestring_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitLinestring_literal(this);
		}
	}

	public final Linestring_literalContext linestring_literal() throws RecognitionException {
		Linestring_literalContext _localctx = new Linestring_literalContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_linestring_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(494);
			match(VALUE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Region_literalContext extends ParserRuleContext {
		public TerminalNode VALUE() { return getToken(x2gParser.VALUE, 0); }
		public Region_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_region_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterRegion_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitRegion_literal(this);
		}
	}

	public final Region_literalContext region_literal() throws RecognitionException {
		Region_literalContext _localctx = new Region_literalContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_region_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(496);
			match(VALUE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Numeric_literalContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(x2gParser.NUMBER, 0); }
		public Numeric_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numeric_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterNumeric_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitNumeric_literal(this);
		}
	}

	public final Numeric_literalContext numeric_literal() throws RecognitionException {
		Numeric_literalContext _localctx = new Numeric_literalContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_numeric_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(498);
			match(NUMBER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Boolean_literalContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(x2gParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(x2gParser.FALSE, 0); }
		public Boolean_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterBoolean_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitBoolean_literal(this);
		}
	}

	public final Boolean_literalContext boolean_literal() throws RecognitionException {
		Boolean_literalContext _localctx = new Boolean_literalContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_boolean_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(500);
			_la = _input.LA(1);
			if ( !(_la==FALSE || _la==TRUE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Attr_typeContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(x2gParser.STRING, 0); }
		public TerminalNode DATESPAN() { return getToken(x2gParser.DATESPAN, 0); }
		public TerminalNode POINT() { return getToken(x2gParser.POINT, 0); }
		public TerminalNode LINESTRING() { return getToken(x2gParser.LINESTRING, 0); }
		public TerminalNode REGION() { return getToken(x2gParser.REGION, 0); }
		public TerminalNode NUMERIC() { return getToken(x2gParser.NUMERIC, 0); }
		public TerminalNode BOOLEAN() { return getToken(x2gParser.BOOLEAN, 0); }
		public Attr_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attr_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterAttr_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitAttr_type(this);
		}
	}

	public final Attr_typeContext attr_type() throws RecognitionException {
		Attr_typeContext _localctx = new Attr_typeContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_attr_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(502);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << DATESPAN) | (1L << LINESTRING) | (1L << NUMERIC) | (1L << POINT) | (1L << REGION) | (1L << STRING))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Attr_valueContext extends ParserRuleContext {
		public Scalar_exprContext scalar_expr() {
			return getRuleContext(Scalar_exprContext.class,0);
		}
		public Attr_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attr_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterAttr_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitAttr_value(this);
		}
	}

	public final Attr_valueContext attr_value() throws RecognitionException {
		Attr_valueContext _localctx = new Attr_valueContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_attr_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(504);
			scalar_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Attr_type_listContext extends ParserRuleContext {
		public List<Attr_definitionContext> attr_definition() {
			return getRuleContexts(Attr_definitionContext.class);
		}
		public Attr_definitionContext attr_definition(int i) {
			return getRuleContext(Attr_definitionContext.class,i);
		}
		public Attr_type_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attr_type_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterAttr_type_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitAttr_type_list(this);
		}
	}

	public final Attr_type_listContext attr_type_list() throws RecognitionException {
		Attr_type_listContext _localctx = new Attr_type_listContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_attr_type_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(506);
			match(LPAREN);
			setState(507);
			attr_definition();
			setState(512);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(508);
				match(COMMA);
				setState(509);
				attr_definition();
				}
				}
				setState(514);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(515);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Attr_definitionContext extends ParserRuleContext {
		public Attr_nameContext attr_name() {
			return getRuleContext(Attr_nameContext.class,0);
		}
		public Attr_typeContext attr_type() {
			return getRuleContext(Attr_typeContext.class,0);
		}
		public Attr_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attr_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterAttr_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitAttr_definition(this);
		}
	}

	public final Attr_definitionContext attr_definition() throws RecognitionException {
		Attr_definitionContext _localctx = new Attr_definitionContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_attr_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(517);
			attr_name();
			setState(518);
			attr_type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Attr_value_listContext extends ParserRuleContext {
		public List<Attr_assignmentContext> attr_assignment() {
			return getRuleContexts(Attr_assignmentContext.class);
		}
		public Attr_assignmentContext attr_assignment(int i) {
			return getRuleContext(Attr_assignmentContext.class,i);
		}
		public Attr_value_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attr_value_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterAttr_value_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitAttr_value_list(this);
		}
	}

	public final Attr_value_listContext attr_value_list() throws RecognitionException {
		Attr_value_listContext _localctx = new Attr_value_listContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_attr_value_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(520);
			attr_assignment();
			setState(525);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(521);
				match(COMMA);
				setState(522);
				attr_assignment();
				}
				}
				setState(527);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Attr_assignmentContext extends ParserRuleContext {
		public Attr_nameContext attr_name() {
			return getRuleContext(Attr_nameContext.class,0);
		}
		public Attr_valueContext attr_value() {
			return getRuleContext(Attr_valueContext.class,0);
		}
		public Attr_assignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attr_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterAttr_assignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitAttr_assignment(this);
		}
	}

	public final Attr_assignmentContext attr_assignment() throws RecognitionException {
		Attr_assignmentContext _localctx = new Attr_assignmentContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_attr_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(528);
			attr_name();
			setState(529);
			match(EQ);
			setState(530);
			attr_value();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Func_exprContext extends ParserRuleContext {
		public Func_nameContext func_name;
		public Func_nameContext func_name() {
			return getRuleContext(Func_nameContext.class,0);
		}
		public NamespaceContext namespace() {
			return getRuleContext(NamespaceContext.class,0);
		}
		public Func_param_listContext func_param_list() {
			return getRuleContext(Func_param_listContext.class,0);
		}
		public Func_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterFunc_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitFunc_expr(this);
		}
	}

	public final Func_exprContext func_expr() throws RecognitionException {
		Func_exprContext _localctx = new Func_exprContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_func_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(535);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				{
				setState(532);
				namespace();
				setState(533);
				match(COLON);
				}
				break;
			}
			setState(537);
			((Func_exprContext)_localctx).func_name = func_name();
			setState(538);
			match(LPAREN);
			setState(540);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STR) | (1L << NUMBER) | (1L << POSITIV_INTEGER) | (1L << EDGE) | (1L << FALSE) | (1L << NODE) | (1L << TRUE) | (1L << VALUE) | (1L << ID))) != 0) || _la==DOLLAR || _la==LPAREN) {
				{
				setState(539);
				func_param_list();
				}
			}

			setState(542);
			match(RPAREN);

						System.out.println("CALL " + (((Func_exprContext)_localctx).func_name!=null?_input.getText(((Func_exprContext)_localctx).func_name.start,((Func_exprContext)_localctx).func_name.stop):null));
				  
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Func_param_listContext extends ParserRuleContext {
		public List<Func_paramContext> func_param() {
			return getRuleContexts(Func_paramContext.class);
		}
		public Func_paramContext func_param(int i) {
			return getRuleContext(Func_paramContext.class,i);
		}
		public Func_param_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_param_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterFunc_param_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitFunc_param_list(this);
		}
	}

	public final Func_param_listContext func_param_list() throws RecognitionException {
		Func_param_listContext _localctx = new Func_param_listContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_func_param_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(545);
			func_param();
			setState(550);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(546);
				match(COMMA);
				setState(547);
				func_param();
				}
				}
				setState(552);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Func_paramContext extends ParserRuleContext {
		public Node_exprContext node_expr() {
			return getRuleContext(Node_exprContext.class,0);
		}
		public Nodeset_exprContext nodeset_expr() {
			return getRuleContext(Nodeset_exprContext.class,0);
		}
		public Edge_exprContext edge_expr() {
			return getRuleContext(Edge_exprContext.class,0);
		}
		public Edgeset_exprContext edgeset_expr() {
			return getRuleContext(Edgeset_exprContext.class,0);
		}
		public Scalar_exprContext scalar_expr() {
			return getRuleContext(Scalar_exprContext.class,0);
		}
		public Func_paramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterFunc_param(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitFunc_param(this);
		}
	}

	public final Func_paramContext func_param() throws RecognitionException {
		Func_paramContext _localctx = new Func_paramContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_func_param);
		try {
			setState(558);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(553);
				node_expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(554);
				nodeset_expr();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(555);
				edge_expr();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(556);
				edgeset_expr();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(557);
				scalar_expr();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Scalar_funcContext extends ParserRuleContext {
		public Func_exprContext func_expr() {
			return getRuleContext(Func_exprContext.class,0);
		}
		public Scalar_funcContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scalar_func; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterScalar_func(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitScalar_func(this);
		}
	}

	public final Scalar_funcContext scalar_func() throws RecognitionException {
		Scalar_funcContext _localctx = new Scalar_funcContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_scalar_func);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(560);
			func_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NidContext extends ParserRuleContext {
		public TerminalNode POSITIV_INTEGER() { return getToken(x2gParser.POSITIV_INTEGER, 0); }
		public NidContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nid; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterNid(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitNid(this);
		}
	}

	public final NidContext nid() throws RecognitionException {
		NidContext _localctx = new NidContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_nid);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(562);
			match(POSITIV_INTEGER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EidContext extends ParserRuleContext {
		public TerminalNode POSITIV_INTEGER() { return getToken(x2gParser.POSITIV_INTEGER, 0); }
		public EidContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eid; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterEid(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitEid(this);
		}
	}

	public final EidContext eid() throws RecognitionException {
		EidContext _localctx = new EidContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_eid);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(564);
			match(POSITIV_INTEGER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Node_exprContext extends ParserRuleContext {
		public NidContext nid() {
			return getRuleContext(NidContext.class,0);
		}
		public Node_varContext node_var() {
			return getRuleContext(Node_varContext.class,0);
		}
		public Node_constructorContext node_constructor() {
			return getRuleContext(Node_constructorContext.class,0);
		}
		public Node_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_node_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterNode_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitNode_expr(this);
		}
	}

	public final Node_exprContext node_expr() throws RecognitionException {
		Node_exprContext _localctx = new Node_exprContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_node_expr);
		try {
			setState(569);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case POSITIV_INTEGER:
				enterOuterAlt(_localctx, 1);
				{
				setState(566);
				nid();
				}
				break;
			case DOLLAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(567);
				node_var();
				}
				break;
			case NODE:
				enterOuterAlt(_localctx, 3);
				{
				setState(568);
				node_constructor();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Nodeset_exprContext extends ParserRuleContext {
		public List<Node_exprContext> node_expr() {
			return getRuleContexts(Node_exprContext.class);
		}
		public Node_exprContext node_expr(int i) {
			return getRuleContext(Node_exprContext.class,i);
		}
		public Nodeset_varContext nodeset_var() {
			return getRuleContext(Nodeset_varContext.class,0);
		}
		public Node_constructorContext node_constructor() {
			return getRuleContext(Node_constructorContext.class,0);
		}
		public Nodeset_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nodeset_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterNodeset_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitNodeset_expr(this);
		}
	}

	public final Nodeset_exprContext nodeset_expr() throws RecognitionException {
		Nodeset_exprContext _localctx = new Nodeset_exprContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_nodeset_expr);
		int _la;
		try {
			setState(584);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(571);
				match(LPAREN);
				setState(572);
				node_expr();
				setState(577);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(573);
					match(COMMA);
					setState(574);
					node_expr();
					}
					}
					setState(579);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(580);
				match(RPAREN);
				}
				break;
			case DOLLAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(582);
				nodeset_var();
				}
				break;
			case NODE:
				enterOuterAlt(_localctx, 3);
				{
				setState(583);
				node_constructor();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Node_constructorContext extends ParserRuleContext {
		public TerminalNode NODE() { return getToken(x2gParser.NODE, 0); }
		public Attr_sequenceContext attr_sequence() {
			return getRuleContext(Attr_sequenceContext.class,0);
		}
		public Node_typeContext node_type() {
			return getRuleContext(Node_typeContext.class,0);
		}
		public Node_constructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_node_constructor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterNode_constructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitNode_constructor(this);
		}
	}

	public final Node_constructorContext node_constructor() throws RecognitionException {
		Node_constructorContext _localctx = new Node_constructorContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_node_constructor);
		try {
			setState(596);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(586);
				match(NODE);
				setState(588);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
				case 1:
					{
					setState(587);
					attr_sequence();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(590);
				match(NODE);
				setState(591);
				match(DBLCOLON);
				setState(592);
				node_type();
				setState(594);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
				case 1:
					{
					setState(593);
					attr_sequence();
					}
					break;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Edge_exprContext extends ParserRuleContext {
		public EidContext eid() {
			return getRuleContext(EidContext.class,0);
		}
		public Edge_varContext edge_var() {
			return getRuleContext(Edge_varContext.class,0);
		}
		public Edge_constructorContext edge_constructor() {
			return getRuleContext(Edge_constructorContext.class,0);
		}
		public Edge_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_edge_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterEdge_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitEdge_expr(this);
		}
	}

	public final Edge_exprContext edge_expr() throws RecognitionException {
		Edge_exprContext _localctx = new Edge_exprContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_edge_expr);
		try {
			setState(601);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case POSITIV_INTEGER:
				enterOuterAlt(_localctx, 1);
				{
				setState(598);
				eid();
				}
				break;
			case DOLLAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(599);
				edge_var();
				}
				break;
			case EDGE:
				enterOuterAlt(_localctx, 3);
				{
				setState(600);
				edge_constructor();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Edgeset_exprContext extends ParserRuleContext {
		public List<Edge_exprContext> edge_expr() {
			return getRuleContexts(Edge_exprContext.class);
		}
		public Edge_exprContext edge_expr(int i) {
			return getRuleContext(Edge_exprContext.class,i);
		}
		public Edgeset_varContext edgeset_var() {
			return getRuleContext(Edgeset_varContext.class,0);
		}
		public Edge_constructorContext edge_constructor() {
			return getRuleContext(Edge_constructorContext.class,0);
		}
		public Edgeset_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_edgeset_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterEdgeset_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitEdgeset_expr(this);
		}
	}

	public final Edgeset_exprContext edgeset_expr() throws RecognitionException {
		Edgeset_exprContext _localctx = new Edgeset_exprContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_edgeset_expr);
		int _la;
		try {
			setState(616);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(603);
				match(LPAREN);
				setState(604);
				edge_expr();
				setState(609);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(605);
					match(COMMA);
					setState(606);
					edge_expr();
					}
					}
					setState(611);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(612);
				match(RPAREN);
				}
				break;
			case DOLLAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(614);
				edgeset_var();
				}
				break;
			case EDGE:
				enterOuterAlt(_localctx, 3);
				{
				setState(615);
				edge_constructor();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Edge_constructorContext extends ParserRuleContext {
		public TerminalNode EDGE() { return getToken(x2gParser.EDGE, 0); }
		public Role_node_sequenceContext role_node_sequence() {
			return getRuleContext(Role_node_sequenceContext.class,0);
		}
		public Edge_typeContext edge_type() {
			return getRuleContext(Edge_typeContext.class,0);
		}
		public Edge_constructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_edge_constructor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterEdge_constructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitEdge_constructor(this);
		}
	}

	public final Edge_constructorContext edge_constructor() throws RecognitionException {
		Edge_constructorContext _localctx = new Edge_constructorContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_edge_constructor);
		try {
			setState(628);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(618);
				match(EDGE);
				setState(620);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
				case 1:
					{
					setState(619);
					role_node_sequence();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(622);
				match(EDGE);
				setState(623);
				match(DBLCOLON);
				setState(624);
				edge_type();
				setState(626);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
				case 1:
					{
					setState(625);
					role_node_sequence();
					}
					break;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Role_node_sequenceContext extends ParserRuleContext {
		public List<Scalar_exprContext> scalar_expr() {
			return getRuleContexts(Scalar_exprContext.class);
		}
		public Scalar_exprContext scalar_expr(int i) {
			return getRuleContext(Scalar_exprContext.class,i);
		}
		public Role_node_sequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_role_node_sequence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterRole_node_sequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitRole_node_sequence(this);
		}
	}

	public final Role_node_sequenceContext role_node_sequence() throws RecognitionException {
		Role_node_sequenceContext _localctx = new Role_node_sequenceContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_role_node_sequence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(630);
			match(LPAREN);
			setState(631);
			scalar_expr();
			setState(636);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(632);
				match(COMMA);
				setState(633);
				scalar_expr();
				}
				}
				setState(638);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(639);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Attr_sequenceContext extends ParserRuleContext {
		public List<Scalar_exprContext> scalar_expr() {
			return getRuleContexts(Scalar_exprContext.class);
		}
		public Scalar_exprContext scalar_expr(int i) {
			return getRuleContext(Scalar_exprContext.class,i);
		}
		public Attr_sequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attr_sequence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterAttr_sequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitAttr_sequence(this);
		}
	}

	public final Attr_sequenceContext attr_sequence() throws RecognitionException {
		Attr_sequenceContext _localctx = new Attr_sequenceContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_attr_sequence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(641);
			match(LPAREN);
			setState(642);
			scalar_expr();
			setState(647);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(643);
				match(COMMA);
				setState(644);
				scalar_expr();
				}
				}
				setState(649);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(650);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Scalar_sequenceContext extends ParserRuleContext {
		public List<Scalar_exprContext> scalar_expr() {
			return getRuleContexts(Scalar_exprContext.class);
		}
		public Scalar_exprContext scalar_expr(int i) {
			return getRuleContext(Scalar_exprContext.class,i);
		}
		public Scalar_sequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scalar_sequence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterScalar_sequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitScalar_sequence(this);
		}
	}

	public final Scalar_sequenceContext scalar_sequence() throws RecognitionException {
		Scalar_sequenceContext _localctx = new Scalar_sequenceContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_scalar_sequence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(652);
			match(LPAREN);
			setState(653);
			scalar_expr();
			setState(658);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(654);
				match(COMMA);
				setState(655);
				scalar_expr();
				}
				}
				setState(660);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(661);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Boolean_exprContext extends ParserRuleContext {
		public Boolean_attr_exprContext boolean_attr_expr() {
			return getRuleContext(Boolean_attr_exprContext.class,0);
		}
		public Boolean_node_exprContext boolean_node_expr() {
			return getRuleContext(Boolean_node_exprContext.class,0);
		}
		public Boolean_edge_exprContext boolean_edge_expr() {
			return getRuleContext(Boolean_edge_exprContext.class,0);
		}
		public TerminalNode NOT() { return getToken(x2gParser.NOT, 0); }
		public List<Boolean_exprContext> boolean_expr() {
			return getRuleContexts(Boolean_exprContext.class);
		}
		public Boolean_exprContext boolean_expr(int i) {
			return getRuleContext(Boolean_exprContext.class,i);
		}
		public TerminalNode AND() { return getToken(x2gParser.AND, 0); }
		public TerminalNode OR() { return getToken(x2gParser.OR, 0); }
		public Boolean_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterBoolean_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitBoolean_expr(this);
		}
	}

	public final Boolean_exprContext boolean_expr() throws RecognitionException {
		return boolean_expr(0);
	}

	private Boolean_exprContext boolean_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Boolean_exprContext _localctx = new Boolean_exprContext(_ctx, _parentState);
		Boolean_exprContext _prevctx = _localctx;
		int _startState = 134;
		enterRecursionRule(_localctx, 134, RULE_boolean_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(673);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
			case 1:
				{
				setState(664);
				boolean_attr_expr();
				}
				break;
			case 2:
				{
				setState(665);
				boolean_node_expr();
				}
				break;
			case 3:
				{
				setState(666);
				boolean_edge_expr();
				}
				break;
			case 4:
				{
				setState(667);
				match(NOT);
				setState(668);
				boolean_expr(2);
				}
				break;
			case 5:
				{
				setState(669);
				match(LPAREN);
				setState(670);
				boolean_expr(0);
				setState(671);
				match(RPAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(683);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(681);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
					case 1:
						{
						_localctx = new Boolean_exprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_boolean_expr);
						setState(675);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(676);
						match(AND);
						setState(677);
						boolean_expr(5);
						}
						break;
					case 2:
						{
						_localctx = new Boolean_exprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_boolean_expr);
						setState(678);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(679);
						match(OR);
						setState(680);
						boolean_expr(4);
						}
						break;
					}
					} 
				}
				setState(685);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Boolean_attr_exprContext extends ParserRuleContext {
		public List<Qual_attr_nameContext> qual_attr_name() {
			return getRuleContexts(Qual_attr_nameContext.class);
		}
		public Qual_attr_nameContext qual_attr_name(int i) {
			return getRuleContext(Qual_attr_nameContext.class,i);
		}
		public Comp_opContext comp_op() {
			return getRuleContext(Comp_opContext.class,0);
		}
		public Value_exprContext value_expr() {
			return getRuleContext(Value_exprContext.class,0);
		}
		public Boolean_attr_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean_attr_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterBoolean_attr_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitBoolean_attr_expr(this);
		}
	}

	public final Boolean_attr_exprContext boolean_attr_expr() throws RecognitionException {
		Boolean_attr_exprContext _localctx = new Boolean_attr_exprContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_boolean_attr_expr);
		try {
			setState(694);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(686);
				qual_attr_name();
				setState(687);
				comp_op();
				setState(688);
				value_expr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(690);
				qual_attr_name();
				setState(691);
				comp_op();
				setState(692);
				qual_attr_name();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Qual_attr_nameContext extends ParserRuleContext {
		public Node_varContext node_var() {
			return getRuleContext(Node_varContext.class,0);
		}
		public Attr_nameContext attr_name() {
			return getRuleContext(Attr_nameContext.class,0);
		}
		public Nodeset_varContext nodeset_var() {
			return getRuleContext(Nodeset_varContext.class,0);
		}
		public Node_typeContext node_type() {
			return getRuleContext(Node_typeContext.class,0);
		}
		public Edge_varContext edge_var() {
			return getRuleContext(Edge_varContext.class,0);
		}
		public Edgeset_varContext edgeset_var() {
			return getRuleContext(Edgeset_varContext.class,0);
		}
		public Edge_typeContext edge_type() {
			return getRuleContext(Edge_typeContext.class,0);
		}
		public Qual_attr_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qual_attr_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterQual_attr_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitQual_attr_name(this);
		}
	}

	public final Qual_attr_nameContext qual_attr_name() throws RecognitionException {
		Qual_attr_nameContext _localctx = new Qual_attr_nameContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_qual_attr_name);
		try {
			setState(720);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,67,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(696);
				node_var();
				setState(697);
				match(DOT);
				setState(698);
				attr_name();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(700);
				nodeset_var();
				setState(701);
				match(DOT);
				setState(702);
				attr_name();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(704);
				node_type();
				setState(705);
				match(DBLCOLON);
				setState(706);
				attr_name();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(708);
				edge_var();
				setState(709);
				match(DOT);
				setState(710);
				attr_name();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(712);
				edgeset_var();
				setState(713);
				match(DOT);
				setState(714);
				attr_name();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(716);
				edge_type();
				setState(717);
				match(DBLCOLON);
				setState(718);
				attr_name();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Value_exprContext extends ParserRuleContext {
		public Unary_opContext unary_op() {
			return getRuleContext(Unary_opContext.class,0);
		}
		public List<Value_exprContext> value_expr() {
			return getRuleContexts(Value_exprContext.class);
		}
		public Value_exprContext value_expr(int i) {
			return getRuleContext(Value_exprContext.class,i);
		}
		public Attr_valueContext attr_value() {
			return getRuleContext(Attr_valueContext.class,0);
		}
		public Binary_opContext binary_op() {
			return getRuleContext(Binary_opContext.class,0);
		}
		public Value_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterValue_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitValue_expr(this);
		}
	}

	public final Value_exprContext value_expr() throws RecognitionException {
		return value_expr(0);
	}

	private Value_exprContext value_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Value_exprContext _localctx = new Value_exprContext(_ctx, _parentState);
		Value_exprContext _prevctx = _localctx;
		int _startState = 140;
		enterRecursionRule(_localctx, 140, RULE_value_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(731);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
			case BANG:
				{
				setState(723);
				unary_op();
				setState(724);
				value_expr(4);
				}
				break;
			case LPAREN:
				{
				setState(726);
				match(LPAREN);
				setState(727);
				value_expr(0);
				setState(728);
				match(RPAREN);
				}
				break;
			case STR:
			case NUMBER:
			case FALSE:
			case TRUE:
			case VALUE:
			case ID:
				{
				setState(730);
				attr_value();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(739);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,69,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Value_exprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_value_expr);
					setState(733);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(734);
					binary_op();
					setState(735);
					value_expr(4);
					}
					} 
				}
				setState(741);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,69,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Boolean_node_exprContext extends ParserRuleContext {
		public Node_varContext node_var() {
			return getRuleContext(Node_varContext.class,0);
		}
		public Nodeset_varContext nodeset_var() {
			return getRuleContext(Nodeset_varContext.class,0);
		}
		public Attr_nameContext attr_name() {
			return getRuleContext(Attr_nameContext.class,0);
		}
		public TerminalNode IN() { return getToken(x2gParser.IN, 0); }
		public Nodeset_exprContext nodeset_expr() {
			return getRuleContext(Nodeset_exprContext.class,0);
		}
		public Edge_exprContext edge_expr() {
			return getRuleContext(Edge_exprContext.class,0);
		}
		public Edgeset_exprContext edgeset_expr() {
			return getRuleContext(Edgeset_exprContext.class,0);
		}
		public Boolean_node_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean_node_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterBoolean_node_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitBoolean_node_expr(this);
		}
	}

	public final Boolean_node_exprContext boolean_node_expr() throws RecognitionException {
		Boolean_node_exprContext _localctx = new Boolean_node_exprContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_boolean_node_expr);
		try {
			setState(764);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(742);
				node_var();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(743);
				nodeset_var();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(744);
				node_var();
				setState(745);
				match(DOT);
				setState(746);
				attr_name();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(748);
				nodeset_var();
				setState(749);
				match(DOT);
				setState(750);
				attr_name();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(752);
				node_var();
				setState(753);
				match(IN);
				setState(754);
				nodeset_expr();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(756);
				node_var();
				setState(757);
				match(IN);
				setState(758);
				edge_expr();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(760);
				node_var();
				setState(761);
				match(IN);
				setState(762);
				edgeset_expr();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Boolean_edge_exprContext extends ParserRuleContext {
		public Edge_varContext edge_var() {
			return getRuleContext(Edge_varContext.class,0);
		}
		public Edgeset_varContext edgeset_var() {
			return getRuleContext(Edgeset_varContext.class,0);
		}
		public Attr_nameContext attr_name() {
			return getRuleContext(Attr_nameContext.class,0);
		}
		public TerminalNode IN() { return getToken(x2gParser.IN, 0); }
		public Edgeset_exprContext edgeset_expr() {
			return getRuleContext(Edgeset_exprContext.class,0);
		}
		public Edge_exprContext edge_expr() {
			return getRuleContext(Edge_exprContext.class,0);
		}
		public Boolean_edge_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean_edge_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterBoolean_edge_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitBoolean_edge_expr(this);
		}
	}

	public final Boolean_edge_exprContext boolean_edge_expr() throws RecognitionException {
		Boolean_edge_exprContext _localctx = new Boolean_edge_exprContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_boolean_edge_expr);
		try {
			setState(788);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(766);
				edge_var();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(767);
				edgeset_var();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(768);
				edge_var();
				setState(769);
				match(DOT);
				setState(770);
				attr_name();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(772);
				edgeset_var();
				setState(773);
				match(DOT);
				setState(774);
				attr_name();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(776);
				edge_var();
				setState(777);
				match(IN);
				setState(778);
				edgeset_expr();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(780);
				edge_var();
				setState(781);
				match(IN);
				setState(782);
				edge_expr();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(784);
				edge_var();
				setState(785);
				match(IN);
				setState(786);
				edgeset_expr();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Comp_opContext extends ParserRuleContext {
		public Comp_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comp_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterComp_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitComp_op(this);
		}
	}

	public final Comp_opContext comp_op() throws RecognitionException {
		Comp_opContext _localctx = new Comp_opContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_comp_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(790);
			_la = _input.LA(1);
			if ( !(((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (LT - 71)) | (1L << (LE - 71)) | (1L << (GT - 71)) | (1L << (GE - 71)) | (1L << (EQ - 71)) | (1L << (IDENT - 71)) | (1L << (BANGNOT - 71)) | (1L << (UNEQ - 71)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Unary_opContext extends ParserRuleContext {
		public Unary_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterUnary_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitUnary_op(this);
		}
	}

	public final Unary_opContext unary_op() throws RecognitionException {
		Unary_opContext _localctx = new Unary_opContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_unary_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(792);
			_la = _input.LA(1);
			if ( !(_la==MINUS || _la==BANG) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Binary_opContext extends ParserRuleContext {
		public Binary_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterBinary_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitBinary_op(this);
		}
	}

	public final Binary_opContext binary_op() throws RecognitionException {
		Binary_opContext _localctx = new Binary_opContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_binary_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(794);
			_la = _input.LA(1);
			if ( !(((((_la - 62)) & ~0x3f) == 0 && ((1L << (_la - 62)) & ((1L << (PLUS - 62)) | (1L << (MINUS - 62)) | (1L << (MULT - 62)) | (1L << (DIV - 62)) | (1L << (PERCENT - 62)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NamespaceContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(x2gParser.ID, 0); }
		public NamespaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namespace; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterNamespace(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitNamespace(this);
		}
	}

	public final NamespaceContext namespace() throws RecognitionException {
		NamespaceContext _localctx = new NamespaceContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_namespace);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(796);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Node_typeContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(x2gParser.ID, 0); }
		public Node_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_node_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterNode_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitNode_type(this);
		}
	}

	public final Node_typeContext node_type() throws RecognitionException {
		Node_typeContext _localctx = new Node_typeContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_node_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(798);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Edge_typeContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(x2gParser.ID, 0); }
		public Edge_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_edge_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterEdge_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitEdge_type(this);
		}
	}

	public final Edge_typeContext edge_type() throws RecognitionException {
		Edge_typeContext _localctx = new Edge_typeContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_edge_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(800);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Role_nameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(x2gParser.ID, 0); }
		public Role_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_role_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterRole_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitRole_name(this);
		}
	}

	public final Role_nameContext role_name() throws RecognitionException {
		Role_nameContext _localctx = new Role_nameContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_role_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(802);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Attr_nameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(x2gParser.ID, 0); }
		public Attr_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attr_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterAttr_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitAttr_name(this);
		}
	}

	public final Attr_nameContext attr_name() throws RecognitionException {
		Attr_nameContext _localctx = new Attr_nameContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_attr_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(804);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Func_nameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(x2gParser.ID, 0); }
		public Func_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterFunc_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitFunc_name(this);
		}
	}

	public final Func_nameContext func_name() throws RecognitionException {
		Func_nameContext _localctx = new Func_nameContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_func_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(806);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Node_varContext extends ParserRuleContext {
		public Token ID;
		public TerminalNode ID() { return getToken(x2gParser.ID, 0); }
		public Node_varContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_node_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterNode_var(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitNode_var(this);
		}
	}

	public final Node_varContext node_var() throws RecognitionException {
		Node_varContext _localctx = new Node_varContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_node_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(808);
			match(DOLLAR);
			setState(809);
			((Node_varContext)_localctx).ID = match(ID);
			 if (!nodeSetVars.containsKey((((Node_varContext)_localctx).ID!=null?((Node_varContext)_localctx).ID.getText():null)))	notifyErrorListeners("node variable $"+(((Node_varContext)_localctx).ID!=null?((Node_varContext)_localctx).ID.getText():null)+" is unbound"); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Nodeset_varContext extends ParserRuleContext {
		public Token ID;
		public TerminalNode ID() { return getToken(x2gParser.ID, 0); }
		public Nodeset_varContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nodeset_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterNodeset_var(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitNodeset_var(this);
		}
	}

	public final Nodeset_varContext nodeset_var() throws RecognitionException {
		Nodeset_varContext _localctx = new Nodeset_varContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_nodeset_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(812);
			match(DOLLAR);
			setState(813);
			((Nodeset_varContext)_localctx).ID = match(ID);
			 if (!nodeSetVars.containsKey((((Nodeset_varContext)_localctx).ID!=null?((Nodeset_varContext)_localctx).ID.getText():null)))   notifyErrorListeners("node variable $"+(((Nodeset_varContext)_localctx).ID!=null?((Nodeset_varContext)_localctx).ID.getText():null)+" is unbound"); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Edge_varContext extends ParserRuleContext {
		public Token ID;
		public TerminalNode ID() { return getToken(x2gParser.ID, 0); }
		public Edge_varContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_edge_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterEdge_var(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitEdge_var(this);
		}
	}

	public final Edge_varContext edge_var() throws RecognitionException {
		Edge_varContext _localctx = new Edge_varContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_edge_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(816);
			match(DOLLAR);
			setState(817);
			((Edge_varContext)_localctx).ID = match(ID);
			 if (!edgeSetVars.containsKey((((Edge_varContext)_localctx).ID!=null?((Edge_varContext)_localctx).ID.getText():null)))   notifyErrorListeners("edge variable $"+(((Edge_varContext)_localctx).ID!=null?((Edge_varContext)_localctx).ID.getText():null)+" is unbound"); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Edgeset_varContext extends ParserRuleContext {
		public Token ID;
		public TerminalNode ID() { return getToken(x2gParser.ID, 0); }
		public Edgeset_varContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_edgeset_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).enterEdgeset_var(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof x2gParserListener ) ((x2gParserListener)listener).exitEdgeset_var(this);
		}
	}

	public final Edgeset_varContext edgeset_var() throws RecognitionException {
		Edgeset_varContext _localctx = new Edgeset_varContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_edgeset_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(820);
			match(DOLLAR);
			setState(821);
			((Edgeset_varContext)_localctx).ID = match(ID);
			 if (!edgeSetVars.containsKey((((Edgeset_varContext)_localctx).ID!=null?((Edgeset_varContext)_localctx).ID.getText():null)))   notifyErrorListeners("edge variable $"+(((Edgeset_varContext)_localctx).ID!=null?((Edgeset_varContext)_localctx).ID.getText():null)+" is unbound"); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 67:
			return boolean_expr_sempred((Boolean_exprContext)_localctx, predIndex);
		case 70:
			return value_expr_sempred((Value_exprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean boolean_expr_sempred(Boolean_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean value_expr_sempred(Value_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3W\u033b\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\3\2\7\2\u00b0\n\2\f\2\16\2\u00b3\13\2\3\3\3\3\3\3\5"+
		"\3\u00b8\n\3\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u00c0\n\4\3\5\3\5\3\5\3\5\5\5"+
		"\u00c6\n\5\3\5\5\5\u00c9\n\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3"+
		"\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\5\n\u00e0\n\n\3\n\5\n\u00e3"+
		"\n\n\3\n\5\n\u00e6\n\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00fa\n\f\5\f\u00fc\n\f\3\r\3\r\3\r"+
		"\3\r\5\r\u0102\n\r\3\r\3\r\3\r\3\r\5\r\u0108\n\r\3\r\3\r\3\r\3\r\5\r\u010e"+
		"\n\r\3\r\3\r\3\r\3\r\5\r\u0114\n\r\3\r\3\r\3\r\3\r\5\r\u011a\n\r\3\r\3"+
		"\r\3\r\3\r\5\r\u0120\n\r\5\r\u0122\n\r\3\16\3\16\3\17\3\17\3\17\3\20\3"+
		"\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\5"+
		"\22\u0138\n\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u0141\n\23\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\5\24\u0149\n\24\3\25\3\25\3\25\3\25\5\25\u014f"+
		"\n\25\3\26\3\26\3\26\3\26\5\26\u0155\n\26\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\5\27\u015e\n\27\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u0166\n\30\3"+
		"\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u0171\n\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u017c\n\30\5\30\u017e\n\30\3"+
		"\31\3\31\3\31\3\31\5\31\u0184\n\31\3\32\3\32\3\32\7\32\u0189\n\32\f\32"+
		"\16\32\u018c\13\32\3\33\3\33\3\33\7\33\u0191\n\33\f\33\16\33\u0194\13"+
		"\33\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u019c\n\34\3\35\5\35\u019f\n\35"+
		"\3\35\5\35\u01a2\n\35\3\35\5\35\u01a5\n\35\3\35\3\35\3\36\3\36\3\36\3"+
		"\36\5\36\u01ad\n\36\3\37\3\37\3\37\7\37\u01b2\n\37\f\37\16\37\u01b5\13"+
		"\37\3 \3 \3 \3 \3 \5 \u01bc\n \3 \3 \3!\3!\3!\7!\u01c3\n!\f!\16!\u01c6"+
		"\13!\3\"\3\"\3\"\3\"\3\"\5\"\u01cd\n\"\3\"\3\"\3#\3#\5#\u01d3\n#\3$\3"+
		"$\3$\3%\3%\3%\3&\3&\3&\3\'\3\'\5\'\u01e0\n\'\3(\3(\3(\3(\3(\3(\3(\5(\u01e9"+
		"\n(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62"+
		"\3\62\3\62\3\62\7\62\u0201\n\62\f\62\16\62\u0204\13\62\3\62\3\62\3\63"+
		"\3\63\3\63\3\64\3\64\3\64\7\64\u020e\n\64\f\64\16\64\u0211\13\64\3\65"+
		"\3\65\3\65\3\65\3\66\3\66\3\66\5\66\u021a\n\66\3\66\3\66\3\66\5\66\u021f"+
		"\n\66\3\66\3\66\3\66\3\67\3\67\3\67\7\67\u0227\n\67\f\67\16\67\u022a\13"+
		"\67\38\38\38\38\38\58\u0231\n8\39\39\3:\3:\3;\3;\3<\3<\3<\5<\u023c\n<"+
		"\3=\3=\3=\3=\7=\u0242\n=\f=\16=\u0245\13=\3=\3=\3=\3=\5=\u024b\n=\3>\3"+
		">\5>\u024f\n>\3>\3>\3>\3>\5>\u0255\n>\5>\u0257\n>\3?\3?\3?\5?\u025c\n"+
		"?\3@\3@\3@\3@\7@\u0262\n@\f@\16@\u0265\13@\3@\3@\3@\3@\5@\u026b\n@\3A"+
		"\3A\5A\u026f\nA\3A\3A\3A\3A\5A\u0275\nA\5A\u0277\nA\3B\3B\3B\3B\7B\u027d"+
		"\nB\fB\16B\u0280\13B\3B\3B\3C\3C\3C\3C\7C\u0288\nC\fC\16C\u028b\13C\3"+
		"C\3C\3D\3D\3D\3D\7D\u0293\nD\fD\16D\u0296\13D\3D\3D\3E\3E\3E\3E\3E\3E"+
		"\3E\3E\3E\3E\5E\u02a4\nE\3E\3E\3E\3E\3E\3E\7E\u02ac\nE\fE\16E\u02af\13"+
		"E\3F\3F\3F\3F\3F\3F\3F\3F\5F\u02b9\nF\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\3"+
		"G\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\3G\5G\u02d3\nG\3H\3H\3H\3H\3H\3"+
		"H\3H\3H\3H\5H\u02de\nH\3H\3H\3H\3H\7H\u02e4\nH\fH\16H\u02e7\13H\3I\3I"+
		"\3I\3I\3I\3I\3I\3I\3I\3I\3I\3I\3I\3I\3I\3I\3I\3I\3I\3I\3I\3I\5I\u02ff"+
		"\nI\3J\3J\3J\3J\3J\3J\3J\3J\3J\3J\3J\3J\3J\3J\3J\3J\3J\3J\3J\3J\3J\3J"+
		"\5J\u0317\nJ\3K\3K\3L\3L\3M\3M\3N\3N\3O\3O\3P\3P\3Q\3Q\3R\3R\3S\3S\3T"+
		"\3T\3T\3T\3U\3U\3U\3U\3V\3V\3V\3V\3W\3W\3W\3W\3W\2\4\u0088\u008eX\2\4"+
		"\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNP"+
		"RTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e"+
		"\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e\u00a0\u00a2\u00a4\u00a6"+
		"\u00a8\u00aa\u00ac\2\b\5\2@@BBGG\4\2\34\34\65\65\b\2\23\23\25\25##))-"+
		".\64\64\4\2INVW\4\2AAFF\3\2@D\2\u035a\2\u00b1\3\2\2\2\4\u00b7\3\2\2\2"+
		"\6\u00bf\3\2\2\2\b\u00c1\3\2\2\2\n\u00cc\3\2\2\2\f\u00cf\3\2\2\2\16\u00d4"+
		"\3\2\2\2\20\u00d8\3\2\2\2\22\u00dd\3\2\2\2\24\u00e7\3\2\2\2\26\u00fb\3"+
		"\2\2\2\30\u0121\3\2\2\2\32\u0123\3\2\2\2\34\u0125\3\2\2\2\36\u0128\3\2"+
		"\2\2 \u012d\3\2\2\2\"\u0137\3\2\2\2$\u0139\3\2\2\2&\u0142\3\2\2\2(\u014a"+
		"\3\2\2\2*\u0154\3\2\2\2,\u0156\3\2\2\2.\u017d\3\2\2\2\60\u017f\3\2\2\2"+
		"\62\u0185\3\2\2\2\64\u018d\3\2\2\2\66\u019b\3\2\2\28\u019e\3\2\2\2:\u01ac"+
		"\3\2\2\2<\u01ae\3\2\2\2>\u01b6\3\2\2\2@\u01bf\3\2\2\2B\u01c7\3\2\2\2D"+
		"\u01d2\3\2\2\2F\u01d4\3\2\2\2H\u01d7\3\2\2\2J\u01da\3\2\2\2L\u01df\3\2"+
		"\2\2N\u01e8\3\2\2\2P\u01ea\3\2\2\2R\u01ec\3\2\2\2T\u01ee\3\2\2\2V\u01f0"+
		"\3\2\2\2X\u01f2\3\2\2\2Z\u01f4\3\2\2\2\\\u01f6\3\2\2\2^\u01f8\3\2\2\2"+
		"`\u01fa\3\2\2\2b\u01fc\3\2\2\2d\u0207\3\2\2\2f\u020a\3\2\2\2h\u0212\3"+
		"\2\2\2j\u0219\3\2\2\2l\u0223\3\2\2\2n\u0230\3\2\2\2p\u0232\3\2\2\2r\u0234"+
		"\3\2\2\2t\u0236\3\2\2\2v\u023b\3\2\2\2x\u024a\3\2\2\2z\u0256\3\2\2\2|"+
		"\u025b\3\2\2\2~\u026a\3\2\2\2\u0080\u0276\3\2\2\2\u0082\u0278\3\2\2\2"+
		"\u0084\u0283\3\2\2\2\u0086\u028e\3\2\2\2\u0088\u02a3\3\2\2\2\u008a\u02b8"+
		"\3\2\2\2\u008c\u02d2\3\2\2\2\u008e\u02dd\3\2\2\2\u0090\u02fe\3\2\2\2\u0092"+
		"\u0316\3\2\2\2\u0094\u0318\3\2\2\2\u0096\u031a\3\2\2\2\u0098\u031c\3\2"+
		"\2\2\u009a\u031e\3\2\2\2\u009c\u0320\3\2\2\2\u009e\u0322\3\2\2\2\u00a0"+
		"\u0324\3\2\2\2\u00a2\u0326\3\2\2\2\u00a4\u0328\3\2\2\2\u00a6\u032a\3\2"+
		"\2\2\u00a8\u032e\3\2\2\2\u00aa\u0332\3\2\2\2\u00ac\u0336\3\2\2\2\u00ae"+
		"\u00b0\5\4\3\2\u00af\u00ae\3\2\2\2\u00b0\u00b3\3\2\2\2\u00b1\u00af\3\2"+
		"\2\2\u00b1\u00b2\3\2\2\2\u00b2\3\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b4\u00b8"+
		"\5\6\4\2\u00b5\u00b8\5\"\22\2\u00b6\u00b8\58\35\2\u00b7\u00b4\3\2\2\2"+
		"\u00b7\u00b5\3\2\2\2\u00b7\u00b6\3\2\2\2\u00b8\5\3\2\2\2\u00b9\u00c0\5"+
		"\b\5\2\u00ba\u00c0\5\f\7\2\u00bb\u00c0\5\16\b\2\u00bc\u00c0\5\20\t\2\u00bd"+
		"\u00c0\5\36\20\2\u00be\u00c0\5 \21\2\u00bf\u00b9\3\2\2\2\u00bf\u00ba\3"+
		"\2\2\2\u00bf\u00bb\3\2\2\2\u00bf\u00bc\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf"+
		"\u00be\3\2\2\2\u00c0\7\3\2\2\2\u00c1\u00c2\7\24\2\2\u00c2\u00c3\7\'\2"+
		"\2\u00c3\u00c5\5\u009cO\2\u00c4\u00c6\5\n\6\2\u00c5\u00c4\3\2\2\2\u00c5"+
		"\u00c6\3\2\2\2\u00c6\u00c8\3\2\2\2\u00c7\u00c9\5b\62\2\u00c8\u00c7\3\2"+
		"\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cb\b\5\1\2\u00cb"+
		"\t\3\2\2\2\u00cc\u00cd\7\66\2\2\u00cd\u00ce\5\u009cO\2\u00ce\13\3\2\2"+
		"\2\u00cf\u00d0\7\22\2\2\u00d0\u00d1\7\'\2\2\u00d1\u00d2\5\u009cO\2\u00d2"+
		"\u00d3\5\64\33\2\u00d3\r\3\2\2\2\u00d4\u00d5\7\30\2\2\u00d5\u00d6\7\'"+
		"\2\2\u00d6\u00d7\5\u009cO\2\u00d7\17\3\2\2\2\u00d8\u00d9\7\24\2\2\u00d9"+
		"\u00da\7\32\2\2\u00da\u00db\5\22\n\2\u00db\u00dc\b\t\1\2\u00dc\21\3\2"+
		"\2\2\u00dd\u00df\5\u009eP\2\u00de\u00e0\5\34\17\2\u00df\u00de\3\2\2\2"+
		"\u00df\u00e0\3\2\2\2\u00e0\u00e2\3\2\2\2\u00e1\u00e3\5b\62\2\u00e2\u00e1"+
		"\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e5\3\2\2\2\u00e4\u00e6\5\24\13\2"+
		"\u00e5\u00e4\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\23\3\2\2\2\u00e7\u00e8"+
		"\7$\2\2\u00e8\u00e9\7P\2\2\u00e9\u00ea\5\26\f\2\u00ea\u00eb\7Q\2\2\u00eb"+
		"\25\3\2\2\2\u00ec\u00fc\5\30\r\2\u00ed\u00ee\5\30\r\2\u00ee\u00ef\7;\2"+
		"\2\u00ef\u00f0\5\26\f\2\u00f0\u00fc\3\2\2\2\u00f1\u00f2\5\30\r\2\u00f2"+
		"\u00f3\7E\2\2\u00f3\u00f4\5\26\f\2\u00f4\u00fc\3\2\2\2\u00f5\u00f6\7P"+
		"\2\2\u00f6\u00f7\5\26\f\2\u00f7\u00f9\7Q\2\2\u00f8\u00fa\5\32\16\2\u00f9"+
		"\u00f8\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fc\3\2\2\2\u00fb\u00ec\3\2"+
		"\2\2\u00fb\u00ed\3\2\2\2\u00fb\u00f1\3\2\2\2\u00fb\u00f5\3\2\2\2\u00fc"+
		"\27\3\2\2\2\u00fd\u00fe\5\u00a0Q\2\u00fe\u00ff\7=\2\2\u00ff\u0101\5\u009c"+
		"O\2\u0100\u0102\5\32\16\2\u0101\u0100\3\2\2\2\u0101\u0102\3\2\2\2\u0102"+
		"\u0122\3\2\2\2\u0103\u0104\5\u00a0Q\2\u0104\u0105\7 \2\2\u0105\u0107\5"+
		"\u009cO\2\u0106\u0108\5\32\16\2\u0107\u0106\3\2\2\2\u0107\u0108\3\2\2"+
		"\2\u0108\u0122\3\2\2\2\u0109\u010a\5\u00a0Q\2\u010a\u010b\7I\2\2\u010b"+
		"\u010d\5\u009cO\2\u010c\u010e\5\32\16\2\u010d\u010c\3\2\2\2\u010d\u010e"+
		"\3\2\2\2\u010e\u0122\3\2\2\2\u010f\u0110\5\u00a0Q\2\u0110\u0111\7\37\2"+
		"\2\u0111\u0113\5\u009cO\2\u0112\u0114\5\32\16\2\u0113\u0112\3\2\2\2\u0113"+
		"\u0114\3\2\2\2\u0114\u0122\3\2\2\2\u0115\u0116\5\u00a0Q\2\u0116\u0117"+
		"\7K\2\2\u0117\u0119\5\u009cO\2\u0118\u011a\5\32\16\2\u0119\u0118\3\2\2"+
		"\2\u0119\u011a\3\2\2\2\u011a\u0122\3\2\2\2\u011b\u011c\5\u00a0Q\2\u011c"+
		"\u011d\7+\2\2\u011d\u011f\5\u009cO\2\u011e\u0120\5\32\16\2\u011f\u011e"+
		"\3\2\2\2\u011f\u0120\3\2\2\2\u0120\u0122\3\2\2\2\u0121\u00fd\3\2\2\2\u0121"+
		"\u0103\3\2\2\2\u0121\u0109\3\2\2\2\u0121\u010f\3\2\2\2\u0121\u0115\3\2"+
		"\2\2\u0121\u011b\3\2\2\2\u0122\31\3\2\2\2\u0123\u0124\t\2\2\2\u0124\33"+
		"\3\2\2\2\u0125\u0126\7\66\2\2\u0126\u0127\5\u009eP\2\u0127\35\3\2\2\2"+
		"\u0128\u0129\7\22\2\2\u0129\u012a\7\32\2\2\u012a\u012b\5\u009eP\2\u012b"+
		"\u012c\5\64\33\2\u012c\37\3\2\2\2\u012d\u012e\7\30\2\2\u012e\u012f\7\32"+
		"\2\2\u012f\u0130\5\u009eP\2\u0130!\3\2\2\2\u0131\u0138\5$\23\2\u0132\u0138"+
		"\5&\24\2\u0133\u0138\5(\25\2\u0134\u0138\5,\27\2\u0135\u0138\5.\30\2\u0136"+
		"\u0138\5\60\31\2\u0137\u0131\3\2\2\2\u0137\u0132\3\2\2\2\u0137\u0133\3"+
		"\2\2\2\u0137\u0134\3\2\2\2\u0137\u0135\3\2\2\2\u0137\u0136\3\2\2\2\u0138"+
		"#\3\2\2\2\u0139\u013a\7\24\2\2\u013a\u013b\7&\2\2\u013b\u013c\5\u009c"+
		"O\2\u013c\u013d\7P\2\2\u013d\u013e\5f\64\2\u013e\u0140\7Q\2\2\u013f\u0141"+
		"\5*\26\2\u0140\u013f\3\2\2\2\u0140\u0141\3\2\2\2\u0141%\3\2\2\2\u0142"+
		"\u0143\7\67\2\2\u0143\u0144\7&\2\2\u0144\u0145\5\u009cO\2\u0145\u0146"+
		"\7\63\2\2\u0146\u0148\5f\64\2\u0147\u0149\5F$\2\u0148\u0147\3\2\2\2\u0148"+
		"\u0149\3\2\2\2\u0149\'\3\2\2\2\u014a\u014b\7\27\2\2\u014b\u014c\7&\2\2"+
		"\u014c\u014e\5\u009cO\2\u014d\u014f\5F$\2\u014e\u014d\3\2\2\2\u014e\u014f"+
		"\3\2\2\2\u014f)\3\2\2\2\u0150\u0151\7\60\2\2\u0151\u0155\7%\2\2\u0152"+
		"\u0153\7\60\2\2\u0153\u0155\7\33\2\2\u0154\u0150\3\2\2\2\u0154\u0152\3"+
		"\2\2\2\u0155+\3\2\2\2\u0156\u0157\7\24\2\2\u0157\u0158\7\31\2\2\u0158"+
		"\u0159\5\u009eP\2\u0159\u015a\7P\2\2\u015a\u015b\5f\64\2\u015b\u015d\7"+
		"Q\2\2\u015c\u015e\5*\26\2\u015d\u015c\3\2\2\2\u015d\u015e\3\2\2\2\u015e"+
		"-\3\2\2\2\u015f\u0160\7\67\2\2\u0160\u0161\7\31\2\2\u0161\u0162\5\u009e"+
		"P\2\u0162\u0163\7\63\2\2\u0163\u0165\5f\64\2\u0164\u0166\5F$\2\u0165\u0164"+
		"\3\2\2\2\u0165\u0166\3\2\2\2\u0166\u017e\3\2\2\2\u0167\u0168\7\67\2\2"+
		"\u0168\u0169\7\31\2\2\u0169\u016a\5\u009eP\2\u016a\u016b\7\20\2\2\u016b"+
		"\u016c\7\61\2\2\u016c\u016d\5\u00a0Q\2\u016d\u016e\7=\2\2\u016e\u0170"+
		"\5v<\2\u016f\u0171\5F$\2\u0170\u016f\3\2\2\2\u0170\u0171\3\2\2\2\u0171"+
		"\u017e\3\2\2\2\u0172\u0173\7\67\2\2\u0173\u0174\7\31\2\2\u0174\u0175\5"+
		"\u009eP\2\u0175\u0176\7\26\2\2\u0176\u0177\7\61\2\2\u0177\u0178\5\u00a0"+
		"Q\2\u0178\u0179\7=\2\2\u0179\u017b\5v<\2\u017a\u017c\5F$\2\u017b\u017a"+
		"\3\2\2\2\u017b\u017c\3\2\2\2\u017c\u017e\3\2\2\2\u017d\u015f\3\2\2\2\u017d"+
		"\u0167\3\2\2\2\u017d\u0172\3\2\2\2\u017e/\3\2\2\2\u017f\u0180\7\27\2\2"+
		"\u0180\u0181\7\31\2\2\u0181\u0183\5\u009eP\2\u0182\u0184\5F$\2\u0183\u0182"+
		"\3\2\2\2\u0183\u0184\3\2\2\2\u0184\61\3\2\2\2\u0185\u018a\5\u00a2R\2\u0186"+
		"\u0187\7;\2\2\u0187\u0189\5\u00a2R\2\u0188\u0186\3\2\2\2\u0189\u018c\3"+
		"\2\2\2\u018a\u0188\3\2\2\2\u018a\u018b\3\2\2\2\u018b\63\3\2\2\2\u018c"+
		"\u018a\3\2\2\2\u018d\u0192\5\66\34\2\u018e\u018f\7;\2\2\u018f\u0191\5"+
		"\66\34\2\u0190\u018e\3\2\2\2\u0191\u0194\3\2\2\2\u0192\u0190\3\2\2\2\u0192"+
		"\u0193\3\2\2\2\u0193\65\3\2\2\2\u0194\u0192\3\2\2\2\u0195\u0196\7\20\2"+
		"\2\u0196\u0197\5\u00a2R\2\u0197\u0198\5^\60\2\u0198\u019c\3\2\2\2\u0199"+
		"\u019a\7\26\2\2\u019a\u019c\5\u00a2R\2\u019b\u0195\3\2\2\2\u019b\u0199"+
		"\3\2\2\2\u019c\67\3\2\2\2\u019d\u019f\5:\36\2\u019e\u019d\3\2\2\2\u019e"+
		"\u019f\3\2\2\2\u019f\u01a1\3\2\2\2\u01a0\u01a2\5F$\2\u01a1\u01a0\3\2\2"+
		"\2\u01a1\u01a2\3\2\2\2\u01a2\u01a4\3\2\2\2\u01a3\u01a5\5H%\2\u01a4\u01a3"+
		"\3\2\2\2\u01a4\u01a5\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6\u01a7\5J&\2\u01a7"+
		"9\3\2\2\2\u01a8\u01a9\7\35\2\2\u01a9\u01ad\5<\37\2\u01aa\u01ab\7\"\2\2"+
		"\u01ab\u01ad\5@!\2\u01ac\u01a8\3\2\2\2\u01ac\u01aa\3\2\2\2\u01ad;\3\2"+
		"\2\2\u01ae\u01b3\5> \2\u01af\u01b0\7;\2\2\u01b0\u01b2\5<\37\2\u01b1\u01af"+
		"\3\2\2\2\u01b2\u01b5\3\2\2\2\u01b3\u01b1\3\2\2\2\u01b3\u01b4\3\2\2\2\u01b4"+
		"=\3\2\2\2\u01b5\u01b3\3\2\2\2\u01b6\u01b7\7H\2\2\u01b7\u01b8\7:\2\2\u01b8"+
		"\u01bb\7\37\2\2\u01b9\u01bc\5x=\2\u01ba\u01bc\5~@\2\u01bb\u01b9\3\2\2"+
		"\2\u01bb\u01ba\3\2\2\2\u01bc\u01bd\3\2\2\2\u01bd\u01be\b \1\2\u01be?\3"+
		"\2\2\2\u01bf\u01c4\5B\"\2\u01c0\u01c1\7;\2\2\u01c1\u01c3\5@!\2\u01c2\u01c0"+
		"\3\2\2\2\u01c3\u01c6\3\2\2\2\u01c4\u01c2\3\2\2\2\u01c4\u01c5\3\2\2\2\u01c5"+
		"A\3\2\2\2\u01c6\u01c4\3\2\2\2\u01c7\u01c8\7H\2\2\u01c8\u01c9\7:\2\2\u01c9"+
		"\u01cc\7O\2\2\u01ca\u01cd\5x=\2\u01cb\u01cd\5~@\2\u01cc\u01ca\3\2\2\2"+
		"\u01cc\u01cb\3\2\2\2\u01cd\u01ce\3\2\2\2\u01ce\u01cf\b\"\1\2\u01cfC\3"+
		"\2\2\2\u01d0\u01d3\5x=\2\u01d1\u01d3\5~@\2\u01d2\u01d0\3\2\2\2\u01d2\u01d1"+
		"\3\2\2\2\u01d3E\3\2\2\2\u01d4\u01d5\79\2\2\u01d5\u01d6\5\u0088E\2\u01d6"+
		"G\3\2\2\2\u01d7\u01d8\7,\2\2\u01d8\u01d9\5\62\32\2\u01d9I\3\2\2\2\u01da"+
		"\u01db\7/\2\2\u01db\u01dc\5~@\2\u01dcK\3\2\2\2\u01dd\u01e0\5N(\2\u01de"+
		"\u01e0\5p9\2\u01df\u01dd\3\2\2\2\u01df\u01de\3\2\2\2\u01e0M\3\2\2\2\u01e1"+
		"\u01e9\5P)\2\u01e2\u01e9\5R*\2\u01e3\u01e9\5T+\2\u01e4\u01e9\5V,\2\u01e5"+
		"\u01e9\5X-\2\u01e6\u01e9\5Z.\2\u01e7\u01e9\5\\/\2\u01e8\u01e1\3\2\2\2"+
		"\u01e8\u01e2\3\2\2\2\u01e8\u01e3\3\2\2\2\u01e8\u01e4\3\2\2\2\u01e8\u01e5"+
		"\3\2\2\2\u01e8\u01e6\3\2\2\2\u01e8\u01e7\3\2\2\2\u01e9O\3\2\2\2\u01ea"+
		"\u01eb\7\3\2\2\u01ebQ\3\2\2\2\u01ec\u01ed\78\2\2\u01edS\3\2\2\2\u01ee"+
		"\u01ef\78\2\2\u01efU\3\2\2\2\u01f0\u01f1\78\2\2\u01f1W\3\2\2\2\u01f2\u01f3"+
		"\78\2\2\u01f3Y\3\2\2\2\u01f4\u01f5\7\5\2\2\u01f5[\3\2\2\2\u01f6\u01f7"+
		"\t\3\2\2\u01f7]\3\2\2\2\u01f8\u01f9\t\4\2\2\u01f9_\3\2\2\2\u01fa\u01fb"+
		"\5L\'\2\u01fba\3\2\2\2\u01fc\u01fd\7P\2\2\u01fd\u0202\5d\63\2\u01fe\u01ff"+
		"\7;\2\2\u01ff\u0201\5d\63\2\u0200\u01fe\3\2\2\2\u0201\u0204\3\2\2\2\u0202"+
		"\u0200\3\2\2\2\u0202\u0203\3\2\2\2\u0203\u0205\3\2\2\2\u0204\u0202\3\2"+
		"\2\2\u0205\u0206\7Q\2\2\u0206c\3\2\2\2\u0207\u0208\5\u00a2R\2\u0208\u0209"+
		"\5^\60\2\u0209e\3\2\2\2\u020a\u020f\5h\65\2\u020b\u020c\7;\2\2\u020c\u020e"+
		"\5h\65\2\u020d\u020b\3\2\2\2\u020e\u0211\3\2\2\2\u020f\u020d\3\2\2\2\u020f"+
		"\u0210\3\2\2\2\u0210g\3\2\2\2\u0211\u020f\3\2\2\2\u0212\u0213\5\u00a2"+
		"R\2\u0213\u0214\7M\2\2\u0214\u0215\5`\61\2\u0215i\3\2\2\2\u0216\u0217"+
		"\5\u009aN\2\u0217\u0218\7=\2\2\u0218\u021a\3\2\2\2\u0219\u0216\3\2\2\2"+
		"\u0219\u021a\3\2\2\2\u021a\u021b\3\2\2\2\u021b\u021c\5\u00a4S\2\u021c"+
		"\u021e\7P\2\2\u021d\u021f\5l\67\2\u021e\u021d\3\2\2\2\u021e\u021f\3\2"+
		"\2\2\u021f\u0220\3\2\2\2\u0220\u0221\7Q\2\2\u0221\u0222\b\66\1\2\u0222"+
		"k\3\2\2\2\u0223\u0228\5n8\2\u0224\u0225\7;\2\2\u0225\u0227\5n8\2\u0226"+
		"\u0224\3\2\2\2\u0227\u022a\3\2\2\2\u0228\u0226\3\2\2\2\u0228\u0229\3\2"+
		"\2\2\u0229m\3\2\2\2\u022a\u0228\3\2\2\2\u022b\u0231\5v<\2\u022c\u0231"+
		"\5x=\2\u022d\u0231\5|?\2\u022e\u0231\5~@\2\u022f\u0231\5L\'\2\u0230\u022b"+
		"\3\2\2\2\u0230\u022c\3\2\2\2\u0230\u022d\3\2\2\2\u0230\u022e\3\2\2\2\u0230"+
		"\u022f\3\2\2\2\u0231o\3\2\2\2\u0232\u0233\5j\66\2\u0233q\3\2\2\2\u0234"+
		"\u0235\7\6\2\2\u0235s\3\2\2\2\u0236\u0237\7\6\2\2\u0237u\3\2\2\2\u0238"+
		"\u023c\5r:\2\u0239\u023c\5\u00a6T\2\u023a\u023c\5z>\2\u023b\u0238\3\2"+
		"\2\2\u023b\u0239\3\2\2\2\u023b\u023a\3\2\2\2\u023cw\3\2\2\2\u023d\u023e"+
		"\7P\2\2\u023e\u0243\5v<\2\u023f\u0240\7;\2\2\u0240\u0242\5v<\2\u0241\u023f"+
		"\3\2\2\2\u0242\u0245\3\2\2\2\u0243\u0241\3\2\2\2\u0243\u0244\3\2\2\2\u0244"+
		"\u0246\3\2\2\2\u0245\u0243\3\2\2\2\u0246\u0247\7Q\2\2\u0247\u024b\3\2"+
		"\2\2\u0248\u024b\5\u00a8U\2\u0249\u024b\5z>\2\u024a\u023d\3\2\2\2\u024a"+
		"\u0248\3\2\2\2\u024a\u0249\3\2\2\2\u024by\3\2\2\2\u024c\u024e\7&\2\2\u024d"+
		"\u024f\5\u0084C\2\u024e\u024d\3\2\2\2\u024e\u024f\3\2\2\2\u024f\u0257"+
		"\3\2\2\2\u0250\u0251\7&\2\2\u0251\u0252\7<\2\2\u0252\u0254\5\u009cO\2"+
		"\u0253\u0255\5\u0084C\2\u0254\u0253\3\2\2\2\u0254\u0255\3\2\2\2\u0255"+
		"\u0257\3\2\2\2\u0256\u024c\3\2\2\2\u0256\u0250\3\2\2\2\u0257{\3\2\2\2"+
		"\u0258\u025c\5t;\2\u0259\u025c\5\u00aaV\2\u025a\u025c\5\u0080A\2\u025b"+
		"\u0258\3\2\2\2\u025b\u0259\3\2\2\2\u025b\u025a\3\2\2\2\u025c}\3\2\2\2"+
		"\u025d\u025e\7P\2\2\u025e\u0263\5|?\2\u025f\u0260\7;\2\2\u0260\u0262\5"+
		"|?\2\u0261\u025f\3\2\2\2\u0262\u0265\3\2\2\2\u0263\u0261\3\2\2\2\u0263"+
		"\u0264\3\2\2\2\u0264\u0266\3\2\2\2\u0265\u0263\3\2\2\2\u0266\u0267\7Q"+
		"\2\2\u0267\u026b\3\2\2\2\u0268\u026b\5\u00acW\2\u0269\u026b\5\u0080A\2"+
		"\u026a\u025d\3\2\2\2\u026a\u0268\3\2\2\2\u026a\u0269\3\2\2\2\u026b\177"+
		"\3\2\2\2\u026c\u026e\7\31\2\2\u026d\u026f\5\u0082B\2\u026e\u026d\3\2\2"+
		"\2\u026e\u026f\3\2\2\2\u026f\u0277\3\2\2\2\u0270\u0271\7\31\2\2\u0271"+
		"\u0272\7<\2\2\u0272\u0274\5\u009eP\2\u0273\u0275\5\u0082B\2\u0274\u0273"+
		"\3\2\2\2\u0274\u0275\3\2\2\2\u0275\u0277\3\2\2\2\u0276\u026c\3\2\2\2\u0276"+
		"\u0270\3\2\2\2\u0277\u0081\3\2\2\2\u0278\u0279\7P\2\2\u0279\u027e\5L\'"+
		"\2\u027a\u027b\7;\2\2\u027b\u027d\5L\'\2\u027c\u027a\3\2\2\2\u027d\u0280"+
		"\3\2\2\2\u027e\u027c\3\2\2\2\u027e\u027f\3\2\2\2\u027f\u0281\3\2\2\2\u0280"+
		"\u027e\3\2\2\2\u0281\u0282\7Q\2\2\u0282\u0083\3\2\2\2\u0283\u0284\7P\2"+
		"\2\u0284\u0289\5L\'\2\u0285\u0286\7;\2\2\u0286\u0288\5L\'\2\u0287\u0285"+
		"\3\2\2\2\u0288\u028b\3\2\2\2\u0289\u0287\3\2\2\2\u0289\u028a\3\2\2\2\u028a"+
		"\u028c\3\2\2\2\u028b\u0289\3\2\2\2\u028c\u028d\7Q\2\2\u028d\u0085\3\2"+
		"\2\2\u028e\u028f\7P\2\2\u028f\u0294\5L\'\2\u0290\u0291\7;\2\2\u0291\u0293"+
		"\5L\'\2\u0292\u0290\3\2\2\2\u0293\u0296\3\2\2\2\u0294\u0292\3\2\2\2\u0294"+
		"\u0295\3\2\2\2\u0295\u0297\3\2\2\2\u0296\u0294\3\2\2\2\u0297\u0298\7Q"+
		"\2\2\u0298\u0087\3\2\2\2\u0299\u029a\bE\1\2\u029a\u02a4\5\u008aF\2\u029b"+
		"\u02a4\5\u0090I\2\u029c\u02a4\5\u0092J\2\u029d\u029e\7(\2\2\u029e\u02a4"+
		"\5\u0088E\4\u029f\u02a0\7P\2\2\u02a0\u02a1\5\u0088E\2\u02a1\u02a2\7Q\2"+
		"\2\u02a2\u02a4\3\2\2\2\u02a3\u0299\3\2\2\2\u02a3\u029b\3\2\2\2\u02a3\u029c"+
		"\3\2\2\2\u02a3\u029d\3\2\2\2\u02a3\u029f\3\2\2\2\u02a4\u02ad\3\2\2\2\u02a5"+
		"\u02a6\f\6\2\2\u02a6\u02a7\7\21\2\2\u02a7\u02ac\5\u0088E\7\u02a8\u02a9"+
		"\f\5\2\2\u02a9\u02aa\7*\2\2\u02aa\u02ac\5\u0088E\6\u02ab\u02a5\3\2\2\2"+
		"\u02ab\u02a8\3\2\2\2\u02ac\u02af\3\2\2\2\u02ad\u02ab\3\2\2\2\u02ad\u02ae"+
		"\3\2\2\2\u02ae\u0089\3\2\2\2\u02af\u02ad\3\2\2\2\u02b0\u02b1\5\u008cG"+
		"\2\u02b1\u02b2\5\u0094K\2\u02b2\u02b3\5\u008eH\2\u02b3\u02b9\3\2\2\2\u02b4"+
		"\u02b5\5\u008cG\2\u02b5\u02b6\5\u0094K\2\u02b6\u02b7\5\u008cG\2\u02b7"+
		"\u02b9\3\2\2\2\u02b8\u02b0\3\2\2\2\u02b8\u02b4\3\2\2\2\u02b9\u008b\3\2"+
		"\2\2\u02ba\u02bb\5\u00a6T\2\u02bb\u02bc\7?\2\2\u02bc\u02bd\5\u00a2R\2"+
		"\u02bd\u02d3\3\2\2\2\u02be\u02bf\5\u00a8U\2\u02bf\u02c0\7?\2\2\u02c0\u02c1"+
		"\5\u00a2R\2\u02c1\u02d3\3\2\2\2\u02c2\u02c3\5\u009cO\2\u02c3\u02c4\7<"+
		"\2\2\u02c4\u02c5\5\u00a2R\2\u02c5\u02d3\3\2\2\2\u02c6\u02c7\5\u00aaV\2"+
		"\u02c7\u02c8\7?\2\2\u02c8\u02c9\5\u00a2R\2\u02c9\u02d3\3\2\2\2\u02ca\u02cb"+
		"\5\u00acW\2\u02cb\u02cc\7?\2\2\u02cc\u02cd\5\u00a2R\2\u02cd\u02d3\3\2"+
		"\2\2\u02ce\u02cf\5\u009eP\2\u02cf\u02d0\7<\2\2\u02d0\u02d1\5\u00a2R\2"+
		"\u02d1\u02d3\3\2\2\2\u02d2\u02ba\3\2\2\2\u02d2\u02be\3\2\2\2\u02d2\u02c2"+
		"\3\2\2\2\u02d2\u02c6\3\2\2\2\u02d2\u02ca\3\2\2\2\u02d2\u02ce\3\2\2\2\u02d3"+
		"\u008d\3\2\2\2\u02d4\u02d5\bH\1\2\u02d5\u02d6\5\u0096L\2\u02d6\u02d7\5"+
		"\u008eH\6\u02d7\u02de\3\2\2\2\u02d8\u02d9\7P\2\2\u02d9\u02da\5\u008eH"+
		"\2\u02da\u02db\7Q\2\2\u02db\u02de\3\2\2\2\u02dc\u02de\5`\61\2\u02dd\u02d4"+
		"\3\2\2\2\u02dd\u02d8\3\2\2\2\u02dd\u02dc\3\2\2\2\u02de\u02e5\3\2\2\2\u02df"+
		"\u02e0\f\5\2\2\u02e0\u02e1\5\u0098M\2\u02e1\u02e2\5\u008eH\6\u02e2\u02e4"+
		"\3\2\2\2\u02e3\u02df\3\2\2\2\u02e4\u02e7\3\2\2\2\u02e5\u02e3\3\2\2\2\u02e5"+
		"\u02e6\3\2\2\2\u02e6\u008f\3\2\2\2\u02e7\u02e5\3\2\2\2\u02e8\u02ff\5\u00a6"+
		"T\2\u02e9\u02ff\5\u00a8U\2\u02ea\u02eb\5\u00a6T\2\u02eb\u02ec\7?\2\2\u02ec"+
		"\u02ed\5\u00a2R\2\u02ed\u02ff\3\2\2\2\u02ee\u02ef\5\u00a8U\2\u02ef\u02f0"+
		"\7?\2\2\u02f0\u02f1\5\u00a2R\2\u02f1\u02ff\3\2\2\2\u02f2\u02f3\5\u00a6"+
		"T\2\u02f3\u02f4\7\37\2\2\u02f4\u02f5\5x=\2\u02f5\u02ff\3\2\2\2\u02f6\u02f7"+
		"\5\u00a6T\2\u02f7\u02f8\7\37\2\2\u02f8\u02f9\5|?\2\u02f9\u02ff\3\2\2\2"+
		"\u02fa\u02fb\5\u00a6T\2\u02fb\u02fc\7\37\2\2\u02fc\u02fd\5~@\2\u02fd\u02ff"+
		"\3\2\2\2\u02fe\u02e8\3\2\2\2\u02fe\u02e9\3\2\2\2\u02fe\u02ea\3\2\2\2\u02fe"+
		"\u02ee\3\2\2\2\u02fe\u02f2\3\2\2\2\u02fe\u02f6\3\2\2\2\u02fe\u02fa\3\2"+
		"\2\2\u02ff\u0091\3\2\2\2\u0300\u0317\5\u00aaV\2\u0301\u0317\5\u00acW\2"+
		"\u0302\u0303\5\u00aaV\2\u0303\u0304\7?\2\2\u0304\u0305\5\u00a2R\2\u0305"+
		"\u0317\3\2\2\2\u0306\u0307\5\u00acW\2\u0307\u0308\7?\2\2\u0308\u0309\5"+
		"\u00a2R\2\u0309\u0317\3\2\2\2\u030a\u030b\5\u00aaV\2\u030b\u030c\7\37"+
		"\2\2\u030c\u030d\5~@\2\u030d\u0317\3\2\2\2\u030e\u030f\5\u00aaV\2\u030f"+
		"\u0310\7\37\2\2\u0310\u0311\5|?\2\u0311\u0317\3\2\2\2\u0312\u0313\5\u00aa"+
		"V\2\u0313\u0314\7\37\2\2\u0314\u0315\5~@\2\u0315\u0317\3\2\2\2\u0316\u0300"+
		"\3\2\2\2\u0316\u0301\3\2\2\2\u0316\u0302\3\2\2\2\u0316\u0306\3\2\2\2\u0316"+
		"\u030a\3\2\2\2\u0316\u030e\3\2\2\2\u0316\u0312\3\2\2\2\u0317\u0093\3\2"+
		"\2\2\u0318\u0319\t\5\2\2\u0319\u0095\3\2\2\2\u031a\u031b\t\6\2\2\u031b"+
		"\u0097\3\2\2\2\u031c\u031d\t\7\2\2\u031d\u0099\3\2\2\2\u031e\u031f\7:"+
		"\2\2\u031f\u009b\3\2\2\2\u0320\u0321\7:\2\2\u0321\u009d\3\2\2\2\u0322"+
		"\u0323\7:\2\2\u0323\u009f\3\2\2\2\u0324\u0325\7:\2\2\u0325\u00a1\3\2\2"+
		"\2\u0326\u0327\7:\2\2\u0327\u00a3\3\2\2\2\u0328\u0329\7:\2\2\u0329\u00a5"+
		"\3\2\2\2\u032a\u032b\7H\2\2\u032b\u032c\7:\2\2\u032c\u032d\bT\1\2\u032d"+
		"\u00a7\3\2\2\2\u032e\u032f\7H\2\2\u032f\u0330\7:\2\2\u0330\u0331\bU\1"+
		"\2\u0331\u00a9\3\2\2\2\u0332\u0333\7H\2\2\u0333\u0334\7:\2\2\u0334\u0335"+
		"\bV\1\2\u0335\u00ab\3\2\2\2\u0336\u0337\7H\2\2\u0337\u0338\7:\2\2\u0338"+
		"\u0339\bW\1\2\u0339\u00ad\3\2\2\2J\u00b1\u00b7\u00bf\u00c5\u00c8\u00df"+
		"\u00e2\u00e5\u00f9\u00fb\u0101\u0107\u010d\u0113\u0119\u011f\u0121\u0137"+
		"\u0140\u0148\u014e\u0154\u015d\u0165\u0170\u017b\u017d\u0183\u018a\u0192"+
		"\u019b\u019e\u01a1\u01a4\u01ac\u01b3\u01bb\u01c4\u01cc\u01d2\u01df\u01e8"+
		"\u0202\u020f\u0219\u021e\u0228\u0230\u023b\u0243\u024a\u024e\u0254\u0256"+
		"\u025b\u0263\u026a\u026e\u0274\u0276\u027e\u0289\u0294\u02a3\u02ab\u02ad"+
		"\u02b8\u02d2\u02dd\u02e5\u02fe\u0316";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}