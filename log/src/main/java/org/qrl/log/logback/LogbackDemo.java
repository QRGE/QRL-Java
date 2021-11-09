package org.qrl.log.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author qr
 * @date 2021/11/8 11:37 PM
 */
public class LogbackDemo {

    private final static Logger LOGGER = LoggerFactory.getLogger(LogbackDemo.class);

    public static void main(String[] args) {
        LOGGER.info("logback.info: {}", "测试info");
        LOGGER.warn("logback.warn: {}", "");
        LOGGER.error("logback.error: {}", "测试error");
    }
}
