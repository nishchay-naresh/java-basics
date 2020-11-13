package com.nishchay.java8.basic.methodref;

public class InstcMethodParamDemo {

    public void myMethod(int x){
        System.out.println("Instance Method - " + x);
    }

    public static void main(String[] args) {
        InstcMethodParamDemo obj = new InstcMethodParamDemo();
        MyInterface2 ref = obj::myMethod;
//        Intrf ref = (x) -> obj.myMethod(x);
/*
Its same like providing the implementation of abstract method display(int x) as
 void display(int a){
    myMethod(a)
 }
 */
        ref.display(10);
    }
}

