package qrl.design.pattern;

import org.junit.jupiter.api.Test;
import qrl.design.pattern.singleton.LazySingletonEnum;

/**
 * @Author: QR
 * @Date: 2021/8/31-22:40
 */
public class SingletonTests {

    @Test
    public void lazySingletonEnumTest(){
        LazySingletonEnum singleton = LazySingletonEnum.SINGLETON;
        System.out.println(singleton);
    }
}
