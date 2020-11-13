package com.nishchay.java8.basic.methodref;

public class ConstructorDemo {

    public static void main(String[] args) {
        //  Method reference to a constructor
        MyInterface3 ref = (s) ->  new Hello(s);
        //  MyInterface3 ref = Hello::new;
        ref.display("Hello World!");
    }

}


