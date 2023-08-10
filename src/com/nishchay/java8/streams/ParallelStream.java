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
*
* Streams			:	sequential vs parallel
* Reactive Stream	:	sync vs. async
*
* Reactive Stream -  have 3 states , data, error, completed
* similarly it also have 3 channel : data, error, completed channel
*
* Promises vs Reactive Stream :
* Promises -  it is for 0/1 data
* Reactive Stream - it is series of data, so for 0/1/many data
*
* */
public class ParallelStream {

    public static void main(String[] args) {

        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        serialStreamEvaluation(numbers);
        parallelStreamEvaluation(numbers);

        receivedStreamInParallelExc(numbers);
        threadsFormula();
    }



    // Martin Fowler : Collection pipeline pattern
    private static void serialStreamEvaluation(List<Integer> numbers) {
        timeIt(() ->
                System.out.println("sum - " +
                        numbers.stream()
                                .filter(e -> e % 2 == 0)
                                .mapToInt(ParallelStream::doubledIt)
                                .sum()
                )
        );
    }

    // I don't mind using a lot of threads/resources to get the result faster
    private static void parallelStreamEvaluation(List<Integer> numbers) {

        timeIt(() ->
                System.out.println("sum - " +
                        numbers.parallelStream()
                                .filter(e -> e % 2 == 0)
                                .mapToInt(ParallelStream::doubledIt)
                                .sum()
                )
        );

    }

    private static int doubledIt(int number) {
        // assume this is time intensive
        delay(1);
        return number * 2;
    }

    private static void receivedStreamInParallelExc(List<Integer> numbers) {
        useIt(numbers.stream());
    }

    /*
    *
    *  How to turn the code in parallelStream, when you are not creating the stream, instead you are receiving stream
    *
    *  Evaluation will go which comes first from bottom to top from terminal operation
    *  after the fist switch (parallel/sequential) later switches are getting ignored
    *  entire pipeline is sequential or parallel no segments
    *
    * */
    private static void useIt(Stream<Integer> stream) {
        stream
            .parallel() // no op because of sequential operation
            .mapToInt(ParallelStream::doubledIt)
            .sequential()
            .forEach(System.out::println);
    }


    /*
     * ================ How many threads ===============
     *
     * How many threads can I create? //bad question
     * How much food can I eat?
     *
     * How many threads should I create?
     * How much food should I eat?
     *
     *
     * Two kind of operation we can perform :
     * Computation intensive. <- Never give more threads than number of cores. Threads <= No of cores
     * IO intensive. <- May be more than number of cores, but again how many don't know
     *
     * Blocking Factor - Ratio of time the task is waiting on IO
     *
     * Blocking factor for computation intensive = 0
     * Blocking factor 0 <= Blocking Factor < 1
     *
     *                             Core
     * Number of threads =  _____________________
     *                       1 - Blocking Factor
     *
     *
     * */
    public static void threadsFormula() {

        /*
        * System.out.println(Runtime.getRuntime().availableProcessors()); // No of cores
        * System.out.println(ForkJoinPool.commonPool()); // parallelism = No of cores - 1(main)
        * */

        List<Integer> numbers = Arrays.asList(
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
                21, 22, 23, 24, 25, 26, 27, 28, 29, 30);

        numbers
                .parallelStream()
                .map(ObservingAThread::compute)
                .forEach(e -> {});
    }
}

/*
 * O/P =>
 *	Time taken(sec): 5.0297611
 *	Time taken(sec): 1.0166795
 *
 * */