package com.nishchay.java8.async.cf;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class CF00Basic {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        createCF();

    }

    // Different ways to create a CompletableFuture<T>
    private static void createCF() {
        CompletableFuture<Void> cf1 = new CompletableFuture<>();
        CompletableFuture<Integer> cf2 = CompletableFuture.supplyAsync(() -> 10);
        ForkJoinPool pool = new ForkJoinPool(5);
        // when wanted to use our own thread pool for CF rather than common pool
        CompletableFuture<Integer> cf3 = CompletableFuture.supplyAsync(() -> 10, pool);
        CompletableFuture<String> cf4 = cf3.thenApply(e -> Integer.toString(e));
    }

}
