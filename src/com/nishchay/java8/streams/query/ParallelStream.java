package com.nishchay.java8.streams.query;

import java.util.Arrays;
import java.util.List;

public class ParallelStream {

    public static void main(String[] args) {

        serialStreamEvaluation();
        parallelStreamEvaluation();

    }


    private static void serialStreamEvaluation() {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        final long startTime = System.currentTimeMillis();
        numbers.stream()
                .filter(e -> e % 2 == 0)
                .mapToInt(ParallelStream::compute)
                .sum();
        final long endTime = System.currentTimeMillis();
        float totalTimeInSec = (endTime - startTime) / 1000;

        System.out.println("SerialStream : total execution time: " + totalTimeInSec);
    }

    // I don't mind using lot of threads/resources to get the result faster
    private static void parallelStreamEvaluation() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        final long startTime = System.currentTimeMillis();
        numbers.parallelStream()
                .filter(e -> e % 2 == 0)
                .mapToInt(ParallelStream::compute)
                .sum();
        final long endTime = System.currentTimeMillis();
        float totalTimeInSec = (endTime - startTime) / 1000;

        System.out.println("ParallelStream : total execution time: " + totalTimeInSec);
    }


    private static int compute(int number) {
        // assume this is time intensive
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {}
        return number * 2;
    }


}
