package com.nishchay.java8.async.cf;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import static com.nishchay.java8.async.Utils.delay;

/*
*
* All the async exception is happening in under a new thread of internal fork-join pool
*
*
* */
public class CF05ThreadingBehavior {

    public static void main(String[] args) {

        asyncRunEx();
        System.out.println("----------------------------------");
        asyncSupplyEx();

    }

    private static void asyncRunEx() {
        System.out.println("main - " + Thread.currentThread());

        Runnable task = () -> {
            System.out.println("runnable - " + Thread.currentThread());
            System.out.println("sum100 = " + IntStream.rangeClosed(1, 100).sum());
        };

        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(task);
        completableFuture.join();
    }


    private static void asyncSupplyEx() {
        System.out.println("main - " + Thread.currentThread());

        Supplier<Integer> supplier = () -> {
            System.out.println("supplier - " + Thread.currentThread());
            delay(2);
            return IntStream.rangeClosed(1, 100).sum();
        };
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(supplier);

        Integer sum100 = completableFuture.join();
        System.out.println("sum100 = " + sum100);

    }

}
/*
 * O/P =>
 *
 *	main - Thread[main,5,main]
 *	runnable - Thread[ForkJoinPool.commonPool-worker-9,5,main]
 *	sum100 = 5050
 *	----------------------------------
 *	main - Thread[main,5,main]
 *	supplier - Thread[ForkJoinPool.commonPool-worker-9,5,main]
 *	sum100 = 5050
 *
 * */