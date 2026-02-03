package com.nishchay.core.basics;

/*
*  https://stackoverflow.com/questions/351565/system-currenttimemillis-vs-system-nanotime
*
*  replacing System.currentTimeMillis() to System.nanoTime()
* */

import com.nishchay.util.Utils;

/*
*  https://stackoverflow.com/questions/29537639/
* ======= assignment and null check in single statement ==========
*  You can use the result variable as your temporary, like this:
*     dinner = ((dinner = cage.getChicken()) != null) ? dinner : getFreeRangeChicken();
*
* */
public class TimeSpendInSecond {

    public static void main(String[] args) {

        int n = 100000;
        millis(n);
        nanos(n);

    }

    private static void millis(int no){
        long start = System.currentTimeMillis();
        Utils.countPrimes(no);
        long end = System.currentTimeMillis();

        System.out.println("Took : " + ((end - start) / 1000));
    }

    private static void nanos(int no){
        final long start = System.nanoTime();
        Utils.countPrimes(no);
        final long end = System.nanoTime();

        System.out.println("Took: " + ((end - start) / 1000000) + "ms");
        System.out.println("Took: " + (end - start)/ 1000000000 + " seconds");
    }
}
