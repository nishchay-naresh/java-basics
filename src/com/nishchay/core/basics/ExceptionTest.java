package com.nishchay.core.basics;

public class ExceptionTest {

    public static void main(String[] args) throws Exception {

        System.out.println(test1Ex());
        System.out.println(test2Ex());

        test3Ex();
        // Exception in thread "main" java.lang.Exception

        System.out.println(test4Ex());
        // java.lang.NumberFormatException: For input string: "two"

    }


    private static int test1Ex() {

        try {
            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            return 3;
        }

    }


    private static int test2Ex() {

        int k = 0;
        try {
            return 100 / k;
        } catch (Exception e) {
            return 200 / k;
        } finally {
            return 300;
        }

    }

    private static void test3Ex() throws Exception {

        try {
            int x = 5 / 0;
        } catch (Exception e) {
            throw new Exception();
        } finally {
            System.out.println("in finally");
        }
    }


    private static int test4Ex() {
        int x = 0;
        try {
            x = Integer.parseInt("two");
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return x;
    }


}
