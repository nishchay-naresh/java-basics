package com.nishchay.java8.streams;

import java.util.Arrays;
import java.util.List;

import static com.nishchay.util.Utils.delay;
import static com.nishchay.util.Utils.timeIt;

/*
*  we can easily leverage the muti-threading benefits by enabling/disabling a switch in same piece of code
*
*  switch - .stream() / .parallelStream()
*  and performance difference is also very significance
*
* */
public class ParallelStream {

    public static void main(String[] args) {

        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        serialStreamEvaluation(numbers);
        parallelStreamEvaluation(numbers);

    }

    private static void serialStreamEvaluation(List<Integer> numbers) {

        timeIt(() ->
                numbers.stream()
                .filter(e -> e % 2 == 0)
                .mapToInt(ParallelStream::compute)
                .sum()
        );
    }

    // I don't mind using a lot of threads/resources to get the result faster
    private static void parallelStreamEvaluation(List<Integer> numbers) {

        timeIt(() ->
                numbers.parallelStream()
                        .filter(e -> e % 2 == 0)
                        .mapToInt(ParallelStream::compute)
                        .sum()
        );

    }

    private static int compute(int number) {
        // assume this is time intensive
        delay(1);
        return number * 2;
    }

}

/*
 * O/P =>
 *	Time taken(sec): 5.0297611
 *	Time taken(sec): 1.0166795
 *
 * */