package com.nishchay.java8.async.cf;

import com.nishchay.util.Utils;

import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class CF04AsyncExecution {

    public static void main(String[] args){

        runAsyncEx();
        supplyAsyncEx();

    }


    /*
    * Running asynchronous computation using runAsync() - Passing a Runnable
    * returns -  CompletableFuture<Void> , means using in scenarios, when don't want to return any result
    *
    * Doing some computation and publishing its result
    * */
    private static void runAsyncEx(){

        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> Utils.primeSum());
        // completableFuture.get();
        completableFuture.join();

    }

    /*
     * =====CompletableFuture with Encapsulated Computation Logic=====
     *
     * Running asynchronous computation using supplyAsync() - Passing a Supplier<T>
     * returns -  CompletableFuture<T> , means using in scenarios, when want to return a computed result
     *
     * */
    private static void supplyAsyncEx(){

        CompletableFuture<String> completableFutureString = CompletableFuture.supplyAsync(() -> "Hello");
        System.out.println("result = " + completableFutureString.join()); // Hello

        CompletableFuture<Integer> completableFutureInteger = CompletableFuture.supplyAsync(() -> IntStream.rangeClosed(1, 100).sum());
        System.out.println("result = " + completableFutureInteger.join()); // 5050

    }

}
