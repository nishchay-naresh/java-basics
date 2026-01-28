package com.nishchay.java8.basic.defaultmethod;

public class DefaultMethodDemo {

    interface I55 {

        // abstract method -> this required an implementation
        public abstract void abstractMethod();

        // default method -> can have some default implementation and can also be overridden by implementing class
        public default void newMethod_default_1() {
            System.out.println("Newly added default method");
        }

        public default void newMethod_default_2() {
            System.out.println("I55.newMethod_default_2()");
        }

        // static method -> can have some fixed implementation that can't be overridden by implementing class
        public static void newMethod_static() {
            System.out.println("Newly added static method");
        }
    }

    static class C55 implements I55 {

        // implementing abstract method
        public void abstractMethod() {
            System.out.println("Abstract method, which gets implemented");
        }

        /*
         * A default method can also be overridden by implementing classes.
         * If one is not happy with the default implementation, One can override its default implementation
         * */
        @Override
        public void newMethod_default_2() {
            System.out.println("C55.newMethod_default_2()");
        }
    }

    public static void main(String[] args) {

        C55 c55 = new DefaultMethodDemo.C55();
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
 * 		Abstract method, which gets implemented
 * 		Newly added static method
 * */
