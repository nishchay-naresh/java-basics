package com.nishchay.java8.fun;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class SupplierEx {

    public static void main(String[] args) {

        basicEx();
        castSupplier();

        suppFromAnotherSupplier();
    }


    private static void basicEx() {
        Supplier<String> strSupplier = () -> "dummy";
        System.out.println("strSupplier - " + strSupplier.get());

        Supplier<Integer> integerSupplier = () -> 10;
        System.out.println("integerSupplier - " + integerSupplier.get());


        String result = Stream.of("java", "python", "go")
                .filter(e -> e.length() > 4)
                .findAny()
                .orElseGet(strSupplier);

        System.out.println("result = " + result);
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
