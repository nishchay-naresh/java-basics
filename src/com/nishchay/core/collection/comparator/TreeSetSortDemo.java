package com.nishchay.core.collection.comparator;

import java.util.*;

public class TreeSetSortDemo {

    public static void main(String[] args) {

        basicTreeSetDemo();
        treeSetDemoWithComparator();

    }

    private static void basicTreeSetDemo() {

        List<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("BBB");
        stringArrayList.add("JJJ");
        stringArrayList.add("ZZZ");
        stringArrayList.add("AAA");
        stringArrayList.add("QQQ");
        stringArrayList.add("III");

        Set<String> stringTreeSet = new TreeSet<>(stringArrayList);
        System.out.println("stringArrayList = " + stringArrayList);
        System.out.println("stringTreeSet = " + stringTreeSet);

    }
    /*
     * O/P =>
     * stringArrayList = [BBB, JJJ, ZZZ, AAA, QQQ, III]
     * stringTreeSet = [AAA, BBB, III, JJJ, QQQ, ZZZ]
     * */

    private static void treeSetDemoWithComparator() {


        Set<Employee> empTSet = new TreeSet<>();

        empTSet.add(new Employee("ALLEN", "SALES", "SALESMAN", 7499, "CHICAGO"));
        empTSet.add(new Employee("BLAKE", "SALES", "MANAGER", 7698, "CHICAGO"));
        empTSet.add(new Employee("CLARK", "ACCOUNTING", "MANAGER", 7782, "NEW YORK"));
        empTSet.add(new Employee("FORD", "RESEARCH", "ANALYST", 7902, "DALLAS"));
        empTSet.add(new Employee("JAMES", "SALES", "CLERK", 7900, "CHICAGO"));
        empTSet.add(new Employee("JONES", "RESEARCH", "MANAGER", 7566, "DALLAS"));

        System.out.println("######## Default(empNo) ordering #######");
        empTSet.forEach(System.out::println);

        empTSet = null;
        empTSet = new TreeSet<>(Comparator.comparing(Employee::getEmpName));

        empTSet.add(new Employee("ALLEN", "SALES", "SALESMAN", 7499, "CHICAGO"));
        empTSet.add(new Employee("BLAKE", "SALES", "MANAGER", 7698, "CHICAGO"));
        empTSet.add(new Employee("CLARK", "ACCOUNTING", "MANAGER", 7782, "NEW YORK"));
        empTSet.add(new Employee("FORD", "RESEARCH", "ANALYST", 7902, "DALLAS"));
        empTSet.add(new Employee("JAMES", "SALES", "CLERK", 7900, "CHICAGO"));
        empTSet.add(new Employee("JONES", "RESEARCH", "MANAGER", 7566, "DALLAS"));
        System.out.println("######## City wise ordering #######");
        empTSet.forEach(System.out::println);

    }
}
/*
 * O/P =>
 *	######## Default(empNo) ordering #######
 *	Employee{empName='ALLEN', deptName='SALES', job='SALESMAN', empNo=7499, city='CHICAGO'}
 *	Employee{empName='JONES', deptName='RESEARCH', job='MANAGER', empNo=7566, city='DALLAS'}
 *	Employee{empName='BLAKE', deptName='SALES', job='MANAGER', empNo=7698, city='CHICAGO'}
 *	Employee{empName='CLARK', deptName='ACCOUNTING', job='MANAGER', empNo=7782, city='NEW YORK'}
 *	Employee{empName='JAMES', deptName='SALES', job='CLERK', empNo=7900, city='CHICAGO'}
 *	Employee{empName='FORD', deptName='RESEARCH', job='ANALYST', empNo=7902, city='DALLAS'}
 *	######## City wise ordering #######
 *	Employee{empName='ALLEN', deptName='SALES', job='SALESMAN', empNo=7499, city='CHICAGO'}
 *	Employee{empName='BLAKE', deptName='SALES', job='MANAGER', empNo=7698, city='CHICAGO'}
 *	Employee{empName='CLARK', deptName='ACCOUNTING', job='MANAGER', empNo=7782, city='NEW YORK'}
 *	Employee{empName='FORD', deptName='RESEARCH', job='ANALYST', empNo=7902, city='DALLAS'}
 *	Employee{empName='JAMES', deptName='SALES', job='CLERK', empNo=7900, city='CHICAGO'}
 *	Employee{empName='JONES', deptName='RESEARCH', job='MANAGER', empNo=7566, city='DALLAS'}
 *
 * */

