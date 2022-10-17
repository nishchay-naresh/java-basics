package com.nishchay.core.objectclazz;

import java.util.Objects;
import java.util.Random;


public class ObjectsMethodDemo {

    public static void main(String[] args) {

//        toStringEx();
//        equalsEx();
        requireNonNullEx();

    }




    private static void toStringEx() {

        Pair<String, String> p1 = new Pair<>("java8", "Functional Programming");
        Pair<String, String> p2 = new Pair<>("java7", "Objects class");

        System.out.println(p1);
        System.out.println(p2);

    }

    private static void equalsEx() {

        Pair<String, String> p1 = new Pair<>("java8", "Functional Programming");
        Pair<String, String> p2 = new Pair<>("java8", "Functional Programming");
        Pair<String, String> p3 = new Pair<>("java8", "Functional Programming");

        System.out.println("p1.equals(p2) = " + p1.equals(p2));
        System.out.println("p2.equals(p3) = " + p2.equals(p3));

        System.out.println("Objects.deepEquals(p1,p2) = " + Objects.deepEquals(p1,p2));
        System.out.println("Objects.deepEquals(p2,p3) = " + Objects.deepEquals(p2,p3));

    }

    private static void requireNonNullEx() {

        Pair<String, String> pair;

        Pair<String, String> pair1 = Objects.requireNonNull(new Pair<>("java8", "Functional Programming"));
        System.out.println("pair1 = " + pair1);

        pair = Objects.requireNonNull(null, "Pair is null");
        System.out.println("pair = " + pair);

        //  pair = Objects.requireNonNull(null);
        //  System.out.println("pair = " + pair);
    }

    private static Pair<String, String> getPair() {
        boolean unknownCondition = new Random().nextInt(100) % 2 == 0;
        if (unknownCondition) {
            return new Pair<>("java8", "Functional Programming");
        }
        return null;
    }

    static class Pair<K, V> {
        public K key;
        public V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Pair {key = " + Objects.toString(key) + ", value = " +
                    Objects.toString(value, "no value") + "}";

        /* without Objects.toString(Object o) and
         Objects.toString(Object o, String nullDefault) method
         return "Pair {key = " + (key == null ? "null" : key.toString()) +
     ", value = " + (value == null ? "no value" : value.toString()) + "}"; */
        }

        @Override
        public int hashCode(){
            return (Objects.hashCode(key) ^ Objects.hashCode(value));

            /* without Objects.hashCode(Object o) method
            return (key == null ? 0 : key.hashCode()) ^
            (value == null ? 0 : value.hashCode()); */
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair<?, ?> pair = (Pair<?, ?>) o;

            if (!key.equals(pair.key))
                return false;
            return value.equals(pair.value);
        }
    }
}
