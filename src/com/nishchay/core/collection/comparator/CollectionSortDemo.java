package com.nishchay.core.collection.comparator;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionSortDemo {

    public static void main(String[] args) {
        List<Employee> empList  = populateEmployeeList();

        System.out.println("######## Employee List #######");
        empList.forEach(System.out::println);

        Collections.sort(empList);
        System.out.println("######## Default(empNo) ordering #######");
        empList.forEach(System.out::println);

        //
        System.out.println("######## Job wise ordering #######");
        Collections.sort(empList, (e1,e2) -> e1.getJob().compareTo(e2.getJob()));
        empList.forEach(System.out::println);


        System.out.println("######## Department wise ordering #######");
        Collections.sort(empList, (e1,e2) -> e1.getDeptName().compareTo(e2.getDeptName()));

        empList.forEach(System.out::println);


        System.out.println("######## City wise ordering #######");
//        Collections.sort(empList, (e1,e2) -> e1.getCity().compareTo(e2.getCity()));
//        (c1, c2) -> keyExtractor.apply(c1).compareTo(keyExtractor.apply(c2))
        Comparator<Employee> cityComparator = Comparator.comparing(Employee::getCity);

        empList.sort(cityComparator);
        empList.forEach(System.out::println);

    }


    public static List<Employee> populateEmployeeList(){
        List<Employee> empList = new ArrayList<>();
//        empList.add(new  Employee("ADAMS","RESEARCH","CLERK",7876,"DALLAS"));
        empList.add(new  Employee("ALLEN","SALES","SALESMAN",7499,"CHICAGO"));
//        empList.add(new  Employee("BLAKE","SALES","MANAGER",7698,"CHICAGO"));
        empList.add(new  Employee("CLARK","ACCOUNTING","MANAGER",7782,"NEW YORK"));
//        empList.add(new  Employee("FORD","RESEARCH","ANALYST",7902,"DALLAS"));
        empList.add(new  Employee("JAMES","SALES","CLERK",7900,"CHICAGO"));
//        empList.add(new  Employee("JONES","RESEARCH","MANAGER",7566,"DALLAS"));
        empList.add(new  Employee("KING","ACCOUNTING","PRESIDENT",7839,"NEW YORK"));
//        empList.add(new  Employee("MARTIN","SALES","SALESMAN",7654,"CHICAGO"));
//        empList.add(new  Employee("MILLER","ACCOUNTING","CLERK",7934,"NEW YORK"));
//        empList.add(new  Employee("SCOTT","RESEARCH","ANALYST",7788,"DALLAS"));
        empList.add(new  Employee("SMITH","RESEARCH","CLERK",7369,"DALLAS"));
        empList.add(new  Employee("TURNER","SALES","SALESMAN",7844,"CHICAGO"));
//        empList.add(new  Employee("WARD","SALES","SALESMAN",7521,"CHICAGO"));
        return empList;
    }

}
