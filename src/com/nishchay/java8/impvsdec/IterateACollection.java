package com.nishchay.java8.impvsdec;

import java.util.ArrayList;
import java.util.Arrays;

/*
 *	Imperative 		vs 	Declarative
 *
 *	how					what
 *	mutate				transform
 *	side effect			pure
 *	pass objects		pass functions also
 *	hard to compose		functional composition
 *
 * -----------------------
 *
 * With Imperative style
 *      ◦ saying how to do the things
 *      ◦ introducing mutability
 *
 * Mixing “what” and “how”
 *  Loop mixes:
 *      what: filter even numbers, double them, sum
 *      how: iteration + mutation
 *  Stream separates concerns:
 *      filter → what
 *      map → transformation
 *      sum → reduction
 * This improves intent clarity.
 *
 * */
public class IterateACollection {

    public static void main(String[] args) {

        doubleEvenAndTotalThem();

    }

    // filter even numbers, double them, sum
    private static void doubleEvenAndTotalThem() {

        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        /*
         * Imperative style - doing a mutation in loop
         * Mixing “what” and “how”
         * SideEffect of mutation:
         *   -   make refactoring harder
         *   -   break easily in parallel execution
         *   -   Not composable / reusable
         *
         * */
        int result = 0;
        for (int e : numbers) {
            if (e % 2 == 0) {
                result += e * 2; // code smell - mutating result
            }
        }
        System.out.println("result = " + result);


        /*
         * Declarative style - doing a mutation in loop
         *  -   avoid side-effects
         *   -   safe in parallel execution
         *
         * */
        int sum = numbers.stream()
                .filter(e -> e % 2 == 0)
                .mapToInt(e -> e)
                .map(e -> e * 2)
                .sum();
        System.out.println("sum = " + sum);
    }

}
