package com.nishchay.core.basics.overload;

public class OverloadingDemo {

    public static void main(String[] args) {

        overloadBasedOnNonRelatedClass();
    }

    private static void overloadBasedOnNonRelatedClass(){

        Test ref = new Test();
//        ref.display("java");
        ref.display(null);  // working bcus Object <- String

    }

}

