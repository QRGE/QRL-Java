package org.qrl.tools.basic.inherit.Interface;

/**
 * 如果两个类都有相同的默认方法, 你需要重写, 可以通过 Interface.function() 的形式去调用某个接口的默认方法
 * @author qr
 * @date 2021/11/13 4:00 PM
 */
public class Trainee implements Hunter, Police{


    public static void main(String[] args) {
        new Trainee().shoot();
    }

    @Override
    public void shoot() {
        Police.super.shoot();
    }
}
