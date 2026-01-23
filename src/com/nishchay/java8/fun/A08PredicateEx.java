package com.nishchay.java8.fun;


import com.nishchay.java8.streams.query.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;


/*
 *	java.util.function.Predicate<T>	:    T -> boolean      :	boolean test(T t);
 *	A predicate is a function that receives a value and returns a boolean value
 *
 *  A typical use case of the Predicate lambda is to filter a collection of values
 * https://zetcode.com/java/predicate/
 *
 * */
public class A08PredicateEx {

    public static void main(String[] args) {

        simplePredicateEx();
        simplePredicateEx1();
        negateEx();
        composePredicateEx();
        composePredicateEx_Object();

        biPredicateEx();
    }


    private static void simplePredicateEx() {

        Predicate<Integer> votingAgePredicate = i -> (i > 18);
        System.out.println("10 - " + votingAgePredicate.test(10));
        boolean result = votingAgePredicate.test(21);
        System.out.println("21 - " + result);
    }

    private static void simplePredicateEx1() {
        List<String> strList = Arrays.asList("java", "go", null, "python", null, "ruby", null, "redis");
        System.out.println("original list = " + strList);
        strList = strList.stream().filter(Objects::nonNull).collect(Collectors.toList());
        System.out.println("update list = " + strList);

        strList = Arrays.asList("Delhi6", "5Th Cross", "98.3FM", "1,233.00$ USD", "text", "java8");
        List<Double> doubleList = strList.stream()
                .map(s -> s.replaceAll("[^\\d.]", ""))
                .filter(s -> !s.isEmpty())
                .map(Double::parseDouble)
                .collect(Collectors.toList());
        System.out.println("doubleList = " + doubleList);
    }

    private static void negateEx() {
        Predicate<String> startWithA = x -> x.startsWith("A");

        List<String> list = Arrays.asList("A", "AA", "DD", "AAA", "B", "CC", "ZZZ");
        // Find all elements not start with ‘A’.
        List<String> collect = list.stream()
                .filter(startWithA.negate())
                .collect(Collectors.toList());

        System.out.println(collect);
    }

    /*
     *  Predicate Composition
     *  The Predicate interface (java.util.function.Predicate) contains a few methods that help you compose new Predicate instances from other Predicate instances.
     *       and()
     *       or()
     *
     * */
    private static void composePredicateEx() {

        Predicate<Integer> ageLowerLimit = i -> (i > 25);
        Predicate<Integer> ageUpperLimit = i -> (i < 60);
        Predicate<Integer> eligibleAge = ageLowerLimit.and(ageUpperLimit);
        System.out.println("22 - " + eligibleAge.test(22));
        System.out.println("45 - " + eligibleAge.test(45));

//        Predicate<String> weekDays = value -> value.startsWith("M|T|W|F");
        Predicate<String> weekDays = value -> value.substring(0, 1).matches("M|T|W|F");
        Predicate<String> weekEnds = value -> value.startsWith("S");

        System.out.println("Mon - " + weekDays.test("Mon"));
        System.out.println("Fri - " + weekDays.test("Fri"));
        System.out.println("Sun - " + weekEnds.test("Sun"));
        System.out.println("Tue - " + weekEnds.test("Tue"));

        Predicate<String> days = weekDays.or(weekEnds);


    }

    private static void composePredicateEx_Object() {
        Employee emp = new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0);

        Predicate<Employee> femaleEmp = e -> e.getGender().startsWith("F");
        Predicate<Employee> MgrEmp = e -> e.getSalary() > 24000.0;
        Predicate<Employee> femaleMgr = femaleEmp.and(e -> e.getSalary() > 24000.0);
        System.out.println("Emp - " + femaleMgr.test(emp));

        Predicate<Employee> accOrSaleMgr = MgrEmp
                .or(e -> e.getDepartment().startsWith("Sales"))
                .or(e -> e.getDepartment().startsWith("Account"));

    }

    private static void biPredicateEx() {

        BiPredicate<List<String>, String> contians = (list, key) -> list.contains(key);

        List<String> list = Arrays.asList("java", "perl", "go", "python");
        System.out.println(contians.test(list, "go"));
        System.out.println(contians.test(list, "ruby"));

    }
}
