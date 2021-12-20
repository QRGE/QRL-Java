package org.qrl.database.jdbc.demo;

import cn.hutool.core.io.IoUtil;
import org.qrl.database.util.ResourceUtil;

import java.sql.*;
import java.util.Properties;

/**
 * jdbc java-database-connectivity java官方提供连接数据库的一套标准
 * mysql-connector-java 是 mysql 官方对 jdbc 的实现
 * - 第三方供应商在他们的数据库驱动程序中都实现了 java.sql.Driver
 * @author qr
 * @date 2021/12/20 13:46
 */
public class Demo1_JDBCStart {

    public static void main(String[] args) {
        // 配置文件内容读取
        Properties properties = ResourceUtil.getResourceFile("database.properties");
        String driver = properties.getProperty("driver", "com.mysql.cj.jdbc.Driver");
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        // 基础 demo
        ResultSet resultSet = null;
        Statement statement = null;
        Connection conn = null;
        new Properties();
        try {
            // 注册驱动, 动态加载驱动程序的类文件到内存中
            Class.forName(driver);
            // 获取连接
            conn = DriverManager.getConnection(url, user, password);
            // 获取sql执行对象: statement
            statement =  conn.createStatement();
            // 需要执行的 sql 语句
            String sql = "select * from t_user where data_id = 1 or 1=1"; // 😏
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
