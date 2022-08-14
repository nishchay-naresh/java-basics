package com.nishchay.core.collection;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysMethodDemo {

    public static void main(String[] args) {

//        sortNSearchEx();
        fillEx();

    }


    private static void sortNSearchEx() {

        String[] cities = {"Bangalore", "Pune", "San Francisco", "New York"};

        Arrays.sort(cities, Comparator.naturalOrder());
        System.out.println("Array after sorting - " + Arrays.toString(cities));

        int foundAt = Arrays.binarySearch(cities, "New York");
        System.out.println("Found at = " + foundAt);

        int k = Arrays.binarySearch(cities, "xxxx");
        System.out.println("Found at = " + k); // -5
    }

    private static void fillEx() {

        final int len = 8;
        char[] chars = new char[len];
        Arrays.fill(chars, '$');
        System.out.println("chars = " + Arrays.toString(chars));

        int[] nums = new int[len];
        Arrays.fill(nums, -1);
        System.out.println("nums  = " + Arrays.toString(nums));
    }

}
