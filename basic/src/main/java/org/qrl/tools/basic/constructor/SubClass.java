package org.qrl.tools.basic.constructor;

/**
 * @Author: QR
 * @Date: 2021/7/23-20:42
 */
@SuppressWarnings("all")
public class SubClass extends SuperClass{

    public SubClass(){
        System.out.println("SubClass Constructor");
    }

    public SubClass(String name){
        System.out.println("SubClass: " + name);
    }

    public static void main(String[] args) {
        SubClass subClass = new SubClass("Test");
    }
}
