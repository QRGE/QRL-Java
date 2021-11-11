package org.qrl.log.slf4j;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author qr
 * @date 2021/11/10 10:45 PM
 */
public class Slf4jDemo {
    /**
     * slf4j need binding, 如果一个项目中导入了多个 slf4j 的实现依赖, 那默认会绑定第一个依赖(POM顺序)
     */
    Logger logger = LoggerFactory.getLogger(Slf4jDemo.class);

    @Test
    public void helloWord(){
        logger.info("helloWorld");
    }

    @Test
    public void error(){
        try {
            Class.forName("NiHaoWa");
        } catch (ClassNotFoundException e) {
            // 直接传入一个 Throwable 类的参数
            logger.error("报错: ", e);
        }
    }
}
