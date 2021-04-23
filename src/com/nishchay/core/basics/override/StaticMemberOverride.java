package com.nishchay.core.basics.override;

/*
* Since its an overriding of static members
* so it will pick the member based on reference type at compile time.
* */

public class StaticMemberOverride {

    public static void main(String[] args) {
        Employee emp = new Manager();
        System.out.println("emp.name = " + emp.name); // emp.name = Employee

        emp.printName(); // Employee.printName()
    }

}

class Employee {
    public static String name = "Employee";

    public static void printName() {
        System.out.println("Employee.printName()");
    }

}

class Manager extends Employee {
    public static String name = "Manager";

    public static void printName() {
        System.out.println("Manager.printName()");
    }

}