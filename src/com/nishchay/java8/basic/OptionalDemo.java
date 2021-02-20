package com.nishchay.java8.basic;

public class OptionalDemo {

    public static void main(String[] args) {

        NPEExample();

        optionalDemo();


    }

    private static void NPEExample() {
        User user = findUserById(999);
        // User user = findUserById(555); // Exception in thread "main" java.lang.NullPointerException
        System.out.println(user.getName());
    }

    private static void optionalDemo() {

//        Optional<User> optional = findUserById(999);


    }


    private static User findUserById(int id) {
        User user = null;
        if (id == 999) {
            user = new User(999, "James Gosling");
        }
        return user;
    }

}


class User {

    int id;
    String name;


    public User(int id, String name) {
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
