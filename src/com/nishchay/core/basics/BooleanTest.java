package com.nishchay.core.basics;

public class BooleanTest {

    public static void main(String[] args) {

        test1Ex();
        test2Ex();

    }

    private static void test1Ex() {
        boolean condition = Boolean.TRUE;
        if (condition) {
            System.out.println("condition id true");
        } else {
            System.out.println("condition id false");
        }
    }

    private static void test2Ex() {
        boolean a = true;
        if (a = false) { // depends upon what we are assigning to boolean var
            System.out.println("TRUE");
        } else {
            System.out.println("FALSE");
        }
    }
}
