package com.nishchay.core.basics;

public class StaticMthdCallByNullRef {

    public static void main(String[] args) {

        StaticMthdCallByNullRef ref1 = null;
        ref1.sayHi("java");

        StaticMthdCallByNullRef ref2 =  new StaticMthdCallByNullRef();
        ref2.sayHi("java");

    }


    public static void sayHi(String name){
        System.out.println("hi " + name);
    }

}
