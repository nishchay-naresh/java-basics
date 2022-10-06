package com.nishchay.java8.async.cf.combine;

import java.util.concurrent.CompletableFuture;

import static com.nishchay.java8.async.Utils.*;

/*
 * ======= Composing dependent futures =======
 *
 * When second operation is dependent upon the output of first operation
 * Account - fetchAccountDetails(id )
 * Balance - getAccountBalance(Account )
 *
 * .thenCompose(Function<T, R> ) - used to chain two features sequentially
 *  Can be used to create a pipeline of dependent operations
 *
 *
 *
 * */
public class ComposeExample {

    public static void main(String[] args) {

        ex1();
//        ex2();

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