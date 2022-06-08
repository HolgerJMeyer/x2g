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
		// TODO:	forall bind_expr
		// TODO:		visit(body)
		//visitChildren(ctx);
		//visit(ctx.bind_expr_list());
		for (x2gParser.Bind_exprContext bctx : ctx.bind_expr()) {
			visit(bctx);
		}
		// forall bindings: for all bindings of this scope
			visit(ctx.body());
		symtab.endScope();
		return null;
	}

	@Override public Object visitBodyActionList(x2gParser.BodyActionListContext ctx) {
		for (x2gParser.Body_actionContext bctx : ctx.body_action()) {
			visit(bctx);
		}
		return null;
	}

	@Override public Object visitBind_expr(x2gParser.Bind_exprContext ctx) {
		//TODO: defined in the context of enclosing binding/match
		String kw = ctx.b.getText();
		int kwtype = ctx.b.getType();
		String e = (String)visit(ctx.string_expr());
		String c = null;
		Variable context = null;
		String v;
		Map<String, Object> vars = new HashMap<String, Object>();

		if (ctx.ID(1) != null) { /* bind relative to context var */
			c = ctx.ID(0).getText();
			v = ctx.ID(1).getText();
			context = symtab.resolve(c);
			vars.put(c, context.getExpr());
			e = context.getExpr() + "/" + e;
		}
		else { /* bin absolute without context var */
			v = ctx.ID(0).getText();
		}

		// bind_expr: ('$' c=ID '.')? b=(XPATH|JPATH|SQL|NODE|EDGE) '(' e=string_expr ')' USING '$' v=ID
		switch (kwtype) {
		case x2gLexer.XPATH:
			List<Content> seq = xtractor.xtract(e, vars);
			Variable var = symtab.define(v, VarType.XPATH, e);
			List<String> list = new ArrayList<String>();
			for (Content n : seq) {
				switch (n.getCType()) {
					case Element:
					case CDATA:
					case EntityRef:
					case Text:
						list.add(n.getValue());
						break;
					case Comment:
					case DocType:
					case ProcessingInstruction:
						list.add(n.toString());
						break;
					default:
						list.add(n.toString());
						break;
				}
			}
			/* TODO: Store all current bindings of an xpath result
			 * A bind consists of a varname, a type and an sequence/list of content values.
			 */
			if (verbose) evalMessage("@bind_expr: $" + var + " = " + list);
			var.setBinding(list);
			break;

		case x2gLexer.JPATH:
			symtab.define(v, VarType.JPATH, e);
			/* TODO: */
			evalMessage("binding of " + kw + "(" + e + ") not support in this version");
			if (verbose) evalMessage("@bind_expr: " + kw + "(" + e + ")");
			break;

		case x2gLexer.SQL:
			symtab.define(v, VarType.SQL, e);
			/* TODO: */
			evalMessage("binding of " + kw + "(" + e + ") not support in this version");
			if (verbose) evalMessage("@bind_expr: " + kw + "(" + e + ")");
			break;

		case x2gLexer.NODE:
			symtab.define(v, VarType.NODE, e);
			/* TODO: */
			evalMessage("binding of " + kw + "(" + e + ") not support in this version");
			if (verbose) evalMessage("@bind_expr: " + kw + "(" + e + ")");
			break;

		case x2gLexer.EDGE:
			symtab.define(v, VarType.EDGE, e);
			/* TODO: */
			evalMessage("binding of " + kw + "(" + e + ") not support in this version");
			if (verbose) evalMessage("@bind_expr: " + kw + "(" + e + ")");
			break;

		default:
			break;
		}
		return null;
	}

	@Override public Object visitCreate_node(x2gParser.Create_nodeContext ctx) {
		symtab.define(ctx.ID().getText(), VarType.NODE);
		Scope scope = symtab.setScope("node.properties");
		String e = (String)visit(ctx.string_expr());
		symtab.define("__label", VarType.PROPERTY, e);
		// TODO: symtab.define("__binding", VarType.PROPERTY, new ArrayList<gNode>());
		visit(ctx.property_statement_list());
evalMessage("current scope: " + symtab.getCurrent().getVariables());
		symtab.endScope();
		return null;
	}

	@Override public Object visitCreate_edge(x2gParser.Create_edgeContext ctx) {
		//OOPS: visitChildren(ctx);
		symtab.define(ctx.ID(0).getText(), VarType.EDGE);
		Scope scope = symtab.setScope("edge.properties");
		String e = (String)visit(ctx.string_expr());
		symtab.define("__label", VarType.PROPERTY, e);
		symtab.define("__from", VarType.PROPERTY, ctx.ID(1).getText());
		symtab.define("__to", VarType.PROPERTY, ctx.ID(2).getText());
		// TODO: symtab.define("__binding", VarType.PROPERTY, new ArrayList<gEdge>());
		visit(ctx.property_statement_list());
evalMessage("current scope: " + symtab.getCurrent().getVariables());
		symtab.endScope();
		return null;
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
		symtab.define(ctx.ID().getText(), VarType.PROPERTY, ctx.expr().getText());
		return null;
	}

	@Override public Object visitProperty_unique(x2gParser.Property_uniqueContext ctx) {
		String props = ctx.property_name_list().getText();
		List<String> plist = new ArrayList<String>();
		Variable v = symtab.define("__unique", VarType.PROPERTY, props);
		for (String prop : props.split(",")) {
			if (symtab.resolveCurrent(prop) == null) {
				evalMessage("unique constraint: property " + prop + " unknown!");
			}
			plist.add(prop);
		}
		v.setBinding(plist);
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

	// eval_expr
	//		: '$' v=ID
	//		| '$' v=ID '.' a=ID
	//		| '$' v=ID '.' p=(XPATH|JPATH) '(' e=string_expr ')'
	//		;
	@Override public String visitEval_expr(x2gParser.Eval_exprContext ctx) {
		//	'$' v=ID '.' p=(XPATH|JPATH) '(' e=string_expr ')'
		if (ctx.string_expr() != null) {
			String p = ctx.p.getText();
			String e = (String)visit(ctx.string_expr());
			String vid = ctx.v.getText();
			Variable v = symtab.resolve(vid);
			if (v != null) {
				evalMessage("@eval_expr: $" + v + "/" + e);
			}
			// TODO: extract value
			return "v.path(" + e + ")";
		}
		//	'$' v=ID '.' a=ID
		if (ctx.ID(1) != null) {
			String vid = ctx.v.getText();
			String aid = ctx.a.getText();
			Variable v = symtab.resolve(vid);
			if (v != null) {
				evalMessage("@eval_expr: $" + v + "." + aid);
			}
			// TODO: extract value
			return "$" + vid + "." + aid;
		}
		//	'$' v=ID
		String vid = ctx.v.getText();
		Variable v = symtab.resolve(vid);
		if (v != null) {
			evalMessage("@eval_expr: $" + v);
		}
		// TODO: extract value
		return "$" + vid;
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

	// string_expr: eval_expr
	@Override public String visitStringEval(x2gParser.StringEvalContext ctx) {
		return visit(ctx.eval_expr()).toString();
	}

	// string_expr: STR
	@Override public String visitStringSTR(x2gParser.StringSTRContext ctx) {
		return ctx.STR().getText();
	}
}

// vim: ff=unix ts=3 sw=3 sts=3 noet
