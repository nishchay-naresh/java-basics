package com.nishchay.java8.async.cf;

import java.util.concurrent.CompletableFuture;

public class CompFutureDemo3 {

    public static void main(String[] args) {

        thenCombineEx();

        thenComposeEx();

    }

    public static void thenCombineEx(){
        create(2).thenCombine(create(3), (a,b) -> a+b)
                .thenAccept(System.out::println);
    }

    public static void thenComposeEx(){
        create(2).thenCompose(data -> doubled(data)).thenCompose(data -> addThree(data))
                .thenAccept(System.out::println);
    }

    public static CompletableFuture<Integer> create(int n){
        return CompletableFuture.supplyAsync(() -> n);
    }

    public static CompletableFuture<Integer> doubled(int n){
        return CompletableFuture.supplyAsync(() -> n * 2);
    }

    public static CompletableFuture<Integer> addThree(int n){
        return CompletableFuture.supplyAsync(() -> n + 3);
    }

}

