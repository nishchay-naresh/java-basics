package com.nishchay.core.collection;

import java.util.*;

public class HashSetDemo {

    public static void main(String[] args) {

        hashSetMethodsEx();
        removeDuplicateFromListPreserveOrder();
        hashSetKeyMutation();
    }

    private static void hashSetMethodsEx() {

        Set<Integer> hashSet = new HashSet<>();
        int x = 2;
        hashSet.add(1);
        System.out.println("add(uniqueValue) - " + hashSet.add(2)); // true
        System.out.println("add(duplicatesValue) - " + hashSet.add(x)); // false

        hashSet.add(3);
        x = 3;
        hashSet.add(x);
        System.out.println("size - " + hashSet.size()); // 3

        hashSet.clear();
        System.out.println("size - " + hashSet.size()); // 0

        //  1,2,2,3,3,4,4,5,5,6 => 1,2,3,4,5,6
        int[] arr = new int[]{1, 2, 2, 3, 3, 4, 4, 5, 5, 6};
        for (int e : arr) {
            hashSet.add(e);
        }

        System.out.print("hashSet - " + hashSet);
        // hashSet.forEach(System.out::print);
    }


    private static void removeDuplicateFromListPreserveOrder() {
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


    private static void hashSetKeyMutation() {

        Student std1 = new Student("10", "Java");
        Student std2 = new Student("10", "Perl");

        Set<Student> set = new HashSet<>();
        set.add(std1);
        set.add(std2);

        System.out.println("set = " + set.size()); // 2

        /*
        // Problam - classic HashSet + mutable key bug.
        std2.setName("Java");
        set.add(std2);
        System.out.println("set = " + set.size()); // 2
        System.out.println("set = " + set); // Student("10", "Java"),  new Student("10", "Java")
        */

        // solution 1 - Remove the old entry from set prior to mutation, do the mutation, add the new updated entry again
        if (set.remove(std2)) {   // remove using OLD state
            std2.setName("Java"); // mutate after removal
            set.add(std2);        // reinsert
        }

        /*
        // solution 2 - do the mutation, populate a new set out of source Set
        std2.setName("Java");
        Set<Student> targetSet = new HashSet<>(set);

        System.out.println("set = " + targetSet.size()); // 1
        System.out.println("set = " + targetSet); // new Student("10", "Java")
        */
    }

    static class Student {
        private String id;
        private String name;

        public Student() {
        }

        public Student(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public Student(Student student) {
            this.id = student.id;
            this.name = student.name;
        }


        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return Objects.equals(id, student.id) && Objects.equals(name, student.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }


    }
}

/*
 * O/P =>
 * add(uniqueValue) - true
 * add(duplicatesValue) - false
 * size - 3
 * size - 0
 * hashSet - [1, 2, 3, 4, 5, 6]list of prime numbers : [2, 3, 5, 7, 7, 11]
 * list of primes without duplicates : [2, 3, 5, 7, 11]
 * */