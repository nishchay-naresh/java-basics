package com.nishchay.core.collection.comparator;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetSortDemo {

    public static void main(String[] args) {
        Set<Employee> empTSet = new TreeSet<>();

        empTSet.add(new  Employee("ALLEN","SALES","SALESMAN",7499,"CHICAGO"));
        empTSet.add(new  Employee("BLAKE","SALES","MANAGER",7698,"CHICAGO"));
        empTSet.add(new  Employee("CLARK","ACCOUNTING","MANAGER",7782,"NEW YORK"));
        empTSet.add(new  Employee("FORD","RESEARCH","ANALYST",7902,"DALLAS"));
        empTSet.add(new  Employee("JAMES","SALES","CLERK",7900,"CHICAGO"));
        empTSet.add(new  Employee("JONES","RESEARCH","MANAGER",7566,"DALLAS"));

        System.out.println("######## Default(empNo) ordering #######");
        empTSet.forEach(e -> System.out.println(e));

        empTSet=null;
        empTSet = new TreeSet<>( (e1,e2) -> e1.getEmpName().compareTo(e2.getEmpName()));

        empTSet.add(new  Employee("ALLEN","SALES","SALESMAN",7499,"CHICAGO"));
        empTSet.add(new  Employee("BLAKE","SALES","MANAGER",7698,"CHICAGO"));
        empTSet.add(new  Employee("CLARK","ACCOUNTING","MANAGER",7782,"NEW YORK"));
        empTSet.add(new  Employee("FORD","RESEARCH","ANALYST",7902,"DALLAS"));
        empTSet.add(new  Employee("JAMES","SALES","CLERK",7900,"CHICAGO"));
        empTSet.add(new  Employee("JONES","RESEARCH","MANAGER",7566,"DALLAS"));
        System.out.println("######## City wise ordering #######");
        empTSet.forEach(e -> System.out.println(e));

    }
}
