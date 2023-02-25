package com.nishchay.java8.async.cf.combine;

import java.util.concurrent.CompletableFuture;

import static com.nishchay.util.Utils.delay;

public class AnyAllOfExample {


    public static void main(String[] args) {

        allOfEx();
        anyOfEx();

    }

    /*
    * Waits for all the future to complete
    * */
    private static void allOfEx() {
        long startTime = System.currentTimeMillis();
        CompletableFuture<String> future1 = future1();
        CompletableFuture<String> future2 = future2();
        CompletableFuture<String> future3 = future3();

        CompletableFuture<Void> future = CompletableFuture.allOf(future1, future2, future3);

        future.join();
        long endTime = System.currentTimeMillis();
        System.out.println("Time Taken - " + (endTime - startTime) / 1000);
    }

    /*
     * Waits for any of the future to complete (means wait to get first response)
     * */
    private static void anyOfEx() {
        long startTime = System.currentTimeMillis();
        CompletableFuture<String> future1 = future1();
        CompletableFuture<String> future2 = future2();
        CompletableFuture<String> future3 = future3();

        CompletableFuture<Object> future = CompletableFuture.anyOf(future1, future2, future3);

        Object fistCompletedFutureResult = future.join();
        System.out.println("fistCompletedFutureResult = " + fistCompletedFutureResult);
        long endTime = System.currentTimeMillis();
        System.out.println("Time Taken - " + (endTime - startTime) / 1000);
    }


    public static CompletableFuture<String> future1() {
        return CompletableFuture.supplyAsync(
                () -> {
                    System.out.println(" future1 - " + Thread.currentThread().getName());
                    delay(2);
                    return "1";
                }
        );
    }

    public static CompletableFuture<String> future2() {
        return CompletableFuture.supplyAsync(
                () -> {
                    System.out.println(" future3 - " + Thread.currentThread().getName());
                    delay(4);
                    return "2";
                }
        );
    }

    public static CompletableFuture<String> future3() {
        return CompletableFuture.supplyAsync(
                () -> {
                    System.out.println(" future3 - " + Thread.currentThread().getName());
                    delay(3);
                    return "3";
                }
        );
    }

}