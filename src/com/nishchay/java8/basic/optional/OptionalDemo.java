package com.nishchay.java8.basic.optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;

/*
 *
 * =========================== Method Description ==============================
 * empty()			Returns an empty Optional instance
 * filter()		    If the value is present and matches the given predicate, returns this Optional; otherwise returns the empty one
 * flatMap()		If a value is present, returns the Optional resulting from the application of the provided mapping function to it;
 *                  otherwise returns the empty Optional
 * get()			Returns the value wrapped by this Optional if present; otherwise throws a NoSuchElementException
 * ifPresent()		If a value is present, invokes the specified consumer with the value; otherwise does nothing
 * isPresent()		Returns true if there is a value present; otherwise false
 * map()			If a value is present, applies the provided mapping function to it
 * of()			    Returns an Optional wrapping the given value or throws a NullPointerException if this value is null
 * ofNullable()	    Returns an Optional wrapping the given value or the empty Optional if this value is null
 * orElse()		    Returns the value if present or the given default value otherwise
 * orElseGet()	 	Returns the value if present or the one provided by the given Supplier otherwise
 * orElseThrow()	Returns the value if present or throws the exception created by the given Supplier otherwise
 *
 * https://www.baeldung.com/java-optional
 *
 * */

public class OptionalDemo {

    public static void main(String[] args) {

        whatIsNull();
        whatIsOptional();
        System.out.println("---------------------------------------");
        suppressNPEUsingOptional();

        createOptional();
        System.out.println("---------------------------------------");
        checkOptional();
        System.out.println("---------------------------------------");
        extractOptional();
        System.out.println("---------------------------------------");
        optionalStreamMethods();
        givenOptional_whenMapWorks_thenCorrect();

        System.out.println("---------------------------------------");
        strIdGenerationCheck();
    }

    /*
     *
     * What is null?
     *      -   unknown value
     *      -   absent of a value
     *      -   null is the default value of reference-type variables
     *
     * The null is a wrong way to model absent of a value
     *
     * The null keyword is a literal that represents a null reference, One that does not refer to any object.
     * */
    private static void whatIsNull() {
        System.out.println(null == null); // always true
    }

    /*
     *  null - is a wrong way to model absent of a value
     *
     *  java.util.Optional<T>  is an optional type inspired form the idea of - mayBe type of Haskell / Optional[T] of Scala
     *      - A way to model absent of a value
     *      - Help developers to deal with null values properly (avoid NullPointerException)
     *
     *  Optional<Car>   -   A wrapper/Holder class for a value, which indicates value may or may not be present
     *                  -   Can give you a value/absent of a value
     *                  -   Car object / Optional.empty()
     *                  -   It forces you to handle absence safely
     *                  -   Forces you to unwrap an Optional / deal with absent of a value
     *
     * */
    private static void whatIsOptional() {
        Optional<User> optionalUser = Optional.of(findUserById(999));
        System.out.println("optionalUser = " + optionalUser.get());
    }

    // The client is now forced by the type system to write the Optional check in his code.
    private static void suppressNPEUsingOptional() {
        User user = findUserById(555);
        // System.out.println("name - " + user.getName()); // Exception in thread "main" java.lang.NullPointerException

        // ofNullable() - when value may be null
        Optional<User> userOptional = Optional.ofNullable(user);

        if (userOptional.isPresent()) {
            System.out.println("User detail - " + userOptional.get());
        } else {
            System.out.println("Optional is empty");
        }
    }

    /*
     * ========================= create Optional ===========================
     *
     * 1. Create an empty Optional, which describes the absence of a value.
     *       empty()         -   Returns an empty Optional instance.
     *
     * 2. create an Optional with a non-null value : Optional.of() - value / NullPointerException
     *       of()            -  Returns an Optional wrapping the given value or throws a NullPointerException if this value is null
     *
     * 3. Create an Optional with a value which may or may not be null : Optional.ofNullable() - value / empty optional
     *       ofNullable()    -	Returns an Optional wrapping the given value or the empty Optional if this value is null
     *
     * */
    private static void createOptional() {
        Optional<User> emptyOptional = Optional.empty();
        Optional<User> emptyOptionalFromNull = Optional.ofNullable(null);// empty Optional
        if (emptyOptional.equals(emptyOptionalFromNull)) {
            System.out.println("Optional.ofNullable(null) == Optional.empty");
        }

        Optional<User> optionalUser = Optional.of(findUserById(999));
        System.out.println("optionalUser = " + optionalUser);
        // Optional<User> userOptional = Optional.of(null); // Exception in thread "main" java.lang.NullPointerException

        optionalUser = Optional.ofNullable(findUserById(111));
        System.out.println("empty optional = " + optionalUser);
        optionalUser = Optional.ofNullable(findUserById(999));
        System.out.println("userOptional = " + optionalUser);
    }

    /*
     * ========================= check Optional ===========================
     * public boolean isPresent()
     *              -   Returns true if there is a value present; otherwise false
     * public void ifPresent(Consumer<? super T> action)
     *              -   If a value is present, invokes the specified consumer; otherwise does nothing
     * */
    private static void checkOptional() {
        Optional<String> empty = Optional.empty();
        System.out.println("AbsentOptional.isPresent()  - " + empty.isPresent());
        Optional<String> stringOptional = Optional.of("java-8");
        System.out.println("PresentOptional.isPresent() - " + stringOptional.isPresent());

        Consumer<String> stringConsumer = (s) -> System.out.print("value stored in Optional object = " + s);

        System.out.print("When value is present - ");
        stringOptional.ifPresent(stringConsumer);
        System.out.println();

        System.out.println("When value is absent - does nothing");
        empty.ifPresent(stringConsumer);

        Consumer<User> userConsumer = (user) -> System.out.println("User Details : " + user);
        Optional<User> userOptional = Optional.of(findUserById(999));
        userOptional.ifPresent(userConsumer);
    }


    /*
     * ========================================= extract Optional ====================================================
     *
     * get()			value / throws a NoSuchElementException
     * orElse(-)		value / default value
     * orElseGet(-)	    value / default value Supplier
     * orElseThrow(-)	value / throws a exception Supplier
     *
     * ==================  orElse() vs orElseGet() ==================
     * orElse(T)    -       passing a default value/Object for empty optional
     *                      performance impact - one object gets created every time, irrespective of optional value
     *
     * orElseGet(Supplier<T> ) -    pass a Supplier function for empty optional
     *                              performance impact - supplier will only get evaluated for empty optional, then only object will get created
     *
     * orElseThrow(Supplier<X>)throws X -   similar to get() methods, Throw an exception on absence of value
     *                                      It allows you to choose the type of exception that you want to throw
     *
     * */
    private static void extractOptional() {

        Optional<User> optionalUser = findUserByIdOptionally(999);
        System.out.println("Optional.get() - " + optionalUser.get());

        int userId = 111;
        User user = Optional.ofNullable(findUserById(userId)).orElse(new User(0, "Default User"));
        System.out.println("Optional.orElse() - " + user);

        user = Optional.ofNullable(findUserById(userId)).orElseGet(() -> new User(0, "Default User"));
        System.out.println("Optional.orElseGet() - " + user);

        /*
        // cause  - Exception in thread "main" java.lang.RuntimeException: User not found with userId 111
        user = findUserByIdOptionally(userId).orElseThrow(() -> new RuntimeException("User not found with userId " + userId));
        System.out.println("Optional.orElseThrow() - " + user);
        */
    }

    /*
     * ======================  Optional Stream Methods ============================
     * These methods decide what happens to the value inside the box.
     *
     * map()    -   Mainly used to transform Optional<A> to Optional<B>
     *              If a value is present, applies the provided mapping function to it
     *
     * flatMap() -  Avoid nested Optional
     *              If a value is present, returns the Optional resulting from the application of the provided mapping function to it;
     *              otherwise returns the empty Optional
     *
     * filter()  -  Keeps the value only if it satisfies a condition
     *              If the value is present and matches the given predicate, returns this Optional; otherwise returns the empty one
     *
     * */
    private static void optionalStreamMethods() {
        Optional<String> nonEmptyGender = Optional.of("male");
        Optional<String> emptyGender = Optional.empty();

        System.out.println("Non-Empty Optional  =   " + nonEmptyGender.map(String::toUpperCase));
        System.out.println("Empty Optional      =   " + emptyGender.map(String::toUpperCase));

        Optional<String> name = Optional.of("java");
        Optional<Integer> length = name.map(String::length);
        System.out.println("length              = " + length);

        Optional<Optional<String>> nonEmptyOptionalGender = Optional.of(Optional.of("male"));
        System.out.println("Optional value      =   " + nonEmptyOptionalGender);
        System.out.println("Optional.map        =   " + nonEmptyOptionalGender.map(gender -> gender.map(String::toUpperCase)));
        System.out.println("Optional.flatMap    =   " + nonEmptyOptionalGender.flatMap(gender -> gender.map(String::toUpperCase)));

        Optional<String> gender = Optional.of("MALE");
        System.out.println(gender.filter(g -> g.equals("male"))); //Optional.empty
        System.out.println(gender.filter(g -> g.equalsIgnoreCase("MALE"))); //Optional[MALE]
        System.out.println(emptyGender.filter(g -> g.equalsIgnoreCase("MALE"))); //Optional.empty
    }

    public static void givenOptional_whenMapWorks_thenCorrect() {
        List<String> companyNames = Arrays.asList(
                "paypal", "oracle", "microsoft", "google", "apple");
        Optional<List<String>> listOptional = Optional.of(companyNames);

        int size = listOptional                     // Optional<List<String>>
                .map(List::size)                    // Optional<int>
                .orElse(0);                   // value != null ? value : other;
        System.out.println(size == 5 ? size : 0);
    }

    private static void strIdGenerationCheck() {
        String idFromDB = new Random().nextInt(100) % 2 == 0 ? "id from DB - 999" : null;

        AtomicLong idCounter = new AtomicLong(554L);
        String id = Optional.ofNullable(idFromDB).orElseGet(() -> "generated id - " + idCounter.incrementAndGet());
        System.out.println(id);
    }

    /*
     * Return type User, indicates that it will always return a User
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