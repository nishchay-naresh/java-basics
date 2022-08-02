package com.nishchay.core.serialization;

import java.lang.reflect.Field;

public class ReflectToUpdateVersion {

    public static void main(String[] args)throws ClassNotFoundException,
            NoSuchFieldException,SecurityException, IllegalArgumentException, IllegalAccessException {

        setPrivateFieldValue();

//        setStaticValue("com.nishchay.core.serialization.Employee","serialVersionUID", 25L );


    }



    private static void setPrivateFieldValue(){
        try {
            Field addressField = Class.forName("com.nishchay.core.serialization.Employee").getDeclaredField("address");
            addressField.setAccessible(true);
            Employee employee = new Employee(555, "Hulk", "Old Address", 5000);

            System.out.println("Current address is - " + addressField.get(employee));
            addressField.set(employee, "New updated address");
            System.out.println("    New address is - " + addressField.get(employee));
        } catch (IllegalAccessException | NoSuchFieldException | SecurityException |
                 IllegalArgumentException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * get/set the private field value by turning off the java access check for field modifiers.
     * @throws ClassNotFoundException
     * @throws NoSuchFieldException
     * @throws SecurityException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     */
    private static void setPrivateStaticFinalFieldValue() throws ClassNotFoundException,
            NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
        Field privateField = Class.forName("com.nishchay.core.serialization.Employee").getDeclaredField("serialVersionUID");
        //turning off access check with below method call
        privateField.setAccessible(true);
        Employee employee = new Employee(555, "Hulk", "Hulk Address", 5000);
        System.out.println(privateField.get(employee)); // prints : -367591245516138230L
        privateField.set(employee, 333L);
        System.out.println(privateField.get(employee)); //prints : -333L
    }

    /**
     * Use reflection to change value of any static field.
     * @param className The complete name of the class (ex. java.lang.String)
     * @param fieldName The name of a static field in the class
     * @param newValue The value you want the field to be set to.
     * @throws SecurityException .
     * @throws NoSuchFieldException .
     * @throws ClassNotFoundException .
     * @throws IllegalArgumentException .
     * @throws IllegalAccessException .
     */
    public static void setStaticValue(final String className, final String fieldName, final Object newValue) throws SecurityException, NoSuchFieldException,
            ClassNotFoundException, IllegalArgumentException, IllegalAccessException {
        // Get the private String field
        final Field field = Class.forName(className).getDeclaredField(fieldName);
        // Allow modification on the field
        field.setAccessible(true);
        // Get
        final Object oldValue = field.get(Class.forName(className));
        // Sets the field to the new value
        field.set(oldValue, newValue);

    }

}
