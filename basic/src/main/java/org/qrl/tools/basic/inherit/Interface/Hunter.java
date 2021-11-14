package org.qrl.tools.basic.inherit.Interface;

public interface Hunter {

    default void shoot(){
        System.out.println("Life one shoot");
    }
}
