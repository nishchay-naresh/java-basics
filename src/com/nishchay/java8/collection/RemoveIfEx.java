package com.nishchay.java8.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * java.lang.Collection<E>
 *         default boolean removeIf(Predicate<? super E> filter)
 * - Removes all the elements of this collection that satisfy the given predicate.
 */

public class RemoveIfEx {

    public static void main(String[] args) {

        // For Integer
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        numbers.removeIf(num -> num % 2 == 0);
        System.out.println("Odd Numbers: " + numbers);

        // For String
        List<String> countries = new ArrayList<>(
                Arrays.asList("Iceland", "Australia", "New Zealand", "America", "Ireland", "Canada", "Greenland")
        );
        System.out.println("Countries: " + countries);

        // remove all even countries
        countries.removeIf(e -> e.contains("land"));;
        System.out.println("Countries without land: " + countries);
    }
}

