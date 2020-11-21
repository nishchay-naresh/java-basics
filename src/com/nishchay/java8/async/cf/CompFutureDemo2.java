package com.nishchay.java8.async.cf;

import java.util.concurrent.CompletableFuture;

public class CompFutureDemo2 {

    public static void main(String[] args) {

        CompletableFuture<Integer> compFuture = new CompletableFuture<>();

        process(compFuture);

        // manually completing the future - proper returned value
        // compFuture.complete(2);

        // manually completing the future - with the Exception
        compFuture.completeExceptionally(new RuntimeException("Something went wrong ..!!"));

//          if we are commenting both of the above line for the completion of the CompletableFuture
//          this will be a typical use case of LiveLock -  u are waiting for a condition that will never going to happen
    }


    // setting the pipeline , keeping it ready once my data will arrive, ready with what to do with it
    // series of transformation then processing with the final result
    public static void process(CompletableFuture<Integer> future) {
        future
                .exceptionally(throwable -> handle(throwable))
                .thenApply(data -> data * 2)
                .thenApply(data -> data + 1)
                .thenAccept(System.out::println);
    }

    private static Integer handle(Throwable throwable) {
        System.out.println("ERROR - " + throwable);
//        return 100;
        throw new RuntimeException("this is beyond repair");
    }

}

