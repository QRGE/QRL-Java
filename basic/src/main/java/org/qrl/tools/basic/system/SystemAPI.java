package org.qrl.tools.basic.system;

import org.junit.jupiter.api.Test;

/**
 * @author qr
 * @date 2021/11/9 11:15 PM
 */
public class SystemAPI {

    @Test
    public void userDir(){
        System.out.println(System.getProperty("user.dir"));
    }
}
