package org.qrl.log.logback;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author qr
 * @date 2021/11/11 9:25 PM
 */
public class LogbackDemo {

    private final static Logger LOGGER = LoggerFactory.getLogger(LogbackDemo.class);

    @Test
    public void helloWorld() {
        LOGGER.info("logback.info");
        LOGGER.warn("logback.warn");
        LOGGER.error("logback.error");
    }
}
