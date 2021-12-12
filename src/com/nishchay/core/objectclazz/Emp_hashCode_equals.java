package com.nishchay.core.objectclazz;

import java.util.Date;

public class Emp_hashCode_equals {

    private String name;
    private double salary;
    private int age;
    private Date dob;

    public Emp_hashCode_equals() {

    }
    public Emp_hashCode_equals(String name, double salary, int age, Date dob) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.dob = dob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Emp_hashCode_equals emp = (Emp_hashCode_equals) o;

        if (Double.compare(emp.salary, salary) != 0) return false;
        if (age != emp.age) return false;
        if (!name.equals(emp.name)) return false;
        return dob.equals(emp.dob);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        temp = Double.doubleToLongBits(salary);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + age;
        result = 31 * result + dob.hashCode();
        return result;
    }
}
