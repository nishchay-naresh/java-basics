package com.nishchay.java8.async.cf.combine;

import java.util.concurrent.CompletableFuture;

import static com.nishchay.java8.async.Utils.*;


/*
 * ====== Combining independent futures =======
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


    public static void ex1() {
        create(2)
                .thenCombine(create(3), (a, b) -> a + b)
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