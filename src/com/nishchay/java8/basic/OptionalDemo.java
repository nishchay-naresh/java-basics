package com.nishchay.java8.basic;

import java.util.Optional;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;

/*
 *   Optional is a container type for a value which may be absent.
 *   Java 8 introduced a new type called Optional<T> to help developers deal with null values properly (avoid NullPointerException)
 *
 * */
public class OptionalDemo {

    public static void main(String[] args) {

        whatIsNull();
        NPEExample();
        whatIsOptional();
        NPESuppressUsingOptional();

        createOptional();
        extractOptional();

        isPresentEx();
        strIdGenerationCheck();

    }

    /*
    * null - is a wrong way to model absent of a value
    *
    * java.util.Optional<T>  is an optional type inspired form the idea of  - mayBe type of Haskell / Optional[T] of Scala
    * A way to model absent of a value
    *
    * Optional<Car> -   A wrapper/Holder class for a value, which can come up with the absent of a value
    *               -   Can give you a Value/absent of a value
    *               -   Car object /  Optional.empty()
    *               -   Forces you unwrap an Optional / deal with the absent of a value
    *
    *
    * */
    private static void whatIsOptional() {
        Optional<User> optionalUser = Optional.of(findUserById(999));
        System.out.println("optionalUser = " + optionalUser);
    }


    /*
     * null -   unknown value
     *      -   absent of a value
     *
     * The null keyword is a literal that represents a null reference,
     * one that does not refer to any object. null is the default value of reference-type variables.
     * */
    private static void whatIsNull() {
        System.out.println(null == null); // Always true
    }

    private static void NPEExample() {
        User user = findUserById(999);
        // User user = findUserById(555); // Exception in thread "main" java.lang.NullPointerException
        System.out.println("name - " + user.getName());

        Optional<User> optionalUser = findUserByIdOptionally(999);
        System.out.println("name - " + optionalUser.map(User::getName));

        optionalUser = findUserByIdOptionally(555);
        System.out.println("name - " + optionalUser.map(User::getName)); // Now no java.lang.NullPointerException

    }

    // The client is now forced by the type system to write the Optional check in his code.
    private static void NPESuppressUsingOptional() {
        User user = findUserById(999);
        Optional<User> userOptional = Optional.of(user);

        if (userOptional.isPresent()) {
            System.out.println("User detail - " + userOptional.get());
        } else {
            System.out.println("Optional is empty");
        }

        // checking container for value preset - using Consumer
        userOptional.ifPresent(v -> System.out.println("User detail - " + v));

    }

    /*
     * Return tpe User, indicates that it will always return a User
     * No Way this function is telling its client that, User could be null
     * */
    private static User findUserById(int id) {
        User user = null;
        if (id == 999) {
            user = new User(999, "Iron Man");
        }
        return user;
    }

    /*
     *   By returning Optional<User> from the function, we have made it clear to the clients of this function that
     *   there might not be a User with the given userId.
     *   Now the clients of this function are explicitly forced to handle this fact.
     * */
    private static Optional<User> findUserByIdOptionally(int id) {
        Optional<User> optionalUser = Optional.empty();

        if (id == 999) {
            // create an Optional with a non-null value
            optionalUser = Optional.of(new User(999, "Iron Man"));
        }
        return optionalUser;
    }


    private static void createOptional() {

        //1. Create an empty Optional, which describes the absence of a value.
        Optional<User> emptyOptional = Optional.empty();
        Optional<User> emptyOptionalFromNull = Optional.ofNullable(null);// empty Optional
        if (emptyOptional.equals(emptyOptionalFromNull)) {
            System.out.println("Optional.empty() & optional.ofNullable(null) = Optional.empty");
        }

        //2. create an Optional with a non-null value : Optional.of() - value / NullPointerException
        Optional<User> optionalUser = Optional.of(findUserById(999));
        System.out.println("optionalUser = " + optionalUser);
        // Optional<User> userOptional = Optional.of(null); // Exception in thread "main" java.lang.NullPointerException

        //3. Create an Optional with a value which may or may not be null : Optional.ofNullable() - value / empty optional
        optionalUser = Optional.ofNullable(findUserById(111));
        System.out.println("empty optional = " + optionalUser);
        optionalUser = Optional.ofNullable(findUserById(999));
        System.out.println("userOptional = " + optionalUser);
    }

    private static void extractOptional() {

        // Filtering values using filter() method
        boolean isIronMan = findUserByIdOptionally(999).filter(e -> e.getName().equalsIgnoreCase("iron man")).isPresent();
        System.out.println("isIronMan = " + isIronMan);


        /*
        * 1. Retrieving optional using get()
        *  get() -  simplest , but least safe method
        *           returns a value / NoSuchElementException
        *           get() method returns a value if it is present, otherwise it throws NoSuchElementException.
        *
        * */
        Optional<User> optionalUser = findUserByIdOptionally(999);
        System.out.println("Optional.get() - " + optionalUser.orElse(null));

        /* Below code will throw NoSuchElementException
        System.out.println("Optional.get() - " + Optional.ofNullable(findUserById(111)).get());
        String name = (String) Optional.empty().get();
        name = (String) Optional.ofNullable(null).get();
        */

        //2. Retrieving optional using orElse(), orElseGet() & orElseThrow() method
        int userId = 111;
        User user = Optional.ofNullable(findUserById(userId)).orElse(new User(0, "Default User"));
        System.out.println("Optional.orElse() - " + user);

        user = Optional.ofNullable(findUserById(userId)).orElseGet(() -> new User(0, "Default User"));
        System.out.println("Optional.orElseGet() - " + user);

        /*
         * ==============  orElse() vs orElseGet() =============
         * orElse() -       passing an default value/Object for empty optional
         *                  performance impact - one object gets created every time, irrespective of optional value
         *
         * orElseGet() -    pass a Supplier function for empty optional
         *                  performance impact - supplier function will only get invoked for empty optional, then only object will get created
         *
         * orElseThrow() -  similar to get() methods, Throw an exception on absence of value
         *                  It allows you to choose the type of exception that you want to throw
         *
         * */

        user = findUserByIdOptionally(userId).orElseThrow(
                () -> new RuntimeException("User not found with userId " + userId)
        );
        System.out.println("Optional.orElseThrow() - " + user);
    }

    private static void isPresentEx() {

        Consumer<String> stringConsumer = (s) -> System.out.println("value stored in Optional object = " + s);

        Optional<String> stringOptional = Optional.of("java-8");
        System.out.println("When a value is present - ");
        stringOptional.ifPresent(stringConsumer);

        System.out.println("When no value is present - ");
        stringOptional = Optional.ofNullable(null);
        stringOptional.ifPresent(stringConsumer);

        System.out.println("---------------------------------------");

        Consumer<User> userSalaryConsumer = (user) -> {
            if (user.getId() == 999) {
                System.out.println("User salary is - 9999");
            } else {
                System.out.println("User salary is - 0");
            }
        };

        findUserByIdOptionally(999).ifPresent(userSalaryConsumer);
        Optional.of(new User(555, "Bat Man")).ifPresent(userSalaryConsumer);
    }


    private static void strIdGenerationCheck() {
        String idFromDB = new Random().nextInt(100) % 2 == 0 ? "id from DB - 999" : null;

        AtomicLong idCounter = new AtomicLong(554L);
        String id = Optional.ofNullable(idFromDB).orElseGet(() -> "generated id - " + idCounter.incrementAndGet());
        System.out.println(id);
    }

    static class User {

        private final int id;
        private final String name;

        User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", id=" + id +
                    '}';
        }
    }

}