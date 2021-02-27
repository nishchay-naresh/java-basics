package com.nishchay.java8.streams.flatmap;

import java.util.Optional;


public class OptionalMapDemo {

    public static void main(String[] args) {

        mapExample1();
//        mapExample2();

//        flatMapExample1();
//        flatMapExample2();

    }


    private static void mapExample1() {

        //Creating Optional object from a String
        Optional<String> language = Optional.ofNullable("Java Programming");
        //Optional.empty() creates an empty Optional object
        Optional<String> nothing = Optional.empty();

        System.out.println(language);
        System.out.println(language.map(String::toLowerCase));
        System.out.println(nothing);
        System.out.println(nothing.map(String::toLowerCase));

        Optional<String> nullOptional = Optional.ofNullable(null);
        Optional<String> output = nullOptional.flatMap(value -> Optional.of("No Value"));
        System.out.println("output value : " + output);


        Optional<String> optional1 = Optional.ofNullable("Hello Java 8");
        Optional<Optional<String>> optional2 = Optional.of(optional1);
        System.out.println("Optional2 value : " + optional2);

        Optional<Optional<String>> mapOutput = optional2.map(e -> e.map(String::toUpperCase));
        System.out.println("Optional.map: " + mapOutput);


        // System.out.println("Optional.flatMap: " + optional2.flatMap(e -> e.map(String::toUpperCase)));
        Optional<String> flatMapOutput = optional2.flatMap(value -> value.map(String::toLowerCase));
        System.out.println("Optional.flatMap : " + flatMapOutput);
        System.out.println("Optional.flatMap : " + optional2.flatMap(e -> e));
        //Optional<Optional<String>>  ->  flatMap -> Optional<String>

    }


}
