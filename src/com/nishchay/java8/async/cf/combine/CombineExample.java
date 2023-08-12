package com.nishchay.java8.async.cf.combine;

import java.util.concurrent.CompletableFuture;

import static com.nishchay.util.Utils.*;


/*
 * ====== Combining independent futures =======
 * combine - taking one CF and combining it with result of another CF and producing third CF
 *
 * We can run our two independent operation in parallel and
 * when my both independent operations are done, then I want to combine the result and do the third operation
 *
 * .thenCombine(CompletionStage<U>, BiConsumer<T, U> ) - used to run two Futures parallel and combine result
 *
 * */
public class CombineExample {

    public static void main(String[] args) {
        ex1();
        ex2();
    }

    /*
    * two independent asynchronous task, when both of them are finished,
    *  combine them using a biFunction and return a third CF
    *
    *   task1 -  create(2)
    *   task2 -  create(3)
    *   when both of them gets resolved, then only this method thenCombine(-,-) will be executed and return a third CF
    *
    * */
    public static void ex1() {
        create(2)
                .thenCombine(create(3), (result1, result2) -> result1 + result2)
                .thenAccept(System.out::println);
    }

    private static void ex2() {
        timeIt(() -> {
            CompletableFuture<String> future = getUserEmail()
                    .thenCombine(getWeatherReport(), (e, w) -> {
                        System.out.println("Sending email to " + e + " with report - " + w);
                        delay(1);
                        return e + w;
                    });

            System.out.println(future.join());
        });
    }

    /*
     * Below 2 are independent operation, which both can run independent in parallel
     * */
    public static CompletableFuture<String> getUserEmail() {
        return CompletableFuture.supplyAsync(
                () -> {
                    System.out.println("getUserEmail() - " + Thread.currentThread().getName());
                    delay(6);
                    return "user.name@sag.com";
                }
        );
    }

    public static CompletableFuture<String> getWeatherReport() {
        return CompletableFuture.supplyAsync(
                () -> {
                    System.out.println("getWeatherReport() - " + Thread.currentThread().getName());
                    delay(3);
                    return "Weather Report of city is - Rainy";
                }
        );
    }
}