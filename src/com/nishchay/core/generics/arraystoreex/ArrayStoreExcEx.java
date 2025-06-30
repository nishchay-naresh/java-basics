package com.nishchay.core.generics.arraystoreex;


import java.util.Arrays;

/*
* ArrayStoreException is a runtime exception
*   - Which occurs when you try to store the wrong type of object in an array that expects another type.
*   - It happens at runtime, not at compile time - typically when you're dealing with object arrays and inheritance.
* */
public class ArrayStoreExcEx {

    public static void main(String[] args) {
        Object[] objectArray = new String[3];   // Creating an array of String, assigned to Object[]
                                                // The compiler allows this (because String[] is-a Object[]).

        objectArray[0] = "Hello";               // OK: String in String[]
        objectArray[1] = 100;                   // Not ok: Integer in String[] Throws ArrayStoreException at runtime
                                                // Java store/knows the type info of array. So during each cell assignment
                                                // At runtime, Java checks assigned value type and actual array type → here Integer & String[].
        System.out.println("objectArray = " + Arrays.toString(objectArray));
    }
}
/*
 * How to Prevent It?
 *   - Avoid treating arrays of subtype as arrays of supertype when you plan to store values.
 *   - Use generics and collections (List<T>) where possible - they offer better type safety.
 *   - Unlike generics (which throw compile-time errors for type issues),
 *      Arrays do runtime type checks(because they have the type info), which is why ArrayStoreException exists.
 *
 * */