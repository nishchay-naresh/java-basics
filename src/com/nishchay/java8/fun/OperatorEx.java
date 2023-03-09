package com.nishchay.java8.fun;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;


/*
 *  java.util.function.UnaryOperator<T>	 -  child of Function<T, R>
 *
 *  java.util.function.UnaryOperator<T>	    :    T -> T         :	T apply(T t);
 *  java.util.function.BinaryOperator<T>	:    (T,T) -> T     :	T apply(T t1, Tt2);
 *
 *
 *	The way we have many function in Package java.util.function, Similarly we have so many Operators as well.
 *
 *	These Operators are same like Function, Only difference their type is fixed ( input and return type will always be same)
 *  For primitive:
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
 * =============================================Adv usage of UnaryOperator<T> ==================================================
 * NOTE : Usage of UnaryOperator<T> for Enrichment or Delegation use-case
 *
 * Can be referred at -
 * https://github.com/nnares/design-pattern/blob/main/src/com/nishchay/dp/structural/delegator/Launcher.java
 *
 *
 *
* */
public class OperatorEx {

    public static void main(String[] args) {

        operatorEx();
        unaryOperatorEx();
        System.out.println("------------------------------");
        binaryOperatorEx();

    }


    private static void operatorEx(){
        List<String> names = Arrays.asList("java", "go", "python");
        names.replaceAll(name -> name.toUpperCase());
        System.out.println("names = " + names);

        List<Integer> values = Arrays.asList(3, 5, 8, 9, 12);
        int sum = values.stream()
                .reduce(0, (i1, i2) -> i1 + i2);
        System.out.println("sum = " + sum);
    }

    private static void unaryOperatorEx() {
        UnaryOperator<String> stringUnaryOperator = e -> "Hello " + e;
        System.out.println(stringUnaryOperator.apply("World"));

        UnaryOperator<String> f1 = String::toUpperCase;
        System.out.println(f1.apply("hello"));

        IntUnaryOperator intUnaryOperator = e -> 10 + e;
        System.out.println("result - " + intUnaryOperator.applyAsInt(5));
        IntUnaryOperator discountedPrice = e -> (int) (e * 0.9);
        System.out.println("discount - " + discountedPrice.applyAsInt(70));
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
