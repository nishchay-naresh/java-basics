package com.nishchay.java8.streams;

import com.nishchay.java8.streams.query.Employee;
import com.nishchay.java8.streams.query.EmployeeSQL;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsDemo {

    public static void main(String[] args) {

//        toListEx();
//        toSetEx();
        toMapEx();

        identityEx_toMap();
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

        // get a hashMap of <String,Employee> out of List of employee
/*        Map<String, Employee> empMap = EmployeeSQL.populateEmployeeList().stream()
                .collect(Collectors.toMap(e -> e.getName(), e -> e));
*/
        Map<String, Employee> empMap = EmployeeSQL.populateEmployeeList().stream()
                .collect(Collectors.toMap(e -> e.getName(), Function.identity()));

        System.out.println("-----------<String,Employee> empMap------------");
        empMap.forEach((key, value) -> System.out.println("[Key] : " + key + " [Value] : " + value));

    }

    private static void identityEx_toMap() {

        Map<String, Integer> map =
                Stream.of("java", "perl", "Java")
                        .collect(Collectors.toMap(Function.identity(), String::length));

        System.out.println("map = " + map);
    }


}
