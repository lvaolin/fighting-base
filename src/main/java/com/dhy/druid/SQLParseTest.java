package com.dhy.druid;

import com.alibaba.druid.DbType;
import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLLimit;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.statement.*;
import com.alibaba.druid.sql.visitor.SchemaStatVisitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @Title SQLParseTest
 * @Description   解析sql中的表名称
 * @Author lvaolin
 * @Date 2021/11/20 23:38
 **/
public class SQLParseTest {

    static Logger logger = LoggerFactory.getLogger(SQLParseTest.class);

    public static void main(String[] args) {
        SimpleAppendUpdateTimeVisitor visitor = new SimpleAppendUpdateTimeVisitor();

        String sql = "select id,name,address,mobile,school from a left join b on a.id = b.id order by id desc limit 100";
        //String s = SQLUtils.formatMySql(sql);
        //System.out.println(s);
       // String dbType = "mysql";
        DbType dbType = DbType.valueOf("mysql".toLowerCase());
        List<SQLStatement> sqlStatementList = SQLUtils.parseStatements(sql, dbType);


        sqlStatementList.forEach(sqlStatement -> sqlStatement.accept(visitor));

        if (visitor.getAndResetRewriteStatus()) {
            // 改写了SQL，需要替换
            String newSql = SQLUtils.toSQLString(sqlStatementList, dbType);
            logger.info("rewrite sql, origin sql: [{}], new sql: [{}]", sql, newSql);
        }

        for (SQLStatement statement : sqlStatementList) {
            if (statement instanceof SQLSelectStatement) {
                SchemaStatVisitor schemaStatVisitor = new SchemaStatVisitor(dbType);
                statement.accept(schemaStatVisitor);

                //解析表名
                SQLSelectStatement selectStatement = (SQLSelectStatement) statement;
                SQLSelectQueryBlock queryBlock =  selectStatement.getSelect().getFirstQueryBlock();
                SQLTableSource from = queryBlock.getFrom();

                SQLJoinTableSource sqlJoinTableSource = (SQLJoinTableSource) from;
                System.out.println(sqlJoinTableSource.getLeft().toString());
                System.out.println(sqlJoinTableSource.getCondition().toString());
                System.out.println(sqlJoinTableSource.getJoinType().toString());
                System.out.println(sqlJoinTableSource.getRight().toString());
               // System.out.println(sqlJoinTableSource.getUdj().toString());
                //System.out.println(sqlJoinTableSource.getUsing().toString());


                for (SQLSelectItem sqlSelectItem : queryBlock.getSelectList()) {
                    System.out.println(sqlSelectItem.getExpr().toString());
                }

                for (SQLSelectOrderByItem item : queryBlock.getOrderBy().getItems()) {
                    System.out.println(item.toString());
                }
                SQLLimit limit = queryBlock.getLimit();
             //   System.out.println(limit.getOffset().toString());
                System.out.println(limit.getRowCount().toString());

            }
        }




    }
}
