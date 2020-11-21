package com.nishchay.java8.async.cf;

import java.util.concurrent.CompletableFuture;

public class CompFutureDemo1 {

    public static void main(String[] args) {

        createCF().thenAccept(e -> printIt(e));
    }

    public static CompletableFuture<Integer> createCF(){
        System.out.println("createCF - " + Thread.currentThread());
        return CompletableFuture.supplyAsync(() -> compute());
    }

    public static int compute(){
        System.out.println("compute - " + Thread.currentThread());
        return 2;
    }

    public static void printIt(int val) {
        System.out.println(val);
        System.out.println("printIt - " + Thread.currentThread());
    }
}

/*
 *
 * O/P=>
 * createCF - Thread[main,5,main]
 * compute - Thread[ForkJoinPool.commonPool-worker-1,5,main]
 * 2
 * printIt - Thread[main,5,main]
 * -------------------
 * createCF - Thread[main,5,main]
 * compute - Thread[ForkJoinPool.commonPool-worker-1,5,main]
 * 2
 * printIt - Thread[ForkJoinPool.commonPool-worker-2,5,main]
 *
 *
 * */