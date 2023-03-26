package com.nishchay.java8.fun;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 *    Function<inputType, outputType>
 *	java.util.function.Function<T, R>	:    T -> R      :	R apply(T t);
 *
 *	T – Type of the input to the function.
 *	R – Type of the result of the function.
 *
 *  We may replace the lambda with a method reference that matches passed and returned value types.
 *
 * Methods in Function Interface :
 *  1. apply()
 *	2. andThen()
 *	3. compose()
 *	4. identity()
 *
 *
 * https://www.baeldung.com/java-8-functional-interfaces
 * */
public class FunctionEx {

    public static void main(String[] args) {

        applyEx();
        functionExWithGenerics();

        identityEx();
        identityEx_toMap();

        System.out.println("---------Composing Functions--------");
        funcCompositionEx();

        funAsParameter();

        funWithPredicate();
    }


    /*
     * apply() - abstract method, used to execute/evaluate the function
     *
     *  output = function.apply(input)
     *
     * */
    private static void applyEx() {

        Function<Integer, Integer> f1 = i -> i * 4;
        System.out.println(f1.apply(3));    //12

        Function<Integer, Integer> f2 = i -> i + 4;
        System.out.println(f2.apply(3));    //7

        // Function which takes in a number and returns half of it
        Function<Integer, Double> funHalf = a -> a / 2.0;
        System.out.println(funHalf.apply(10));  //5.0

        // Function which takes in a String and returns its length
        Function<String, Integer> funStrLength = String::length;
        System.out.println(funStrLength.apply("java")); // 4

    }

    private static void functionExWithGenerics(){

        Map<Number, CharSequence> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");

        Function<Iterable<Number>, Iterable<? extends Map.Entry<Number, CharSequence>>> mappingFunction =  numbers -> map.entrySet();
        System.out.println("mappingFunction.apply(Collections.singleton(3)) - " + mappingFunction.apply(Collections.singleton(3)));
        System.out.println("mappingFunction.apply(Collections.singleton(1)) - " + mappingFunction.apply(Collections.singleton(1)));

        System.out.println("mappingFunction.apply(new HashSet<>(Arrays.asList(1, 2, 3))) - " + mappingFunction.apply(new HashSet<>(Arrays.asList(1, 2, 3))));
        System.out.println("mappingFunction.apply(new HashSet<>(Arrays.asList(1, 2))) - " + mappingFunction.apply(new HashSet<>(Arrays.asList(1, 2))));

        System.out.println("------------------------------------------------------------------------------------------");

        Function<Iterable<Number>, Iterable<? extends Map.Entry<Number, CharSequence>>> mappingFunction1 =

                numbers -> {
                    int key = (int) numbers.iterator().next();
                    if (key == 1) {
                        return Collections.singletonList(new AbstractMap.SimpleImmutableEntry<>(1, "one"));
                    } else if (key == 2) {
                        return Collections.singletonList(new AbstractMap.SimpleImmutableEntry<>(2, "two"));
                    } else if (key == 3) {
                        return Collections.singletonList(new AbstractMap.SimpleImmutableEntry<>(3, "three"));
                    }
                    return Collections.singletonList(new AbstractMap.SimpleImmutableEntry<>(-1, null));
                };


        System.out.println("mappingFunction1.apply(Collections.singleton(3)) - " + mappingFunction1.apply(Collections.singleton(3)));
        System.out.println("mappingFunction1.apply(Collections.singleton(2)) - " + mappingFunction1.apply(Collections.singleton(2)));
        System.out.println("mappingFunction1.apply(Collections.singleton(1)) - " + mappingFunction1.apply(Collections.singleton(1)));
        System.out.println("mappingFunction1.apply(Collections.singleton(1)) - " + mappingFunction1.apply(Collections.singleton(9)));

    }

    private static Map.Entry<? extends Number, ? extends CharSequence> newMapEntry(Number key, CharSequence value) {
        return new AbstractMap.SimpleEntry<>(key, value);
    }

    /*
     * identity() – static method returns a function that returns its only argument
     * T -> T : input -> output
     *
     * */
    private static void identityEx() {

        Function<String, String> f1 = x -> x;
        System.out.println(f1.apply("java"));
        Function<Integer, Integer> f2 = x -> x;
        System.out.println(f2.apply(25));

        f1 = Function.identity();
        System.out.println(f1.apply("java"));
        f2 = Function.identity();
        System.out.println(f2.apply(25));

        System.out.println(Function.identity().apply("java"));
        System.out.println(Function.identity().apply(25));

    }

    private static void identityEx_toMap() {

        Map<String, Integer> map =
                Stream.of("java", "python", "go")
                        .collect(Collectors.toMap(Function.identity(), String::length));
//         .collect(Collectors.toMap(e -> e, String::length));

        System.out.println("map = " + map);
    }


    /*
     *  ============== Composing Functions =================
     *
     *  Functional style of programming
     *  compose functions together -> Composability
     *
     *  Now we can have a function which is composed of two other functions
     *  Big Function = small function + andThen()/compose() + another small function
     *
     * andThen() - returns a composed function wherein the parameterized function will be executed after the first one.
     * throws NullPointerException if the parameterized function is null
     *
     * compose() - returns a composed function wherein the parameterized function will be executed first and then the first one.
     * throws NullPointerException if the parameterized function is null
     *
     *
     * x.andThen(y) is the same as y.compose(x)
     *
     * */
    private static void funcCompositionEx() {

        Function<Integer, Integer> incrementIt = e -> e + 1;
        printIt(5, "increment", incrementIt);
        printIt(10, "increment", incrementIt);

        Function<Integer, Integer> doubledIt = e -> e * 2;
        printIt(5, "doubled", doubledIt);
        printIt(10, "doubled", doubledIt);

        Function<Integer, Integer> incrementAndDoubled = e -> (e + 1) * 2; // no friend
        printIt(20, "incrementAndDoubled", incrementAndDoubled);

        incrementAndDoubled = incrementIt.andThen(doubledIt);
        printIt(20, "incrementAndDoubled", incrementAndDoubled);
        // Function<Integer, Integer> npe = doubledIt.andThen(null); // java.lang.NullPointerException

        Function<Integer, Integer> doubledAndIncrement = incrementIt.compose(doubledIt); // e -> (e * 2) + 1;
        printIt(20, "doubledAndIncrement", doubledAndIncrement);
        // Function<Integer, Integer> npe = incrementIt.compose(null); // java.lang.NullPointerException

    }

    // this method itself an example of Function composition, taking input and the Function operation over it
    private static void printIt(int input, String msg, Function<Integer, Integer> func) {
        System.out.println(input + " " + msg + " : " + func.apply(input));
    }


    /*
     * Pass a function as a parameter to another method.
     * List<String> -> List<EncodedString> -> List<String>
     *
     * Creating a generic method takes a list, and a mapping method to apply the mapping
     * Java Base64 Example: Basic Encoding and Decoding
     * */
    private static void funAsParameter() {

        List<String> list = Arrays.asList("node", "c++", "java", "javascript", "ruby");

        Function<String, String> encodeFun = str -> Base64.getEncoder().encodeToString(str.getBytes());
        Function<String, String> decodeFun = str -> new String(Base64.getDecoder().decode(str));
        // method reference
        List<String> encodeList = map(list, encodeFun);
        System.out.println("encodeList = " + encodeList);

        List<String> decodeBackList = map(encodeList, decodeFun);
        System.out.println("decodeBackList = " + decodeBackList);

    }


    /*
    * Applying a mappingFunction for each element of list
    * List<T>  ->   t   ->    mappingFun.apply(t)   ->  r   ->      List<R>
    *
    * */
    public static <T, R> List<R> map(List<T> list, Function<T, R> mappingFun) {

        /*
        // imperative way
        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(mappingFun.apply(t));
        }
        return result;
        */

        // declarative way
        return list.stream().map(mappingFun).collect(Collectors.toList());

    }


    private static void funWithPredicate() {

        Function<String, Predicate<String>> startsWithLetter =
                (String letter) -> {
                    Predicate<String> checkStarts = (String name) -> name.startsWith(letter);
                    return checkStarts;
                };

        startsWithLetter =
                (String letter) -> (String name) -> name.startsWith(letter);

        startsWithLetter =
                (letter) -> (name) -> name.startsWith(letter);

        startsWithLetter.apply("java");

        final List<String> friends =
                Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

        System.out.println(
                friends.stream()
                        .filter(startsWithLetter.apply("N")).count()
        );

        System.out.println(
                friends.stream()
                        .filter(startsWithLetter.apply("B")).count()
        );

    }

}
