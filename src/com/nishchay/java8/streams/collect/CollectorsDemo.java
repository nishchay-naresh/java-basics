package com.nishchay.java8.streams.collect;

import com.nishchay.java8.streams.qns.pojo.Employee;
import com.nishchay.java8.streams.qns.EmployeeSQL;
import com.nishchay.util.pojo.Dish;
import com.nishchay.util.pojo.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorsDemo {

    public static void main(String[] args) {

        needOfToList();
        toListEx();

        toSetEx();
        toMapEx();

        minByEx();
        maxByEx();
        joiningEx();
        countingEx();
        partitionBy();

        groupingByEx();
        groupingAndMappingEx();
        collectingAndThenEx();
    }

    //To List - double the even values and put that into a list.
    private static void needOfToList() {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3, 4, 5);

        // wrong way to do this
        List<Integer> doubleOfEven = new ArrayList<>();
        numbers.stream()
                .filter(e -> e % 2 == 0)
                .map(e -> e * 2)
                .forEach(e -> doubleOfEven.add(e));

        //mutability is OK, sharing is nice, shared mutability is devils work
        //friends don't let friends do shared mutation.
        System.out.println("doubleOfEven = " + doubleOfEven);

        // right way to do this
        List<Integer> doubleOfEven1 =
                numbers.stream()
                        .filter(e -> e % 2 == 0)
                        .map(e -> e * 2)
                        .collect(Collectors.toList());

        System.out.println("doubleOfEven1 = " + doubleOfEven1);
    }

    // get the name of employee whose salary are more than 25K in a list
    private static void toListEx() {
        List<String> empNameList = Employee.employeeList.stream()
                .filter(e -> e.getSalary() > 25000)
                .map(e -> e.getName())
                .collect(Collectors.toList());
        System.out.println("-----------name of employee whose salary are more than 25K------------");
        empNameList.forEach(System.out::println);
    }

    private static void toSetEx() {

        // get all the age data of all employee - in a set
        Set<Integer> ageSet = Employee.employeeList.stream()
                .map(e -> e.getAge())
                .collect(Collectors.toSet()); // or  .collect(Collectors.toCollection(HashSet::new));
        System.out.println("-----------all the age data of all employee------------");
        ageSet.forEach(e -> System.out.print(e + ", "));
        System.out.println();


        // Accumulate age data of all employees into a TreeSet
        Set<Integer> ageTreeSet = Employee.employeeList.stream()
                .map(Employee::getAge)
                .collect(Collectors.toCollection(TreeSet::new));

        System.out.println("-----------age in tree set------------");
        ageTreeSet.forEach(e -> System.out.print(e + ", "));
        System.out.println();
    }

    private static void toMapEx() {

        List<Student> students = Student.populateStudentList();

        /*
         * create a Map with name and no as key, and the Student as value.
         *
         * toMap() method take two Function parameters keyMapper and valueMapper
         * keyMapper - > take a lambda for key mapping from list
         * valueMapper - > take a lambda for value mapping from list
         *
         * */
        Map<String, Student> map = students.stream()
                .collect(Collectors.toMap(
                        e -> e.getStudName() + "-" + e.getStudNo(),     // key
                        student -> student)                             // value
                );

        System.out.println("map = " + map);
        // get a hashMap of <String, Student> out of List of Student
        Map<String, Student> studMap = students.stream()
                .collect(Collectors.toMap(e -> e.getStudName(), Function.identity()));

        System.out.println("-----------<String,Student> studMap------------");
        studMap.forEach((key, value) -> System.out.println("[Key] : " + key + " [Value] : " + value));


        ConcurrentMap<String, Student> studCcyMap
                = students.parallelStream()
                .collect(Collectors.toConcurrentMap(Student::getStudName, Function.identity()));

        System.out.println("-----------<String,Student> ConcurrentMap ------------");
        studCcyMap.forEach((key, value) -> System.out.println(key + " -> " + value));
    }

    private static void minByEx() {
        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
        Dish leastCaloriesDish =
                Dish.getManu()
                        .stream()
                        .min(dishCaloriesComparator).orElse(null);

        System.out.println("leastCaloriesDish = " + leastCaloriesDish);

        leastCaloriesDish =
                Dish.getManu()
                        .stream()
                        .collect(Collectors.minBy(dishCaloriesComparator)).orElse(null);
        System.out.println("leastCaloriesDish = " + leastCaloriesDish);
    }

    private static void maxByEx() {

        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);

        Dish mostCalorieDish =
                Dish.getManu()
                        .stream()
                        .max(dishCaloriesComparator).orElse(null);
        System.out.println("mostCalorieDish = " + mostCalorieDish);

        mostCalorieDish =
                Dish.getManu()
                        .stream()
                        .collect(Collectors.maxBy(dishCaloriesComparator)).orElse(null);
        System.out.println("mostCalorieDish = " + mostCalorieDish);
    }

    private static void countingEx() {
        List<Integer> numbers = Arrays.asList(17, 9, 13, 21, 5, 2);
        long count = numbers.stream()
                .filter(number -> number > 10)
                .collect(Collectors.counting());

        System.out.println(" count = " + count); //3
    }

    // partitionBy()  - can be used to partition a Stream in two parts
    private static void partitionBy() {

        List<Integer> numbers = Arrays.asList(17, 9, 14, 20, 5, 2);
        Map<Boolean, List<Integer>> evenAndOddNumbers = numbers.stream()
                .collect(Collectors.partitioningBy(number -> number % 2 == 0));

        System.out.println("evenAndOddNumbers = " + evenAndOddNumbers);
    }

    private static void joiningEx() {
        String shortMenu;
        shortMenu = Dish.getManu()
                .stream()
                .map(Dish::getName)
                .collect(Collectors.joining(", "));
        System.out.println("shortMenu = " + shortMenu);
    }

    private static void groupingByEx() {

        List<Student> students = Student.populateStudentList();

        // groupingBy - will group the rows based on department, put these rows in a List against of this department
        // outcome will be a map where department will be key and value will be list of students' studies in that department
        Map<String, List<Student>> deptWiseStudents = students.stream()
                .collect(Collectors.groupingBy(Student::getDeptName));

        System.out.println("\t\tDept Name \t\t\t\t   Student Count");
        System.out.println("----------------------------------------------------");
        // deptMap.forEach((key, value) -> System.out.println(String.format("%25s", key) + "\t --->\t " + value));
        deptWiseStudents.forEach((key, value) -> System.out.println(String.format("%25s", key) + "\t --->\t " + value.size()));

        Map<String, Long> deptCount = students.stream()
                .collect(Collectors.groupingBy(Student::getDeptName, Collectors.counting()));
        System.out.println("deptCount = " + deptCount);
    }

    private static void groupingAndMappingEx() {

        List<Employee> employees = Employee.employeeList;
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

    private static void collectingAndThenEx() {

        String mainStr = "car, bus, car, jeep, cycle, bike, train, bus, truck, jeep, car, jeep, cycle, truck, train, car, bike, bus, cycle";
        Map<String, Integer> freqMapInt = Arrays.stream(mainStr.split(", "))
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.collectingAndThen(Collectors.counting(), e -> e.intValue())
                        )
                );
        System.out.println("freqMapInt = " + freqMapInt);
    }
}
