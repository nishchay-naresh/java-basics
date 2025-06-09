package com.nishchay.java8.basic.defaultmethod;

interface MyInterface {
    /*
     * This is a default method -> It can have some default implementation
     * One is not happy with the default implementation he can override its default implementation
     */
    default void newMethod() {
        System.out.println("Newly added default method");
    }
    /*
     * public and abstract method -> One need to implement this method
     */
    void existingMethod(String str);
    default void m1(){
        System.out.println("MyInterface.m1()");
    }

    static void anotherNewMethod() {
        System.out.println("Newly added static method");
    }
}

