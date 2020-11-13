package com.nishchay.java8.basic.methodref;

public class InstcMethodDemo {

    public void myMethod(){
        System.out.println("Instance Method");
    }

    public static void main(String[] args) {

        InstcMethodDemo obj = new InstcMethodDemo();
        int x= 10;
        MyInterface1 ref = obj::myMethod;
        //  MyInterface ref = () -> obj.myMethod();
        //  Calling the method of functional interface
        ref.display();
    }
}




