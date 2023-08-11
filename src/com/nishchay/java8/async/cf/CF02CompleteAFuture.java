package com.nishchay.java8.async.cf;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static com.nishchay.util.Utils.delay;

public class CF02CompleteAFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        completingAFuture();
        lazyPipelineEx();

        completedFutureEx();
        completingAFutureExceptionally();
    }

    /*
     *
     * CF.get() -    It's a blocking call
     *               Waits if necessary for this future to complete, and then returns its result.
     *
     * CF.join() -   It's a blocking call
     *               Waits if necessary for this future to complete, and then returns its result,
     *               Throws an (unchecked) exception if completed exceptionally
     *
     * Until someone is not completing the CF, CF.get()/CF.join() call will be blocking
     *
     * One can complete a CF by calling complete(value) method
     *
     * */
    private static void completingAFuture() throws ExecutionException, InterruptedException {
        CompletableFuture<String> cf = new CompletableFuture<>();
        // completing the cf by calling complete() method
        new Thread(() -> {
            delay(2);
            cf.complete("dummy value");
        }).start();

        // cf.get() call will get blocked, we need to complete this cf
        // System.out.println("cf.get() = " + cf.get());
        System.out.println("cf.join() = " + cf.join());
    }


    /*
     * ================ creating a pipe, then completing =================
     *
     * Create a pipeline first then push the data through the pipeline - evaluating lazily
     * We build the pipeline but no data is through this pipeline - so no output, irrespective how long we wait
     *
     * We can pass the data to this pipeline by calling/completing a CF -  future.complete(data)
     *
     * */
    private static void lazyPipelineEx() {
        CompletableFuture<Integer> future = new CompletableFuture<>();
        future
                .thenApply(data -> data * 2)
                .thenApply(data -> data + 1)
                .thenAccept(data -> System.out.println(data));

        System.out.println("build the pipeline");
        delay(1);
        future.complete(2);
        delay(1);
        System.out.println("prepared to print");
    }

    /*
     * completedFuture(v) - Returns a new CompletableFuture that is already completed with a given value
     * */
    private static void completedFutureEx(){
        Future<String> future = CompletableFuture.completedFuture("Hello");
        String result = null;
        try {
            result = future.get();
        } catch (InterruptedException | ExecutionException ignored) { }
        System.out.println("result = " + result);
    }

    /*
     * completeExceptionally(t) - completing a CompletableFuture with an Exception
     * */
    private static void completingAFutureExceptionally() {

        CompletableFuture<String> f1 = new CompletableFuture<>();
        //f1.completeExceptionally(new RuntimeException("completed exceptionally"));
        f1.complete("response");

        // join() -  will get result/exception based on its completion
        System.out.println("result = " + f1.join());
    }
}
