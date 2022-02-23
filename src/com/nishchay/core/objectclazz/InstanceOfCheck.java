package com.nishchay.core.objectclazz;

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
        * Using the instanceof Operator When an Object Is null
        *
        * If we use the instanceof operator on any object that is null, it returns false.
        * Also, no null check is needed when using an instanceof operator.
        * */
        Parent ref = null;
        System.out.println(ref instanceof Parent);


        Parent p = new Parent();
        Child c = new Child();
        System.out.println("child instanceof Parent " + (c instanceof Parent)); // true
        System.out.println("parent instanceof Child " + (p instanceof Child)); // false
    }
}

class Parent {
}

class Child extends Parent {
}
/*
O/P =>
    child instanceof Parent true
    parent instanceof Child false
* */