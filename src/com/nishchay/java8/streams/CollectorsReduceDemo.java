package com.nishchay.java8.streams;


import com.nishchay.util.pojo.Dish;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CollectorsReduceDemo {

    public static void main(String[] args) {

        reduceEx();
        reduceEx1();

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


    private static void reduceEx1() {

        int totalCalories;

        totalCalories = Dish.getManu().stream().map(Dish::getCalories).mapToInt(i -> i).sum();
        System.out.println("totalCalories = " + totalCalories);
        totalCalories = Dish.getManu().stream().map(Dish::getCalories).reduce(0, Integer::sum);
        System.out.println("totalCalories = " + totalCalories);


        totalCalories = Dish.getManu().stream()
                .collect(Collectors.reducing(0, Dish::getCalories, Integer::sum));
        System.out.println("totalCalories = " + totalCalories);


        Optional<Dish> mostCalorieDish;

        mostCalorieDish = Dish.getManu().stream()
                .max(Comparator.comparingInt(Dish::getCalories));
        System.out.println("mostCaloriesDish = " + mostCalorieDish.orElse(null));

        mostCalorieDish =
                Dish.getManu().stream()
                        .collect(Collectors.reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));

        System.out.println("mostCaloriesDish = " + mostCalorieDish.orElse(null));

    }

}
