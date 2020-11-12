package com.nishchay.core.basics.override;

import java.io.FileNotFoundException;

public class Child extends Parent {

    public void print() {
        System.out.println("Child.print()");
    }

    public void go() throws FileNotFoundException {
        System.out.println("Child.go() throws FileNotFoundException");
    }

    public void go1() {
        System.out.println("Child.go1() Without throws of any exceptions");
    }

    public void go2() throws NullPointerException {
        System.out.println("Child.go2() throws NullPointerException");
    }

    public void fo() throws NullPointerException {
        System.out.println("Child.fo() throws NullPointerException");
    }

    public void fo1() {
        System.out.println("Child.fo1() Without throws of any exceptions");
    }

    public void fo2() throws ArrayIndexOutOfBoundsException {
        System.out.println("Child.fo2() throws ArrayIndexOutOfBoundsException");
    }

    // not a valid override, can't override for checked exception
/*
    public void po() throws FileNotFoundException {
        System.out.println("Child.po() throws FileNotFoundException");
    }
*/

    public void po() throws ArrayIndexOutOfBoundsException {
        System.out.println("Child.po() throws ArrayIndexOutOfBoundsException");
    }

}