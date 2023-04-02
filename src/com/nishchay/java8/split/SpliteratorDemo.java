package com.nishchay.java8.split;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.TreeSet;


/**
 * This example shows several examples of using Java Spliterators and
 * streams to traverse over list of String
 *
 *
 * <a href="Ref Link">https://www.javadevjournal.com/java/java-spliterator/</a>
 */
public class SpliteratorDemo {

    public static void main(String[] args) {

        List<String> quote = Arrays.asList("Strength ", "is ", "Life, ", "Weakness ", "is ", "Death.",
                "Expansion ", "is ", "Life, ", "Contraction ", "is ", "Death.",
                "Love ", "is ", "Life, ", "Hatred ", "is ", "Death.");

        tryAdvanceEx(quote);
        characteristicsEx();
        sizeEx(quote);
        getComparatorEx();
        trySplitEx(quote);
        trySplitAnotherEx();
        forEachRemainingEx(quote);

    }

    private static void tryAdvanceEx(List<String> quote) {

        System.out.println("\n----------printing using iterator ----------");

        Iterator<String> iterator = quote.iterator();
        while(iterator.hasNext()) {
            String curr = iterator.next();
            System.out.print(curr);
        }

        System.out.println("\n----------printing using tryAdvance() method ----------");

        Spliterator<String> spliterator = quote.spliterator();
        // tryAdvance() combines the hasNext() & next() methods of Iterator
        while(spliterator.tryAdvance(System.out::print)) {
        }

    }


    private static void characteristicsEx() {

        /*
         *	DISTINCT    - 1,		2^1		DISTINCT(0x00000001)
         *	SORTED      - 4,		2^2		SORTED(0x00000004)
         *	ORDERED     - 16,		2^4		ORDERED(0x00000010)
         *	SIZED       - 64,		2^8		SIZED(0x00000040)
         *	NONNULL     - 256,		2^16	NONNULL(0x00000100)
         *	IMMUTABLE   - 1024,		2^32	IMMUTABLE(0x00000400)
         *	CONCURRENT  - 4096,		2^64	CONCURRENT(0x00001000)
         *	SUBSIZED    - 16384,	2^128	SUBSIZED(0x00004000)
         *
         * */

        printAllCharacteristicConstValue();

        System.out.println("characteristics - " + Collections.EMPTY_LIST.spliterator().characteristics()); //16448
        System.out.println("--------------------------------------------------");

        ArrayList<String> list = new ArrayList<>();

        Spliterator<String> spliterator = list.spliterator();
        System.out.println("characteristics - " + spliterator.characteristics()); //16464 (16 + 64 + 16384)

        int expected = Spliterator.ORDERED | Spliterator.SIZED | Spliterator.SUBSIZED;

        System.out.println(spliterator.characteristics() == expected);  //true

        if (spliterator.hasCharacteristics(Spliterator.ORDERED)) {
            System.out.println("ORDERED");
        }
        if (spliterator.hasCharacteristics(Spliterator.DISTINCT)) {
            System.out.println("DISTINCT");
        }
        if (spliterator.hasCharacteristics(Spliterator.SORTED)) {
            System.out.println("SORTED");
        }
        if (spliterator.hasCharacteristics(Spliterator.SIZED)) {
            System.out.println("SIZED");
        }
        if (spliterator.hasCharacteristics(Spliterator.CONCURRENT)) {
            System.out.println("CONCURRENT");
        }
        if (spliterator.hasCharacteristics(Spliterator.IMMUTABLE)) {
            System.out.println("IMMUTABLE");
        }
        if (spliterator.hasCharacteristics(Spliterator.NONNULL)) {
            System.out.println("NONNULL");
        }
        if (spliterator.hasCharacteristics(Spliterator.SUBSIZED)) {
            System.out.println("SUBSIZED");
        }
    }


    private static void printAllCharacteristicConstValue() {
        System.out.println("DISTINCT    - " + Spliterator.DISTINCT + ",\t\t2^" + (int) Math.sqrt(Spliterator.DISTINCT));
        System.out.println("SORTED      - " + Spliterator.SORTED + ",\t\t2^" + (int) Math.sqrt(Spliterator.SORTED));
        System.out.println("ORDERED     - " + Spliterator.ORDERED + ",\t\t2^" + (int) Math.sqrt(Spliterator.ORDERED));
        System.out.println("SIZED       - " + Spliterator.SIZED + ",\t\t2^" + (int) Math.sqrt(Spliterator.SIZED));
        System.out.println("NONNULL     - " + Spliterator.NONNULL + ",\t\t2^" + (int) Math.sqrt(Spliterator.NONNULL));
        System.out.println("IMMUTABLE   - " + Spliterator.IMMUTABLE + ",\t\t2^" + (int) Math.sqrt(Spliterator.IMMUTABLE));
        System.out.println("CONCURRENT  - " + Spliterator.CONCURRENT + ",\t\t2^" + (int) Math.sqrt(Spliterator.CONCURRENT));
        System.out.println("SUBSIZED    - " + Spliterator.SUBSIZED + ",\t2^" + (int) Math.sqrt(Spliterator.SUBSIZED));
    }

    private static void sizeEx(List<String> quote) {

        System.out.println("list size - " + quote.size());
        Spliterator<String> spliterator = quote.spliterator();

        System.out.println("estimateSize - " + spliterator.estimateSize());
        System.out.println("getExactSizeIfKnown - " + spliterator.getExactSizeIfKnown());
    }

    private static void getComparatorEx() {

        SortedSet<String> set = new TreeSet<>(Collections.reverseOrder());
        set.add("A");
        set.add("D");
        set.add("C");
        set.add("B");

        System.out.println(set);
        System.out.println(set.spliterator().getComparator());
    }

    /*
     * Java example to split the elements to two groups and iterate independently.
     * */
    private static void trySplitEx(List<String> quote) {

        Spliterator<String> secondHalf = quote.spliterator();
        Spliterator<String> firstHalf = secondHalf.trySplit();

        System.out.println(firstHalf.getExactSizeIfKnown());
        System.out.println(secondHalf.getExactSizeIfKnown());

        secondHalf.forEachRemaining(System.out::println);
        System.out.println("========");
        firstHalf.forEachRemaining(System.out::println);
    }

    private static void trySplitAnotherEx() {

        List<String> values = Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");

        Spliterator<String> firstSpliterator = values.spliterator();
        Spliterator<String> secondSpliterator = firstSpliterator.trySplit();
        Spliterator<String> thirdSpliterator = firstSpliterator.trySplit();

        System.out.print("\nfirstSpliterator : ");
        while(firstSpliterator.tryAdvance(e -> System.out.print(" " + e))){
            //inside while loop
        }

        System.out.print("\nsecondSpliterator : ");
        while(secondSpliterator.tryAdvance(e -> System.out.print(" " + e))){
            //inside while loop
        }

        System.out.print("\nthirdSpliterator : ");
        while(thirdSpliterator.tryAdvance(e -> System.out.print(" " + e))){
            //inside while loop
        }

    }

    private static void forEachRemainingEx(List<String> quote) {

        Spliterator<String> strSpliterator = quote.spliterator();
        strSpliterator.forEachRemaining(System.out::println);
    }

}
