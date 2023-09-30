package com.nishchay.core.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IterableDemo {

    public static void main(String[] args) {

        wayToItr();
        userImplItr();
    }


    private static void wayToItr() {

        Iterable<String> list = Arrays.asList("two", "four", "six", "eight");

        // 1. Iterate an Iterable With the for-each Loop
        for (String element : list) {
            System.out.print(element + ", ");
        }
        System.out.println();

        // 2.	Iterate an Iterable via an Iterator
        Iterator<String> iterator = list.iterator();
        do {
            String element = iterator.next();
            System.out.print(element + ", ");
        } while (iterator.hasNext());
        System.out.println();

        // 3.	Iterate an Iterable via its forEach() Method
        list.forEach(e -> System.out.print(e + ", "));
    }

    private static void userImplItr() {
        CustomCollectionIterator<String> collection = new CustomCollectionIterator<>();
        collection.add("ten");
        collection.add("nine");
        collection.add("five");
        Iterator<String> iterator = collection.iterator();
        do {
            String element = iterator.next();
            System.out.print(element + ", ");
        } while (iterator.hasNext());
    }

}

// A Custom Collection Iterator implementation
class CustomCollectionIterator <T> implements Iterable<T> {

    private final List<T> source = new ArrayList<>();
    public Iterator<T> iterator() {
        return this.source.iterator();
    }
    public boolean add(T t) {
        return this.source.add(t);
    }
}
