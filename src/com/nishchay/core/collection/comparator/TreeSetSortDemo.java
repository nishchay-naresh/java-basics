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

    private static void treeSetDemoWithComparator() {


        List<Employee> employeeList = Employee.populateEmployeeList();

        Set<Employee> empTSet = new TreeSet<>(employeeList);
        System.out.println("                ######## Default(empNo) ordering #######");
        empTSet.forEach(System.out::println);

        empTSet = null;
        empTSet = new TreeSet<>(Comparator.comparing(Employee::getEmpName));
        empTSet.addAll(employeeList);
        System.out.println("                ######## Name wise ordering #######");
        empTSet.forEach(System.out::println);

        empTSet = null;
        empTSet = new TreeSet<>(Comparator.comparing(Employee::getCity));
        // TreeSet : emp with duplicate city name will be not gets added, only the first added entry will be there
        empTSet.addAll(employeeList);
        System.out.println("                ######## City wise ordering #######");
        empTSet.forEach(System.out::println);
    }
}
/*
 * O/P =>
 *	stringArrayList = [BBB, JJJ, ZZZ, AAA, QQQ, III]
 *	stringTreeSet = [AAA, BBB, III, JJJ, QQQ, ZZZ]
 *	                ######## Default(empNo) ordering #######
 *	Employee{empName='SMITH', deptName='RESEARCH', job='CLERK', empNo=7369, city='DALLAS'}
 *	Employee{empName='ALLEN', deptName='SALES', job='SALESMAN', empNo=7499, city='CHICAGO'}
 *	Employee{empName='CLARK', deptName='ACCOUNTING', job='MANAGER', empNo=7782, city='NEW YORK'}
 *	Employee{empName='KING', deptName='ACCOUNTING', job='PRESIDENT', empNo=7839, city='NEW YORK'}
 *	Employee{empName='TURNER', deptName='SALES', job='SALESMAN', empNo=7844, city='CHICAGO'}
 *	Employee{empName='JAMES', deptName='SALES', job='CLERK', empNo=7900, city='CHICAGO'}
 *	                ######## Name wise ordering #######
 *	Employee{empName='ALLEN', deptName='SALES', job='SALESMAN', empNo=7499, city='CHICAGO'}
 *	Employee{empName='CLARK', deptName='ACCOUNTING', job='MANAGER', empNo=7782, city='NEW YORK'}
 *	Employee{empName='JAMES', deptName='SALES', job='CLERK', empNo=7900, city='CHICAGO'}
 *	Employee{empName='KING', deptName='ACCOUNTING', job='PRESIDENT', empNo=7839, city='NEW YORK'}
 *	Employee{empName='SMITH', deptName='RESEARCH', job='CLERK', empNo=7369, city='DALLAS'}
 *	Employee{empName='TURNER', deptName='SALES', job='SALESMAN', empNo=7844, city='CHICAGO'}
 *	                ######## City wise ordering #######
 *	Employee{empName='ALLEN', deptName='SALES', job='SALESMAN', empNo=7499, city='CHICAGO'}
 *	Employee{empName='SMITH', deptName='RESEARCH', job='CLERK', empNo=7369, city='DALLAS'}
 *	Employee{empName='CLARK', deptName='ACCOUNTING', job='MANAGER', empNo=7782, city='NEW YORK'}
 *
 * */

