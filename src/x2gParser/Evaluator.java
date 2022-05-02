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
		System.err.println("Symtab[[" + symtab + "]]");
		System.err.println("Graph[[" + graph + "]]");
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
	@Override public Object visitX2g(x2gParser.X2gContext ctx) {
		visitChildren(ctx);
		if (verbose) {
			System.err.println("Symtab[[" + symtab + "]]");
			System.err.println("Graph[[" + graph + "]]");
		}
		return null;
	}

	@Override public Object visitX2g_rule(x2gParser.X2g_ruleContext ctx) {
		symtab.newScope("match");
		visitChildren(ctx);
		symtab.endScope();
		return null;
	}

	@Override public Object visitBind_expr(x2gParser.Bind_exprContext ctx) {
		visitChildren(ctx);
		String kw = ctx.getChild(0).getText();
		String xp = ctx.string_expr.getText();

		switch (kw) {
		case "xpath":
			List<Content> list = xtractor.xtract(xp);
			symtab.define(ctx.ID().getText(), VarType.XPATH, ctx.string_expr().getText());
			/* TODO: Store all current bindings of an xpath result
			 * A bind consists of a varname, a type and an sequence/list of content values.
			 */
			List<String> slist = new ArrayList<String>();
			for (Content n : list) {
					switch (n.getCType()) {
					case Element:
					case CDATA:
					case EntityRef:
					case Text:
						slist.add(n.getValue());
						break;
					case Comment:
					case DocType:
					case ProcessingInstruction:
						slist.add(n.toString());
						break;
					default:
						slist.add(n.toString());
						break;
					}
			}
			if (verbose) System.err.println("@bind_expr: " + kw + "(" + xp + ") = " + slist);
			break;
		case "node":
			symtab.define(ctx.ID().getText(), VarType.NODE, ctx.string_expr().getText());
			/* TODO: */
			break;
		case "edge":
			symtab.define(ctx.ID().getText(), VarType.EDGE, ctx.string_expr().getText());
			/* TODO: */
			break;
		default:
			break;
		}
		return null;
	}

	@Override public Object visitCreate_node(x2gParser.Create_nodeContext ctx) {
		symtab.define(ctx.ID().getText(), VarType.NODE);
		Scope scope = symtab.newScope("node.properties");
		symtab.define("__label", VarType.PROPERTY, ctx.string_expr().getText());
		visitChildren(ctx);
      symtab.define("__binding", VarType.PROPERTY, scope);
      symtab.endScope();
		return null;
	}

	@Override public Object visitCreate_edge(x2gParser.Create_edgeContext ctx) {
		symtab.define(ctx.ID(0).getText(), VarType.EDGE);
		Scope scope = symtab.newScope("edge.properties");
		symtab.define("__label", VarType.PROPERTY, ctx.string_expr().getText());
		symtab.define("__from", VarType.PROPERTY, ctx.ID(1).getText());
		symtab.define("__to", VarType.PROPERTY, ctx.ID(2).getText());
		visitChildren(ctx);
		symtab.define("__binding", VarType.PROPERTY, scope);
		symtab.endScope();
		return null;
	}

	@Override public Object visitIf_stmt(x2gParser.If_stmtContext ctx) {
		if ((Boolean)visit(ctx.boolean_expr())) {
			return visit(ctx.body_action());
		}
		return null;
	}

	@Override public Object visitProperty_name_expr(x2gParser.Property_name_exprContext ctx) {
		// TODO:
		visitChildren(ctx);
		symtab.define(ctx.ID().getText(), VarType.PROPERTY, ctx.expr().getText());
		return null;
	}

	@Override public Object visitProperty_unique(x2gParser.Property_uniqueContext ctx) {
		visitChildren(ctx);
		symtab.define("__unique", VarType.PROPERTY, ctx.property_name_list().getText());
		return null;
	}

	@Override public Object visitProperty_if(x2gParser.Property_ifContext ctx) {
		if ((Boolean)visit(ctx.boolean_expr())) {
			return visit(ctx.property_assignment_list());
		}
		return null;
	}

	//@Override public Object visitProperty_type(x2gParser.Property_typeContext ctx) { return visitChildren(ctx); }

   // boolean_expr: boolean_expr op=(AND|OR) boolean_expr
	@Override public Boolean visitBoolAndOr(x2gParser.BoolAndOrContext ctx) {
		if (ctx.op.getType() == x2gParser.OR)
			return ((Boolean)visit(ctx.boolean_expr(0))) || ((Boolean)visit(ctx.boolean_expr(1)));
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
		if (verbose) System.err.println("boolean_expr:BOOL: " + kw);
		return (kw == "TRUE" || kw == "true") ? true : false;
	}

   // boolean_expr: expr op=(LT|GT|LE|GE|EQ|NEQ) expr
	@Override public Boolean visitBoolRelop(x2gParser.BoolRelopContext ctx) {
		Object left = visit(ctx.expr(0));
		Object right = visit(ctx.expr(1));
		/*
		 * TODO: test if type of right expr is compatible to left
		 * Valid types are: Boolean, String, Integer, Float, Date
		 * */
		switch (ctx.op.getType()) {
		case x2gParser.LT:
				break;
		}
		return false;
	}

	// expr: MINUS expr
	@Override public Float visitUnaryExpr(x2gParser.UnaryExprContext ctx) {
		try {
			Float f = (Float)visit(ctx.expr());
			if (verbose) System.err.println("expr:MINUS expr: " + -f);
			return -f;
		}
		catch (ClassCastException e) {
			evalError(e, "MINUS expr");
		}
		return null;
	}

   // expr op=(MULT|DIV) expr
   // expr op=(ADD|MINUS) expr
	@Override public Object visitArithExpr(x2gParser.ArithExprContext ctx) {
		// TODO:
		return visitChildren(ctx);
	}

	// expr: '(' expr ')'
	@Override public Object visitParensExpr(x2gParser.ParensExprContext ctx) {
		return visit(ctx.expr());
	}

	// expr: eval_expr
	@Override public Object visitEvalExpr(x2gParser.EvalExprContext ctx) {
		return visit(ctx.eval_expr());
	}

	// expr: literal_expr
	@Override public Object visitLiteralExpr(x2gParser.LiteralExprContext ctx) {
		return visit(ctx.literal_expr());
	}

	@Override public Object visitEval_expr(x2gParser.Eval_exprContext ctx) {
		// TODO:
		return visitChildren(ctx);
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
	@Override public Float visitLiteralNumber(x2gParser.LiteralNumberContext ctx) {
		return Float.valueOf(ctx.NUMBER().getText());
	}

	// literal_expr: BOOL
	@Override public Boolean visitLiteralBool(x2gParser.LiteralBoolContext ctx) {
		String kw = ctx.getChild(0).getText();
		if (verbose) System.err.println("literal_expr:BOOL: " + kw);
		return (kw == "TRUE" || kw == "true") ? true : false;
	}

	// string_expr: string_expr PLUS string_expr
	@Override public String visitStringConcat(x2gParser.StringConcatContext ctx) {
		return ctx.string_expr(0).getText() + ctx.string_expr(1).getText();
	}

	// string_expr: eval_expr
	@Override public String visitStringEval(x2gParser.StringEvalContext ctx) {
		// TODO:
		return visit(ctx.eval_expr()).toString();
	}

	// string_expr: STR
	@Override public String visitStringSTR(x2gParser.StringSTRContext ctx) {
		return ctx.STR().getText();
	}
}

// vim: ff=unix ts=3 sw=3 sts=3 noet
