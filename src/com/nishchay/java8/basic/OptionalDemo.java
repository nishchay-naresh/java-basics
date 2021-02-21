package com.nishchay.java8.basic;

import java.util.Optional;

public class OptionalDemo {

    public static void main(String[] args) {

        NPEExample();
        NPESuppressUsingOptional();

        optionalDemo();


    }

    private static void NPEExample() {
        User user = findUserById(999);
        // User user = findUserById(555); // Exception in thread "main" java.lang.NullPointerException
        System.out.println(user.getName());
    }

    private static void NPESuppressUsingOptional() {
        User user = findUserById(999);
        Optional<User> userOptional = Optional.ofNullable(user);

        if (userOptional.isPresent()) {
            System.out.println("Value found - " + userOptional.get());
        } else {
            System.out.println("Optional is empty");
        }

        userOptional.ifPresent(value -> {
            System.out.println("Value found - " + value);
        });

    }

    private static void optionalDemo() {

        Optional<User> userOptional = findUserByIdOptionally(555);


    }

    private static Optional<User> findUserByIdOptionally(int id) {

        Optional<User> emptyOptional = Optional.empty();

        if (id == 555) {
            User user = new User(555, "Iron Man");
            Optional<User> userOptional = Optional.of(user);
            return userOptional;
        }
        return emptyOptional;
    }

    private static User findUserById(int id) {
        User user = null;
        if (id == 999) {
            user = new User(999, "Iron Man");
        }
        return user;
    }

}


class User {

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
