package com.dhy.druid;

import com.alibaba.druid.DbType;
import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.statement.SQLExprTableSource;
import com.alibaba.druid.sql.ast.statement.SQLSelectQueryBlock;
import com.alibaba.druid.sql.ast.statement.SQLSelectStatement;
import com.alibaba.druid.sql.ast.statement.SQLTableSource;
import com.alibaba.druid.sql.visitor.SchemaStatVisitor;

import java.util.List;

/**
 * @Title SQLParseTest
 * @Description   解析sql中的表名称
 * @Author lvaolin
 * @Date 2021/11/20 23:38
 **/
public class SQLParseTest {


    public static void main(String[] args) {
        String sql = "select * from a left join b on a.id = b.id ";
        //String s = SQLUtils.formatMySql(sql);
        //System.out.println(s);
       // String dbType = "mysql";
        DbType dbType = DbType.valueOf("mysql".toLowerCase());
        List<SQLStatement> sqlStatementList = SQLUtils.parseStatements(sql, dbType);
        for (SQLStatement statement : sqlStatementList) {
            if (statement instanceof SQLSelectStatement) {
                SchemaStatVisitor visitor = new SchemaStatVisitor(dbType);
                statement.accept(visitor);

                //解析表名
                SQLSelectStatement selectStatement = (SQLSelectStatement) statement;
                SQLSelectQueryBlock queryBlock =  selectStatement.getSelect().getFirstQueryBlock();
                SQLTableSource from = queryBlock.getFrom();
                SQLExprTableSource sqlExprTableSource = (SQLExprTableSource) from;
                String tableName = sqlExprTableSource.getTableName();
                System.out.println(tableName);

            }
        }




    }
}
