package com.nishchay.java8.dp;

import java.util.function.Function;

public class DP04Decorator {

    public static void main(String[] args) {

        // refer this
        // OperatorEx.main(null);

        /*
         * Can be referred at -
         * https://github.com/nnares/design-pattern/blob/main/src/com/nishchay/dp/structural/delegator/Launcher.java
         *
         * */

        composabilityEx();

    }


    private static void composabilityEx() {
        Function<Integer, Integer> inc = e -> e + 1;
        printIt(5, "incremented", inc);
        printIt(10, "incremented", inc);

        Function<Integer, Integer> doubled = e -> e * 2;
        printIt(5, "doubled", doubled);
        printIt(10, "doubled", doubled);

//        Function<Integer, Integer> incAndDoubled = e -> (e+1) * 2; // No Friend
        printIt(10, "increment and doubled", inc.andThen(doubled));

    }

    private static void printIt(int n, String msg, Function<Integer, Integer> func) {
        System.out.println(n + " " + msg + " : " + func.apply(n));
    }

}
