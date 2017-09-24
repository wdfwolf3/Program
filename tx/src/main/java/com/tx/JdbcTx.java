package com.tx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcTx {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sql1 = "update bank set rmb=rmb-500 where id=1 ";
        String sql2 = "update bank set rmb=rmb+500 where id=2 ";
        Connection connection = null;
        PreparedStatement statement1 = null, statement2 = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tx?serverTimezone=GMT%2B8&useSSL=false&useUnicode=true&characterEncoding=utf8", "root", "1234");
            connection.setAutoCommit(false);
            statement1 = connection.prepareStatement(sql1);
            statement1.executeUpdate();
            statement2 = connection.prepareStatement(sql2);
            statement2.executeUpdate();
//            connection.rollback();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                statement1.close();
                statement2.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
