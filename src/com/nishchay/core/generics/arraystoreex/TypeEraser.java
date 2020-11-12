package com.nishchay.core.generics.arraystoreex;

import java.util.ArrayList;
import java.util.List;

public class TypeEraser {

    public static void main(String[] args) {

        List<Dog> list = new ArrayList<>();

        list.add(new Dog());
        list.add(new Dog());

        for (Dog x : list) {
            x.speak();
        }

//        Compiler error - Required type - List<Animal> Provided - ArrayList<Dog>
//        addMore(list);
    }

    private static void addMore(List<Animal> animalList) {

        animalList.add(new Cat());
        animalList.add(new Bird());

        System.out.println("animalList = " + animalList);

    }


}
