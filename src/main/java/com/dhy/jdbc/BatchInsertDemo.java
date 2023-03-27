package com.dhy.jdbc;

import java.sql.*;

/**
 * @Project fighting-core
 * @Description 主要用途描述
 * @Author lvaolin
 * @Date 2023/3/27 上午8:59
 */
public class BatchInsertDemo {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("url");
        Statement st = connection.createStatement();
        st.addBatch("insert into a values(1,2)");
        st.clearBatch();
        st.executeBatch();
        st.executeLargeBatch();


        PreparedStatement ps = connection.prepareStatement("insert into a values(?,?)");
        ps.setString(1,"a");
        ps.setString(2,"b");
        ps.addBatch();

        ps.clearBatch();
        ps.executeBatch();
        ps.executeLargeBatch();

        connection.commit();


    }
}
