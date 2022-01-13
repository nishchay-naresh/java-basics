package com.nishchay.ds.number;

import java.util.stream.IntStream;

public class Prime {

    public static void main(String[] args) {

        for (int i = 2; i <= 100; i++)
            if (isPrime(i))
                System.out.print("  " + i);


    }

    public static void countPrimes(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i))
                count++;
        }
        System.out.println("count = " + count);
    }

    // Imperative way to find the Prime.
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        for (int i = 2; i <= n / 2; i++)
            if (n % i == 0)
                return false;
        return true;
    }


    // Declarative way to find the Prime.
    // Using Stream & Predicate
    public static boolean isPrime1(int number) {
        return 1 < number &&
                IntStream.range(2, number / 2)
                        .noneMatch(index -> number % index == 0);
    }

}
