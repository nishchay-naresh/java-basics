package com.nishchay.java8.async.cf;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import static com.nishchay.util.Utils.delay;

/*
 * Threads of execution - where are things going to be run
 * really love, what they have done
 * Is cf execution always happening in a different threads all the time ?
 *
 * it has both of the behaviour
 *
 * 1. When we comment both of the delay(2) at both of the places
 *      by the time main thread try to execute - future.thenAccept(data -> printIt((data)));
 *      CF is been completed. So printIt() execution will be done by main thread itself
 *      main will say - since data is already available, no need to switch to new thread, main can execute this
 *
 * o/P =>
 * 		main - Thread[main,5,main]
 * 		compute - Thread[ForkJoinPool.commonPool-worker-9,5,main]
 * 		printIt - Thread[main,5,main] - 10
 * 		main done
 *
 * 2. When we uncomment both of the delay(2) at both of the places
 *      by the time main thread try to execute - future.thenAccept(data -> printIt((data)));
 *      CF is been not been completed. CF has another pipeline (printIt()) to execute So printIt() execution will be done by CF thread
 *      main will say - since CF is going for its own execution, don't know when its will be completed (don't know whether it will complete ot not)
 *      I am not going to be blocked, I am finishing out here, lets CF thread to execute the remaining piece of pipeline when data will be available
 *
 * o/P =>
 *  	main - Thread[main,5,main]
 *		compute - Thread[ForkJoinPool.commonPool-worker-9,5,main]
 *		main done
 *		printIt - Thread[ForkJoinPool.commonPool-worker-9,5,main] - 10
 *
 * We can't determine which thread will execute which piece of code in CF.
 * Think executing thread as implementation detail, shouldn't be our concern
 *
 *
 * -----------------------
 * All the async exception is happening in under a new thread of internal fork-join pool
 *
 * */
public class CF05ThreadingBehavior {

    public static void main(String[] args){

        threadsOfExec();

        System.out.println("----------------------------------");
        asyncRunEx();
        System.out.println("----------------------------------");
        asyncSupplyEx();

    }
    public static void threadsOfExec() {
        System.out.println("main - " + Thread.currentThread());
        CompletableFuture<Integer> future = create();
        future.thenAccept(data -> printIt((data)));

        System.out.println("main done");
        delay(2);
    }

    public static CompletableFuture<Integer> create() {
        return CompletableFuture.supplyAsync(() -> compute());
    }

    public static int compute() {
        System.out.println("compute - " + Thread.currentThread());
        delay(2);
        return 10;
    }

    public static void printIt(int value) {
        System.out.println("printIt - " + Thread.currentThread() + " - " + value);
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