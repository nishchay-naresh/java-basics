package com.nishchay.core.collection;

import com.nishchay.core.immutable.pojo.Person;
import com.nishchay.util.pojo.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CollectionsMethodDemo {

    public static void main(String[] args) {

//        swapEx();
//        nCopiesEx();
//        frequencyEx();
        unmodifiableListEx();
    }


    private static void swapEx() {
        List<String> list = Arrays.asList("a", "b", "c", "d", "e", "f");
        System.out.println("At index 1 & 2 = " + list.get(1) + " " + list.get(2));
        Collections.swap(list, 1, 2);
        System.out.println("At index 1 & 2 = " + list.get(1) + " " + list.get(2));
    }

    /*
     *   Collections.nCopies() is to return an immutable list which contains n copies of a given object.
     *   This function helps if we want to create a list with n copies of a given object.
     *   The newly allocated data object is tiny i.e, it contains a single reference to the data object.
     *
     *       public static <T> List<T> nCopies(int n, T o)
     *           int n : the number of elements in the returned list.
     *           T o: the element to appear repeatedly in the returned list.
     *           Exception: The function throws IllegalArgumentException if the value of number is less than 0.
     *
     * */
    private static void nCopiesEx() {

        String stringToBeCopied = "java8";
        List<String> copyList = Collections.nCopies(5, stringToBeCopied);
        System.out.println("The list returned is: " + copyList);

        System.out.println("----------------Atomic Integer------------------");
        AtomicInteger ai = new AtomicInteger();
        List<AtomicInteger> list = Collections.nCopies(3, ai);
        System.out.println(list);
        ai.incrementAndGet();
        System.out.println(list);

        System.out.println("----------------------------------Student------------------------------");
        Student stud = new Student(7900, "Rober Downey Jr ", "R&D", 62.52, "New York");
        List<Student> studList = Collections.nCopies(4, stud);
        System.out.println(studList.get(0) + "\n" + studList.get(1) + "\n" + studList.get(2) + "\n" + studList.get(3));
        stud.setStudName("Iron Man");
        stud.setStudNo(9999);
        System.out.println(studList.get(0) + "\n" + studList.get(1) + "\n" + studList.get(2) + "\n" + studList.get(3));

    }

    /*
     *  there is a method in Collection class -  to get the freq of an element out of the collection
     *       public static int frequency(Collection<?> c, Object o)
     *
     * */
    private static void frequencyEx() {

        int freq = Collections.frequency( Arrays.asList(2, 5, 2, 3, 2, 1, 5), 2);
        System.out.println("Frequency of 2 is: " + freq);

        String mainStr = "car, bus, car, jeep, cycle, bike, train, bus, truck, jeep, car, jeep, cycle, truck, train, car, bike, bus, cycle";
        String key = "car";

        freq = Collections.frequency(Arrays.asList(mainStr.split(", ")), key);
        System.out.println("Frequency of - " + key + " is - " + freq);
    }

    /*
     *  public static <T> List<T> unmodifiableList(List<? extends T> list)
     *
     *  Collections.unmodifiableList() creates a read-only view, not a new list
     *  A wrapper around the original list that prevents modification through that reference,
     *  But the source list still opens for modification through its old reference.
     *  That’s why we say: "It is a read-only view, not a defensive copy."
     *
     * Return a wrapper top of the original list, there it delegates read operations, blocks write operations.
     * Does It Protect Elements? - No
     *      unmodifiable.get(0).setName("Changed");  // Allowed
     *
     * */
    private static void unmodifiableListEx() {
        List<String> strList = new ArrayList<>();
        strList.add("A");
        List<String> unmodifiableStrList = Collections.unmodifiableList(strList);

        strList.add("B");
        System.out.println(unmodifiableStrList);  // [A, B]

        List<Person> personList = new ArrayList<>();
        personList.add(new Person());
        List<Person> unmodifiablepersonList = Collections.unmodifiableList(personList);
        System.out.println(unmodifiablepersonList);

        unmodifiablepersonList.get(0).setName("Changed");
        System.out.println(unmodifiablepersonList);
    }
}

