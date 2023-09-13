package com.nishchay.ds.collection;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/*
 *   java TestMe 1, @, 2, -4, ?, -6, ab, $, %, 9, 0, 1
 *   should give output like
 *   Numbers : In ascending order no duplicate
 *   Non-Numbers : In the order of their arrival
 *   -----------
 *   args - [1, @, 2, -4, ?, -6, ab, $, %, 9, 0, 1]
 *   Numbers - [-6, -4, 0, 1, 2, 9]
 *   Non-Numbers - [@, ?, ab, $, %]
 *
 * */
public class ExceptionBranchingEx {
    public static void main(String[] args) {
        String[] arguments = {"1", "@", "2", "-4", "?", "-6", "ab", "$", "%", "9", "0", "1", "de", "9", "12", "#", "5"};
        System.out.println("arguments = " + Arrays.toString(arguments));
        System.out.println("------------------------------------------------");
        imperativeWay(arguments);
        System.out.println("------------------------------------------------");
        java8Way(arguments);
    }

    private static void imperativeWay(String[] arguments) {
        Set<Integer> numberTreeSet = new TreeSet<>();
        Set<String> stringLinkedHashSet = new LinkedHashSet<>();

        int number;
        for (String element : arguments) {
            try {
                number = Integer.parseInt(element);
                numberTreeSet.add(number); // add number to TS
            } catch (NumberFormatException e) {
                stringLinkedHashSet.add(element); // add string to LHS
            }
        }
        System.out.println("Numbers = " + numberTreeSet);
        System.out.println("Non-Numbers = " + stringLinkedHashSet);
    }

    private static void java8Way(String[] arguments) {
        TreeSet<Integer> numbers =
                Arrays.stream(arguments)
                        .map(ExceptionBranchingEx::stringToInt)
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .collect(Collectors.toCollection(TreeSet::new));
        System.out.println("numbers = " + numbers);

        Set<String> stringLinkedHashSet = new LinkedHashSet<>();
        for (String element : arguments) {
            if (stringToInt(element).equals(Optional.empty())) {
                stringLinkedHashSet.add(element);
            }
        }
        System.out.println("Non-Numbers = " + stringLinkedHashSet);
    }

    private static Optional<Integer> stringToInt(String str) {
        try {
            return Optional.of(Integer.parseInt(str));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
}
