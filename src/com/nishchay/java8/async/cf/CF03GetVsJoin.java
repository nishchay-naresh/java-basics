package com.nishchay.java8.async.cf;

import com.nishchay.util.Utils;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/*
 *
 *	CompletableFuture<T> class: join() vs get()
 *	Both functionally does the same thing :  extract out the computed result
 *	the only difference is how methods throw exceptions :
 *
 *	V get() throws InterruptedException, ExecutionException;
 *	V join()
 *
 * Since both are the checked InterruptedException, ExecutionException we need to handle it
 * So If we sure that, there will not be any exception, we don't have any fallback mechanism to handle the exception
 * We will always fetch the result using join() rather get()
 *
 * */
public class CF03GetVsJoin {

    public static void main(String[] args) {

        retrieveUsingGet();
        retrieveUsingJoin();

    }

    private static void retrieveUsingGet() {

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> Utils.doSomeTask());

        // retrieving the result using join()
        String resultValue;
        try {
            resultValue = completableFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Result - " + resultValue);
    }

    private static void retrieveUsingJoin() {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> Utils.doSomeTask());

        // retrieving the result using join()
        // need not required to handle checked exceptions
        String resultValue = completableFuture.join();
        System.out.println("Result - " + resultValue);
    }

}