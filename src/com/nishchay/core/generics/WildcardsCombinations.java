package com.nishchay.core.generics;

import com.nishchay.core.generics.pojo.Animal;
import com.nishchay.core.generics.pojo.Dog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 *  ? - Wildcard means Unknown type
 *
 *	1. <?>              -   Unbounded Wildcard
 *                      -   ? means unknown type — can read only (as Object), not write (except null)
 *
 *	2. <? extends T>    -   Upper Bounded Wildcard
 *                      -   Accepts T or any subclass of T.
 *                      -   Good for reading (as T), you cannot add items except null.
 *
 *	3. <? super T>      -   Lower Bounded Wildcard
 *                      -   Accepts T or any superclass of T.
 *                      -   Good for adding elements of type T or its subtypes.
 *                      -   Reading returns Object.
 *
 *	4. PECS rule        -   Producer Extends, Consumer Super
 *                          Use extends when    :   only need to read data (it's a producer)
 *                          Use super when      :   only need to write data (it's a consumer)
 *
 * extends / <?>    -   read
 * super            -   write
 *
 *	Name					Wildcard Syntax		Meaning					CanAdd			Can Read As
 * -------------------------------------------------------------------------------------------------------
 *	Unbounded				<T>					any object type			✅T				✅T
 *	Upper Bounded			<T extends X>		X or any subtype		✅X/X subtype	✅X/Object
 *	Unbounded Wildcard		<?>					Any type				❌(null only)	Object
 *	Upper Bounded Wildcard	<? extends T>		T or any subtype		❌(null only)	T
 *	Lower Bounded Wildcard	<? super T>			T or any supertype		✅ T			Object
 *
 * */
public class WildcardsCombinations {

    public static void main(String[] args) {

        unboundedWildcardEx();
        System.out.println("---------------------------------");
        upperBoundedWildcardEx();
        System.out.println("---------------------------------");
        lowerBoundedWildcardEx();
    }

    private static void unboundedWildcardEx() {
        List<String> names = Arrays.asList("java", "generics");
        List<Integer> numbers = Arrays.asList(1, 2, 3);

        printList(names);
        printList(numbers);
    }

    private static void upperBoundedWildcardEx() {
        List<Integer> intList = Arrays.asList(1, 2, 3);
        List<Double> dblList = Arrays.asList(1.1, 2.2, 3.3);

        printNumbers(intList);
        printNumbers(dblList);

        List<String> strList = Arrays.asList("java", "generics");
        // printNumbers(strList); // CE - Required type :  List<? extends Number>, Provided :  List<String>
    }

    private static void lowerBoundedWildcardEx() {
        List<Animal> animals = new ArrayList<>();
        List<Object> objects = new ArrayList<>();

        addDogs(animals); // allowed
        addDogs(objects); // allowed

        List<Dog> dogs = new ArrayList<>();
        addDogs(dogs);    // allowed

        List<Puppy> puppies = new ArrayList<>();
        // addDogs(puppies);  // CE - Required type :  List<? super Dog>, Provided :  List<Puppy>
    }

    private static void printList(List<?> list) {
        for (Object obj : list) {
            System.out.println(obj);
        }

    }

    private static void printNumbers(List<? extends Number> list) {
        for (Number n : list) {
            System.out.println(n);
        }
        // list.add((Integer)100);  // CE - Required type : capture of ? extends Number, Provided : Integer
    }

    private static void addDogs(List<? super Dog> list) {
        list.add(new Dog());
        list.add(new Puppy()); // Puppy extends Dog

        Object obj = list.get(0);  // Only safe as Object
        // Animal animal = list.get(1);  // CE - Required type : Animal, Provided : capture of ? super Dog
    }

}

class Puppy extends Dog {
}
