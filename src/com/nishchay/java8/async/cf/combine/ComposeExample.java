package com.nishchay.java8.async.cf.combine;

import java.util.concurrent.CompletableFuture;

import static com.nishchay.util.Utils.*;

/*
 *
 *  thenApply(Function<T,R> ) - transforming the response
 *                              It performs the transformation
 *
 *
 *      Stream					    CompletableFuture
 *      zero, one, or more          zero or one
 *      only data channel           data channel and error channel
 *      forEach(Consumer<T> )       thenAccept(Consumer<T> )
 *      map(Function<T,R> )         thenApply(Function<T,R> )
 *      exception - oops            error channel
 *      ((( zip)))	                thenCombine()
 *      flatMap()                   thenCompose()
 *
 *
 *  UseCase of thenApply(Function<T,R> ) :
 *       -   want to transforming the response
 *
 *
 *  function returns data - map
 *  function returns collection - flatMap
 *
 *  function returns data - thenApply
 *  function returns CompletableFuture- thenCompose
 *
 *
 * ======= Composing dependent futures =======
 *
 * When second operation is dependent upon the output of first operation
 * Account - fetchAccountDetails(id )
 * Balance - getAccountBalance(Account )
 *
 * .thenCompose(Function<T, R> ) - used to chain two features sequentially
 *  Can be used to create a pipeline of dependent operations
 *
 * */
public class ComposeExample {
    public static void main(String[] args) {

        needOfCompose();
        ex1();
        ex2();
    }

    /*
    *
    * O/P - java.util.concurrent.CompletableFuture@6d03e736[Completed normally]
    * What I wanted, I wanted the result of inner CF computed data, not the outer CF computed data
    *
    * How to evaluate the CF, wait for its computation
    *
    * */
    private static void needOfCompose() {
        create(2)
                .thenApply(data -> inc(data))
                .thenAccept(result -> System.out.println(result));

        create(2)
                .thenCompose(data -> inc(data))
                .thenAccept(result -> System.out.println(result));

    }

    public static CompletableFuture<Integer> inc(int n){
        return CompletableFuture.supplyAsync(() -> n + 1);
    }

    public static void ex1() {
        create(2)
                .thenCompose(data -> doubled(data))
                .thenCompose(data -> addThree(data))
                .thenAccept(System.out::println);

    }

    private static void ex2() {
        long startTime = System.currentTimeMillis();

        CompletableFuture<String> future =
                getUserDetails()
                        .thenCompose(s -> getWishList(s));

        System.out.println("Doing something");
        delay(4);
        System.out.println(future.join());
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken " + (endTime - startTime) / 1000);
    }

    public static CompletableFuture<String> getUserDetails() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("getUserDetails() -" + Thread.currentThread().getName());
            delay(2);
            return "UserDetails";
        });
    }

    public static CompletableFuture<String> getWishList(String user) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("getWishList() - " + user + " - " + Thread.currentThread().getName());
            delay(3);
            return "User's WishList";
        });
    }
}