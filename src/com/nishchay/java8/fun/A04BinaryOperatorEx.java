package com.nishchay.java8.fun;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import com.nishchay.util.pojo.Student;

/*
 *  BinaryOperator<T> extends BiFunction<T, T, T>
 *	java.util.function.BinaryOperator<T>	:    (T, T) -> T      :	T apply(T t1, T t2);
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
 * Primitive Unary Operators
 *      -   IntUnaryOperator
 *      -   LongUnaryOperator
 *      -   DoubleUnaryOperator
 * */
public class A04BinaryOperatorEx {

    public static void main(String[] args) {
        operatorBasicEx();
        streamUsageEx();
        streamUsagePOJOEx();
    }

    private static void operatorBasicEx() {
        BinaryOperator<Integer> sum = (a, b) -> a + b;
        System.out.println(sum.apply(10, 20));                      // 30

        BinaryOperator<Integer> max = (a, b) -> a > b ? a : b;
        System.out.println(max.apply(15, 10));                      // 15

        BinaryOperator<String> concat = (s1, s2) -> s1 + s2;
        System.out.println(concat.apply("Hello ", "World"));        // Hello World
    }

    private static void streamUsageEx() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 5, 4, 6, 7, 8, 9, 10);

        // Integer::sum → BinaryOperator<Integer>
        int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println("sum = " + sum);
        Optional<Integer> max = numbers.stream().reduce(BinaryOperator.maxBy(Integer::compareTo));
        Optional<Integer> min = numbers.stream().reduce(BinaryOperator.minBy(Integer::compareTo));
        System.out.println("max = " + max.get() + "min = " + min.get());
    }

    private static void streamUsagePOJOEx() {
        BinaryOperator<Student> marksCompare =
                (s1, s2) -> s1.getMarks() > s2.getMarks() ? s1 : s2;

        Student topper = Student.populateStudentList().stream()
                        .reduce(marksCompare)
                        .orElse(null);
        System.out.println("topper = " + topper);

        Double maxMarks = Student.populateStudentList().stream().map(Student::getMarks).max(Double::compareTo).orElse(0.0);
        System.out.println("maxMarks = " + maxMarks);
    }
}
