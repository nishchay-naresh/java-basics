package com.nishchay.core.basics.overload;

public class Test {

    public void display(Object obj) {
        System.out.println("Object");
    }

    // Ambiguous method call
    // Won't work with Test type, String and Test are independent class
/*
    public void display(Test obj){
        System.out.println("Test");
    }
*/

    public void display(String str) {
        System.out.println("String");
    }

}