package com.nishchay.java8.fun;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;


/*
 *  java.util.function.UnaryOperator<T>	 -  child of Function<T, R>
 *  java.util.function.BinaryOperator<T> -  child of BiFunction<T, U, R>
 *
 *	Here both input and Output are same type.
 *	    UnaryOperator is Child of Function      : BinaryOperator<T> extends Function<T,T>
 *	    BinaryOperator is Child of BiFunction   : BinaryOperator<T> extends BiFunction<T,T,T>
 *
 *  java.util.function.UnaryOperator<T>	    :    T -> T         :	T apply(T t);
 *  java.util.function.BinaryOperator<T>	:    (T,T) -> T     :	T apply(T t1, T t2);
 *
 *
 *	These Operators are same like Function, Only difference their type is fixed ( input and return type will always be same)
 *	UnaryOperator<T>                    BinaryOperator<T>
 *
 *  Operators for primitive:
 *	IntUnaryOperator                    IntBinaryOperator
 *	LongUnaryOperator                   LongBinaryOperator
 *	DoubleUnaryOperator                 DoubleBinaryOperator
 *
 * =============================================Adv usage of UnaryOperator<T> ==================================================
 * NOTE : Usage of UnaryOperator<T> for Enrichment or Delegation use-case
 *
 * Can be referred at -
 * https://github.com/nnares/design-pattern/blob/main/src/com/nishchay/dp/structural/delegator/Launcher.java
 *
 * ===========================================================================================================================
 *  UnaryOperator<T> extends Function<T, T>
 *	java.util.function.UnaryOperator<T>	:    T -> T      :	T apply(T t);
 *
 *	T – Type of the input to the function.
 *
 *
 * Methods in UnaryOperator Interface :
 *  1. identity()
 *
 * UnaryOperator is a specialization of Function where input and output types are the same.
 * It improves readability and is commonly used in stream mappings and in-place collection updates like replaceAll().
 *
 * */
public class A03UnaryOperatorEx {

    public static void main(String[] args) {
        operatorBasicEx();
        replaceAllEx();
    }

    private static void operatorBasicEx() {
        UnaryOperator<Integer> square = x -> x * x;
        System.out.println(square.apply(5)); // 25

        UnaryOperator<String> toUpper = s -> s.toUpperCase();
        System.out.println(toUpper.apply("java")); // JAVA

        // UnaryOperator.identity()
        UnaryOperator<String> identity = UnaryOperator.identity();
        System.out.println(identity.apply("Java")); // Java
    }

    private static void replaceAllEx() {
        List<String> names = new ArrayList<>(List.of("java", "spring", "docker"));
        names.replaceAll(String::toUpperCase);
        System.out.println(names); // [JAVA, SPRING, DOCKER]
    }
}
