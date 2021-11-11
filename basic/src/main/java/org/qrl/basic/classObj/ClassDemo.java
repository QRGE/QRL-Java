package org.qrl.basic.classObj;

import org.qrl.basic.entity.Person;

/**
 * @Author: QR
 * @Date: 2021/7/21-21:55
 */
public class ClassDemo {

    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person.getClass().getName());
    }
}
