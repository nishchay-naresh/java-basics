package com.nishchay.core.objectclazz;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class EmpHashMapDemo {

    public static void main(String[] args) {

        Map<Emp, Integer> hm = new HashMap<>();

        Emp e1 = new Emp(10,"Abc", 100.00);
        Emp e2 = new Emp(10,"Abc", 100.00);

        hm.put(e1,10);
        hm.put(e2,20);

        System.out.println("hm.size() = " + hm.size());
    }

}

class Emp{

    private int id;
    private String name;
    private double salary;

    public Emp(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emp emp = (Emp) o;
        return id == emp.id && Double.compare(emp.salary, salary) == 0 && Objects.equals(name, emp.name);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        temp = Double.doubleToLongBits(salary);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + id;
        return result;
    }
}
