package com.nishchay.java8.streams;

import com.nishchay.util.Utils;

public class LazyEvaluationDemo1 {
    public static void main(String[] args) {

        eagerEvaluation_logicalOp1(evaluate(1),evaluate(2));
//        System.out.println("-------------------------------");
//        lazyEvaluationUsingSupplier1(() -> evaluate(1), () -> evaluate(2));
//
//        eagerEvaluation_collection1();
//        lazyEvaluationInStream1();
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