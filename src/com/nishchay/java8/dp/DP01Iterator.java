package com.nishchay.java8.dp;

import java.util.stream.IntStream;

public class DP01Iterator {

    public static void main(String[] args) {

        System.out.println(factorial(5));
        System.out.println(factorialFunctional(5));

/*
        // Refer this
        System.out.println("isPrime(47) - " + Prime.isPrime(47));
        System.out.println("isPrime(53) - " + Prime.isPrime1(53));
        System.out.println("isPrime(31) - " + Prime.isPrime1(31));
        System.out.println("isPrime(51) - " + Prime.isPrime1(51));
*/

    }

    // Imperative way to find the factorial.
    public static int factorial(int number) {
        int product = 1;
        for(int i = 1; i <= number; i++) {
            product *= i;
        }
        return product;
    }

    // Declarative way to find the factorial.
    // Using Stream & Reduce
    public static int factorialFunctional(int number) {
        return IntStream.rangeClosed(1, number)
                .reduce(1, (product, index) -> product * index);
    }

}
