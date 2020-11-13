package com.nishchay.java8.basic.defaultmethod;



/*
 * Reffer the link - https://www.javacodemonk.com/diamond-problem-of-inheritance-in-java-8-88faf6c9
 * error - inherits unrelated defualt for method show() from I & J
 * Its class A who introduces this ambiguity by implementing interface I & J
 * So now its class A responsibility to resolve this ambiguity by providing the implementation for show() method
 * concrete method have more priority over default method, ojb ref will execute the concrete method
 */


class A implements I, J {

    @Override
    public void show() {
        System.out.println("A.show");
    }
}