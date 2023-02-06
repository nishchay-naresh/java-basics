package com.nishchay.java8.async.cf;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static com.nishchay.java8.async.Utils.delay;


/*
 *
 *	========Future Interface=============
 *
 *	A Future represents the result of an asynchronous operation.
 *
 *	Drawbacks :
 *	1.	There is no way to complete the future(in case of exception / call gets blocked). we can only attempt to cancel the task.
 *	2.	The get() method in the Future Interface is blocking operation
 *	3.	No support for exception handling
 *	4.	Multiple futures cannot be chained together.
 *	5.	Asynchronous workflows can not be created by chaining multiple Futures together.
 *	6.	Futures which are running in parallel, can not be combined together.
 *
 * */
public class CF01WhyNotFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        canNotCompleteAFuture();
        futuresCanNotBeCombined();
        noSupportForExceptionHandling();

    }

    /*
     *
     * Achieving asynchronous programming using old construct :
     *
     *  Futures, ExecutorService, CompletionService, Callable interfaces, ThreadPools, etc.
     *
     * */
    private static void canNotCompleteAFuture() throws InterruptedException, ExecutionException {
        ExecutorService service = Executors.newFixedThreadPool(10);

        Future<List<Integer>> future = service.submit(() -> {
            //suppose doing an api call
            delay(10);
            return Arrays.asList(1, 2, 3, 4);
        });


        List<Integer> integers = future.get();
        // No way we can complete this future (upon blocking)
        System.out.println("api response - " + integers);

        service.shutdown();
    }

    private static void futuresCanNotBeCombined() {

        ExecutorService service = Executors.newFixedThreadPool(10);

        Future<List<Integer>> future1 = service.submit(() -> {
            delay(1);
            return Arrays.asList(1, 2, 3, 4);
        });

        Future<List<Integer>> future2 = service.submit(() -> {
            delay(2);
            return Arrays.asList(5, 6);
        });

        Future<List<Integer>> future3 = service.submit(() -> {
            delay(3);
            return Arrays.asList(8, 9);
        });

        // Futures which are running in parallel(although sequential can be combined), can not be combined
        // future1 + future2 + future3;
        service.shutdown();
    }

    /*
    * We can't complete the remaining process on Exception been raised
    * when error = true, an RuntimeException been raised unable close the pool
    * Need to have a mechanism to put some fallback process for exception use-case
    *
    * */
    private static void noSupportForExceptionHandling() throws ExecutionException, InterruptedException {

//        boolean error = true;
        boolean unKnownBool = new Random().nextInt(100) % 2 == 0 ;
        ExecutorService service = Executors.newFixedThreadPool(10);

        Future<List<Integer>> future = service.submit(() -> {
            if (unKnownBool){
                throw new RuntimeException("some problem has happened!!");
            }

            return Arrays.asList(1, 2, 3, 4);
        });

        List<Integer> integers = future.get();
        System.out.println("api response - " + integers);

        service.shutdown();
    }

}