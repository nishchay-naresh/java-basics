package com.nishchay.core.generics.arraystoreex;


/*
 * Why polymorphic assignment is not allowed for java generic type in collection declaration
 *   Ex :  List<Animal> list = new ArrayList<Dog> giving compilation error
 *
 * Java generics are invariant, which means:
 * List<Dog> is not a subtype of List<Animal> - even though Dog is a subtype of Animal.
 * This is done for type safety.
 *
 * */

import com.nishchay.core.generics.pojo.Animal;
import com.nishchay.core.generics.pojo.Cat;
import com.nishchay.core.generics.pojo.Dog;
import com.nishchay.core.generics.pojo.Rat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericsTypeSafety {
    public static void main(String[] args) {

        genericsBasic();
        allowedInArray();
        notAllowedInCollection();
        howToAllowSafely();
    }

    private static void genericsBasic() {

        // since animals is a List<Animal>, so it can take Animal / co-variant of Animal (its sub-type) / null
        List<Animal> animals = new ArrayList<>();
        animals.add(new Cat());
        animals.add(new Dog());
        animals.add(new Rat());
        animals.add(null);
        animals.add(null);
        System.out.println("animals list size - " + animals.size()); // 5
    }



    /*
     * Problem Statement :
     *   List<Animal> list = new ArrayList<Dog>();
     *   Compiler error - Required type - List<Animal> Provided - ArrayList<Dog>
     *
     * In normal (non-generic) Java, you can do:
     *  Animal a = new Dog();
     *
     * Why This Is Not Allowed :
     *   Java generics are invariant, which means:
     *   List<Dog> is not a subtype of List<Animal> — even though Dog is a subtype of Animal.
     *
     *   Let’s say the compiler did allow this
     *       List<Animal> animals = new ArrayList<Dog>();    // assume this is allowed
     *       animals.add(new Cat());                         // Illegal! You just added a Cat to a Dog list!
     *   you've put a Cat into a list that should only have Dog/Dog's subtype objects — this breaks type safety, terms as heap pollution issue
     *
     * Why throwing error at the compile time only
     *       In generic all type info get erased after the compilation
     *       There is no type info at the runtime, so java can't check the type safety
     *       That's why there is no equivalent Exception here in collection class like one is there for array - ArrayStoreException
     *
     *
     * */

    /*
     *  As this is allowed here in array
     *       Animal[] animalArr = new Dog[5];
     *  To Support this java is doing a type safety check at runtime ( since java have the type info for array)
     *  Failure of this type safety check at runtime will lead to - java.lang.ArrayStoreException
     *
     * */
    private static void allowedInArray() {

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

        // java is doing a type safety check at runtime, in which it is getting failed and causing - java.lang.ArrayStoreException
        animalArr[4] = new Cat();
        animalArr[5] = new Rat();
    }

    private static void notAllowedInCollection() {

        List<Dog> dogList = new ArrayList<>();
        dogList.add(new Dog());
        dogList.add(new Dog());

        for (Dog x : dogList) {
            x.speak();
        }

        // Compiler error - Cannot resolve method 'addMore(List<Dog>)'
        // addMore(dogList);
    }

    private static void addMore(List<Animal> animalList) {
        animalList.add(new Cat());
        animalList.add(new Rat());
    }

    /*
    *
    * How to Allow It Safely? One can use wildcards:
    *       1. Read-only (Covariant)        : <? extends Animal>
    *       2. Write-only (Contravariant)   : <? super Dog>
    *
    *
    * */
    private static void howToAllowSafely() {

        List<Dog> dogList = new ArrayList<>();
        dogList.add(new Dog());
        dogList.add(new Dog());

        List<? extends Animal> animalsReadOnly = new ArrayList<Dog>(dogList);   // allowed
        Animal animal = animalsReadOnly.get(0);                                 // safe to read
        // animalsReadOnly.add(new Dog());                                      // Cannot add (compiler doesn't know exact subtype)
        System.out.println("animal = " + animal);

        List<? super Dog> animalsWriteOnly = new ArrayList<Animal>();   // allowed
        animalsWriteOnly.add(new Dog());                                // Can add Dog or its subclasses
        Object objectRead = animalsWriteOnly.get(0);                    // Only read as Object
        System.out.println("objectRead = " + objectRead);
    }
}

