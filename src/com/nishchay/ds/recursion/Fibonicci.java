package com.nishchay.ds.recursion;

public class Fibonicci {

    public static void main(String[] args) {
        int n=9;
/*        Fibonicci ref = new Fibonicci();
        System.out.println(ref.fibo(n));*/

        printFibo(n);

    }

    private int fibo(int n) {

        if(n <= 1)
            return n;
        else
            return fibo(n-1) + fibo(n-2);

    }

    private int fibo1(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        return fibo1(n - 1) + fibo1(n - 2);
    }

    private static void printFibo(int n) {
        int t1, t2, t3;
        t1 = 0;
        t2 = 1;
        System.out.print("Series -  " + t1 + " " + t2);
        for (int i = 2; i <= n; i++) {
            t3 = t1 + t2;
            System.out.print(" " + t3);
            t1 = t2;
            t2 = t3;
        }
    }

}
