package com.nishchay.java8.basic;

import java.util.Optional;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

/*
 *   Optional is a container type for a value which may be absent.
 *   Java 8 introduced a new type called Optional<T> to help developers deal with null values properly (avoid NullPointerException)
 *
 * */
public class OptionalDemo {

    private static final AtomicLong instanceId = new AtomicLong(0L);

    public static void main(String[] args) {

        whatIsNull();
        NPEExample();
        NPESuppressUsingOptional();

        optionalDemo();
        strValueCheck();

    }

    private static void whatIsNull() {
        // null -  unknown value
        // The null keyword is a literal that represents a null reference,
        // one that does not refer to any object. null is the default value of reference-type variables.
        System.out.println(null == null); // Always true
    }


    private static void NPEExample() {
        User user = findUserById(999);
        // User user = findUserById(555); // Exception in thread "main" java.lang.NullPointerException
        System.out.println(user.getName());
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

    // The client is now forced by the type system to write the Optional check in his code.
    private static void NPESuppressUsingOptional() {
        User user = findUserById(999);
        Optional<User> userOptional = Optional.of(user);

        // checking container for value preset - using loop
        if (userOptional.isPresent()) {
            System.out.println("Value found - " + userOptional.get());
        } else {
            System.out.println("Optional is empty");
        }

        // checking container for value preset - using Consumer
        userOptional.ifPresent(value -> {
            System.out.println("Value found - " + value);
        });

    }

    /*
     *   By returning Optional<User> from the function, we have made it clear to the clients of this function that
     *   there might not be a User with the given userId.
     *   Now the clients of this function are explicitly forced to handle this fact.
     * */
    private static Optional<User> findUserByIdOptionally(int id) {

        Optional<User> emptyOptional = Optional.empty();

        if (id == 555) {
            User user = new User(555, "Iron Man");
            Optional<User> userOptional = Optional.ofNullable(user);
            return userOptional;
        }
        return emptyOptional;
    }


    private static void strValueCheck() {
        String id = getId();
        id = Optional.ofNullable(id).orElseGet(() -> "default id - " + instanceId.incrementAndGet());
        System.out.println("cacheName = " + id);
    }

    private static String getId() {
        return new Random().nextInt(100) % 2 == 0 ? "idIsThere - 99" : null;
    }

    private static void optionalDemo() {

        // Create an empty Optional, which describes the absence of a value.
        Optional<User> emptyOptional = Optional.empty();
        System.out.println("emptyOptional = " + emptyOptional);
        System.out.println(emptyOptional.equals(Optional.ofNullable(null)));


        // create an Optional with a non-null value -
        User user1 = findUserById(999);
        Optional<User> userOptional1 = Optional.of(user1);
        //If the argument supplied to Optional.of() is null, then it will throw a NullPointerException immediately and the Optional object won’t be created.
        // Optional<User> userOptional = Optional.of(null); // Exception in thread "main" java.lang.NullPointerException
        System.out.println("userOptional1 = " + userOptional1);

        // Create an Optional with a value which may or may not be null -

//        User user2 = findUserById(999);
        User user2 = findUserById(111);
        Optional<User> userOptional2 = Optional.ofNullable(user2);
        // If the argument passed to Optional.ofNullable() is non-null, then it returns an Optional containing the specified value,
        // otherwise it returns an empty Optional.
        System.out.println("userOptional2 = " + userOptional2);

        Optional<User> userOptional3 = Optional.ofNullable(null);// empty Optional
        System.out.println("userOptional3 = " + userOptional3);

        // Retrieving the value using get() method
        // Optional’s get() method returns a value if it is present, otherwise it throws NoSuchElementException.
        // Below code will throws NoSuchElementException
        // System.out.println("Optional.get() - " + userOptional2.get());
        // String name1 = (String) Optional.empty().get();
        // String name2 = (String) Optional.ofNullable(null).get();


        // Returning default value using orElse()
        // return "Unknown User" if user is null
        User finalUser = userOptional3.orElse(new User(0, "Unknown User"));
        System.out.println("Optional.orElse() - " + finalUser);
        // performance impact - one object gets created every time, irrespective of optional value

        // Returning default value using orElseGet()
        // Unlike orElse(), which returns a default value directly if the Optional is empty,
        // orElseGet() allows you to pass a Supplier function which is invoked when the Optional is empty.
        // means we need to pass a method call, rather a direct value
        User returnUser = userOptional3.orElseGet(() -> new User(0, "default User"));
        System.out.println("Optional.orElseGet() - " + returnUser);

        // orElseThrow() - Throw an exception on absence of a value
//         int userId = 111;
        int userId = 555;
        Optional<User> returnUserOptional = findUserByIdOptionally(userId);
        User returnUser1 = returnUserOptional.orElseThrow(
                () -> new RuntimeException("User not found with userId " + userId)
        );
        System.out.println("Optional.orElseThrow() - " + returnUser1);

        // Filtering values using filter() method
        boolean isIronMan = returnUserOptional.filter(user -> user.getName().equalsIgnoreCase("iron man")).isPresent();
        System.out.println("isIronMan = " + isIronMan);

    }

    static class User {

        private int id;
        private String name;


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