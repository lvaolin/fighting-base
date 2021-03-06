package com.dhy.druid;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.statement.*;
import com.alibaba.druid.sql.dialect.mysql.ast.clause.MySqlSelectIntoStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.*;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlASTVisitorAdapter;
import com.alibaba.druid.util.JdbcConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project fighting-core
 * @Description
 * 在这个方法中，我企图自己遍历各种SQL情况修改 表名称 ，但是这个思路是不正确的，
 * 因为每个 sql 都不一样，下级节点非常多，如果要考虑完整，工作量会是巨大的。
 * 面对树状结构的处理方法中 组合模式 才是正确的方案，druid已经为我们做好了准备，参考 MyVisitor2。
 * @Author lvaolin
 * @Date 2022/2/28 上午9:00
 */
public class MyVisitor {

    public static void main(String[] args) {
        List<String> sqlList = new ArrayList<>();
       // sqlList.add("delete from gl_account a where a.id = 1;");
       // sqlList.add("REPLACE INTO gl_collected_log( orgId,id,startTime ) VALUES (1,2,3)");
//        sqlList.add("SELECT id,matchId,matchAccFatherCode,accName,matchName,matchMethod,category,errerMsg,isOrderMode,spare\n" +
//                "        FROM gl_acc_match_preset\n" +
//                "        WHERE category in(1) AND matchId IN (1,2)\n" +
//                "        ORDER BY matchId,isOrderMode ;");
//
//        sqlList.add(" INSERT INTO gl_excel_accountBegin (`orgId`,`id`) VALUES (1,2),(1,3);");

//        sqlList.add(" SELECT\n" +
//                "        acc.isEndNode,acc.isCalc as accIsCalc,ctf.accountId,\n" +
//                "        acc.isCalcMulti,ctf.id,ctf.orgId,ctf.year,\n" +
//                "        ctf.origAmountDr,ctf.origAmountCr,ctf.amountDr,ctf.amountCr,\n" +
//                "        ctf.quantityDr,ctf.quantityCr,ctf.isDetailData,\n" +
//                "        ctf.beginOrigAmount,ctf.beginAmount,ctf.beginQuantity,\n" +
//                "        ctf.beginOrigAmountDr,ctf.beginAmountDr,ctf.beginQuantityDr,\n" +
//                "        ctf.beginOrigAmountCr,ctf.beginAmountCr,ctf.beginQuantityCr\n" +
//                "    FROM gl_certificate ctf\n" +
//                "    INNER JOIN gl_account acc ON ctf.accountId = acc.id AND ctf.orgId = acc.orgId\n" +
//                "         and ctf.isPeriodBegin = 1 and ctf.orgId = #{orgId} and ctf.year = #{year}\n" +
//                "\tand (acc.parentId = #{accountId} or acc.id=#{accountId})\n" +
//                "\twhere ctf.orgId = #{orgId};");
//
//        sqlList.add("\n" +
//                "\t select 1 from gl_certificate ctf\n" +
//                "        inner join edf_org org on ctf.orgId = org.id and ctf.year = org.enabledYear\n" +
//                "        where ctf.orgId = #{orgId}\n" +
//                "        and ctf.isPeriodBegin = 1\n" +
//                "      LIMIT 1;");
//
//        sqlList.add("select ts from gl_certificate \n" +
//                "        inner join edf_org org on orgId = org.id and year = org.enabledYear\n" +
//                "        where orgId = #{orgId}\n" +
//                "        and isPeriodBegin = 1\n" +
//                "        order by ts desc\n" +
//                "      LIMIT 1;");
//
//        sqlList.add("SELECT \n" +
//                "    acc.id,\n" +
//                "    acc.code,\n" +
//                "    acc.name,\n" +
//                "    acc.balanceDirection,\n" +
//                "    IF(acc.balanceDirection = 0, '借', '贷') AS balanceDirectionName,\n" +
//                "    1 AS selected\n" +
//                "FROM\n" +
//                "    gl_account acc\n" +
//                "WHERE\n" +
//                "    acc.orgId = 1 AND acc.id = 1\n" +
//                "\n" +
//                "\tunion all\n" +
//                "\n" +
//                "\t\tSELECT \n" +
//                "    acc.id,\n" +
//                "    acc.code,\n" +
//                "    acc.name,\n" +
//                "    acc.balanceDirection,\n" +
//                "    IF(acc.balanceDirection = 0, '借', '贷') AS balanceDirectionName,\n" +
//                "    0 AS selected\n" +
//                "FROM\n" +
//                "    gl_account acc\n" +
//                "        LEFT JOIN\n" +
//                "    gl_excel_account_relation relation ON acc.orgId = relation.orgId\n" +
//                "        AND acc.id = relation.accountId\n" +
//                "WHERE\n" +
//                "    acc.orgId = 1\n" +
//                "        AND relation.accountId IS NULL\n" +
//                "ORDER BY code");


        sqlList.add("select * from product a   \n" +
                "join product b  \n" +
                "join product c \n" +
                "join orders d \n" +
                "join (select * from orders where id=1) e\n" +
                "\n" +
                "on a.id = b.id \n" +
                "\n" +
                "where a.id = 1 and a.id in (select id from goods)");

    //    sqlList.add("update order a set id = 1,name = 2 where id = 1;");
        for (String sql : sqlList) {
            String newSQL = getNewSQL(sql);
        }

    }

    private static String getNewSQL(String sql) {
        System.out.println("原始sql:"+sql);
        boolean rewrite = false;
        String newSQL = sql;
        List<SQLStatement> sqlStatements = SQLUtils.parseStatements(sql, JdbcConstants.MYSQL);
        for (SQLStatement st : sqlStatements) {
            RewriteTableNameVisitor visitor = new RewriteTableNameVisitor();
            st.accept(visitor);
            if (visitor.isRewrite()) {
                rewrite = true;
            }
        }
        if (rewrite) {
            newSQL = SQLUtils.toSQLString(sqlStatements, JdbcConstants.MYSQL);
        }
        System.out.println("改写后sql:"+newSQL);
        return newSQL;
    }


    static class RewriteTableNameVisitor extends MySqlASTVisitorAdapter {

        /**
         * sql是否被重写
         */
        private boolean rewrite = false;

        @Override
        public boolean visit(MySqlUpdateStatement x){
            //解析语法树，修改语法树
            SQLTableSource sqlTableSource = x.getTableSource();
            updateTableSource(sqlTableSource);
            this.rewrite = true;
            return false;
        }

        @Override
        public boolean visit(MySqlDeleteStatement x){
            SQLExprTableSource exprTableSource = x.getExprTableSource();
            updateTableSource(exprTableSource);
            this.rewrite = true;
            return false;
        }

        @Override
        public boolean visit(MySqlSelectIntoStatement x){
            SQLSelectQueryBlock queryBlock = x.getSelect().getQueryBlock();
            SQLTableSource from = queryBlock.getFrom();
            updateTableSource(from);
            this.rewrite = true;
            return false;
        }

        @Override
        public boolean visit(MySqlInsertStatement x) {
            SQLExprTableSource tableSource = x.getTableSource();
            tableSource.setSimpleName(tableSource.getTableName()+"_1");
            this.rewrite = true;
            return false;
        }
        @Override
        public boolean visit(SQLReplaceStatement x) {
            SQLExprTableSource tableSource = x.getTableSource();
            tableSource.setSimpleName(tableSource.getTableName()+"_1");
            this.rewrite = true;
            return false;
        }
        @Override
        public boolean visit(SQLUnionQuery x){
            List<SQLSelectQuery> children = x.getChildren();
            for (SQLSelectQuery child : children) {
                if (child instanceof MySqlSelectQueryBlock) {
                    MySqlSelectQueryBlock sqlSelectQuery = (MySqlSelectQueryBlock) child;
                    visit(sqlSelectQuery);
                }
            }
            this.rewrite = true;
            return false;
        }

        @Override
        public boolean visit(MySqlSelectQueryBlock x){
            SQLTableSource sqlTableSource = x.getFrom();
            updateTableSource(sqlTableSource);
            return false;
        }

        private void updateTableSource(SQLTableSource sqlTableSource) {
            if (sqlTableSource instanceof SQLExprTableSource) {
                SQLExprTableSource tableSource = (SQLExprTableSource)sqlTableSource;
                String tableName = tableSource.getTableName();
                //查询分表配置信息，确认此表是否需要分表
                if (true) {
                    //查询分表的后缀信息（token中获取）
                    if (tableSource.getAlias()==null) {
                        tableSource.setAlias(tableName);
                    }
                    tableSource.setSimpleName(tableName+"_1");
                    this.rewrite = true;
                }

                return;
            }
            if (sqlTableSource instanceof SQLJoinTableSource) {
                SQLJoinTableSource tableSource = (SQLJoinTableSource) sqlTableSource;
                updateTableSource(tableSource.getLeft());
                updateTableSource(tableSource.getRight());
                return;
            }

            if (sqlTableSource instanceof SQLSubqueryTableSource) {
                SQLSubqueryTableSource tableSource = (SQLSubqueryTableSource)sqlTableSource;
                SQLSelect select = tableSource.getSelect();
                SQLSelectQueryBlock queryBlock = select.getQueryBlock();
                SQLTableSource from = queryBlock.getFrom();
                updateTableSource(from);
                return;
            }
            if (sqlTableSource instanceof SQLWithSubqueryClause.Entry) {
                SQLWithSubqueryClause.Entry tableSource = (SQLWithSubqueryClause.Entry)sqlTableSource;
                SQLSelect select = tableSource.getSubQuery();
                SQLSelectQueryBlock queryBlock = select.getQueryBlock();
                SQLTableSource from = queryBlock.getFrom();
                updateTableSource(from);
                return;
            }


        }



        public boolean isRewrite() {
            return rewrite;
        }
    }
}
