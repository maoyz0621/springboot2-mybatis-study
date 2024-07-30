/**
 * Copyright 2024 Inc.
 **/
package com.myz.springboot2.mybatisplus.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author maoyz0621 on 2024/5/16
 * @version v1.0
 */
public class SqliteTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        System.setProperty("sqlite.home", "E:\\WorkWare\\sqlite");
        Class.forName("org.sqlite.JDBC");
        //SQLite 数据库文件
        String dbFile = "/data/test.db";
        String url = "jdbc:sqlite:" + System.getProperty("sqlite.home") + dbFile;

        String password = "123456";
        Connection conn = DriverManager.getConnection(url, "root", password);

        //添加
        // insert(conn);
        //查询
        select(conn);
        //修改
        // update(conn);
        //删除
        // delete(conn);

        conn.close();
    }

    private static void select(Connection connection) throws SQLException {
        String sql = "select * from `user`";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("username");
            double age = rs.getDouble("age");

            System.out.println(id);
            System.out.println(name);
            System.out.println(age);
        }
        rs.close();
        statement.close();
    }

    private static void insert(Connection connection) throws SQLException {
        String sql = "insert into user( username) values('小丽')";
        Statement stat = connection.createStatement();
        stat.executeUpdate(sql);
        stat.close();
    }

    private static void update(Connection connection) throws SQLException {
        String sql = "update user set username = ? where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setObject(1, "小雪花");
        ps.setObject(2, 1);
        ps.executeUpdate();
        ps.close();
    }

    private static void delete(Connection connection) throws SQLException {
        String sql = "delete from user where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setObject(1, 1);
        ps.executeUpdate();
        ps.close();
    }
}