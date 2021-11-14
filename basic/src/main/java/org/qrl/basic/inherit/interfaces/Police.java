package org.qrl.basic.inherit.interfaces;

public interface Police {

    default void shoot(){
        System.out.println("Avoid the key");
    }
}
