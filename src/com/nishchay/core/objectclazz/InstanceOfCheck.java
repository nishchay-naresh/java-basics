package com.nishchay.core.objectclazz;


import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;

/*
 *============== instanceof Operator ====================
 *
 * instanceof is a binary operator used to test if an object is of a given type. The result of the operation is either true or false.
 *
 * The instanceof operator works on the principle of the is-a relationship.
 *
 *
 * https://www.baeldung.com/java-instanceof
 */
public class InstanceOfCheck {

    public static void main(String[] args) {

        /*
        * Using the instanceof Operator when object is null
        *
        * If we use the instanceof operator on any reference variable which points to null, it returns false.
        * Also, no null check is needed when using an instanceof operator.
        * */

        String str = null;
        System.out.println("instanceof result for reference variable which points null - " + (str instanceof String));
        Object ref = null;
        System.out.println("instanceof result for reference variable which points null - " + (ref instanceof Object));

        str = new String("java");
        ref = new Object();

        System.out.println("    ref instanceof Self - " + (str instanceof String)); // true
        System.out.println("child instanceof Parent - " + (str instanceof Object)); // true
        System.out.println("    ref instanceof Self - " + (ref instanceof Object)); // true
        System.out.println("parent instanceof Child - " + (ref instanceof String)); // false

        System.out.println("---------ArrayList instanceof test of all of its parents-----------");
        ArrayList<String> list = new ArrayList<>();
        System.out.println("    ref instanceof Self - " + (list instanceof ArrayList));
        System.out.println("child instanceof Parent - " + (list instanceof AbstractList));
        System.out.println("child instanceof Parent - " + (list instanceof List));
        System.out.println("child instanceof Parent - " + (list instanceof RandomAccess));
        System.out.println("child instanceof Parent - " + (list instanceof Cloneable));
        System.out.println("child instanceof Parent - " + (list instanceof Serializable));

    }
}
