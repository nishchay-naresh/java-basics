package com.nishchay.java8.async.cf;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static com.nishchay.java8.async.Utils.delay;

/*
 * ============ Callback =================
 *
 * thenApply(Function<T,R> ) - transforming the response
 * thenAccept(Consumer<T> ) - takes the response and doesn't return anything
 * thenRun(Runnable ) - doesn't take response, can trigger some activity
 *
 * thenApplyAsync(), thenAcceptAsync(), thenRunAsync() - method to execute the callback methods as async
 *
 * */
public class CF06CallbackMethods {

    public static void main(String[] args) {

        using2MethodsInt();
        System.out.println("------------------------------");
        usingAll3MethodsStr();

    }

    private static void using2MethodsInt() {

        Supplier<Integer> intSupplier = () -> {
            delay(2);
            return 10;
        };

        Function<Integer, Integer> functionTwice = e -> e * e;

        Consumer<Integer> consumerPrintElement = e -> System.out.println("sqrt = " + e);

        CompletableFuture<Void> completableFuture =
                CompletableFuture.supplyAsync(intSupplier)
                        .thenApply(functionTwice)
                        .thenAccept(consumerPrintElement);

        completableFuture.join();
    }


    public static void usingAll3MethodsStr() {

        CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(
                () -> {
                    delay(2);
                    return "Java";
                }
        ).thenApply(s -> {
            return "CompletableFuture class is there since " + s + "8";
        }).thenAccept((input) -> {
            System.out.println("Result - " + input);
        }).thenRun(() -> {
            System.out.println("All Done !!");
        });

        completableFuture.join();
    }

}
