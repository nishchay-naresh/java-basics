package com.nishchay.java8.async.cf;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class CF02CompleteAFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        completingAFuture();

        completedFutureEx();

    }

    private static void completingAFuture() throws ExecutionException, InterruptedException {

        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        String result = completableFuture.get();
        System.out.println("result - " + result);
        // again this.get() call will get blocked, we need to complete this cf

        // completing the cf by calling complete() method
        completableFuture.complete("dummy value");

    }

    /*
     * completedFuture(v) - Returns a new CompletableFuture that is already completed with
     * */
    private static void completedFutureEx(){

        Future<String> future = CompletableFuture.completedFuture("Hello");
        String result = null;
        try {
            result = future.get();
        } catch (InterruptedException | ExecutionException ignored) { }
        System.out.println("result = " + result);

    }

}
