package com.nishchay.java8.collection.comparator;

public class Employee {

    private String name;
    private int age;
    private double salary;
    private String city;


    public Employee() {
    }

    public Employee(String name, int age, double salary, String city) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", city='" + city + '\'' +
                '}';
    }
}
