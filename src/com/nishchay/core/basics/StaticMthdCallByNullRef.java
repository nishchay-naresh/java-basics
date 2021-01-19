package com.nishchay.core.basics;

public class StaticMthdCallByNullRef {

    public static void main(String[] args) {

        StaticMthdCallByNullRef ref1 =  new StaticMthdCallByNullRef();
        ref1.sayHi("java");

        StaticMthdCallByNullRef ref2 = null;
        ref2.sayHi("null");

        StaticMthdCallByNullRef.sayHi("class name");

        sayHi("no reference");

    }


    public static void sayHi(String name){
        System.out.println("hi " + name);
    }

}
