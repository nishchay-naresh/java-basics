package com.nishchay.java8.fun;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static com.nishchay.ds.string.freq.StringFrequencyUtility.getFrequencyMapStream;

/*
 *	java.util.function.Supplier<T>	:    () ->   T   :	T get();
 *	T – Type of input argument
 *  does not take any arguments,  returns a value of generified type
 *
 *  typically we use it for lazy evaluation/execution of code
 *
 *
 *	============== BooleanSupplier, IntSupplier, LongSupplier, DoubleSupplier ===================
 *	Java provides following functional interfaces that are used for corresponding primitives data type supplier.
 *	BooleanSupplier: Supplier to return Boolean value. Its method is getAsBoolean().
 *	IntSupplier: Supplier to return integer data type value. Its method is getAsInt().
 *	LongSupplier: Supplier to return long data type value. Its method is getAsLong().
 *	DoubleSupplier: Supplier to return double data type value. Its method is getAsDouble().
 *
 * */

public class SupplierEx {

    public static void main(String[] args) {

        basicEx();
        primitiveSuppliersEx();
        lazyValueEx();
        castSupplier();
        supplierOfObject();

        suppFromAnotherSupplier();
    }


    private static void basicEx() {
        Supplier<String> strSupplier = () -> "dummy";
        System.out.println("strSupplier - " + strSupplier.get());

        String result = Stream.of("java", "python", "go")
                .filter(e -> e.length() > 4)
                .findAny()
                .orElseGet(strSupplier);

        System.out.println("result = " + result);

        Supplier<Integer> integerSupplier = () -> 10;
        System.out.println("integerSupplier - " + integerSupplier.get());

        integerSupplier = () -> new Random().nextInt(100);
        System.out.println("integerSupplier - " + integerSupplier.get());

        //Using Constructor
        Supplier<Random> s1 = Random::new;
        Random random = s1.get();
        System.out.println(random.nextInt(100));

    }

    private static void primitiveSuppliersEx() {
        int age = 30;
        BooleanSupplier bs = () -> age > 20;
        System.out.println(bs.getAsBoolean());

        Random random = new Random();
        IntSupplier is = random::nextInt;
        System.out.println(is.getAsInt());

        LongSupplier ls = random::nextLong;
        System.out.println(ls.getAsLong());

        DoubleSupplier ds = random::nextDouble;
        System.out.println(ds.getAsDouble());
    }

    private static void lazyValueEx() {
        System.out.println("sqr(16) = " + squareLazy(() -> 16.0));
        System.out.println("sqr(13) = " + squareLazy(() -> 13.0));
    }

    // squares a double value. It will not receive a value itself, but a Supplier of this value
    public static double squareLazy(Supplier<Double> lazyValue) {
        return Math.pow(lazyValue.get(), 2);
    }

    private static void supplierOfObject() {

        Supplier<List<Integer>> listSupplier = () -> Arrays.asList(10, 20, 30, 40, 50);
        List<Integer> list = listSupplier.get();
        System.out.println("list = " + list);


        Supplier<Map<String, Long>> mapSupplier = () -> getFrequencyMapStream("java, perl, go, kotlin, java".split(", "));
        Map<String, Long> hm  = mapSupplier.get();
        System.out.println("hm = " + hm);

        // mapSupplier = ConcurrentHashMap::new;
        mapSupplier = () -> new ConcurrentHashMap<>();
        hm  = mapSupplier.get();
        System.out.println("hm = " + hm);

    }

    private static void castSupplier() {

        Supplier<Map<?, ?>> genericMapSupplier = HashMap::new;
        Supplier<Map<String, Integer>> mapSupplier =  castSupplier1(genericMapSupplier);
        System.out.println("map = " + mapSupplier.get());

    }

    private static <L, M> Supplier<Map<L, M>> castSupplier1(Supplier<Map<?, ?>> map) {
        return (Supplier) map;
    }

    // taking one supplier, creation another who does the work of FirstSupplier + something extra piece of code
    private static void suppFromAnotherSupplier() {

        Supplier<String> strSupplier = () -> "dummy";
        System.out.println("strSupplier - " + strSupplier.get());

        AtomicInteger x = new AtomicInteger(10);

        Supplier<String> strSupplier1 = () -> {
            System.out.println("nested");
            x.set(100);
            System.out.println("x = "+ x.get());
            return strSupplier.get();
        };

        System.out.println("strSupplier1 - " + strSupplier1.get());
    }
}
