package com.nishchay.java8.async.cf.combine;

import com.nishchay.util.Utils;

import java.util.concurrent.CompletableFuture;

/*
 *
 * handle(BiFunction<T, Throwable, R> ) - gets called when a cf gets completed successfully, or there is an exception
 *  Its receives both the result and the Exception
 *
 * exceptionally(Function<Throwable, R> ) - gets only called when a there is an exception
 * Its receives only the Exception
 *
 * completeExceptionally(Throwable ) - manually completing a future with Exception
 *
 * */
public class ExceptionHandling {

    public static void main(String[] args) {

        handleEx();
        exceptionallyEx();

        completingAFutureExceptionally();

    }


    private static void handleEx() {

        CompletableFuture<String> future =
                CompletableFuture.supplyAsync(() -> Utils.getResponse())
                        .handle((s, e) -> logError(s, e));

        System.out.println(future.join());

    }

    private static String logError(String result, Throwable error) {
        if (error != null) {
            System.out.println(error.getMessage());
            return "fall back";
        }
        return result;
    }

    private static void exceptionallyEx() {

        CompletableFuture<String> future =
                CompletableFuture.supplyAsync(() -> Utils.getResponse())
                        .exceptionally((e) -> {
                            System.out.println(e.getMessage());
                            return "fall back";
                        });

        System.out.println(future.join());
    }


    private static void completingAFutureExceptionally() {

        CompletableFuture<Integer> completableFuture = new CompletableFuture<>();

        process(completableFuture);

        // manually completing a future - with Exception
        completableFuture.completeExceptionally(new RuntimeException("Something went wrong ..!!"));

    }


    /*
    *  setting the pipeline, keeping it ready once my data will arrive, ready with what to do with these data
    *  series of transformation then processing with the final result
    * */
    public static void process(CompletableFuture<Integer> future) {
        future
                .exceptionally(throwable -> logError(throwable))
                .thenApply(data -> data * 2)
                .thenApply(data -> data + 1)
                .thenAccept(System.out::println);
    }

    private static Integer logError(Throwable throwable) {
        System.out.println("ERROR - " + throwable);
        //throw new RuntimeException("this is beyond repair");
        return 100; // output - 201
    }


}