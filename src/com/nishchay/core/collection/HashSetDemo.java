package com.nishchay.core.collection;

import java.util.*;

public class HashSetDemo {

    public static void main(String[] args) {

        hashSetMethodsEx();
        removeDuplicateFromListPreserveOrder();

    }

    private static void hashSetMethodsEx() {

        Set<Integer> hashSet = new HashSet<>();

        hashSet.add(1);
        System.out.println("add(uniqueValue) - " + hashSet.add(2)); // true
        System.out.println("add(duplicatesValue) - " + hashSet.add(2)); // false
        hashSet.add(3);
        hashSet.add(3);
        System.out.println("size - " + hashSet.size()); // 3

        hashSet.clear();
        System.out.println("size - " + hashSet.size()); // 0

        //  1,2,2,3,3,4,4,5,5,6 => 1,2,3,4,5,6
        int[] arr = new int[]{1, 2, 2, 3, 3, 4, 4, 5, 5, 6};
        for (int x : arr) {
            hashSet.add(x);
        }

        System.out.print("hashSet - " + hashSet);
        // hashSet.forEach(System.out::print);
    }

    public static void removeDuplicateFromListPreserveOrder() {
        // creating ArrayList with duplicate elements
        List<Integer> primes = new ArrayList<>();

        primes.add(2);
        primes.add(3);
        primes.add(5);
        primes.add(7);  //duplicate
        primes.add(7);
        primes.add(11);

        System.out.println("list of prime numbers : " + primes);

        // Now let's remove duplicate element without affecting order
        // LinkedHashSet will guaranteed the order and since it's set
        // it will not allow duplicates, duplicates gets filtered
        Set<Integer> primesWithoutDuplicates = new LinkedHashSet<>(primes);

        // now let's clear the ArrayList to copy all elements from LinkedHashSet
        primes.clear();

        // copying elements but without any duplicates
        primes.addAll(primesWithoutDuplicates);

        System.out.println("list of primes without duplicates : " + primes);
    }
}
