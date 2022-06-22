package com.nishchay.java8.fun;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class SupplierEx {

    public static void main(String[] args) {

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
}
