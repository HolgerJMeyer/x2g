// Generated from x2gParser.g4 by ANTLR 4.7

//package x2g;

import java.util.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link x2gParser}.
 */
public interface x2gParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link x2gParser#x2g}.
	 * @param ctx the parse tree
	 */
	void enterX2g(x2gParser.X2gContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#x2g}.
	 * @param ctx the parse tree
	 */
	void exitX2g(x2gParser.X2gContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#x2g_statement}.
	 * @param ctx the parse tree
	 */
	void enterX2g_statement(x2gParser.X2g_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#x2g_statement}.
	 * @param ctx the parse tree
	 */
	void exitX2g_statement(x2gParser.X2g_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#ddl_statement}.
	 * @param ctx the parse tree
	 */
	void enterDdl_statement(x2gParser.Ddl_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#ddl_statement}.
	 * @param ctx the parse tree
	 */
	void exitDdl_statement(x2gParser.Ddl_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#create_node_type}.
	 * @param ctx the parse tree
	 */
	void enterCreate_node_type(x2gParser.Create_node_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#create_node_type}.
	 * @param ctx the parse tree
	 */
	void exitCreate_node_type(x2gParser.Create_node_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#super_node_type}.
	 * @param ctx the parse tree
	 */
	void enterSuper_node_type(x2gParser.Super_node_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#super_node_type}.
	 * @param ctx the parse tree
	 */
	void exitSuper_node_type(x2gParser.Super_node_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#alter_node_type}.
	 * @param ctx the parse tree
	 */
	void enterAlter_node_type(x2gParser.Alter_node_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#alter_node_type}.
	 * @param ctx the parse tree
	 */
	void exitAlter_node_type(x2gParser.Alter_node_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#drop_node_type}.
	 * @param ctx the parse tree
	 */
	void enterDrop_node_type(x2gParser.Drop_node_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#drop_node_type}.
	 * @param ctx the parse tree
	 */
	void exitDrop_node_type(x2gParser.Drop_node_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#create_edge_type}.
	 * @param ctx the parse tree
	 */
	void enterCreate_edge_type(x2gParser.Create_edge_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#create_edge_type}.
	 * @param ctx the parse tree
	 */
	void exitCreate_edge_type(x2gParser.Create_edge_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#edge_type_definition}.
	 * @param ctx the parse tree
	 */
	void enterEdge_type_definition(x2gParser.Edge_type_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#edge_type_definition}.
	 * @param ctx the parse tree
	 */
	void exitEdge_type_definition(x2gParser.Edge_type_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#content_model}.
	 * @param ctx the parse tree
	 */
	void enterContent_model(x2gParser.Content_modelContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#content_model}.
	 * @param ctx the parse tree
	 */
	void exitContent_model(x2gParser.Content_modelContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#role_node_type_list}.
	 * @param ctx the parse tree
	 */
	void enterRole_node_type_list(x2gParser.Role_node_type_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#role_node_type_list}.
	 * @param ctx the parse tree
	 */
	void exitRole_node_type_list(x2gParser.Role_node_type_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#role_node_type}.
	 * @param ctx the parse tree
	 */
	void enterRole_node_type(x2gParser.Role_node_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#role_node_type}.
	 * @param ctx the parse tree
	 */
	void exitRole_node_type(x2gParser.Role_node_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#quantifier}.
	 * @param ctx the parse tree
	 */
	void enterQuantifier(x2gParser.QuantifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#quantifier}.
	 * @param ctx the parse tree
	 */
	void exitQuantifier(x2gParser.QuantifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#super_edge_type}.
	 * @param ctx the parse tree
	 */
	void enterSuper_edge_type(x2gParser.Super_edge_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#super_edge_type}.
	 * @param ctx the parse tree
	 */
	void exitSuper_edge_type(x2gParser.Super_edge_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#alter_edge_type}.
	 * @param ctx the parse tree
	 */
	void enterAlter_edge_type(x2gParser.Alter_edge_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#alter_edge_type}.
	 * @param ctx the parse tree
	 */
	void exitAlter_edge_type(x2gParser.Alter_edge_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#drop_edge_type}.
	 * @param ctx the parse tree
	 */
	void enterDrop_edge_type(x2gParser.Drop_edge_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#drop_edge_type}.
	 * @param ctx the parse tree
	 */
	void exitDrop_edge_type(x2gParser.Drop_edge_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#dml_statement}.
	 * @param ctx the parse tree
	 */
	void enterDml_statement(x2gParser.Dml_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#dml_statement}.
	 * @param ctx the parse tree
	 */
	void exitDml_statement(x2gParser.Dml_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#create_node}.
	 * @param ctx the parse tree
	 */
	void enterCreate_node(x2gParser.Create_nodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#create_node}.
	 * @param ctx the parse tree
	 */
	void exitCreate_node(x2gParser.Create_nodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#update_node}.
	 * @param ctx the parse tree
	 */
	void enterUpdate_node(x2gParser.Update_nodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#update_node}.
	 * @param ctx the parse tree
	 */
	void exitUpdate_node(x2gParser.Update_nodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#delete_node}.
	 * @param ctx the parse tree
	 */
	void enterDelete_node(x2gParser.Delete_nodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#delete_node}.
	 * @param ctx the parse tree
	 */
	void exitDelete_node(x2gParser.Delete_nodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#returns_clause}.
	 * @param ctx the parse tree
	 */
	void enterReturns_clause(x2gParser.Returns_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#returns_clause}.
	 * @param ctx the parse tree
	 */
	void exitReturns_clause(x2gParser.Returns_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#create_edge}.
	 * @param ctx the parse tree
	 */
	void enterCreate_edge(x2gParser.Create_edgeContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#create_edge}.
	 * @param ctx the parse tree
	 */
	void exitCreate_edge(x2gParser.Create_edgeContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#update_edge}.
	 * @param ctx the parse tree
	 */
	void enterUpdate_edge(x2gParser.Update_edgeContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#update_edge}.
	 * @param ctx the parse tree
	 */
	void exitUpdate_edge(x2gParser.Update_edgeContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#delete_edge}.
	 * @param ctx the parse tree
	 */
	void enterDelete_edge(x2gParser.Delete_edgeContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#delete_edge}.
	 * @param ctx the parse tree
	 */
	void exitDelete_edge(x2gParser.Delete_edgeContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#attr_list}.
	 * @param ctx the parse tree
	 */
	void enterAttr_list(x2gParser.Attr_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#attr_list}.
	 * @param ctx the parse tree
	 */
	void exitAttr_list(x2gParser.Attr_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#alter_attr_list}.
	 * @param ctx the parse tree
	 */
	void enterAlter_attr_list(x2gParser.Alter_attr_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#alter_attr_list}.
	 * @param ctx the parse tree
	 */
	void exitAlter_attr_list(x2gParser.Alter_attr_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#alter_attr}.
	 * @param ctx the parse tree
	 */
	void enterAlter_attr(x2gParser.Alter_attrContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#alter_attr}.
	 * @param ctx the parse tree
	 */
	void exitAlter_attr(x2gParser.Alter_attrContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#query_statement}.
	 * @param ctx the parse tree
	 */
	void enterQuery_statement(x2gParser.Query_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#query_statement}.
	 * @param ctx the parse tree
	 */
	void exitQuery_statement(x2gParser.Query_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#variable_assignments}.
	 * @param ctx the parse tree
	 */
	void enterVariable_assignments(x2gParser.Variable_assignmentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#variable_assignments}.
	 * @param ctx the parse tree
	 */
	void exitVariable_assignments(x2gParser.Variable_assignmentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#itervar_assignment_list}.
	 * @param ctx the parse tree
	 */
	void enterItervar_assignment_list(x2gParser.Itervar_assignment_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#itervar_assignment_list}.
	 * @param ctx the parse tree
	 */
	void exitItervar_assignment_list(x2gParser.Itervar_assignment_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#itervar_assignment}.
	 * @param ctx the parse tree
	 */
	void enterItervar_assignment(x2gParser.Itervar_assignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#itervar_assignment}.
	 * @param ctx the parse tree
	 */
	void exitItervar_assignment(x2gParser.Itervar_assignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#setvar_assignment_list}.
	 * @param ctx the parse tree
	 */
	void enterSetvar_assignment_list(x2gParser.Setvar_assignment_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#setvar_assignment_list}.
	 * @param ctx the parse tree
	 */
	void exitSetvar_assignment_list(x2gParser.Setvar_assignment_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#setvar_assignment}.
	 * @param ctx the parse tree
	 */
	void enterSetvar_assignment(x2gParser.Setvar_assignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#setvar_assignment}.
	 * @param ctx the parse tree
	 */
	void exitSetvar_assignment(x2gParser.Setvar_assignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#set_expr}.
	 * @param ctx the parse tree
	 */
	void enterSet_expr(x2gParser.Set_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#set_expr}.
	 * @param ctx the parse tree
	 */
	void exitSet_expr(x2gParser.Set_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#where_clause}.
	 * @param ctx the parse tree
	 */
	void enterWhere_clause(x2gParser.Where_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#where_clause}.
	 * @param ctx the parse tree
	 */
	void exitWhere_clause(x2gParser.Where_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#order_by_clause}.
	 * @param ctx the parse tree
	 */
	void enterOrder_by_clause(x2gParser.Order_by_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#order_by_clause}.
	 * @param ctx the parse tree
	 */
	void exitOrder_by_clause(x2gParser.Order_by_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#return_clause}.
	 * @param ctx the parse tree
	 */
	void enterReturn_clause(x2gParser.Return_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#return_clause}.
	 * @param ctx the parse tree
	 */
	void exitReturn_clause(x2gParser.Return_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#scalar_expr}.
	 * @param ctx the parse tree
	 */
	void enterScalar_expr(x2gParser.Scalar_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#scalar_expr}.
	 * @param ctx the parse tree
	 */
	void exitScalar_expr(x2gParser.Scalar_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#literal_value}.
	 * @param ctx the parse tree
	 */
	void enterLiteral_value(x2gParser.Literal_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#literal_value}.
	 * @param ctx the parse tree
	 */
	void exitLiteral_value(x2gParser.Literal_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#string_literal}.
	 * @param ctx the parse tree
	 */
	void enterString_literal(x2gParser.String_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#string_literal}.
	 * @param ctx the parse tree
	 */
	void exitString_literal(x2gParser.String_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#datespan_literal}.
	 * @param ctx the parse tree
	 */
	void enterDatespan_literal(x2gParser.Datespan_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#datespan_literal}.
	 * @param ctx the parse tree
	 */
	void exitDatespan_literal(x2gParser.Datespan_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#point_literal}.
	 * @param ctx the parse tree
	 */
	void enterPoint_literal(x2gParser.Point_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#point_literal}.
	 * @param ctx the parse tree
	 */
	void exitPoint_literal(x2gParser.Point_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#linestring_literal}.
	 * @param ctx the parse tree
	 */
	void enterLinestring_literal(x2gParser.Linestring_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#linestring_literal}.
	 * @param ctx the parse tree
	 */
	void exitLinestring_literal(x2gParser.Linestring_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#region_literal}.
	 * @param ctx the parse tree
	 */
	void enterRegion_literal(x2gParser.Region_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#region_literal}.
	 * @param ctx the parse tree
	 */
	void exitRegion_literal(x2gParser.Region_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#numeric_literal}.
	 * @param ctx the parse tree
	 */
	void enterNumeric_literal(x2gParser.Numeric_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#numeric_literal}.
	 * @param ctx the parse tree
	 */
	void exitNumeric_literal(x2gParser.Numeric_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#boolean_literal}.
	 * @param ctx the parse tree
	 */
	void enterBoolean_literal(x2gParser.Boolean_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#boolean_literal}.
	 * @param ctx the parse tree
	 */
	void exitBoolean_literal(x2gParser.Boolean_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#attr_type}.
	 * @param ctx the parse tree
	 */
	void enterAttr_type(x2gParser.Attr_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#attr_type}.
	 * @param ctx the parse tree
	 */
	void exitAttr_type(x2gParser.Attr_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#attr_value}.
	 * @param ctx the parse tree
	 */
	void enterAttr_value(x2gParser.Attr_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#attr_value}.
	 * @param ctx the parse tree
	 */
	void exitAttr_value(x2gParser.Attr_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#attr_type_list}.
	 * @param ctx the parse tree
	 */
	void enterAttr_type_list(x2gParser.Attr_type_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#attr_type_list}.
	 * @param ctx the parse tree
	 */
	void exitAttr_type_list(x2gParser.Attr_type_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#attr_definition}.
	 * @param ctx the parse tree
	 */
	void enterAttr_definition(x2gParser.Attr_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#attr_definition}.
	 * @param ctx the parse tree
	 */
	void exitAttr_definition(x2gParser.Attr_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#attr_value_list}.
	 * @param ctx the parse tree
	 */
	void enterAttr_value_list(x2gParser.Attr_value_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#attr_value_list}.
	 * @param ctx the parse tree
	 */
	void exitAttr_value_list(x2gParser.Attr_value_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#attr_assignment}.
	 * @param ctx the parse tree
	 */
	void enterAttr_assignment(x2gParser.Attr_assignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#attr_assignment}.
	 * @param ctx the parse tree
	 */
	void exitAttr_assignment(x2gParser.Attr_assignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#func_expr}.
	 * @param ctx the parse tree
	 */
	void enterFunc_expr(x2gParser.Func_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#func_expr}.
	 * @param ctx the parse tree
	 */
	void exitFunc_expr(x2gParser.Func_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#func_param_list}.
	 * @param ctx the parse tree
	 */
	void enterFunc_param_list(x2gParser.Func_param_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#func_param_list}.
	 * @param ctx the parse tree
	 */
	void exitFunc_param_list(x2gParser.Func_param_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#func_param}.
	 * @param ctx the parse tree
	 */
	void enterFunc_param(x2gParser.Func_paramContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#func_param}.
	 * @param ctx the parse tree
	 */
	void exitFunc_param(x2gParser.Func_paramContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#scalar_func}.
	 * @param ctx the parse tree
	 */
	void enterScalar_func(x2gParser.Scalar_funcContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#scalar_func}.
	 * @param ctx the parse tree
	 */
	void exitScalar_func(x2gParser.Scalar_funcContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#nid}.
	 * @param ctx the parse tree
	 */
	void enterNid(x2gParser.NidContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#nid}.
	 * @param ctx the parse tree
	 */
	void exitNid(x2gParser.NidContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#eid}.
	 * @param ctx the parse tree
	 */
	void enterEid(x2gParser.EidContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#eid}.
	 * @param ctx the parse tree
	 */
	void exitEid(x2gParser.EidContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#node_expr}.
	 * @param ctx the parse tree
	 */
	void enterNode_expr(x2gParser.Node_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#node_expr}.
	 * @param ctx the parse tree
	 */
	void exitNode_expr(x2gParser.Node_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#nodeset_expr}.
	 * @param ctx the parse tree
	 */
	void enterNodeset_expr(x2gParser.Nodeset_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#nodeset_expr}.
	 * @param ctx the parse tree
	 */
	void exitNodeset_expr(x2gParser.Nodeset_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#node_constructor}.
	 * @param ctx the parse tree
	 */
	void enterNode_constructor(x2gParser.Node_constructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#node_constructor}.
	 * @param ctx the parse tree
	 */
	void exitNode_constructor(x2gParser.Node_constructorContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#edge_expr}.
	 * @param ctx the parse tree
	 */
	void enterEdge_expr(x2gParser.Edge_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#edge_expr}.
	 * @param ctx the parse tree
	 */
	void exitEdge_expr(x2gParser.Edge_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#edgeset_expr}.
	 * @param ctx the parse tree
	 */
	void enterEdgeset_expr(x2gParser.Edgeset_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#edgeset_expr}.
	 * @param ctx the parse tree
	 */
	void exitEdgeset_expr(x2gParser.Edgeset_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#edge_constructor}.
	 * @param ctx the parse tree
	 */
	void enterEdge_constructor(x2gParser.Edge_constructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#edge_constructor}.
	 * @param ctx the parse tree
	 */
	void exitEdge_constructor(x2gParser.Edge_constructorContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#role_node_sequence}.
	 * @param ctx the parse tree
	 */
	void enterRole_node_sequence(x2gParser.Role_node_sequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#role_node_sequence}.
	 * @param ctx the parse tree
	 */
	void exitRole_node_sequence(x2gParser.Role_node_sequenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#attr_sequence}.
	 * @param ctx the parse tree
	 */
	void enterAttr_sequence(x2gParser.Attr_sequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#attr_sequence}.
	 * @param ctx the parse tree
	 */
	void exitAttr_sequence(x2gParser.Attr_sequenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#scalar_sequence}.
	 * @param ctx the parse tree
	 */
	void enterScalar_sequence(x2gParser.Scalar_sequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#scalar_sequence}.
	 * @param ctx the parse tree
	 */
	void exitScalar_sequence(x2gParser.Scalar_sequenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#boolean_expr}.
	 * @param ctx the parse tree
	 */
	void enterBoolean_expr(x2gParser.Boolean_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#boolean_expr}.
	 * @param ctx the parse tree
	 */
	void exitBoolean_expr(x2gParser.Boolean_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#boolean_attr_expr}.
	 * @param ctx the parse tree
	 */
	void enterBoolean_attr_expr(x2gParser.Boolean_attr_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#boolean_attr_expr}.
	 * @param ctx the parse tree
	 */
	void exitBoolean_attr_expr(x2gParser.Boolean_attr_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#qual_attr_name}.
	 * @param ctx the parse tree
	 */
	void enterQual_attr_name(x2gParser.Qual_attr_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#qual_attr_name}.
	 * @param ctx the parse tree
	 */
	void exitQual_attr_name(x2gParser.Qual_attr_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#value_expr}.
	 * @param ctx the parse tree
	 */
	void enterValue_expr(x2gParser.Value_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#value_expr}.
	 * @param ctx the parse tree
	 */
	void exitValue_expr(x2gParser.Value_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#boolean_node_expr}.
	 * @param ctx the parse tree
	 */
	void enterBoolean_node_expr(x2gParser.Boolean_node_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#boolean_node_expr}.
	 * @param ctx the parse tree
	 */
	void exitBoolean_node_expr(x2gParser.Boolean_node_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#boolean_edge_expr}.
	 * @param ctx the parse tree
	 */
	void enterBoolean_edge_expr(x2gParser.Boolean_edge_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#boolean_edge_expr}.
	 * @param ctx the parse tree
	 */
	void exitBoolean_edge_expr(x2gParser.Boolean_edge_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#comp_op}.
	 * @param ctx the parse tree
	 */
	void enterComp_op(x2gParser.Comp_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#comp_op}.
	 * @param ctx the parse tree
	 */
	void exitComp_op(x2gParser.Comp_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#unary_op}.
	 * @param ctx the parse tree
	 */
	void enterUnary_op(x2gParser.Unary_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#unary_op}.
	 * @param ctx the parse tree
	 */
	void exitUnary_op(x2gParser.Unary_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#binary_op}.
	 * @param ctx the parse tree
	 */
	void enterBinary_op(x2gParser.Binary_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#binary_op}.
	 * @param ctx the parse tree
	 */
	void exitBinary_op(x2gParser.Binary_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#namespace}.
	 * @param ctx the parse tree
	 */
	void enterNamespace(x2gParser.NamespaceContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#namespace}.
	 * @param ctx the parse tree
	 */
	void exitNamespace(x2gParser.NamespaceContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#node_type}.
	 * @param ctx the parse tree
	 */
	void enterNode_type(x2gParser.Node_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#node_type}.
	 * @param ctx the parse tree
	 */
	void exitNode_type(x2gParser.Node_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#edge_type}.
	 * @param ctx the parse tree
	 */
	void enterEdge_type(x2gParser.Edge_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#edge_type}.
	 * @param ctx the parse tree
	 */
	void exitEdge_type(x2gParser.Edge_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#role_name}.
	 * @param ctx the parse tree
	 */
	void enterRole_name(x2gParser.Role_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#role_name}.
	 * @param ctx the parse tree
	 */
	void exitRole_name(x2gParser.Role_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#attr_name}.
	 * @param ctx the parse tree
	 */
	void enterAttr_name(x2gParser.Attr_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#attr_name}.
	 * @param ctx the parse tree
	 */
	void exitAttr_name(x2gParser.Attr_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#func_name}.
	 * @param ctx the parse tree
	 */
	void enterFunc_name(x2gParser.Func_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#func_name}.
	 * @param ctx the parse tree
	 */
	void exitFunc_name(x2gParser.Func_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#node_var}.
	 * @param ctx the parse tree
	 */
	void enterNode_var(x2gParser.Node_varContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#node_var}.
	 * @param ctx the parse tree
	 */
	void exitNode_var(x2gParser.Node_varContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#nodeset_var}.
	 * @param ctx the parse tree
	 */
	void enterNodeset_var(x2gParser.Nodeset_varContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#nodeset_var}.
	 * @param ctx the parse tree
	 */
	void exitNodeset_var(x2gParser.Nodeset_varContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#edge_var}.
	 * @param ctx the parse tree
	 */
	void enterEdge_var(x2gParser.Edge_varContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#edge_var}.
	 * @param ctx the parse tree
	 */
	void exitEdge_var(x2gParser.Edge_varContext ctx);
	/**
	 * Enter a parse tree produced by {@link x2gParser#edgeset_var}.
	 * @param ctx the parse tree
	 */
	void enterEdgeset_var(x2gParser.Edgeset_varContext ctx);
	/**
	 * Exit a parse tree produced by {@link x2gParser#edgeset_var}.
	 * @param ctx the parse tree
	 */
	void exitEdgeset_var(x2gParser.Edgeset_varContext ctx);
}