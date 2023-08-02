package com.nishchay.java8.async.cf;

import com.nishchay.util.Utils;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;


/*
 * ============ Callback =================
 *
 * thenApply(Function<T,R> ) - transforming the response
 * thenAccept(Consumer<T> ) - It accept a Consumer<T> and return a CompletableFuture<Void>
 *                              Its take the computed result from CF over which this has been invoked,
 *                              and pass that result to the Consumer
 *
 * thenRun(Runnable ) - doesn't take response, can trigger some activity
 *
 * thenApplyAsync(), thenAcceptAsync(), thenRunAsync() - method to execute the callback methods as async
 *
 * */
public class CF06CallbackMethods {

    public static void main(String[] args) {


        thenAcceptEx();
        System.out.println("------------------------------");
        thenApplyEx();
        System.out.println("------------------------------");


        System.out.println("------------------------------");
        using2MethodsInt();
        System.out.println("------------------------------");
        usingAll3MethodsStr();

    }

    /*
     *  thenAccept(Consumer<T> ) - It accept a Consumer<T> and return a CompletableFuture<Void>
     *  UseCase for CompletableFuture<Void> :
     *        -  want to perform a DB operation
     *        -  wanted to do a commit
     *        -  write to a log file
     *        -  send data to a remote server
     *
     *  You want to evaluate its successfully completion, How will you do this - send Success/Failure msg accordingly
     *  this CompletableFuture<Void> can be used as signal for the last transaction's success or failure
     *
     *
     *  thenRun(Runnable ) - Its accept a Runnable and return nothing
     *  UseCase of thenRun(Runnable ) :
     *       -   want to execute a piece of code(by making it part of Runnable) in CF
     *           Just like - You just tap on a running train, submitting your code(in form of Runnable) and get the result
     *       -   wanted to evaluate the result for last submitted Consumer to CF
     *
     *
     * */
    private static void thenAcceptEx() {
        Utils.create(10)
                .thenAccept(data -> System.out.println(data))
                .thenRun(() -> System.out.println("Success"));

        Utils.create(10)
                .thenAccept(data -> {
                    throw new RuntimeException("Something went wrong ..!!");
                })
                //.thenRun(() -> System.out.println("Failure")); // won't get executed bcus of exception
                .exceptionally(e -> {
                            System.out.println("Failure, " + e.getMessage());
                            return null;
                        }
                );
    }

    /*
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
     * */
    private static void thenApplyEx() {
        Utils.create(3)
                .thenApply(data -> data * 2)
                .thenApply(data -> data + 1)
                .thenAccept(e -> System.out.println(e));

    }


    private static void using2MethodsInt() {

        Supplier<Integer> intSupplier = () -> {
            Utils.delay(2);
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


    private static void usingAll3MethodsStr() {

        CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(
                () -> {
                    Utils.delay(2);
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
