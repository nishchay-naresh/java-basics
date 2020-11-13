package com.nishchay.java8.basic.defaultmethod;

interface J {
    default void show() {
        System.out.println("J.show");
    }
}