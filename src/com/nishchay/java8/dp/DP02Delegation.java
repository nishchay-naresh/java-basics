package com.nishchay.java8.dp;


import java.util.function.Supplier;

/*
* We can use the supplier to post-pond the evaluation to later point of time ( to achieve a lazyness)
*
* */
public class DP02Delegation {

    public static void main(String[] args) {

//        int x = 5; // path 2
        int x = 6; // called ... ,  path 1

        Lazy<Integer> integerLazy = new Lazy<>(() -> compute(x));

        if (x > 5 && integerLazy.get() > 7){
            System.out.println("path 1 " + integerLazy.get());
        }else {
            System.out.println("path 2");
        }

    }

    private static Integer compute(int n) {
        System.out.println("called ...");
        return n * 2;
    }

    static class Lazy<T> {
        private T instance;
        private Supplier<T> supplier;

        public Lazy(Supplier<T> theSupplier) {
            this.supplier = theSupplier;
        }

        public T get() {
            if(instance == null){
                instance = supplier.get();
                supplier= null;
            }
            return instance;
        }
    }


}

