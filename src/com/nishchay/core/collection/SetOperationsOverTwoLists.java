package com.nishchay.core.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SetOperationsOverTwoLists {

    public static void main(String[] args) {

        List<String> list1 = new ArrayList<String>(Arrays.asList("a", "b", "c", "d", "e"));
        System.out.println("List 1 elements: " + list1);
        List<String> list2 = new ArrayList<String>(Arrays.asList("b", "d", "f", "g"));
        System.out.println("List 2 elements: " + list2);

        System.out.println(".................Union.................");
        //Find union of two lists
        System.out.println(" List1 Union List2 :" + getUnionOfLists(list1, list2));

        System.out.println();
        System.out.println(".................Intersection.................");
        //Find intersect of lists using Stream API (Java 8)
        System.out.println(" List1 Intersection List2 Method 1: " + getIntersectionOfListsStream(list1, list2));

        //Find intersect of lists using retainAll() method
        System.out.println("List1 Intersection List2 Method 2: " + getIntersectionOfLists(list1, list2));

        System.out.println(".................Subtraction.................");
        System.out.println("list1 - list2  : " + getSubtractionOfLists(list1, list2));
        System.out.println("list2 - list1 : " + getSubtractionOfLists(list2, list1));
    }


    private static List<String> getUnionOfLists(List<String> list1, List<String> list2) {

        Set<String> set = new HashSet<>();
        set.addAll(list1);
        set.addAll(list2);

        return new ArrayList<>(set);
    }

    private static List<String> getIntersectionOfListsStream(List<String> list1, List<String> list2) {
        List<String> intersectElements = list1.stream()
                .filter(list2::contains)
                .collect(Collectors.toList());

        if (!intersectElements.isEmpty()) {
            return intersectElements;
        } else {
            return Collections.emptyList();
        }
    }

    private static List<String> getIntersectionOfLists(List<String> list1, List<String> list2) {
        List<String> intersection = new ArrayList<>(list1);
        intersection.retainAll(list2);

        return intersection;
    }

    private static List<String> getSubtractionOfLists(List<String> list1, List<String> list2) {
        List<String> differences = new ArrayList<>(list1);
        differences.removeAll(list2);
        return differences;
    }
}
