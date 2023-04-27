package com.nishchay.java8.streams;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CollectorsReduceDemo {



    public static void main(String[] args) {

        reduceEx();
//        reduceEx1();

    }

    private static void reduceEx() {
        final List<String> friends =
                Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scotty");

        //reduce - the longest name
        final Optional<String> aLongName =
                friends.stream()
                .reduce((name1, name2) ->
                        name1.length() >= name2.length() ? name1 : name2);
        aLongName.ifPresent(name -> System.out.println(String.format("A longest name: %s", name)));

        //reduce - with some initial value
        final String steveOrLonger =
                friends.stream()
                        .reduce("Steve", (name1, name2) ->
                                name1.length() >= name2.length() ? name1 : name2);
        System.out.println("steveOrLonger = " + steveOrLonger);
    }

}
