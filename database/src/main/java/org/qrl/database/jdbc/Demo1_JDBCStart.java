package org.qrl.database.jdbc;

import cn.hutool.core.io.IoUtil;

import java.sql.*;

/**
 * jdbc java-database-connectivity java官方提供连接数据库的一套标准
 * mysql-connector-java 是 mysql 官方对 jdbc 的实现
 * @author qr
 * @date 2021/12/20 13:46
 */
public class Demo1_JDBCStart {

    static final String driver = "com.mysql.cj.jdbc.Driver";

    static final String url = "jdbc:mysql://localhost/mybatis-learn?serverTimezone=Asia/Shanghai";

    static final String user = "root";

    static final String password = "QRWUDI666";

    public static void main(String[] args) {
        ResultSet resultSet = null;
        Statement statement = null;
        Connection conn = null;
        try {
            // 注册驱动
            Class.forName(driver);
            // 获取连接
            conn = DriverManager.getConnection(url, user, password);
            // 获取sql执行对象: statement
            statement =  conn.createStatement();
            // 需要执行的 sql 语句
            String sql = "select * from t_user where data_id = 1 or 1=1"; // sql 注入😏
            // 执行sql语句,返回一个结果集: resultSet
            resultSet =  statement.executeQuery(sql);
            // 处理结果集
            while(resultSet.next()) {
                int id = resultSet.getInt("data_id");
                String name = resultSet.getString("username");
                String nickname = resultSet.getString("nickname");
                System.out.println("id: " + id + ", name: " + name + ", nickname: " + nickname);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            IoUtil.close(resultSet);
            IoUtil.close(statement);
            IoUtil.close(conn);
        }

    }

}
