package com.nishchay.java8.fun;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerEx {

    public static void main(String[] args) {

        Consumer<Integer> consumerPrintElement = e -> System.out.print(" " + e);

        List<Integer> list = Arrays.asList(1, 3, 5, 8, 2);
        System.out.print("list data - ");
        list.stream().forEach(consumerPrintElement);



    }
}
