package com.nishchay.java8.async.cf;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class CF02CompleteAFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        completingAFuture();
        completedFutureEx();
        completingAFutureExceptionally();

    }



    private static void completingAFuture() throws ExecutionException, InterruptedException {

        CompletableFuture<String> cf = new CompletableFuture<>();
        // completing the cf by calling complete() method
        cf.complete("dummy value");

        // again this.get() call will get blocked, we need to complete this cf
        String result = cf.get();
        System.out.println("cf.get() = " + cf.get());


        CompletableFuture<Integer> cf1 = new CompletableFuture<>();
        cf1.complete(999);
        System.out.println("cf.join() = " + cf1.join());

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

    /*
     * completeExceptionally(t) - completing a CompletableFuture with an Exception
     * */
    private static void completingAFutureExceptionally() {

        CompletableFuture<String> f1 = new CompletableFuture<>();
//        f1.completeExceptionally(new RuntimeException("completed exceptionally"));
        f1.complete("response");

        // join() -  will get result/exception based on its completion
        System.out.println("result = " + f1.join());

    }

}
