package com.nishchay.java8.basic.defaultmethod;

public class DefaultMethodDemo implements MyInterface {

    // implementing abstract method
    public void existingMethod(String str){
        System.out.println("String is: "+str);
    }

    // implementing a default method - a default method can be overridden by implementing classes.
    @Override
    public void m1() {
        System.out.println("DefaultMethodDemo.m1()");
    }


}