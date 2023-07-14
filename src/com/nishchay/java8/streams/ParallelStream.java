package com.nishchay.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static com.nishchay.util.Utils.delay;
import static com.nishchay.util.Utils.timeIt;

/*
*  we can easily leverage the multi-threading benefits by enabling/disabling a switch in same piece of code
*
*  switch - .stream() / .parallelStream()
*  and performance difference is also very significance
*
*  -> imperative style the structure of sequential code is very different from the structure of concurrent code
*  -> using streams the structure of sequential code is identical to the structure of concurrent code
*
* mutability and parallel don't go together, you can’t mix them
* sometimes we end of getting wrong result bcus of this mutability
*
*  How to turn the code in parallelStream, when you are not creating the stream, instead you are receiving stream
*
*
* Streams			:	sequential vs parallel
* Reactive Stream	:	sync vs. async
* */
public class ParallelStream {

    public static void main(String[] args) {

        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        serialStreamEvaluation(numbers);
//        parallelStreamEvaluation(numbers);

        receivedStreamInParallelExc(numbers);

    }



    // Martin Fowler : Collection pipeline pattern
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

    private static void receivedStreamInParallelExc(List<Integer> numbers) {
        useIt(numbers.stream());
    }

    /*
    *  Evaluation will go which comes first from bottom to top from terminal operation
    *  after the fist switch (parallel/sequential) later switches are getting ignored
    *  entire pipeline is sequential or parallel no segments
    *
    * */
    private static void useIt(Stream<Integer> stream) {
        stream
            .parallel() // no op because of sequential operation
            .mapToInt(ParallelStream::compute)
            .sequential()
            .forEach(System.out::println);
    }


}

/*
 * O/P =>
 *	Time taken(sec): 5.0297611
 *	Time taken(sec): 1.0166795
 *
 * */