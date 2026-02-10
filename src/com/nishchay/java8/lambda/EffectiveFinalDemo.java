package com.nishchay.java8.lambda;

import com.nishchay.java8.basic.methodref.pojo.FI2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
* Also referred as closure in lambda
* Effective Final - concept introduced in java8. In the earlier version, you need to make y as final to achieve this
* Java compiler keeping a watch on y. If a user modifies it, compiler will flag compiler time error
* Have same behavior for both lambda & anonymous inner class
*
* A variable is effectively final if:
*  - It is assigned only once.
*  - Its value never changes after the initial assignment.
*
* */

public class EffectiveFinalDemo {

    public static void main(String[] args) {

        effectiveFinalEx();
        effectiveFinalEx1();
        lazyEvaluationEx();
    }


    private static void effectiveFinalEx1() {
        int x = 100;
        int y = 20;

        System.out.println("----------anonymous inner class-------------");

        ProcessI process = new ProcessI() {
            @Override
            public void process(int a) {
                int y = 50; // Variable 'y' is accessed from within inner class, needs to be final or effectively final
                System.out.println(a + y);
            }
        };
        doProcess(x, process);


        System.out.println("----------Using lambda-------------");
        ProcessI process1 = a -> {
//            y = 50; // Variable used in lambda expression should be final or effectively final
            System.out.println(a + y);
        };
        doProcess(x, process1);
    }

    public static void doProcess(int a, ProcessI p) {
        p.process(a);
    }

    private static void effectiveFinalEx() {

        String message = "Hello, Java 8"; // effectively final

        Runnable r = () -> {
            System.out.println(message);
            // message = "Hello again";   // CE - java: local variables referenced from a lambda expression must be final or effectively final
        };

        r.run();
    }

    /*
     * ===================================== Key Concepts ===================================
     *		Concept						Explanation
     *	Effectively final   -   Lambda captures variables that don't change — but arrays/objects can be changed without changing their reference.
     *	Mutable state       -   factor[0] is mutable. The lambda sees the latest value during execution.
     *	Stream laziness     -   The stream pipeline does nothing until the terminal operation (forEach) is invoked.
     * 	Side effects        -   Changing shared mutable state (factor[0]) before running the stream can lead to unpredictable results or bugs.
     */
    private static void  lazyEvaluationEx() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);

        int[] factor = {2};
        // no terminal operation, only intermediate operation
        Stream<Integer> stmt = numbers.stream()
                .map(e -> e * factor[0]);
        factor[0] = 0;

        //Now only apply terminal operation, so evaluation will happen now
        stmt.forEach(System.out::println);
    }
}

