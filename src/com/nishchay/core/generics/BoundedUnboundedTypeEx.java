package com.nishchay.core.generics;

import com.nishchay.core.generics.pojo.Animal;
import com.nishchay.core.generics.pojo.Cat;
import com.nishchay.core.generics.pojo.Dog;

/*
 *
 *  <T>             - Unbounded Type Parameter
 *	                - can pass any object type as type parameter (i.e., T extends Object implicitly)
 *  <T extends X>   - Upper Bounded Type (extends)
 *                  - means you can safely add X or its subclass, and can read as X/Object.
 *  <T super X>     - not valid syntax.
 *	                - super is allowed only in wildcards (i.e., ? super T), not in type parameters
 *
 *
 * 	Term						Example					Meaning
 * -------------------------------------------------------------------------------------------------------
 * Unbounded Type				<T>						Any class type
 * Upper Bounded Type			<T extends X>			X/Subtypes of X
 * 								<T super X> 			not valid syntax.
 * Multiple Bounded Type		<T extends A & B>		A/Subtypes of A, B/implements of B
 * Unbounded Wildcard			<?>						Unknown type (read-only)
 * Upper Bounded Wildcard		<? extends X>			Unknown subtype of X (read-only)
 * Lower Bounded Wildcard		<? super X>				Unknown supertype of X (write)
 *
 *
 * */
public class BoundedUnboundedTypeEx {
    public static void main(String[] args) {

        unboundedTypeEx();
        System.out.println("---------------------------------");
        upperBoundedTypeEx();
    }

    private static void unboundedTypeEx() {
        Box<String> strBox = new Box<>();
        strBox.set("Generics");
        System.out.println("strBox = " + strBox);

        Box<Integer> intBox = new Box<>();
        intBox.set(100);
        System.out.println("intBox = " + intBox);
    }
    private static void upperBoundedTypeEx() {
        Cage<Animal> animalCage = new Cage<>();
        animalCage.put(new Animal()); // allowed
        Animal animal = animalCage.get();
        animal.speak();

        Cage<Dog> dogCage = new Cage<>();
        dogCage.put(new Dog()); // allowed
        animal = dogCage.get();
        animal.speak();

        Cage<Cat> catCage = new Cage<>();
        catCage.put(new Cat()); // allowed
        animal = catCage.get();
        animal.speak();

        // not allowed, Compile-time error
        //Cage<String> stringCage = new Cage<>();
    }
}

/*
 *  <T>  - Unbounded Type Parameter
 *       - One can pass any object type as type parameter (i.e., T extends Object implicitly).
 * */
class Box<T> {
    private T value;
    public void set(T val) { value = val; }
    public T get() { return value; }

    @Override
    public String toString() {
        return "Box{" +
                "value=" + value +
                '}';
    }
}

/*
 *  <T extends X>  - Upper Bounded Type (extends)
 *       - means you can safely add X or its subclass, and can read as X/Object.
 * */
class Cage<T extends Animal> {
    private T animal;
    public void put(T animal) { this.animal = animal; }
    public T get() { return animal; }
}

/*
 *  <T super X>  - Lower Bounded Type (super)
 *      -   Now One can pass only X/subclasses of X as type parameter
 *      -   <T super Dog> is not valid syntax in Java generics.
 *      -   You can’t use super in a generic type parameter
 *      -   super is allowed only in wildcards (i.e., ? super T), not in type parameters.
 * */
