package com.nishchay.core.gc;

import com.nishchay.ds.number.Prime;

public class TimeSpanInSecond {

    public static void main(String[] args) {

        int n = 100000;
        millis(n);
        nanos(n);

    }

    private static void millis(int no){
        long start = System.currentTimeMillis();
        Prime.countPrimes(no);
        long end = System.currentTimeMillis();

        System.out.println("Took : " + ((end - start) / 1000));
    }

    private static void nanos(int no){
        final long start = System.nanoTime();
        Prime.countPrimes(no);
        final long end = System.nanoTime();

        System.out.println("Took: " + ((end - start) / 1000000) + "ms");
        System.out.println("Took: " + (end - start)/ 1000000000 + " seconds");
    }
}
