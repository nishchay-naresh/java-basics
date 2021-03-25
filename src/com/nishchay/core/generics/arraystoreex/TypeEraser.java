package com.nishchay.core.generics.arraystoreex;

import java.util.ArrayList;
import java.util.List;

public class TypeEraser {

    public static void main(String[] args) {

        genericsBasic();
        typeEraserEx();

    }

    private static void genericsBasic() {

        List<Animal> zoo= new ArrayList<>();
        zoo.add(new Cat());
        zoo.add(new Dog());
        zoo.add(new Bird());
        System.out.println("size - " + zoo.size());

        // What is the size of list? - 3
        // Why there will be Compiling issue? - No
        // How to add cat and Dog object into zoo list? -  just have a list of type Animal
    }

    private static void typeEraserEx() {
        List<Dog> list = new ArrayList<>();

        list.add(new Dog());
        list.add(new Dog());


        for (Dog x : list) {
            x.speak();
        }

        // Compiler error - Required type - List<Animal> Provided - ArrayList<Dog>
        // addMore(list);
    }
    private static void addMore(List<Animal> animalList) {

        animalList.add(new Cat());
        animalList.add(new Bird());

        System.out.println("animalList = " + animalList);

    }


}
