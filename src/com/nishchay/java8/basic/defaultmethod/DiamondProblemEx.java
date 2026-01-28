package com.nishchay.java8.basic.defaultmethod;


/*
 *
 * Rule 1: Any method inherited from a class or a superclass is given higher priority over any default method inherited from an interface.
 *              class D extends A implements I -> A.show() will get picked bcus concrete impl > default impl
 *
 * Rule 2: Derived interfaces or sub-interfaces take higher precedence than the interfaces higher-up in the inheritance hierarchy.
 *              class E implements I, I10 -> I10.show() will get picked bcus sub-interfaces take higher precedence over actual interfaces
 *
 * Rule 3: In case Rule 1 and Rule 2 are not able to resolve the conflict,
 *          then the implementing class has to specifically override and provide a method with the same method definition.
 *              class A implements I, J -> class A has to provide the implementation for show() method, same will be picked during their call
 *
 * Refer the link - https://www.javacodemonk.com/diamond-problem-of-inheritance-in-java-8-88faf6c9
 */
public class DiamondProblemEx {

    public static void main(String[] args) {

        rule1();
        rule2();
        diamondProblem();
    }
    /*
     * output ==>
     *		A.show()
     *		I10.show()
     *		A.show()
     * */

    private static void rule1() {
        D d = new D();
        d.show();
    }

    private static void rule2() {
        E e = new E();
        e.show();
    }

    private static void diamondProblem() {
        A ref = new A();
        ref.show();
    }

}

interface I {
    default void show() {
        System.out.println("I.show()");
    }
}

interface I10 extends I {
    default void show() {
        System.out.println("I10.show()");
    }
}

interface J {
    default void show() {
        System.out.println("J.show()");
    }
}

/*
 * Java does NOT allow multiple inheritance: designed purposefully to avoid this famous diamond problem
 * class D extends B, C { } // Compilation error,
 * But after java8 default method introduction at Interface level, we end up here
 *
 * CE - A inherits unrelated default for show() from type I & J
 * Conflict -> Now this class inherits both I and J — so there is ambiguity which versin of show() to use?
 * Must resolve the conflict explicitly, else EC
 * So now its class A responsibility to resolve this ambiguity by providing the implementation for show() method
 *
 * */
class A implements I, J {

    @Override
    public void show() {
        // J.super.show(); // or I.super.show(); resolving using super
        System.out.println("A.show()"); // custom implementation
    }
}

class D extends A implements I {
}

class E implements I, I10 {
}