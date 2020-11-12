package com.nishchay.core.basics.override;

import java.io.IOException;

public class Parent {

    public void print() {
        System.out.println("Parent.print()");
    }

    public void go() throws IOException {
        System.out.println("Parent.go()  throws IOException");
    }

    public void go1() throws IOException {
        System.out.println("Parent.go1()  throws IOException");
    }

    public void go2() throws IOException {
        System.out.println("Parent.go2()  throws IOException");
    }

    public void fo() throws RuntimeException {
        System.out.println("Parent.fo()  throws RuntimeException");
    }

    public void fo1() throws RuntimeException {
        System.out.println("Parent.fo1()  throws RuntimeException");
    }

    public void fo2() throws NullPointerException {
        System.out.println("Parent.fo2()  throws NullPointerException");
    }

    public void po() {
        System.out.println("Parent.po() Without throws of any exceptions");
    }
}