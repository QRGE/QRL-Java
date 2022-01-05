package org.qrl.database.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author qr
 * @date 2021/12/20 14:48
 */
public class JDBCUtil {

    private static Properties properties = new Properties();
    static {
        properties = ResourceUtil.getResourceFile("database.properties");
    }

    /**
     * 默认用 mysql 的 driver
     */
    private static final String driver = properties.getProperty("driver", "com.mysql.cj.jdbc.Driver");

    private static final String url = properties.getProperty("url");

    private static final String user = properties.getProperty("user");

    private static final String password = properties.getProperty("password");

    public static Connection getConnect() {
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
