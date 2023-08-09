package com.nishchay.test.paypal;

import java.util.ArrayList;
import java.util.List;

/*
 *			Find Fibonacci numbers till N with below constraints:
 *			Objectives:
 *			- Recursive
 *			- No objects / references in input
 *			- No global variables
 *
 *			Sample:
 *			If n = 6 -> 1,1,2,3,5
 *			If n = 10 -> 1,1,2,3,5,8
 *
 *			public static void main(String arg[]) {
 *			    fib(10).forEach(System.out::print)
 *			}
 *
 *			List<Integer> fib(int n,...) {
 *
 *			}
 * */
public class Fibonacci {

    public static void main(String[] args) {

        int n = 17;

        System.out.println("Fibonacci recursive print");
        fib_rec_print(0, 1, n);

        System.out.println("\n--------------------------------");
        System.out.println("Fibonacci recursive return list but passing a reference");
        fib_rec_list_ref(0, 1, n, new ArrayList<>()).forEach(System.out::print);

        System.out.println("\n--------------------------------");
        System.out.println("Fibonacci recursive return list");
        fib_rec_list(0, 1, n).forEach(e -> System.out.print(" " + e));

    }


    private static void fib_rec_print(int a, int b, int n) {

        if (a == 0) {
            System.out.print(" " + a + " " + b);
        }
        int c = a + b;
        if (n < c) {
            return;
        }

        System.out.print(" " + c);
        fib_rec_print(b, c, n);
    }


    private static List<Integer> fib_rec_list_ref(int a, int b, int n, List<Integer> res) {

        if (a == 0) {
            res.add(a);
            res.add(b);
        }
        int c = a + b;
        if (n < c) {
            return res;
        }

        res.add(c);
        return fib_rec_list_ref(b, c, n, res);
    }

    private static List<Integer> fib_rec_list(int a, int b, int n) {
        List<Integer> res = new ArrayList<>();
        if (a == 0) {
            res.add(a);
            res.add(b);
        }
        int c = a + b;
        if (n < c) {
            return res;
        }
        res.add(c);
        return union(res, fib_rec_list(b, c, n));
    }

    private static <T> List<T> union(List<T> list1, List<T> list2) {
        list1.addAll(list2);
        return list1;
    }

}