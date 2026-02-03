package com.nishchay.util;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Utils {

    public static void delay(int sec) {
        try {
            TimeUnit.SECONDS.sleep(sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String getResponse() {
        boolean unknownCondition = new Random().nextInt(100) % 2 == 0;
        if (unknownCondition) {
            throw new RuntimeException("Error@Future");
        }
        return "success";
    }

    public static String doSomeTask() {
        delay(3);
        return "success";
    }

    public static void primeSum() {
        // Simulate a long-running Job
        int sum = IntStream.rangeClosed(1, 100000).filter(e -> isPrimeStream(e)).sum();
        System.out.println("sum of primes till 100000 = " + sum);
        System.out.println("primeSum - " + Thread.currentThread());
    }

    public static CompletableFuture<Integer> create(int n) {
        return CompletableFuture.supplyAsync(() -> n);
    }

    public static CompletableFuture<Integer> doubled(int n) {
        return CompletableFuture.supplyAsync(() -> n * 2);
    }

    public static CompletableFuture<Integer> addThree(int n) {
        return CompletableFuture.supplyAsync(() -> n + 3);
    }

    public static void timeIt(Runnable block) {
        long start = System.nanoTime();
        try {
            block.run();
        } finally {
            long end = System.nanoTime();
            System.out.println("Time taken(sec): " + (end - start) / 1.0e9);
        }
    }

    public static void printIt(int val) {
        System.out.println(val);
        System.out.println("printIt - " + Thread.currentThread());
    }

    // Declarative way to find the Prime - Using Stream & Predicate
    public static boolean isPrimeStream(int number) {

        // range vs  rangeClosed : To properly check for factors, we should include number / 2, so rangeClosed
        return 1 < number &&
                IntStream.rangeClosed(2, (int) Math.sqrt(number))
                        .noneMatch(index -> number % index == 0);
    }

    public static void countPrimes(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrimeStream(i))
                count++;
        }
        System.out.println("count = " + count);
    }
}
