package com.nishchay.java8.fun;

import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;


/*
 *
 *	The way we have many function in Package java.util.function, Similarly we have so many Operators as well.
 *
 *	These Operators are same like Function, Only difference their type is fixed ( input and return type will always be same)
 *
 *	UnaryOperator<T>                    BinaryOperator<T>
 *	IntUnaryOperator                    IntBinaryOperator
 *	LongUnaryOperator                   LongBinaryOperator
 *	DoubleUnaryOperator                 DoubleBinaryOperator
 *
 *	We can use these operators in place of Function if we know these type constrains
 *	Operators Function Interface
 *	•	Here both input and Output are same type.
 *	•	UnaryOperator is Child of Function : BinaryOperator<T> extends Function<T, T>
 *	•	BinaryOperator is Child of BiFunction : BinaryOperator<T> extends BiFunction<T,T,T>
 *
 *
* */
public class OperatorEx {

    public static void main(String[] args) {

        unaryOperatorEx();
        binaryOperatorEx();

    }



    private static void unaryOperatorEx() {
        UnaryOperator<String> stringUnaryOperator = e -> "Hello " + e;
        System.out.println(stringUnaryOperator.apply("World"));

        IntUnaryOperator intUnaryOperator = e -> 10 + e;
        System.out.println("result - " + intUnaryOperator.applyAsInt(5));
        IntUnaryOperator discountedPrice = e -> (int) (e * 0.9);
        System.out.println("discount - " + discountedPrice.applyAsInt(70));
        // similarly we have LongUnaryOperator, DoubleUnaryOperator
        
    }

    private static void binaryOperatorEx() {
        BinaryOperator<String> stringBinaryOperator = (e1,e2) -> e1 + e2;
        System.out.println(stringBinaryOperator.apply("Hello ","World"));

        BinaryOperator<Integer> integerBinaryOperator = (e1,e2) -> e1 + e2;
        System.out.println(integerBinaryOperator.apply(10,5));

        IntBinaryOperator intBinaryOperator = (e1, e2) -> e1 + e2;
        System.out.println(intBinaryOperator.applyAsInt(10,5));
        /*
        * Both integerBinaryOperator & intBinaryOperator are doing same operation
        * but this - integerBinaryOperator is heavier than intBinaryOperator
        *
        * similarly we have LongUnaryOperator, DoubleUnaryOperator
        * */
    }

}
