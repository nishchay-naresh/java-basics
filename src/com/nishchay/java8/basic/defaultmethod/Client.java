package com.nishchay.java8.basic.defaultmethod;

public class Client {

    public static void main(String[] args) {
        DefaultMethodDemo obj = new DefaultMethodDemo();

        //calling the default method of interface
        obj.newMethod();
        //calling the abstract method of interface
        obj.existingMethod("Java 8 is easy to learn");
        //calling the static method of interface
        MyInterface.anotherNewMethod();
        //calling default method of interface, which ahs been overridden in an implementation class
        obj.m1();
    }

}
