package com.nishchay.java8.streams;

import com.nishchay.java8.streams.query.Employee;
import com.nishchay.java8.streams.query.EmployeeSQL;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorsDemo {

    public static void main(String[] args) {

        toListEx();
        toListEx1();
        toSetEx();
        toMapEx();
        groupingByEx();
        groupingAndMappingEx();

    }


    private static void toListEx() {

        // get the name of employee whose salary are more than 25K in a list
        List<String> empNameList = EmployeeSQL.populateEmployeeList().stream()
                .filter(e -> e.getSalary() > 25000)
                .map(e -> e.getName())
                .collect(Collectors.toList());
        System.out.println("-----------name of employee whose salary are more than 25K------------");
        empNameList.forEach(System.out::println);
    }

    private static void toListEx1() {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3, 4, 5);

        //To List - double the even values and put that into a list.

        // wrong way to do this
        List<Integer> doubleOfEven = new ArrayList<>();
        numbers.stream()
                .filter(e -> e % 2 == 0)
                .map(e -> e * 2)
                .forEach(e -> doubleOfEven.add(e));

        //mutability is OK, sharing is nice, shared mutability is devils work
        //friends don't let friends do shared mutation.
        System.out.println("doubleOfEven = " + doubleOfEven); // don't do this

        List<Integer> doubleOfEven2 =
                numbers.stream()
                        .filter(e -> e % 2 == 0)
                        .map(e -> e * 2)
                        .collect(Collectors.toList());

        System.out.println("doubleOfEven2 = " + doubleOfEven2);
    }

    private static void toSetEx() {

        // get all the age data of all employee - in a set
        Set<Integer> ageSet = EmployeeSQL.populateEmployeeList().stream()
                .map(e -> e.getAge())
                .collect(Collectors.toSet()); // or  .collect(Collectors.toCollection(HashSet::new));
        System.out.println("-----------all the age data of all employee------------");
        ageSet.forEach(System.out::println);


        // Accumulate age data of all employee into a TreeSet
        Set<Integer> ageTreeSet = EmployeeSQL.populateEmployeeList().stream()
                .map(Employee::getAge)
                .collect(Collectors.toCollection(TreeSet::new));

        System.out.println("-----------age in tree set------------");
        ageTreeSet.forEach(System.out::println);
    }

    private static void toMapEx() {

        List<Employee> employees = EmployeeSQL.populateEmployeeList();

        /*
        * create a Map with name and age as key, and the person as value.
        *
        * toMap() method take two keyMapper, valueMapper parameters of Function
        * keyMapper - > take a lambda for key mapping from list
        * valueMapper - > take a lambda for value mapping from list
        *
        * */
        System.out.println(
                employees.stream()
                        .collect(Collectors.toMap(
                                e -> e.getName() + "-" + e.getAge(), // key
                                person -> person)                    // value
                        )
        );

        // get a hashMap of <String,Employee> out of List of employee
/*        Map<String, Employee> empMap = EmployeeSQL.populateEmployeeList().stream()
                .collect(Collectors.toMap(e -> e.getName(), e -> e));
*/
        Map<String, Employee> empMap = employees.stream()
                .collect(Collectors.toMap(e -> e.getName(), Function.identity()));

        System.out.println("-----------<String,Employee> empMap------------");
        empMap.forEach((key, value) -> System.out.println("[Key] : " + key + " [Value] : " + value));
    }

    private static void groupingByEx() {

        List<Employee> employees = EmployeeSQL.populateEmployeeList();
        //given a list of people, create a map where
        //their department is the key and value is all the people works in that department.

        Map<String, List<Employee>> deptMap = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        System.out.println("\t\tDept Name \t\t\t\t   Emp Count");
        System.out.println("----------------------------------------------------");
        deptMap.forEach((key, value) -> System.out.println(String.format("%25s", key) + "\t --->\t " + value.size()));

    }

    private static void groupingAndMappingEx() {

        List<Employee> employees = EmployeeSQL.populateEmployeeList();
        //given a list of people, create a map where
        //their department is the key and value is all the ages of people with that name

        Map<String, List<Integer>> deptMap =
                employees.stream()
                        .collect(Collectors.groupingBy(Employee::getDepartment,
                                Collectors.mapping(Employee::getAge, Collectors.toList())));

        System.out.println("\t\tDept Name \t\t\t\t   AgeList");
        System.out.println("----------------------------------------------------");
        deptMap.forEach((key, value) -> System.out.println(String.format("%25s", key) + "\t --->\t " + value));
    }

}
