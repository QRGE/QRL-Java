package org.qrl.database.jdbc.demo;

import cn.hutool.core.io.IoUtil;
import org.qrl.database.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author qr
 * @date 2021/12/20 14:24
 */
public class Demo2_PrepareStatement {

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtil.getConnect();
            // 需要执行的 sql 语句
            String sql = "select * from t_user where data_id = ?";
            preparedStatement = connection.prepareStatement(sql);
            // 执行sql语句,返回一个结果集: resultSet
            preparedStatement.setInt(1, 1);
            resultSet= preparedStatement.executeQuery(sql);
            // 处理结果集
            while(resultSet.next()) {
                String name = resultSet.getString("username");
                String nickname = resultSet.getString("nickname");
                System.out.println("name: " + name + ", nickname: " + nickname);
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            IoUtil.close(connection);
            IoUtil.close(preparedStatement);
            IoUtil.close(resultSet);
        }
    }
}
