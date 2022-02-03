// Generated from x2gParser.g4 by ANTLR 4.7

//package x2g;
import java.util.*;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link x2gParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface x2gParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link x2gParser#x2g}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitX2g(x2gParser.X2gContext ctx);
	/**
	 * Visit a parse tree produced by {@link x2gParser#x2g_rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitX2g_rule(x2gParser.X2g_ruleContext ctx);
	/**
	 * Visit a parse tree produced by {@link x2gParser#bind_expr_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBind_expr_list(x2gParser.Bind_expr_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link x2gParser#bind_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBind_expr(x2gParser.Bind_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link x2gParser#xpath_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXpath_expr(x2gParser.Xpath_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link x2gParser#node_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNode_expr(x2gParser.Node_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link x2gParser#edge_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEdge_expr(x2gParser.Edge_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link x2gParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(x2gParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link x2gParser#body_action}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody_action(x2gParser.Body_actionContext ctx);
	/**
	 * Visit a parse tree produced by {@link x2gParser#property_assignment_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProperty_assignment_list(x2gParser.Property_assignment_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link x2gParser#property_assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProperty_assignment(x2gParser.Property_assignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link x2gParser#property_name_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProperty_name_list(x2gParser.Property_name_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link x2gParser#property_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProperty_type(x2gParser.Property_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link x2gParser#boolean_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean_expr(x2gParser.Boolean_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link x2gParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(x2gParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link x2gParser#eval_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEval_expr(x2gParser.Eval_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link x2gParser#literal_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral_expr(x2gParser.Literal_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link x2gParser#string_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString_literal(x2gParser.String_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link x2gParser#date_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDate_literal(x2gParser.Date_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link x2gParser#numeric_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumeric_literal(x2gParser.Numeric_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link x2gParser#boolean_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean_literal(x2gParser.Boolean_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link x2gParser#string_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString_expr(x2gParser.String_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link x2gParser#relop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelop(x2gParser.RelopContext ctx);
	/**
	 * Visit a parse tree produced by {@link x2gParser#unaryop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryop(x2gParser.UnaryopContext ctx);
	/**
	 * Visit a parse tree produced by {@link x2gParser#arithop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithop(x2gParser.ArithopContext ctx);
	/**
	 * Visit a parse tree produced by {@link x2gParser#property_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProperty_name(x2gParser.Property_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link x2gParser#xmlfrag_var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlfrag_var(x2gParser.Xmlfrag_varContext ctx);
	/**
	 * Visit a parse tree produced by {@link x2gParser#nodeset_var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNodeset_var(x2gParser.Nodeset_varContext ctx);
	/**
	 * Visit a parse tree produced by {@link x2gParser#edgeset_var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEdgeset_var(x2gParser.Edgeset_varContext ctx);
}