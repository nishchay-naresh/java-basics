package com.nishchay.java8.basic.defaultmethod;

public class DefaultMethodTest {

    public static void main(String[] args) {
        A1 a1 = new A1();
        a1.m1();
        a1.meth();

        B1 b1 = new B1();
        b1.m1();
        b1.meth();

        A1 a2 = new B1();
        a2.m1();
        a2.meth();
    }
}

/*
 * output ==>
 *		I1,I1
 *		I2,I2
 *		I2,I2
 * */
interface I1 {
    default void m1() {
        System.out.println("I1");
    }
}

interface I2 extends I1 {
    default void m1() {
        System.out.println("I2");
    }
}

class A1 implements I1 {
    public void meth() {
        m1();
    }
}

class B1 extends A1 implements I2 {
    public void meth() {
        m1();
    }
}