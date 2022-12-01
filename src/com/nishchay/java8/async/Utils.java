package com.nishchay.java8.async;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static com.nishchay.ds.number.Prime.isPrime1;

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
        int sum = IntStream.rangeClosed(1,100000 ).filter(e -> isPrime1(e)).sum();
        System.out.println("sum of primes till 100000 = " + sum);
        System.out.println("primeSum - "+ Thread.currentThread());
    }

    public static CompletableFuture<Integer> create(int n){
        return CompletableFuture.supplyAsync(() -> n);
    }

    public static CompletableFuture<Integer> doubled(int n){
        return CompletableFuture.supplyAsync(() -> n * 2);
    }

    public static CompletableFuture<Integer> addThree(int n){
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

}
