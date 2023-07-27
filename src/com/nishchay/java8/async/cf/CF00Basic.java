package com.nishchay.java8.async.cf;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

import static com.nishchay.util.Utils.delay;
import static com.nishchay.util.Utils.doSomeTask;

public class CF00Basic {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        createCF();
        executingInCF();
//        extractResult();
//        executingAsync();
    }

    // Different ways to create a CompletableFuture<T>
    private static void createCF() {
        CompletableFuture<Void> cf1 = new CompletableFuture<>();
        CompletableFuture<Integer> cf2 = CompletableFuture.supplyAsync(() -> 10);
        ForkJoinPool pool = new ForkJoinPool(5);
        // when wanted to use our own thread pool for CF rather than common pool
        CompletableFuture<Integer> cf3 = CompletableFuture.supplyAsync(() -> 10, pool);
        CompletableFuture<String> cf4 = cf3.thenApply(e -> Integer.toString(e));
    }

    private static void executingInCF() {
        CompletableFuture.supplyAsync(() -> 10)
                .thenAccept(data -> System.out.println(data))
                .thenRun(() -> System.out.println("this never dies"))
                .thenRun(() -> System.out.println("Really, this never dies"))
                .thenRun(() -> System.out.println("Really,Really,this never dies"));
        //  this is like, You just tap on a running train, submitting your code(in form of Consumer, Runnable) and get the result
    }


    // get() vs getNow() -  impatience call
    private static void extractResult() throws ExecutionException, InterruptedException {
        getWay();
        getNowWay();
        thenAcceptWay();
    }

    private static CompletableFuture<String> create() {
        return CompletableFuture.supplyAsync(() -> doSomeTask());
    }
    private static void getWay() throws InterruptedException, ExecutionException {
        // System.out.println(create().get()); //  bad idea , because it is a blocking call
        CompletableFuture<String> cf = create();
        System.out.println("got it");
        System.out.println(cf.get()); // the best thing to do with get is forget it
        System.out.println("here");
    }

    private static void getNowWay() {
        CompletableFuture<String> cf = create();
        System.out.println("got it");
        System.out.println(cf.getNow("default value")); // impatience call, will give you result immediately in either way
        System.out.println("here");
        //getNow is a little better than get, but they both are bad.
    }

    private static void thenAcceptWay() {
        //  thenAccept() - the best way to extract result from cf, bcus it is non-blocking in nature
        CompletableFuture<String> cf = create();
        System.out.println("got it");
        cf.thenAccept(System.out::println);
        // since thenAccept is non-blocking, so main is exiting by the time we get the result
        delay(3);
        System.out.println("here");
    }

}
