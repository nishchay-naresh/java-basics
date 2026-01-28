package com.nishchay.java8.streams.venkat;

import com.nishchay.util.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class LazyEvaluationDemo1 {
    public static void main(String[] args) {

        eagerEvaluation_logicalOp1(evaluate(1),evaluate(2));
        System.out.println("-------------------------------");
        lazyEvaluationUsingSupplier1(() -> evaluate(1), () -> evaluate(2));

        eagerEvaluation_collection1();
        lazyEvaluationInStream1();
    }

    public static boolean evaluate(final int value) {
        System.out.println("evaluating ..." + value);
        Utils.delay(2);
        return value > 100;
    }

    public static void eagerEvaluation_logicalOp1(final boolean input1, final boolean input2) {
        System.out.println("eagerEvaluator called...");
        System.out.println("accept?: " + (input1 && input2));
    }

    public static void lazyEvaluationUsingSupplier1(final Supplier<Boolean> input1, final Supplier<Boolean> input2) {
        System.out.println("lazyEvaluator called...");
        System.out.println("accept?: " + (input1.get() && input2.get()));
    }

    private static void eagerEvaluation_collection1() {

        List<String> names = Arrays.asList("Brad", "Kate", "Kim", "Jack", "Joe",
                "Mike", "Susan", "George", "Robert", "Julia", "Parker", "Benson");

        List<String> result = new ArrayList<>();
        for(String curr : names) {
            if(length(curr)  == 3) {
                result.add(toUpper(curr));
            }
        }
        System.out.println(result.get(0));
    }

    private static void lazyEvaluationInStream1() {

        List<String> names = Arrays.asList("Brad", "Kate", "Kim", "Jack", "Joe",
                "Mike", "Susan", "George", "Robert", "Julia", "Parker", "Benson");

        final String firstNameWith3Letters =
                names.stream()
                        .filter(name -> length(name) == 3)
                        .map(name -> toUpper(name))
                        .findFirst()
                        .get();
        System.out.println(firstNameWith3Letters);
    }

    private static int length(final String name) {
        System.out.println("getting length for " + name);
        return name.length();
    }

    private static String toUpper(final String name ) {
        System.out.println("converting to uppercase: " + name);
        return name.toUpperCase();
    }

}


/*
 * o/p =>
 *
 *	evaluating ...1
 *	evaluating ...2
 *	eagerEvaluator called...
 *	accept?: false
 *	-------------------------------
 *	eagerEvaluator called...
 *	evaluating ...1
 *	accept?: false
 *
 * */