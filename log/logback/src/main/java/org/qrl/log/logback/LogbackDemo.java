package org.qrl.log.logback;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author qr
 * @date 2021/11/11 9:25 PM
 */
public class LogbackDemo {

    private final static Logger LOG = LoggerFactory.getLogger(LogbackDemo.class);

    @Test
    public void helloWorld() {
        LOG.info("logback.info");
        LOG.warn("logback.warn");
        LOG.error("logback.error");
    }

    public void lambdaStyle() {

    }
}
