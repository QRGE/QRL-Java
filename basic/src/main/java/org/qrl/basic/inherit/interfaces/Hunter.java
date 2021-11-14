package org.qrl.basic.inherit.interfaces;

public interface Hunter {

    default void shoot(){
        System.out.println("Life one shoot");
    }
}
