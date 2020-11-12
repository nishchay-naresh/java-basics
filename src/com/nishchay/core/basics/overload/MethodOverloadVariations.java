package com.nishchay.core.basics.overload;

/**
 * validating all variation for method overload based on
 * widening
 * Autoboxing
 * var-arg
 */

public class MethodOverloadVariations {

    public static void main(String[] args) {

//        widening > Autoboxing
//        so long version will get invoked
        int x = 5;
        go(5);

//        widening > var-arg
//        so int, int version will get invoked
        byte b = 5;
        go(b, b);

//        Autoboxing  > var-arg
//        so Byte, Byte version will get invoked
        go1(b, b);

// SO FINAL CONCLUSION =>  widening > Autoboxing  > var-arg

    }

    static public void go(long l) {
        System.out.println("long version");
    }

    static public void go(Integer i) {
        System.out.println("Integer version");
    }

    static public void go(int x, int y) {
        System.out.println("int, int version");
    }

    static public void go(byte... b) {
        System.out.println("byte ... version");
    }

    static public void go1(Byte x, Byte y) {
        System.out.println("Byte, Byte version");
    }

    static public void go1(byte... x) {
        System.out.println("byte ... version");
    }

}
