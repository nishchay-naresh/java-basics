package com.nishchay.java8.fun;


import com.nishchay.java8.streams.query.Employee;

import java.util.function.Predicate;

public class PredicateEx {

    public static void main(String[] args) {

        composePredicateEx();
    }

    private static void composePredicateEx() {

        Employee emp = new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0);

        Predicate<Employee> femaleEmp = e -> e.getGender().startsWith("F");
        Predicate<Employee> MgrEmp = e -> e.getSalary() > 24000.0;


        Predicate<Employee> femaleMgr = femaleEmp.and( e -> e.getSalary() > 24000.0);

        Predicate<Employee> accOrSaleMgr = MgrEmp
                .or( e -> e.getDepartment().startsWith("Sales"))
                .or(e -> e.getDepartment().startsWith("Account"));


    }
}
