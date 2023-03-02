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
 * */
public class IterateACollection {

    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        int result = 0;
        // single pass vs multiple pass through in operation
        for (int e : numbers) {
            if (e % 2 == 0) {
                result += e * 2; // code smell - mutating result
            }
        }
        System.out.println("result = " + result);

        int sum = numbers.stream()
                .filter(e -> e % 2 == 0)
                .mapToInt(e -> e)
                .map(e -> e * 2)
                .sum();
        System.out.println("sum = " + sum);
    }

}
