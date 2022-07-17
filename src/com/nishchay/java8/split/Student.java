package com.nishchay.java8.split;

public class Student {
    String name;
    int age;
  
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
  
    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}