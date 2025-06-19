package com.nishchay.java8.basic.defaultmethod;

public class DefaultMethodDemo {
    public static void main(String[] args) {

        C55 c55 = new C55();
        c55.newMethod_default_1();
        c55.newMethod_default_2();
        c55.abstractMethod();

        I55.newMethod_static();
    }
}
/*
 * output ==>
 * 		Newly added default method
 * 		C55.newMethod_default_2()
 * 		Abstract method, which got implemented
 * 		Newly added static method
 * */

class C55 implements I55 {

    // implementing abstract method
    public void abstractMethod() {
        System.out.println("Abstract method, which got implemented");
    }

    /*
    * A default method can be overridden by implementing classes.
    * If one is not happy with the default implementation he can override its default implementation
    * */
    @Override
    public void newMethod_default_2() {
        System.out.println("C55.newMethod_default_2()");
    }
}

interface I55 {

    // abstract method -> this required an implementation
    public abstract void abstractMethod();

    // default method -> can have some implementation and can also be overridden by implementing class
    public default void newMethod_default_1() {
        System.out.println("Newly added default method");
    }

    public default void newMethod_default_2() {
        System.out.println("I55.newMethod_default_2()");
    }

    public static void newMethod_static() {
        System.out.println("Newly added static method");
    }
}
