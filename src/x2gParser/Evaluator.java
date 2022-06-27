//package x2g;
import java.util.*;
import java.io.*;

import java.sql.Date;

import org.jdom2.Content;

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link x2gParserVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Object} for
 * operations with no return type.
 */
public class Evaluator extends x2gParserBaseVisitor<Object> {
	private final SymbolTable symtab;
	private final gGraph graph;
	private final boolean verbose;
	private xTractor xtractor;

	public Evaluator(SymbolTable symtab, gGraph graph, boolean verbose) {
		this.symtab = symtab;
		this.graph = graph;
		this.verbose = verbose;
	}

	public Evaluator(SymbolTable symtab, gGraph graph) { this(symtab, graph, false); }

	public void setXtractor(String filename) { xtractor = new xTractor(filename); }

	public gGraph getGraph() { return graph; }

	public void evalError(Exception e, String where) {
		System.err.println(Main.x2g + ": " + where + ": " + e);
		if (verbose) {
			System.err.println("Symtab[[" + symtab + "]]");
			System.err.println("Graph[[" + graph + "]]");
		}
		//System.exit(-1);
	}

	public void evalExit(String message) {
		System.err.println(Main.x2g + ": file " + xtractor.getFilename() + ": " + message);
		System.exit(-1);
	}

	public void evalMessage(String message) {
		System.err.println(Main.x2g + ": file " + xtractor.getFilename() + ": " + message);
	}

	/*
	 * Here starts the real evaluation of X2G rules!
	 * There are two passes:
	 * (1) First calling the parser, doing syntax and some semantic checking for bind variable,
	 *		 building symbol table and if there are no errors generate the AST.
	 *	(2) Visiting the tree and evaluating the expressions based on variable binding. Here we go!
	 *
	 *	Notes:
	 *	- The @Override are just for allerting if parser rules changei and so do ParserBasicVisitor.
	 *
	 */
	@Override public Object visitX2g_rule(x2gParser.X2g_ruleContext ctx) {
		symtab.setScope("match");
		Variable bindvar = visitBind_expr(ctx.bind_expr());
		// forall bindings: for all bindings of this scope
		for (Object s : bindvar.getBinding()) {
			bindvar.setCurrent(s);
			visit(ctx.body());
		}
		symtab.endScope();
		return null;
	}

	@Override public Object visitBodyActionList(x2gParser.BodyActionListContext ctx) {
		for (x2gParser.Body_actionContext bctx : ctx.body_action()) {
			visit(bctx);
		}
		return null;
	}

	@Override public Variable visitBind_expr(x2gParser.Bind_exprContext ctx) {
		//TODO: defined in the context of enclosing binding/match
		String kw = ctx.b.getText();
		int kwtype = ctx.b.getType();
		String e = (String)visit(ctx.string_expr());
		String c = null;
		Variable context = null;
		Variable bindvar = null;
		String v = null;
		Map<String, Object> vars = new HashMap<String, Object>();

		if (ctx.ID(1) != null) { /* bind relative to context var */
			c = ctx.ID(0).getText();
			v = ctx.ID(1).getText();
			context = symtab.resolve(c);
		}
		else { /* bin absolute without context var */
			v = ctx.ID(0).getText();
		}

		// bind_expr: ('$' c=ID '.')? b=(XPATH|JPATH|SQL|NODE|EDGE) '(' e=string_expr ')' USING '$' v=ID
		switch (kwtype) {
		case x2gLexer.XPATH:
			List<Content> seq;
			if (context != null) {
				seq = xtractor.xtract(context.getCurrent(), e, vars);
			}
			else {
				seq = xtractor.xtract(e, vars);
			}
			bindvar = symtab.define(v, VarType.XPATH, e);
			Set<Object> set = new HashSet<Object>();
			for (Content n : seq) {
				set.add(n);
			}
			/* TODO: Store all current bindings of an xpath result
			 * A bind consists of a varname, a type and an sequence/list of content values.
			 */
			if (verbose) evalMessage("@bind_expr: $" + v + " = " + set);
			bindvar.setBinding(set);
			break;

		case x2gLexer.JPATH:
			bindvar = symtab.define(v, VarType.JPATH, e);
			/* TODO: */
			evalMessage("binding of " + kw + '(' + e + ") not support in this version");
			if (verbose) evalMessage("@bind_expr: " + kw + '(' + e + ')');
			break;

		case x2gLexer.SQL:
			bindvar = symtab.define(v, VarType.SQL, e);
			/* TODO: */
			evalMessage("binding of " + kw + '(' + e + ") not support in this version");
			if (verbose) evalMessage("@bind_expr: " + kw + '(' + e + ')');
			break;

		case x2gLexer.NODE:
			bindvar = symtab.define(v, VarType.NODE, e);
			/* TODO: */
			evalMessage("binding of " + kw + '(' + e + ") not support in this version");
			if (verbose) evalMessage("@bind_expr: " + kw + '(' + e + ')');
			break;

		case x2gLexer.EDGE:
			bindvar = symtab.define(v, VarType.EDGE, e);
			/* TODO: */
			evalMessage("binding of " + kw + '(' + e + ") not support in this version");
			if (verbose) evalMessage("@bind_expr: " + kw + '(' + e + ')');
			break;

		default:
			break;
		}
		return bindvar;
	}

	@Override public gNode visitCreate_node(x2gParser.Create_nodeContext ctx) {
		Variable nvar = symtab.define(ctx.ID().getText(), VarType.NODE);
		Scope scope = symtab.setScope("node.properties");
		String label = (String)visit(ctx.string_expr());
		symtab.define("__label", VarType.PROPERTY, label);
		visit(ctx.property_statement_list());
		Map<String, Object> props = new HashMap<String, Object>();
		for (Variable v : symtab.getCurrent().getVariablesByType(VarType.PROPERTY)) {
			props.put(v.getName(), v.getExpr());
		}
		symtab.endScope();
		gNode node = graph.createNode(label, new gProperties(props));
		// add to current nodevar binding!
		if (nvar.getBinding() == null) {
			nvar.setBinding(new HashSet<Object>());
		}
		nvar.getBinding().add(node);
		nvar.setCurrent(node);
		return node;
	}

	@Override public gEdge visitCreate_edge(x2gParser.Create_edgeContext ctx) {
		Variable evar = symtab.define(ctx.ID(0).getText(), VarType.EDGE);
		Scope scope = symtab.setScope("edge.properties");
		String label = (String)visit(ctx.string_expr());
		String from = ctx.ID(1).getText();
		String to = ctx.ID(2).getText();
		symtab.define("__label", VarType.PROPERTY, label);
		// TODO: properties have on String values, should be Object with Type
		symtab.define("__from", VarType.PROPERTY, '$' + from);
		symtab.define("__to", VarType.PROPERTY, '$' + to);
		Variable fromVar = symtab.resolve(from);
		Variable toVar = symtab.resolve(to);
		/* This is already checked by parser, should not happen! */
		if (fromVar == null) {
			evalExit("node variable '" + fromVar + "' for edge creation undefined!");
		}
		if (toVar == null) {
			evalExit("node variable '" + toVar + "' for edge creation undefined!");
		}
		gNode fromNode = (gNode)fromVar.getCurrent();
		gNode toNode = (gNode)toVar.getCurrent();
		visit(ctx.property_statement_list());
		Map<String, Object> props = new HashMap<String, Object>();
		for (Variable v : symtab.getCurrent().getVariablesByType(VarType.PROPERTY)) {
			props.put(v.getName(), v.getExpr());
		}
		symtab.endScope();
		gEdge edge = graph.createEdge(label, fromNode, toNode, new gProperties(props));
		// add to current edgevar binding!
		if (evar.getBinding() == null) {
			evar.setBinding(new HashSet<Object>());
		}
		evar.getBinding().add(edge);
		evar.setCurrent(edge);
		return edge;
	}

	@Override public Object visitIf_stmt(x2gParser.If_stmtContext ctx) {
		if ((Boolean)visit(ctx.boolean_expr())) {
			return visit(ctx.body());
		}
		return null;
	}

	@Override public Object visitProperty_assignment(x2gParser.Property_assignmentContext ctx) {
		// TODO: to be evaluated
		Object e = visit(ctx.expr());
		//symtab.define(ctx.ID().getText(), VarType.PROPERTY, ctx.expr().getText());
		symtab.define(ctx.ID().getText(), VarType.PROPERTY, e.toString());
		return null;
	}

	@Override public Object visitProperty_unique(x2gParser.Property_uniqueContext ctx) {
		String props = ctx.property_name_list().getText();
		Set<Object> pset = new HashSet<Object>();
		Variable v = symtab.define("__unique", VarType.PROPERTY, props);
		for (String prop : props.split(",")) {
			if (symtab.resolveCurrent(prop) == null) {
				evalMessage("unique constraint: property " + prop + " unknown!");
			}
			pset.add(prop);
		}
		v.setBinding(pset);
		return null;
	}

	@Override public Object visitProperty_if(x2gParser.Property_ifContext ctx) {
		if ((Boolean)visit(ctx.boolean_expr())) {
			visit(ctx.property_statement_list());
evalMessage("current scope: " + symtab.getCurrent().getVariables());
		}
		return null;
	}

	//@Override public Object visitProperty_type(x2gParser.Property_typeContext ctx) { return visitChildren(ctx); }

	// boolean_expr: boolean_expr op=(AND|OR) boolean_expr
	@Override public Boolean visitBoolAndOr(x2gParser.BoolAndOrContext ctx) {
		if (ctx.op.getType() == x2gParser.OR) {
			return ((Boolean)visit(ctx.boolean_expr(0))) || ((Boolean)visit(ctx.boolean_expr(1)));
		}
		return ((Boolean)visit(ctx.boolean_expr(0))) && ((Boolean)visit(ctx.boolean_expr(1)));
	}

	// boolean_expr: NOT '(' boolean_expr ')'
	@Override public Boolean visitBoolNot(x2gParser.BoolNotContext ctx) {
		return !((Boolean)visit(ctx.boolean_expr()));
	}

	// boolean_expr: '(' boolean_expr ')'
	@Override public Boolean visitBoolParens(x2gParser.BoolParensContext ctx) {
		return (Boolean)visit(ctx.boolean_expr());
	}

	// boolean_expr: BOOL
	@Override public Boolean visitBoolLiteral(x2gParser.BoolLiteralContext ctx) {
		String kw = ctx.getChild(0).getText();
		if (verbose) evalMessage("boolean_expr:BOOL: " + kw);
		return (kw.equals("TRUE") || kw.equals("true")) ? true : false;
	}

	// boolean_expr: expr op=(LT|GT|LE|GE|EQ|NEQ) expr
	@Override public Boolean visitBoolRelop(x2gParser.BoolRelopContext ctx) {
		Object left = visit(ctx.expr(0));
		Object right = visit(ctx.expr(1));

		/* operands have to comparable */
		switch (ctx.op.getType()) {
		case x2gParser.EQ:
			return left.equals(right);
		case x2gParser.NEQ:
			return !left.equals(right);
		}
		/*
		 * TODO: test if type of right expr is compatible to left
		 * Valid types are: Boolean, String, Number, Date
		 * */
		// TODO: assume both operands are Long/Number
		if (verbose) evalMessage("@boolean_expr: expr relop expr: only Long supported for Number");
		Long l = (Long)left;
		Long r = (Long)right;
		switch (ctx.op.getType()) {
		case x2gParser.LT:
			return l < r;
		case x2gParser.GT:
			return l > r;
		case x2gParser.LE:
			return l <= r;
		case x2gParser.GE:
			return l >= r;
		}
		return false;
	}

	// expr: MINUS expr
	@Override public Number visitUnaryExpr(x2gParser.UnaryExprContext ctx) {
		try {
			Long i = (Long)visit(ctx.expr());
			if (verbose) evalMessage("expr:MINUS expr: " + -i);
			return -i;
		}
		catch (ClassCastException e) {
			evalError(e, "MINUS expr");
		}
		return 0;
	}

	// expr op=(MULT|DIV) expr
	// expr op=(ADD|MINUS) expr
	@Override public Number visitArithExpr(x2gParser.ArithExprContext ctx) {
		Long left = (Long)visit(ctx.expr(0));
		Long right = (Long)visit(ctx.expr(1));
		switch (ctx.op.getType()) {
			case x2gParser.MULT:
				return left * right;
			case x2gParser.DIV:
				return left / right;
			case x2gParser.ADD:
				return left + right;
			case x2gParser.MINUS:
				return left - right;
			default:
				return -0;
		}
	}

	// expr: '(' expr ')'
	@Override public Object visitParensExpr(x2gParser.ParensExprContext ctx) {
		return visit(ctx.expr());
	}

	// expr: literal_expr
	@Override public Object visitLiteralExpr(x2gParser.LiteralExprContext ctx) {
		return visit(ctx.literal_expr());
	}

	// var_ref
	//		: '$' v=ID
	//		| '$' v=ID '.' a=ID
	//		| '$' v=ID '.' p=(XPATH|JPATH) '(' e=string_expr ')'
	//		;
	@Override public String visitVar_ref(x2gParser.Var_refContext ctx) {
		//	'$' v=ID '.' p=(XPATH|JPATH) '(' e=string_expr ')'
		if (ctx.string_expr() != null) {
			String p = ctx.p.getText();
			String e = (String)visit(ctx.string_expr());
			String vid = ctx.v.getText();
			Variable v = symtab.resolve(vid);
			Map<String, Object> vars = new HashMap<String, Object>();
			if (verbose) {
				evalMessage("@var_ref: $" + v.getName() + ".path(" + e + ')');
			}
			if (v != null && (p.equals("xpath") || p.equals("XPATH"))) {
				List<Content> seq = xtractor.xtract(v.getCurrent(), e, vars);
				if (seq.size() == 1) {
					Content node = seq.get(0);
					switch (node.getCType()) {
						case Element:
						case CDATA:
						case EntityRef:
						case Text:
							return node.getValue();
						case Comment:
						case DocType:
						case ProcessingInstruction:
						default:
							break;
					}
					return node.toString();
				}
				else {
					evalMessage("xpath expression (" + e + ") evaluates to a node set, single node expected!");
				}
				return seq.toString();
			}
			// TODO: JPATH
			return '$' + vid + ".jpath(" + e + ')';
		}
		//	'$' v=ID '.' a=ID
		if (ctx.ID(1) != null) {
			String vid = ctx.v.getText();
			String aid = ctx.a.getText();
			Variable v = symtab.resolve(vid);
			if (v != null) {
				evalMessage("@var_ref: $" + v + '.' + aid);
			}
			// TODO: extract value
			return '$' + vid + '.' + aid;
		}
		//	'$' v=ID
		String vid = ctx.v.getText();
		Variable v = symtab.resolve(vid);
		if (v != null) {
			evalMessage("@var_ref: $" + v);
		}
		// TODO: extract value
		return v.getCurrent().toString();
	}

	// literal_expr: STR
	@Override public String visitLiteralString(x2gParser.LiteralStringContext ctx) {
		return ctx.STR().getText();
	}

	// literal_expr: DATETIME
	@Override public Date visitLiteralDate(x2gParser.LiteralDateContext ctx) {
		return Date.valueOf(ctx.DATETIME().getText());
	}

	// literal_expr: NUMBER
	@Override public Long visitLiteralNumber(x2gParser.LiteralNumberContext ctx) {
		return Long.valueOf(ctx.NUMBER().getText());
	}

	// literal_expr: BOOL
	@Override public Boolean visitLiteralBool(x2gParser.LiteralBoolContext ctx) {
		String kw = ctx.getChild(0).getText();
		if (verbose) evalMessage("@literal_expr:BOOL: " + kw);
		return (kw.equals("TRUE") || kw.equals("true")) ? true : false;
	}

	// string_expr: string_expr PLUS string_expr
	@Override public String visitStringConcat(x2gParser.StringConcatContext ctx) {
		visitChildren(ctx);
		return ctx.string_expr(0).getText() + ctx.string_expr(1).getText();
	}

	// string_expr: var_ref
	@Override public String visitStringVar(x2gParser.StringVarContext ctx) {
		return visitVar_ref(ctx.var_ref());
	}

	// string_expr: STR
	@Override public String visitStringSTR(x2gParser.StringSTRContext ctx) {
		return ctx.STR().getText();
	}
}

// vim: ff=unix ts=3 sw=3 sts=3 noet
