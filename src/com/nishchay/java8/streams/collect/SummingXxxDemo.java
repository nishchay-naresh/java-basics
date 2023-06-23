package com.nishchay.java8.streams.collect;

import com.nishchay.util.pojo.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SummingXxxDemo {

    public static void main(String[] args) {

        sumInStream();
        System.out.println("----------------------------");
        summingEx();
        System.out.println("----------------------------");
        summingIntEx();
    }


    private static void sumInStream() {

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);

        // sum - using reduce
        int sum = integers.stream()
                .reduce(0, Integer::sum);

        System.out.println("sum = " + sum);


        // sum - using IntStream.sum()
        sum = integers.stream().
                mapToInt(Integer::intValue).sum();

        System.out.println("sum = " + sum);
    }

    private static void summingEx() {

        List<Integer> listOfI = Arrays.asList(17, 9, 13, 21, 5, 2);
        Integer sumI = listOfI.stream().collect(Collectors.summingInt(Integer::intValue));
        System.out.println("Sum = " + sumI);

        List<Double> listOfD = Arrays.asList(3.0, 5.5, 11.3, 40.3, 21.1);
        Double sumD = listOfD.stream().collect(Collectors.summingDouble(Double::doubleValue));
        System.out.println("Sum = " + sumD);

        List<Long> listOfL = Arrays.asList(23L, 11L, 13L, 49L, 7L);
        Long sumL = listOfL.stream().collect(Collectors.summingLong(Long::longValue));
        System.out.println("Sum = " + sumL);

    }

    private static void summingIntEx() {
        int totalCalories;

        totalCalories = Dish.getManu().stream().map(Dish::getCalories).reduce(0, (e1, e2) -> e1 + e2);
        totalCalories = Dish.getManu().stream().map(Dish::getCalories).mapToInt(i -> i).sum();
        System.out.println("totalCalories = " + totalCalories);

        totalCalories = Dish.getManu().stream().collect(Collectors.summingInt(Dish::getCalories));
        System.out.println("totalCalories = " + totalCalories);
    }

}


