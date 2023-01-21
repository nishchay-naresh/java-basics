package com.nishchay.java8.streams.flatmap;

import com.nishchay.util.pojo.Author;
import com.nishchay.util.pojo.Country;

import java.util.Optional;


public class OptionalMapDemo {

    public static void main(String[] args) {

        mapExample1();
        mapExample2();

        flatMapExample1();
        flatMapExample2();

    }


    private static void mapExample1() {

        //Creating Optional object from a String
        Optional<String> language = Optional.ofNullable("Java Programming");
        //Optional.empty() creates an empty Optional object
        Optional<String> nothing = Optional.empty();

        System.out.println(language);
        System.out.println(language.map(String::toLowerCase));
        System.out.println(nothing);
        System.out.println(nothing.map(String::toLowerCase));

        Optional<String> nullOptional = Optional.ofNullable(null);
        Optional<String> output = nullOptional.flatMap(value -> Optional.of("No Value"));
        System.out.println("output value : " + output);


        Optional<String> optional1 = Optional.ofNullable("Hello Java 8");
        Optional<Optional<String>> optional2 = Optional.of(optional1);
        System.out.println("Optional2 value : " + optional2);

        Optional<Optional<String>> mapOutput = optional2.map(e -> e.map(String::toUpperCase));
        System.out.println("Optional.map: " + mapOutput);


        // System.out.println("Optional.flatMap: " + optional2.flatMap(e -> e.map(String::toUpperCase)));
        Optional<String> flatMapOutput = optional2.flatMap(value -> value.map(String::toLowerCase));
        System.out.println("Optional.flatMap : " + flatMapOutput);
        System.out.println("Optional.flatMap : " + optional2.flatMap(e -> e));
        //Optional<Optional<String>>  ->  flatMap -> Optional<String>

    }

    private static void mapExample2() {

        Author author = new Author();
        author.setName("Dan Brown");
        Optional<Author> authorOptional = Optional.ofNullable(author);

        // map() applies the Function argument to the value, then returns the result wrapped in an Optional.
        Optional<String> name = authorOptional.map(a -> a.getName());
        if (author.getName().equals(name.orElse("Default Name"))) {
            System.out.println("name - " + name.get());
        }

    }

    // Extracting and transforming values using map()
    // map() applies the Function argument to the value, then returns the result wrapped in an Optional.
    private static void flatMapExample1() {

        /*
         * Solving below situation the map method
         *	if(user != null) {
         *		Address address = user.getAddress();
         *		if(address != null && address.getCountry().equalsIgnoreCase("India")) {
         *			System.out.println("User belongs to India");
         *		}
         *	}
         * */

        Author author = new Author();
        author.setName("Chetan Bhagat");
        author.setCountry(new Country("India"));

        Optional<Author> authorOptional = Optional.ofNullable(author);

        // Option<Author>  ->  map ->  Option<Country>
        authorOptional.map(auth -> auth.getCountry())
                .filter(country -> country.getName().equalsIgnoreCase("India"))
                .ifPresent(e -> System.out.println("Indian Author"));


        // Option<Author> -> flatMap -> Option<Country> -> flatMap -> Option<String> -> map -> Option<String>
        String name = Optional.ofNullable(author)
                .flatMap(u -> u.getCountryOptionally())
                .flatMap(a -> a.getNameOptionally())
                .map(e -> e.toUpperCase())
                .orElse("default");

        if ("INDIA".equals(name)) {
            System.out.println("name = " + name);
        }
    }


    private static void flatMapExample2() {

        Optional<String> optional1 = Optional.of("Hello Java 8");
        Optional<Optional<String>> optional2 = Optional.ofNullable(optional1);
        Optional<Optional<Optional<String>>> optional3 = Optional.ofNullable(optional2);

        System.out.println("optional3 value : " + optional3);

        String actualString = optional3.flatMap(v3 -> v3)
                .flatMap(v2 -> v2)
                .get();
        System.out.println("actualString = " + actualString);

        Optional<String> output = optional3.flatMap(value -> value.flatMap(v -> {
            if (v.get().contains("Java 8")) {
                return Optional.of("Yes, Java 8 is found.");
            }
            return Optional.empty();
        }));

        System.out.println("output value : " + output);
    }

}
