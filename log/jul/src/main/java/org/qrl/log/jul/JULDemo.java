package org.qrl.log.jul;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.logging.*;

/**
 * @author qr
 * @date 2021/11/11 9:30 PM
 */
public class JULDemo {
    public static Logger logger = Logger.getLogger("org.qrl.log.jul.JULSample");

    public final static String MODULE_PATH = System.getProperty("user.dir");

    @Test
    public void log(){
        // 通过 java.util.logger.Logger.getLogger() 创建 logger 对象
        // 传入的参数是当前类的全类名
        // 通过 logger.logLevel 进行日志输出
        logger.info("Level.INFO");
        logger.warning("Level.WARNING");

        // logger.log()
        logger.log(Level.SEVERE, "Level.SEVERE");

        // 可以借助 {n} 占位符指定输出的内容, 说实话不是很好看
        String username = "zhangSan";
        String password = "liSi";
        logger.log(Level.WARNING, "username: {0}, password: {1}", new Object[]{username, password});

        // jul 默认的日志级别是 INFO, 故此处不会输出 Fine 级别的日志信息
        logger.log(Level.FINE, "Level.Fine");
    }

    @Test
    public void setLoggerLevel(){
        // 打印日志设置不按照父logger的默认配置进行打印
        logger.setUseParentHandlers(false);
        ConsoleHandler handler = new ConsoleHandler();
        SimpleFormatter formatter = new SimpleFormatter();
        handler.setFormatter(formatter);
        // logger 和 handler 需要设置统一的级别
        logger.setLevel(Level.CONFIG);
        handler.setLevel(Level.CONFIG);
    }

    @Test
    public void file() throws IOException {
        // 每次运行都会覆盖掉原来的"路径"的日志
        FileHandler fileHandler = new FileHandler(MODULE_PATH + "/logs");
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        fileHandler.setFormatter(simpleFormatter);
        logger.addHandler(fileHandler);
        logger.setLevel(Level.ALL);
        fileHandler.setLevel(Level.ALL);
        logger.info("File log: info");
        logger.warning("FBI Warning!");
        logger.severe("something terrible");
        logger.fine("It's fine");
    }
}
