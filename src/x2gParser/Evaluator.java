//package x2g;
import java.util.*;
import java.io.*;

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

	/*
	 * Here starts the real evaluation of X2G rules!
	 */
	public Object visitX2g(x2gParser.X2gContext ctx) {
		visitChildren(ctx);
		if (verbose) {
			System.err.println("Symtab[[" + symtab + "]]");
			System.err.println("Graph[[" + graph + "]]");
		}
		return null;
	}
	public Object visitX2g_rule(x2gParser.X2g_ruleContext ctx) { return visitChildren(ctx); }
	public Object visitBind_expr_list(x2gParser.Bind_expr_listContext ctx) { return visitChildren(ctx); }
	public Object visitBind_expr(x2gParser.Bind_exprContext ctx) {
		visitChildren(ctx);
		String kw = ctx.getChild(0).getText();
		String xp = ctx.string_expr.getText();

		switch (kw) {
		case "xpath":
			List<Content> list = xtractor.xtract(xp);
			/* TODO: Store all current bindings of an xpath result
			 * A bind consiste of a varname, a type and an sequence/list of content values.
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
			/* TODO: */
		case "edge":
			/* TODO: */
		default:
			break;
		}
		return null;
	}
	public Object visitBody(x2gParser.BodyContext ctx) { return visitChildren(ctx); }
	public Object visitBody_action(x2gParser.Body_actionContext ctx) { return visitChildren(ctx); }
	public Object visitProperty_assignment_list(x2gParser.Property_assignment_listContext ctx) { return visitChildren(ctx); }
	public Object visitProperty_assignment(x2gParser.Property_assignmentContext ctx) { return visitChildren(ctx); }
	public Object visitProperty_name_expr(x2gParser.Property_name_exprContext ctx) { return visitChildren(ctx); }
	public Object visitProperty_unique_stmt(x2gParser.Property_unique_stmtContext ctx) { return visitChildren(ctx); }
	public Object visitProperty_if_stmt(x2gParser.Property_if_stmtContext ctx) { return visitChildren(ctx); }
	public Object visitProperty_name_list(x2gParser.Property_name_listContext ctx) { return visitChildren(ctx); }
	public Object visitProperty_type(x2gParser.Property_typeContext ctx) { return visitChildren(ctx); }
	public Object visitBoolean_expr(x2gParser.Boolean_exprContext ctx) { return visitChildren(ctx); }
	public Object visitExpr(x2gParser.ExprContext ctx) { return visitChildren(ctx); }
	public Object visitEval_expr(x2gParser.Eval_exprContext ctx) { return visitChildren(ctx); }
	public Object visitLiteral_expr(x2gParser.Literal_exprContext ctx) { return visitChildren(ctx); }
	public Object visitBoolean_literal(x2gParser.Boolean_literalContext ctx) {
		String kw = ctx.getChild(0).getText();
		if (verbose) System.err.println("@boolean_literal: " + kw);
		return (kw == "TRUE" || kw == "true") ? true : false;
	}
	public Object visitString_expr(x2gParser.String_exprContext ctx) { return visitChildren(ctx); }
	public Object visitRelop(x2gParser.RelopContext ctx) { return visitChildren(ctx); }
	public Object visitUnaryop(x2gParser.UnaryopContext ctx) { return visitChildren(ctx); }
	public Object visitArithop(x2gParser.ArithopContext ctx) { return visitChildren(ctx); }
	public Object visitProperty_name(x2gParser.Property_nameContext ctx) { return visitChildren(ctx); }
}

// vim: ff=unix ts=3 sw=3 sts=3 noet
