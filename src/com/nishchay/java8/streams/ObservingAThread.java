package com.nishchay.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static com.nishchay.util.Utils.delay;


/*
 * ============== Thread Observation – in parallelStream ====================
 *
 * We solve one set of problems only to create a new set of problems
 *
 *	Java 1 - Threads
 *	Java 5 - ExecutorServices
 *	pool induced deadlock
 *	Work stealing - fork join pool
 *	Java 7 - FJP(fork join pool)
 *
 *	Common fork join pool
 *
 * */
public class ObservingAThread {
    public static void main(String[] args) {
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        useIt(numbers.stream());

        reduceExInParallel(numbers);
    }


    static int compute(int number) {
        // assume this is time intensive
        System.out.println("t : " + number + " -- " + Thread.currentThread());
        delay(1);
        return number * 1;
    }

    //  .forEachOrdered() -> terminal operation to control the ordering
    private static void useIt(Stream<Integer> stream) {
        stream
                .parallel()
                .mapToInt(ObservingAThread::compute)
                // .forEach(e -> {});
                .forEachOrdered(e -> {});
    }

    /*
     * Can we run reduce() in parallel? - yes, but we need to carefully with the initial value
     *
     * reduce() does not take an initial value, it takes an identity value
     *
     * int * identity is 1,  x * 1 = x
     * int + identity is 0,  x + 0 = x
     *
     * what we work with should be a monoid
     *
     * */
    private static void reduceExInParallel(List<Integer> numbers) {
        System.out.println(
                numbers
                    // .stream() // working well : 85
                    .parallelStream() // not working well : 355
                    .reduce(30, ObservingAThread::sum));
    }

    public static int sum(int total, int number) {
        System.out.println("sum - " + total + ", " + number + " from " + Thread.currentThread());
        return total + number;
    }

}

/*
 * O/P =>
 *
 * t : 7 -- Thread[main,5,main]
 * t : 3 -- Thread[ForkJoinPool.commonPool-worker-9,5,main]
 * t : 10 -- Thread[ForkJoinPool.commonPool-worker-13,5,main]
 * t : 9 -- Thread[ForkJoinPool.commonPool-worker-2,5,main]
 * t : 6 -- Thread[ForkJoinPool.commonPool-worker-6,5,main]
 * t : 2 -- Thread[ForkJoinPool.commonPool-worker-11,5,main]
 * t : 8 -- Thread[ForkJoinPool.commonPool-worker-4,5,main]
 * t : 4 -- Thread[ForkJoinPool.commonPool-worker-1,5,main]
 * t : 1 -- Thread[ForkJoinPool.commonPool-worker-15,5,main]
 * t : 5 -- Thread[ForkJoinPool.commonPool-worker-8,5,main]
 *
 * */