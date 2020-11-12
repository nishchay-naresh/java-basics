package com.nishchay.core.generics.arraystoreex;

import java.util.Arrays;

public class ArrayStoreExcDemo {

    public static void main(String[] args) {

        Animal[] animalArr = new Dog[5];
        animalArr[0] = new Dog();
        animalArr[1] = new Dog();
        animalArr[2] = new Dog();

        System.out.println("animalArr = " + Arrays.toString(animalArr));

        for (int i = 0; i < 3; i++) {
            animalArr[i].speak();
        }
        addMore(animalArr);

    }

    private static void addMore(Animal[] animalArr) {
        /*
         * Below statement will cause to java.lang.ArrayStoreException
         * Compiler knows array type at runtime, so it is throwing a runtime exception - ArrayStoreException
         * */
        animalArr[4] = new Cat();
        animalArr[5] = new Bird();

    }


}






