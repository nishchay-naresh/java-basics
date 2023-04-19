package com.nishchay.java8.streams;

import java.util.Random;
import java.util.stream.Stream;


/*
* Collection sre still required to be finite but stream can be infinite
*
* we can rely on laziness to easily create a lazy , infinite collection
*
*
* */
public class InfiniteStreamDemo {

    public static void main(String[] args) {

        getUnboundedStream();
        impVsDecEx();

    }

    private static void getUnboundedStream() {

        System.out.print("Stream.iterate() - ");
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(e -> System.out.print(e + ", "));


        System.out.print("\nStream.generate() - ");
        Stream.generate(() -> new Random().nextInt(1000))
                .limit(10)
                .forEach(e -> System.out.print(e + ", "));

    }

    private static void impVsDecEx() {
        // Given a number k, and a count n, find the total of double of n
        // even numbers starting with k, where sqrt of each number is > 20

        int k = 121;
        int n = 51;
        System.out.println(computeIterative(k, n));
        System.out.println(computeStream(k, n));

    }

    public static int computeStream(int k, int n) {

        return Stream.iterate(k, e -> e + 1)            // unbounded, lazy
                .filter(e -> e % 2 == 0)                // unbounded, lazy
                .filter(e -> Math.sqrt(e) > 20)         // unbounded, lazy
                .mapToInt(e -> e * 2)                   // unbounded, lazy
                .limit(n)                               // sized, lazy
                .sum();
    }

    public static int computeIterative(int k, int n) {
        int result = 0;

        int index = k;
        int count = 0;
        while (count < n) {
            if (index % 2 == 0 && Math.sqrt(index) > 20) {
                result += index * 2;
                count++;
            }
            index++;
        }
        return result;
    }

}