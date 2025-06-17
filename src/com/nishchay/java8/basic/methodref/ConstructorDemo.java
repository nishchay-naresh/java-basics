package com.nishchay.java8.basic.methodref;

public class ConstructorDemo {

    public static void main(String[] args) {
        //  Method reference to a constructor
        //  MyInterface3.display signature is (String ) -> Hello, So MyInterface3 MyInterface3 ~= (String ) -> Hello

        // MyInterface3 myInterface3 = Hello::new;
        MyInterface3 myInterface3 = (s) ->  new Hello(s);
        myInterface3.display("Hello World!");
    }
}


class Hello {
    Hello(String say) {
        System.out.print(say);
    }
}