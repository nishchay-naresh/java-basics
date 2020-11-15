package com.nishchay.java8.streams.intstream;


import java.util.stream.IntStream;

public class StreamPrime {

    public static void main(String[] args) {

        System.out.println(isPrime(7));
        System.out.println(isPrime(13));
        System.out.println(isPrime(2));
        System.out.println(isPrime(4));
        System.out.println(isPrime(9));
    }

    private static boolean isPrime(int num) {

        // declarative
        // focus on what, rather how
        // immutability
        return num > 1 && IntStream.range(2, num).noneMatch(i -> num % i == 0);
    }
}
