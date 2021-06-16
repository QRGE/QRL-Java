package qr.Java.Logs.Logback;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackDemo {

    /**
     * logback由5种级别的日志输出:
     *      trace < debug < info < warn < error
     *      通过打印, 默认的日志界别为debug, 故下例种trace信息没有打印出来
     */
    @Test
    public void level(){
        Logger logger = LoggerFactory.getLogger(LogbackDemo.class);
        logger.error("Something Error");
        logger.warn("Something Warn");
        logger.info("Something Info");
        logger.debug("Something Debug");
        logger.trace("Something Trace");
    }

    @Test
    public void Configuration(){
        Logger logger = LoggerFactory.getLogger(LogbackDemo.class);
        logger.error("Something Error");
        logger.warn("Something Warn");
        logger.info("Something Info");
        logger.debug("Something Debug");
        logger.trace("Something Trace");
    }
}
