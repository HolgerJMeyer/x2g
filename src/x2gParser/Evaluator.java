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
	private final boolean warnings;
	private xTractor xtractor;

	public Evaluator(SymbolTable symtab, gGraph graph, boolean warnings, boolean verbose) {
		this.symtab = symtab;
		this.graph = graph;
		this.warnings = warnings;
		this.verbose = verbose;
	}

	public Evaluator(SymbolTable symtab, gGraph graph, boolean warnings) { this(symtab, graph, warnings, false); }

	public Evaluator(SymbolTable symtab, gGraph graph) { this(symtab, graph, false, false); }

	public void setXtractor(String filename) { xtractor = new xTractor(filename, true); }

	public void setXtractor(String filename, boolean nsaware) { xtractor = new xTractor(filename, nsaware); }

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

	public void evalWarning(String message) {
		if (warnings) {
			evalMessage("Warning: " + message);
		}
	}

	/*
	 * Here starts the real evaluation of X2G rules!
	 * There are two passes:
	 * (1) First calling the parser, doing syntax and some semantic checking for bind variable,
	 *		 building symbol table and if there are no errors generate the AST.
	 *	(2) Visiting the tree and evaluating the expressions based on variable binding. Here we go!
	 *
	 *	Notes:
	 *	- The @Override are just for allerting if parser rules change and so do ParserBasicVisitor.
	 *
	 */
	@Override public Object visitX2g_rule(x2gParser.X2g_ruleContext ctx) {
		Variable bindvar = visitBind_expr(ctx.bind_expr());
		symtab.setScope("match", ctx.bind_expr.v.getText());
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
			visitBody_action(bctx);
		}
		return null;
	}

	@Override public Object visitBody_action(x2gParser.Body_actionContext ctx) {
		return visitChildren(ctx);
	}

	@Override public Variable visitBind_expr(x2gParser.Bind_exprContext ctx) {
		String kw = ctx.b.getText();
		int kwtype = ctx.b.getType();
		String e = (String)visit(ctx.string_expr());
		String c = null;
		Variable context = null;
		Variable bindvar = null;
		String v = null;
		Map<String, Object> vars = new HashMap<String, Object>();

		// bind_expr: ('$' c=ID '.')? b=(XPATH|JPATH|SQL|NODE|EDGE) '(' e=string_expr ')' USING '$' v=ID
		if (ctx.ID(1) != null) { /* bind relative to context var */
			c = ctx.ID(0).getText();
			v = ctx.ID(1).getText();
			context = symtab.resolve(c);
		}
		else { /* bind absolute without context var */
			v = ctx.ID(0).getText();
		}

		bindvar = symtab.resolve(v);
		if (bindvar == null) {
			evalMessage("variable binding $" + v + " undefined!");
			evalMessage("symtab.current=" + symtab.getCurrent());
			evalMessage("symtab=[[" + symtab.toString() + "]]");
		}
		switch (kwtype) {
		case x2gLexer.XPATH:
			List<Content> seq;
			if (context != null) {
				seq = xtractor.xtract(context.getCurrent(), e, vars);
			}
			else {
				seq = xtractor.xtract(e, vars);
			}
			Set<Object> set = new HashSet<Object>();
			for (Content n : seq) {
				set.add(n);
			}
			/* TODO: Store all current bindings of an xpath result
			 * A bind consists of a varname, a type and an sequence/list of content values.
			 */
			if (verbose) {
				evalMessage("@bind_expr: $" + v + " = " + set);
			}
			if (Main.warnEmpty && set.size() == 0) {
				evalWarning("$" + v + " (" + e + ") didn't match!");
			}
			bindvar.setBinding(set);
			break;

		case x2gLexer.JPATH:
			/* TODO: */
			evalMessage("binding of " + kw + '(' + e + ") not support in this version");
			if (verbose) {
				evalMessage("@bind_expr: " + kw + '(' + e + ')');
			}
			break;

		case x2gLexer.SQL:
			/* TODO: */
			evalMessage("binding of " + kw + '(' + e + ") not support in this version");
			if (verbose) {
				evalMessage("@bind_expr: " + kw + '(' + e + ')');
			}
			break;

		case x2gLexer.NODE:
			/* TODO: */
			evalMessage("binding of " + kw + '(' + e + ") not support in this version");
			if (verbose) {
				evalMessage("@bind_expr: " + kw + '(' + e + ')');
			}
			break;

		case x2gLexer.EDGE:
			/* TODO: */
			evalMessage("binding of " + kw + '(' + e + ") not support in this version");
			if (verbose) {
				evalMessage("@bind_expr: " + kw + '(' + e + ')');
			}
			break;

		default:
			break;
		}
		return bindvar;
	}

	@Override public gNode visitCreate_node(x2gParser.Create_nodeContext ctx) {
		String vname = ctx.ID().getText();
		Variable nvar = symtab.resolve(vname);
		if (nvar == null) {
			evalMessage("node variable $" + vname + " is undefined!");
		}
		Scope scope = symtab.setScope("node.properties", vname);
		String label = (String)visit(ctx.string_expr());
		visit(ctx.property_statement_list());
		Map<String, Object> props = new HashMap<String, Object>();
		for (Variable v : symtab.getCurrent().getVariablesByType(VarType.PROPERTY)) {
			// TODO: getExpr() -> getValue()
			if (v.getName().equals("__unique")) {
				props.put(v.getName(), v.getBinding());
			}
			else {
				props.put(v.getName(), v.getExpr());
			}
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
		String vname = ctx.ID(0).getText();
		Variable evar = symtab.resolve(vname);
		if (evar == null) {
			evalMessage("node variable $" + vname + " is undefined!");
		}
		Scope scope = symtab.setScope("edge.properties", vname);
		String label = (String)visit(ctx.string_expr());
		String from = ctx.ID(1).getText();
		String to = ctx.ID(2).getText();
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
			return visit(ctx.body(0));
		}
		else if (ctx.body(1) != null) {
			return visit(ctx.body(1));
		}
		return null;
	}

	@Override public Variable visitProperty_assignment(x2gParser.Property_assignmentContext ctx) {
		Object e = visit(ctx.expr());
		Variable v = symtab.resolve(ctx.ID().getText());
		if (e != null) {
			v.setExpr(e.toString());
		}
		else {
			v.setExpr(null);
		}
		return v;
	}

	@Override public Variable visitProperty_unique(x2gParser.Property_uniqueContext ctx) {
		return symtab.resolve("__unique");
	}

	@Override public Object visitProperty_if(x2gParser.Property_ifContext ctx) {
		if ((Boolean)visit(ctx.boolean_expr())) {
			return visit(ctx.property_statement_list(0));
		}
		else if (ctx.property_statement_list(1) != null) {
			return visit(ctx.property_statement_list(1));
		}
		return null;
	}

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
		if (verbose) {
			evalMessage("boolean_expr:BOOL: " + kw);
		}
		return (kw.equals("TRUE") || kw.equals("true")) ? true : false;
	}

	// boolean_expr: expr op=(LT|GT|LE|GE|EQ|NEQ) expr
	@Override public Boolean visitBoolRelop(x2gParser.BoolRelopContext ctx) {
		Object left = visit(ctx.expr(0));
		Object right = visit(ctx.expr(1));


		// Assert: left != null && right != null
		//evalMessage("@boolean_expr: expr relop expr: left=" + left + ", right=" + right);

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
		if (verbose) {
			evalMessage("@boolean_expr: expr relop expr: only Long supported for Number");
		}
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
			if (verbose) {
				evalMessage("expr:MINUS expr: " + -i);
			}
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
				else if (seq.size() == 0) {
					if (Main.warnEmpty) {
						evalWarning("xpath (" + e + ") evaluates to an empty nodeset!");
					}
					// TODO: to return null or empty string?  We go with empty strings!
					return "";
				}
				evalWarning("xpath (" + e + ") evaluates to a nodeset of size " + seq.size() + ", returning as single string!");
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
				// extract attribute/property value from variable
				if (verbose) {
					evalMessage("@var_ref: $" + vid + '.' + aid);
				}
				if (v.getCurrent() instanceof gNode) {
					gNode n = (gNode)v.getCurrent();
					return n.getProperty(aid).toString();
				}
			}
			evalMessage("@var_ref: $" + vid + " is undefined!");
			return '$' + vid + '.' + aid;
		}
		//	'$' v=ID
		String vid = ctx.v.getText();
		Variable v = symtab.resolve(vid);
		if (v != null) {
			evalMessage("@var_ref: $" + v);
		}
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
		if (verbose) {
			evalMessage("@literal_expr:BOOL: " + kw);
		}
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
