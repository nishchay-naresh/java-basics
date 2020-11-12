package com.nishchay.core.basics;

public class BooleanTest {

    public static void main(String[] args) {
        method1();
    }

    private static void method1(){
        boolean condition = Boolean.TRUE;
        if(condition){
            System.out.println("condition id true");
        }else{
            System.out.println("condition id false");
        }
    }
}
