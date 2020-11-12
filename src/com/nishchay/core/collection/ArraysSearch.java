package com.nishchay.core.collection;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysSearch {

    public static void main(String[] args) {
        String[] cities = {"Bangalore", "Pune", "San Francisco", "New York"};

        Arrays.sort(cities, Comparator.naturalOrder());
        System.out.println("Array after sorting - " + Arrays.toString(cities));

        int foundAt = Arrays.binarySearch(cities, "New York");
        System.out.println("Found at = " + foundAt);

        int k = Arrays.binarySearch(cities, "xxxx");
        System.out.println("Found at = " + k); // -5

    }
}
