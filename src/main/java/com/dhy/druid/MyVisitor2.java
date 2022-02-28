package com.dhy.druid;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLObject;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.statement.*;
import com.alibaba.druid.sql.dialect.mysql.ast.clause.MySqlSelectIntoStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlDeleteStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlInsertStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlSelectQueryBlock;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlUpdateStatement;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlASTVisitorAdapter;
import com.alibaba.druid.util.JdbcConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project fighting-core
 * @Description 修改表名称
 * 只覆盖了一个方法就搞定了，我们的目标是 只修改表名称，所以只覆盖下面的方法即可
 * visit(SQLExprTableSource x)
 * 这是因为 SQLStatement 实现类应用了 组合模式 ，能达到遍历整个语法树的目的
 * 在遍历过程中 只需要判断 节点类型 是否为 SQLExprTableSource 即可，
 * 这个节点就是 最简单的表名称节点（叶子节点）
 * ，如果是，处理即可。
 *
 * @Author lvaolin
 * @Date 2022/2/28 上午9:00
 */
public class MyVisitor2 {

    public static void main(String[] args) {
        List<String> sqlList = new ArrayList<>();
        sqlList.add("delete from gl_account a where a.id = 1;");
        sqlList.add("REPLACE INTO gl_collected_log( orgId,id,startTime ) VALUES (1,2,3)");
        sqlList.add("SELECT id,matchId,matchAccFatherCode,accName,matchName,matchMethod,category,errerMsg,isOrderMode,spare\n" +
                "        FROM gl_acc_match_preset\n" +
                "        WHERE category in(1) AND matchId IN (1,2)\n" +
                "        ORDER BY matchId,isOrderMode ;");

        sqlList.add(" INSERT INTO gl_excel_accountBegin (`orgId`,`id`) VALUES (1,2),(1,3);");

        sqlList.add(" SELECT\n" +
                "        acc.isEndNode,acc.isCalc as accIsCalc,ctf.accountId,\n" +
                "        acc.isCalcMulti,ctf.id,ctf.orgId,ctf.year,\n" +
                "        ctf.origAmountDr,ctf.origAmountCr,ctf.amountDr,ctf.amountCr,\n" +
                "        ctf.quantityDr,ctf.quantityCr,ctf.isDetailData,\n" +
                "        ctf.beginOrigAmount,ctf.beginAmount,ctf.beginQuantity,\n" +
                "        ctf.beginOrigAmountDr,ctf.beginAmountDr,ctf.beginQuantityDr,\n" +
                "        ctf.beginOrigAmountCr,ctf.beginAmountCr,ctf.beginQuantityCr\n" +
                "    FROM gl_certificate ctf\n" +
                "    INNER JOIN gl_account acc ON ctf.accountId = acc.id AND ctf.orgId = acc.orgId\n" +
                "         and ctf.isPeriodBegin = 1 and ctf.orgId = #{orgId} and ctf.year = #{year}\n" +
                "\tand (acc.parentId = #{accountId} or acc.id=#{accountId})\n" +
                "\twhere ctf.orgId = #{orgId};");

        sqlList.add("\n" +
                "\t select 1 from gl_certificate ctf\n" +
                "        inner join edf_org org on ctf.orgId = org.id and ctf.year = org.enabledYear\n" +
                "        where ctf.orgId = #{orgId}\n" +
                "        and ctf.isPeriodBegin = 1\n" +
                "      LIMIT 1;");

        sqlList.add("select ts from gl_certificate \n" +
                "        inner join edf_org org on orgId = org.id and year = org.enabledYear\n" +
                "        where orgId = #{orgId}\n" +
                "        and isPeriodBegin = 1\n" +
                "        order by ts desc\n" +
                "      LIMIT 1;");

        sqlList.add("SELECT \n" +
                "    acc.id,\n" +
                "    acc.code,\n" +
                "    acc.name,\n" +
                "    acc.balanceDirection,\n" +
                "    IF(acc.balanceDirection = 0, '借', '贷') AS balanceDirectionName,\n" +
                "    1 AS selected\n" +
                "FROM\n" +
                "    gl_account acc\n" +
                "WHERE\n" +
                "    acc.orgId = 1 AND acc.id = 1\n" +
                "\n" +
                "\tunion all\n" +
                "\n" +
                "\t\tSELECT \n" +
                "    acc.id,\n" +
                "    acc.code,\n" +
                "    acc.name,\n" +
                "    acc.balanceDirection,\n" +
                "    IF(acc.balanceDirection = 0, '借', '贷') AS balanceDirectionName,\n" +
                "    0 AS selected\n" +
                "FROM\n" +
                "    gl_account acc\n" +
                "        LEFT JOIN\n" +
                "    gl_excel_account_relation relation ON acc.orgId = relation.orgId\n" +
                "        AND acc.id = relation.accountId\n" +
                "WHERE\n" +
                "    acc.orgId = 1\n" +
                "        AND relation.accountId IS NULL\n" +
                "ORDER BY code");


        sqlList.add("select * from product a   \n" +
                "join product b  \n" +
                "join product c \n" +
                "join orders d \n" +
                "join (select * from orders where id=1) e\n" +
                "\n" +
                "on a.id = b.id \n" +
                "\n" +
                "where a.id = 1 and a.id in (select id from goods)");

        sqlList.add("update order a set id = 1,name = 2 where id = 1;");

        sqlList.add("insert into xxx values (1), (2), (3)");
        sqlList.add("update A, B set A.a = a1, B.b = b1 where A.id = B.aid");
        sqlList.add("delete A, B from A, B where A.id = B.aid");
        sqlList.add("select * from x limit 2");

        sqlList.add("select A.name, sum(A.num), A.price from A group by A.name");
        sqlList.add("select * from A order by rand()");
        sqlList.add("replace into x select * from y");


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
        public boolean visit(SQLExprTableSource tableSource){
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
            return true;
        }

        public boolean isRewrite() {
            return rewrite;
        }
    }
}
