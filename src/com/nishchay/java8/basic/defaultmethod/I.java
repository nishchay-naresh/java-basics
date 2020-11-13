package com.nishchay.java8.basic.defaultmethod;

interface I {
    default void show() {
        System.out.println("I.show");
    }
}
