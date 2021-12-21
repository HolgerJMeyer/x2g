// Generated from graflParser.g4 by ANTLR 4.7

import java.util.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link graflParser}.
 */
public interface graflParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link graflParser#grafl}.
	 * @param ctx the parse tree
	 */
	void enterGrafl(graflParser.GraflContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#grafl}.
	 * @param ctx the parse tree
	 */
	void exitGrafl(graflParser.GraflContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#grafl_statement}.
	 * @param ctx the parse tree
	 */
	void enterGrafl_statement(graflParser.Grafl_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#grafl_statement}.
	 * @param ctx the parse tree
	 */
	void exitGrafl_statement(graflParser.Grafl_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#ddl_statement}.
	 * @param ctx the parse tree
	 */
	void enterDdl_statement(graflParser.Ddl_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#ddl_statement}.
	 * @param ctx the parse tree
	 */
	void exitDdl_statement(graflParser.Ddl_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#create_node_type}.
	 * @param ctx the parse tree
	 */
	void enterCreate_node_type(graflParser.Create_node_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#create_node_type}.
	 * @param ctx the parse tree
	 */
	void exitCreate_node_type(graflParser.Create_node_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#super_node_type}.
	 * @param ctx the parse tree
	 */
	void enterSuper_node_type(graflParser.Super_node_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#super_node_type}.
	 * @param ctx the parse tree
	 */
	void exitSuper_node_type(graflParser.Super_node_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#alter_node_type}.
	 * @param ctx the parse tree
	 */
	void enterAlter_node_type(graflParser.Alter_node_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#alter_node_type}.
	 * @param ctx the parse tree
	 */
	void exitAlter_node_type(graflParser.Alter_node_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#drop_node_type}.
	 * @param ctx the parse tree
	 */
	void enterDrop_node_type(graflParser.Drop_node_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#drop_node_type}.
	 * @param ctx the parse tree
	 */
	void exitDrop_node_type(graflParser.Drop_node_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#create_edge_type}.
	 * @param ctx the parse tree
	 */
	void enterCreate_edge_type(graflParser.Create_edge_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#create_edge_type}.
	 * @param ctx the parse tree
	 */
	void exitCreate_edge_type(graflParser.Create_edge_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#edge_type_definition}.
	 * @param ctx the parse tree
	 */
	void enterEdge_type_definition(graflParser.Edge_type_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#edge_type_definition}.
	 * @param ctx the parse tree
	 */
	void exitEdge_type_definition(graflParser.Edge_type_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#content_model}.
	 * @param ctx the parse tree
	 */
	void enterContent_model(graflParser.Content_modelContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#content_model}.
	 * @param ctx the parse tree
	 */
	void exitContent_model(graflParser.Content_modelContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#role_node_type_list}.
	 * @param ctx the parse tree
	 */
	void enterRole_node_type_list(graflParser.Role_node_type_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#role_node_type_list}.
	 * @param ctx the parse tree
	 */
	void exitRole_node_type_list(graflParser.Role_node_type_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#role_node_type}.
	 * @param ctx the parse tree
	 */
	void enterRole_node_type(graflParser.Role_node_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#role_node_type}.
	 * @param ctx the parse tree
	 */
	void exitRole_node_type(graflParser.Role_node_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#quantifier}.
	 * @param ctx the parse tree
	 */
	void enterQuantifier(graflParser.QuantifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#quantifier}.
	 * @param ctx the parse tree
	 */
	void exitQuantifier(graflParser.QuantifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#super_edge_type}.
	 * @param ctx the parse tree
	 */
	void enterSuper_edge_type(graflParser.Super_edge_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#super_edge_type}.
	 * @param ctx the parse tree
	 */
	void exitSuper_edge_type(graflParser.Super_edge_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#alter_edge_type}.
	 * @param ctx the parse tree
	 */
	void enterAlter_edge_type(graflParser.Alter_edge_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#alter_edge_type}.
	 * @param ctx the parse tree
	 */
	void exitAlter_edge_type(graflParser.Alter_edge_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#drop_edge_type}.
	 * @param ctx the parse tree
	 */
	void enterDrop_edge_type(graflParser.Drop_edge_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#drop_edge_type}.
	 * @param ctx the parse tree
	 */
	void exitDrop_edge_type(graflParser.Drop_edge_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#dml_statement}.
	 * @param ctx the parse tree
	 */
	void enterDml_statement(graflParser.Dml_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#dml_statement}.
	 * @param ctx the parse tree
	 */
	void exitDml_statement(graflParser.Dml_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#create_node}.
	 * @param ctx the parse tree
	 */
	void enterCreate_node(graflParser.Create_nodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#create_node}.
	 * @param ctx the parse tree
	 */
	void exitCreate_node(graflParser.Create_nodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#update_node}.
	 * @param ctx the parse tree
	 */
	void enterUpdate_node(graflParser.Update_nodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#update_node}.
	 * @param ctx the parse tree
	 */
	void exitUpdate_node(graflParser.Update_nodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#delete_node}.
	 * @param ctx the parse tree
	 */
	void enterDelete_node(graflParser.Delete_nodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#delete_node}.
	 * @param ctx the parse tree
	 */
	void exitDelete_node(graflParser.Delete_nodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#returns_clause}.
	 * @param ctx the parse tree
	 */
	void enterReturns_clause(graflParser.Returns_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#returns_clause}.
	 * @param ctx the parse tree
	 */
	void exitReturns_clause(graflParser.Returns_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#create_edge}.
	 * @param ctx the parse tree
	 */
	void enterCreate_edge(graflParser.Create_edgeContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#create_edge}.
	 * @param ctx the parse tree
	 */
	void exitCreate_edge(graflParser.Create_edgeContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#update_edge}.
	 * @param ctx the parse tree
	 */
	void enterUpdate_edge(graflParser.Update_edgeContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#update_edge}.
	 * @param ctx the parse tree
	 */
	void exitUpdate_edge(graflParser.Update_edgeContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#delete_edge}.
	 * @param ctx the parse tree
	 */
	void enterDelete_edge(graflParser.Delete_edgeContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#delete_edge}.
	 * @param ctx the parse tree
	 */
	void exitDelete_edge(graflParser.Delete_edgeContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#attr_list}.
	 * @param ctx the parse tree
	 */
	void enterAttr_list(graflParser.Attr_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#attr_list}.
	 * @param ctx the parse tree
	 */
	void exitAttr_list(graflParser.Attr_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#alter_attr_list}.
	 * @param ctx the parse tree
	 */
	void enterAlter_attr_list(graflParser.Alter_attr_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#alter_attr_list}.
	 * @param ctx the parse tree
	 */
	void exitAlter_attr_list(graflParser.Alter_attr_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#alter_attr}.
	 * @param ctx the parse tree
	 */
	void enterAlter_attr(graflParser.Alter_attrContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#alter_attr}.
	 * @param ctx the parse tree
	 */
	void exitAlter_attr(graflParser.Alter_attrContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#query_statement}.
	 * @param ctx the parse tree
	 */
	void enterQuery_statement(graflParser.Query_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#query_statement}.
	 * @param ctx the parse tree
	 */
	void exitQuery_statement(graflParser.Query_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#variable_assignments}.
	 * @param ctx the parse tree
	 */
	void enterVariable_assignments(graflParser.Variable_assignmentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#variable_assignments}.
	 * @param ctx the parse tree
	 */
	void exitVariable_assignments(graflParser.Variable_assignmentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#itervar_assignment_list}.
	 * @param ctx the parse tree
	 */
	void enterItervar_assignment_list(graflParser.Itervar_assignment_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#itervar_assignment_list}.
	 * @param ctx the parse tree
	 */
	void exitItervar_assignment_list(graflParser.Itervar_assignment_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#itervar_assignment}.
	 * @param ctx the parse tree
	 */
	void enterItervar_assignment(graflParser.Itervar_assignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#itervar_assignment}.
	 * @param ctx the parse tree
	 */
	void exitItervar_assignment(graflParser.Itervar_assignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#setvar_assignment_list}.
	 * @param ctx the parse tree
	 */
	void enterSetvar_assignment_list(graflParser.Setvar_assignment_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#setvar_assignment_list}.
	 * @param ctx the parse tree
	 */
	void exitSetvar_assignment_list(graflParser.Setvar_assignment_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#setvar_assignment}.
	 * @param ctx the parse tree
	 */
	void enterSetvar_assignment(graflParser.Setvar_assignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#setvar_assignment}.
	 * @param ctx the parse tree
	 */
	void exitSetvar_assignment(graflParser.Setvar_assignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#set_expr}.
	 * @param ctx the parse tree
	 */
	void enterSet_expr(graflParser.Set_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#set_expr}.
	 * @param ctx the parse tree
	 */
	void exitSet_expr(graflParser.Set_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#where_clause}.
	 * @param ctx the parse tree
	 */
	void enterWhere_clause(graflParser.Where_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#where_clause}.
	 * @param ctx the parse tree
	 */
	void exitWhere_clause(graflParser.Where_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#order_by_clause}.
	 * @param ctx the parse tree
	 */
	void enterOrder_by_clause(graflParser.Order_by_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#order_by_clause}.
	 * @param ctx the parse tree
	 */
	void exitOrder_by_clause(graflParser.Order_by_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#return_clause}.
	 * @param ctx the parse tree
	 */
	void enterReturn_clause(graflParser.Return_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#return_clause}.
	 * @param ctx the parse tree
	 */
	void exitReturn_clause(graflParser.Return_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#scalar_expr}.
	 * @param ctx the parse tree
	 */
	void enterScalar_expr(graflParser.Scalar_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#scalar_expr}.
	 * @param ctx the parse tree
	 */
	void exitScalar_expr(graflParser.Scalar_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#literal_value}.
	 * @param ctx the parse tree
	 */
	void enterLiteral_value(graflParser.Literal_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#literal_value}.
	 * @param ctx the parse tree
	 */
	void exitLiteral_value(graflParser.Literal_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#string_literal}.
	 * @param ctx the parse tree
	 */
	void enterString_literal(graflParser.String_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#string_literal}.
	 * @param ctx the parse tree
	 */
	void exitString_literal(graflParser.String_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#datespan_literal}.
	 * @param ctx the parse tree
	 */
	void enterDatespan_literal(graflParser.Datespan_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#datespan_literal}.
	 * @param ctx the parse tree
	 */
	void exitDatespan_literal(graflParser.Datespan_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#point_literal}.
	 * @param ctx the parse tree
	 */
	void enterPoint_literal(graflParser.Point_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#point_literal}.
	 * @param ctx the parse tree
	 */
	void exitPoint_literal(graflParser.Point_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#linestring_literal}.
	 * @param ctx the parse tree
	 */
	void enterLinestring_literal(graflParser.Linestring_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#linestring_literal}.
	 * @param ctx the parse tree
	 */
	void exitLinestring_literal(graflParser.Linestring_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#region_literal}.
	 * @param ctx the parse tree
	 */
	void enterRegion_literal(graflParser.Region_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#region_literal}.
	 * @param ctx the parse tree
	 */
	void exitRegion_literal(graflParser.Region_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#numeric_literal}.
	 * @param ctx the parse tree
	 */
	void enterNumeric_literal(graflParser.Numeric_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#numeric_literal}.
	 * @param ctx the parse tree
	 */
	void exitNumeric_literal(graflParser.Numeric_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#boolean_literal}.
	 * @param ctx the parse tree
	 */
	void enterBoolean_literal(graflParser.Boolean_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#boolean_literal}.
	 * @param ctx the parse tree
	 */
	void exitBoolean_literal(graflParser.Boolean_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#attr_type}.
	 * @param ctx the parse tree
	 */
	void enterAttr_type(graflParser.Attr_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#attr_type}.
	 * @param ctx the parse tree
	 */
	void exitAttr_type(graflParser.Attr_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#attr_value}.
	 * @param ctx the parse tree
	 */
	void enterAttr_value(graflParser.Attr_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#attr_value}.
	 * @param ctx the parse tree
	 */
	void exitAttr_value(graflParser.Attr_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#attr_type_list}.
	 * @param ctx the parse tree
	 */
	void enterAttr_type_list(graflParser.Attr_type_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#attr_type_list}.
	 * @param ctx the parse tree
	 */
	void exitAttr_type_list(graflParser.Attr_type_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#attr_definition}.
	 * @param ctx the parse tree
	 */
	void enterAttr_definition(graflParser.Attr_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#attr_definition}.
	 * @param ctx the parse tree
	 */
	void exitAttr_definition(graflParser.Attr_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#attr_value_list}.
	 * @param ctx the parse tree
	 */
	void enterAttr_value_list(graflParser.Attr_value_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#attr_value_list}.
	 * @param ctx the parse tree
	 */
	void exitAttr_value_list(graflParser.Attr_value_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#attr_assignment}.
	 * @param ctx the parse tree
	 */
	void enterAttr_assignment(graflParser.Attr_assignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#attr_assignment}.
	 * @param ctx the parse tree
	 */
	void exitAttr_assignment(graflParser.Attr_assignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#func_expr}.
	 * @param ctx the parse tree
	 */
	void enterFunc_expr(graflParser.Func_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#func_expr}.
	 * @param ctx the parse tree
	 */
	void exitFunc_expr(graflParser.Func_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#func_param_list}.
	 * @param ctx the parse tree
	 */
	void enterFunc_param_list(graflParser.Func_param_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#func_param_list}.
	 * @param ctx the parse tree
	 */
	void exitFunc_param_list(graflParser.Func_param_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#func_param}.
	 * @param ctx the parse tree
	 */
	void enterFunc_param(graflParser.Func_paramContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#func_param}.
	 * @param ctx the parse tree
	 */
	void exitFunc_param(graflParser.Func_paramContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#scalar_func}.
	 * @param ctx the parse tree
	 */
	void enterScalar_func(graflParser.Scalar_funcContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#scalar_func}.
	 * @param ctx the parse tree
	 */
	void exitScalar_func(graflParser.Scalar_funcContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#nid}.
	 * @param ctx the parse tree
	 */
	void enterNid(graflParser.NidContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#nid}.
	 * @param ctx the parse tree
	 */
	void exitNid(graflParser.NidContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#eid}.
	 * @param ctx the parse tree
	 */
	void enterEid(graflParser.EidContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#eid}.
	 * @param ctx the parse tree
	 */
	void exitEid(graflParser.EidContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#node_expr}.
	 * @param ctx the parse tree
	 */
	void enterNode_expr(graflParser.Node_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#node_expr}.
	 * @param ctx the parse tree
	 */
	void exitNode_expr(graflParser.Node_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#nodeset_expr}.
	 * @param ctx the parse tree
	 */
	void enterNodeset_expr(graflParser.Nodeset_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#nodeset_expr}.
	 * @param ctx the parse tree
	 */
	void exitNodeset_expr(graflParser.Nodeset_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#node_constructor}.
	 * @param ctx the parse tree
	 */
	void enterNode_constructor(graflParser.Node_constructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#node_constructor}.
	 * @param ctx the parse tree
	 */
	void exitNode_constructor(graflParser.Node_constructorContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#edge_expr}.
	 * @param ctx the parse tree
	 */
	void enterEdge_expr(graflParser.Edge_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#edge_expr}.
	 * @param ctx the parse tree
	 */
	void exitEdge_expr(graflParser.Edge_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#edgeset_expr}.
	 * @param ctx the parse tree
	 */
	void enterEdgeset_expr(graflParser.Edgeset_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#edgeset_expr}.
	 * @param ctx the parse tree
	 */
	void exitEdgeset_expr(graflParser.Edgeset_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#edge_constructor}.
	 * @param ctx the parse tree
	 */
	void enterEdge_constructor(graflParser.Edge_constructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#edge_constructor}.
	 * @param ctx the parse tree
	 */
	void exitEdge_constructor(graflParser.Edge_constructorContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#role_node_sequence}.
	 * @param ctx the parse tree
	 */
	void enterRole_node_sequence(graflParser.Role_node_sequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#role_node_sequence}.
	 * @param ctx the parse tree
	 */
	void exitRole_node_sequence(graflParser.Role_node_sequenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#attr_sequence}.
	 * @param ctx the parse tree
	 */
	void enterAttr_sequence(graflParser.Attr_sequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#attr_sequence}.
	 * @param ctx the parse tree
	 */
	void exitAttr_sequence(graflParser.Attr_sequenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#scalar_sequence}.
	 * @param ctx the parse tree
	 */
	void enterScalar_sequence(graflParser.Scalar_sequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#scalar_sequence}.
	 * @param ctx the parse tree
	 */
	void exitScalar_sequence(graflParser.Scalar_sequenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#boolean_expr}.
	 * @param ctx the parse tree
	 */
	void enterBoolean_expr(graflParser.Boolean_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#boolean_expr}.
	 * @param ctx the parse tree
	 */
	void exitBoolean_expr(graflParser.Boolean_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#boolean_attr_expr}.
	 * @param ctx the parse tree
	 */
	void enterBoolean_attr_expr(graflParser.Boolean_attr_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#boolean_attr_expr}.
	 * @param ctx the parse tree
	 */
	void exitBoolean_attr_expr(graflParser.Boolean_attr_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#qual_attr_name}.
	 * @param ctx the parse tree
	 */
	void enterQual_attr_name(graflParser.Qual_attr_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#qual_attr_name}.
	 * @param ctx the parse tree
	 */
	void exitQual_attr_name(graflParser.Qual_attr_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#value_expr}.
	 * @param ctx the parse tree
	 */
	void enterValue_expr(graflParser.Value_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#value_expr}.
	 * @param ctx the parse tree
	 */
	void exitValue_expr(graflParser.Value_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#boolean_node_expr}.
	 * @param ctx the parse tree
	 */
	void enterBoolean_node_expr(graflParser.Boolean_node_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#boolean_node_expr}.
	 * @param ctx the parse tree
	 */
	void exitBoolean_node_expr(graflParser.Boolean_node_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#boolean_edge_expr}.
	 * @param ctx the parse tree
	 */
	void enterBoolean_edge_expr(graflParser.Boolean_edge_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#boolean_edge_expr}.
	 * @param ctx the parse tree
	 */
	void exitBoolean_edge_expr(graflParser.Boolean_edge_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#comp_op}.
	 * @param ctx the parse tree
	 */
	void enterComp_op(graflParser.Comp_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#comp_op}.
	 * @param ctx the parse tree
	 */
	void exitComp_op(graflParser.Comp_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#unary_op}.
	 * @param ctx the parse tree
	 */
	void enterUnary_op(graflParser.Unary_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#unary_op}.
	 * @param ctx the parse tree
	 */
	void exitUnary_op(graflParser.Unary_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#binary_op}.
	 * @param ctx the parse tree
	 */
	void enterBinary_op(graflParser.Binary_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#binary_op}.
	 * @param ctx the parse tree
	 */
	void exitBinary_op(graflParser.Binary_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#namespace}.
	 * @param ctx the parse tree
	 */
	void enterNamespace(graflParser.NamespaceContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#namespace}.
	 * @param ctx the parse tree
	 */
	void exitNamespace(graflParser.NamespaceContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#node_type}.
	 * @param ctx the parse tree
	 */
	void enterNode_type(graflParser.Node_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#node_type}.
	 * @param ctx the parse tree
	 */
	void exitNode_type(graflParser.Node_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#edge_type}.
	 * @param ctx the parse tree
	 */
	void enterEdge_type(graflParser.Edge_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#edge_type}.
	 * @param ctx the parse tree
	 */
	void exitEdge_type(graflParser.Edge_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#role_name}.
	 * @param ctx the parse tree
	 */
	void enterRole_name(graflParser.Role_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#role_name}.
	 * @param ctx the parse tree
	 */
	void exitRole_name(graflParser.Role_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#attr_name}.
	 * @param ctx the parse tree
	 */
	void enterAttr_name(graflParser.Attr_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#attr_name}.
	 * @param ctx the parse tree
	 */
	void exitAttr_name(graflParser.Attr_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#func_name}.
	 * @param ctx the parse tree
	 */
	void enterFunc_name(graflParser.Func_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#func_name}.
	 * @param ctx the parse tree
	 */
	void exitFunc_name(graflParser.Func_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#node_var}.
	 * @param ctx the parse tree
	 */
	void enterNode_var(graflParser.Node_varContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#node_var}.
	 * @param ctx the parse tree
	 */
	void exitNode_var(graflParser.Node_varContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#nodeset_var}.
	 * @param ctx the parse tree
	 */
	void enterNodeset_var(graflParser.Nodeset_varContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#nodeset_var}.
	 * @param ctx the parse tree
	 */
	void exitNodeset_var(graflParser.Nodeset_varContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#edge_var}.
	 * @param ctx the parse tree
	 */
	void enterEdge_var(graflParser.Edge_varContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#edge_var}.
	 * @param ctx the parse tree
	 */
	void exitEdge_var(graflParser.Edge_varContext ctx);
	/**
	 * Enter a parse tree produced by {@link graflParser#edgeset_var}.
	 * @param ctx the parse tree
	 */
	void enterEdgeset_var(graflParser.Edgeset_varContext ctx);
	/**
	 * Exit a parse tree produced by {@link graflParser#edgeset_var}.
	 * @param ctx the parse tree
	 */
	void exitEdgeset_var(graflParser.Edgeset_varContext ctx);
}