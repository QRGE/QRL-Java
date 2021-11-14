package org.qrl.basic.inherit.Interface;

public interface Police {

    default void shoot(){
        System.out.println("Avoid the key");
    }
}
