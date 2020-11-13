package com.nishchay.java8.basic;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ForEachDemo {


    public static void main(String[] args) {

        List<String> stringList =  Arrays.asList("Rohit", "Shikhar", "Kohli", "Iyyar", "Rahul");

//        stringList.forEach(s -> System.out.println(s));
        stringList.forEach(System.out::println);

        Stream<String> strStream = stringList.stream();
        strStream.forEach(e -> System.out.println(e));
    }
}
