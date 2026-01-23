package com.nishchay.java8.fun;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
public class A01FunctionEx {

    public static void main(String[] args) {

        applyEx();
        System.out.println(".....................");
        identityEx();
        System.out.println(".....................");
        identityEx_toMap();

        funAsParameter();
        funWithPredicate();

        System.out.println("---------Composing Functions--------");
        funcCompositionEx();

        functionExWithGenerics();
    }

    /*
     * apply() - abstract method, used to execute/evaluate the function
     *
     *  output = function.apply(input)
     *  throw java.lang.NullPointerException if mapping function is null
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
        Function<String, Integer> funStrLength = x -> x.length();
        System.out.println(funStrLength.apply("java")); // 4

        // Storing a method to a FI reference type
        funStrLength = Integer::parseInt;
        System.out.println(funStrLength.apply("10")); // 10

        // Function which takes an Integer and returns List<Integer>
        Function<Integer, List<Integer>> oneToMany = e -> Arrays.asList(e - 1, e + 1);
        System.out.println(oneToMany.apply(10)); // [9, 11]
    }


    /*
     * identity() – static method returns a function that returns its only argument
     * T -> T: input -> output
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
        List<String> stringList = Arrays.asList("java", "python", "go", "spring", "kafka");

        // frequency use case - using Function.identity() in Collectors.toMap for keyholder
        Map<String, Long> freqMap = stringList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("freqMap = " + freqMap);

        // creating a Map<String, String.length()> from List<String>
        Map<String, Integer> map = stringList.stream()
                .collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println("map = " + map);
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
     *      <T>  ->   t   ->    mappingFun.apply(t)   ->  r   ->      List<R>
     * */
    public static <T, R> List<R> map(List<T> list, Function<T, R> mappingFun) {
        // return list.stream().map(e -> mappingFun.apply(e)).collect(Collectors.toList());
        return list.stream().map(mappingFun).collect(Collectors.toList());
    }

    /*
     *  ============== Composing Functions =================
     *
     *  Functional style of programming
     *  Compose functions together -> Composability
     *
     *  Now we can have a function which is composed of two other functions
     *  Big Function = small function + andThen()/compose() + another small function
     *
     *  - andThen() - returns a composed function wherein the parameterized function will be executed after the first one.
     *  - throws NullPointerException if the parameterized function is null
     *
     *  - compose() - returns a composed function wherein the parameterized function will be executed first and then the first one.
     *  - throws NullPointerException if the parameterized function is null
     *
     *      x.andThen(y) is the same as y.compose(x)
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

    private static void funWithPredicate() {

        Function<String, Predicate<String>> startsWithAWord =
                (String word) -> {
                    Predicate<String> checkStarts = (String line) -> line.startsWith(word);
                    return checkStarts;
                };
        // startsWithAWord = (String word) -> (String name) -> name.startsWith(word);
        // startsWithAWord = (word) -> (name) -> name.startsWith(word);

        Predicate<String> startsWith = startsWithAWord.apply("java");
        System.out.println(startsWith.test("java 8 enable functional programming"));        // true
        System.out.println(startsWith.test("functional programming enabled in java 8"));    // false

        final List<String> friends =
                Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

        System.out.println(
                friends.stream()
                        .filter(startsWithAWord.apply("N")).count()
        );

        System.out.println(
                friends.stream()
                        .filter(startsWithAWord.apply("B")).count()
        );
    }


    private static void functionExWithGenerics() {

        Map<Number, CharSequence> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");

        Function<Iterable<Number>, Iterable<? extends Map.Entry<Number, CharSequence>>> mappingFunction = numbers -> map.entrySet();
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
}
