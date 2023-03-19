package com.nishchay.java8.streams.collect;

import com.nishchay.java8.streams.query.Employee;
import com.nishchay.java8.streams.query.EmployeeSQL;
import com.nishchay.util.pojo.Dish;

import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorsDemo {

    public static void main(String[] args) {

        toListEx();
        toListEx1();
        toSetEx();
        toMapEx();

        minByEx();
        maxByEx();
        joiningEx();
        countingEx();
//        partitionBy();

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


        ConcurrentMap<String, Employee> chMap
                = employees.parallelStream()
                .collect(Collectors.toConcurrentMap(Employee::getName, Function.identity()));

        System.out.println("-----------<String,Employee> ConcurrentMap ------------");
        empMap.forEach((key, value) -> System.out.println( key + " -> " + value));

    }

    private static void minByEx() {

        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);

        Optional<Dish> leastCaloriesDish;

        leastCaloriesDish = Dish.getManu().stream()
                .collect(Collectors.minBy(dishCaloriesComparator));
        System.out.println("leastCaloriesDish = " + leastCaloriesDish.orElse(null));
    }

    private static void maxByEx() {

        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);

        Optional<Dish> mostCalorieDish;

        mostCalorieDish = Dish.getManu().stream()
                .max(dishCaloriesComparator);
        System.out.println("mostCalorieDish = " + mostCalorieDish.orElse(null));

        mostCalorieDish = Dish.getManu().stream()
                .collect(Collectors.maxBy(dishCaloriesComparator));
        System.out.println("mostCalorieDish = " + mostCalorieDish.orElse(null));
    }
    
    private static void countingEx() {

        List<Integer> numbers = Arrays.asList(17, 9, 13, 21, 5, 2);
        long count = numbers.stream()
                .filter( number -> number> 10)
                .collect(Collectors.counting());

        System.out.println(" count = " + count);
    }


    private static void joiningEx() {
        String shortMenu;
        shortMenu = Dish.getManu().stream().map(Dish::getName).collect(Collectors.joining(", "));
        System.out.println("shortMenu = " + shortMenu);
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

        System.out.println("\t\t Dept Name \t\t\t\t   AgeList");
        System.out.println("----------------------------------------------------");
        deptMap.forEach((key, value) -> System.out.println(String.format("%25s", key) + "\t --->\t " + value));
    }

}
