package com.nishchay.core.basics.overload;

public class OverloadingDemo {

    public static void main(String[] args) {

        overloadBasedOnNonRelatedClass();
        overloadBasedOnRelatedClass();

    }


    private static void overloadBasedOnNonRelatedClass(){

        display("java");
//        display(null);  // Ambiguous method call - not working bcus Thread, String are non-relatable class

    }

    private static void overloadBasedOnRelatedClass(){

        m1("java");
        m1(null);  // working bcus Object <- String

    }

    private static void display(String str) {
        System.out.println("String");
    }

    private static void display(Thread t){
        System.out.println("Thread");
    }

    private static void m1(Object obj) {
        System.out.println("Object");
    }

    private static void m1(String str) {
        System.out.println("String");
    }

}

