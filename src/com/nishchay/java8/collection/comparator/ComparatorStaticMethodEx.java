package com.nishchay.java8.collection.comparator;


import com.nishchay.ds.string.freq.StringFrequencyUtility;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class ComparatorStaticMethodEx {

    public static void main(String[] args) {

//        naturalOrder_reverseOrder_ex();

/*
        List<Employee> employeeList = populateEmployeeList();
        System.out.println(" --------------- Original List -----------------");
        employeeList.forEach(System.out::println);

        comparing_ex(employeeList);
        comparingXxx_ex(employeeList);
        thenComparing_ex(employeeList);
        nullsLast_nullsFirst_ex();
*/

        thenComparing_ex_map();

    }


    //    Using Comparator.naturalOrder() & Comparator.reverseOrder()
    private static void naturalOrder_reverseOrder_ex() {

        List<String> animals = new ArrayList<>();
        animals.add("dog");
        animals.add("penguin");
        animals.add("cat");
        animals.add("panther");
        animals.add("zebra");
        animals.add("rat");
        animals.add("donkey");

        System.out.println(" --------------- Original List -----------------");
        animals.forEach(System.out::println);

        System.out.println(" --------------- Natural Order Sorting -----------------");
        animals.sort(Comparator.naturalOrder());
        animals.forEach(System.out::println);

        System.out.println(" --------------- Reverse Order Sorting -----------------");
        animals.sort(Comparator.reverseOrder());
        animals.forEach(System.out::println);
    }

    private static void comparing_ex(List<Employee> employeeList) {

        // Using Comparator.comparing(-)
        System.out.println(" --------------- Sorting based on Names -----------------");
        Comparator<Employee> nameComparator = Comparator.comparing(Employee::getName);
        employeeList.sort(nameComparator);
        employeeList.forEach(System.out::println);


        System.out.println(" --------------- Sorting based on Names but in reverse order -----------------");
//        Collections.sort(employeeList, nameComparator.reversed());
//        employeeList.forEach(System.out::println);
//         Another way to achieve this

//        Using Comparator.reverseOrder()
//        Comparator nameComparator1 = Comparator.comparing(Employee::getName, (o1, o2) -> o2.compareTo(o1));
        Comparator<Employee> nameComparator1 = Comparator.comparing(Employee::getName, Comparator.reverseOrder());
        employeeList.sort(nameComparator1);
        employeeList.forEach(System.out::println);

        // Using Comparator.comparing(-,-)
//        Collections.sort(employeeList, Comparator.comparing(Employee::getSalary,Double::compareTo));
        System.out.println(" --------------- Sorting based on Names length -----------------");
//        Comparator<Employee> nameLengthComparator = Comparator.comparing(Employee::getName, (o1, o2) -> o1.length()-o2.length());
//        Comparator<Employee> nameLengthComparator = Comparator.comparing(Employee::getName, Comparator.comparing(String::length));
        Comparator<Employee> nameLengthComparator = Comparator.comparing(Employee::getName, Comparator.comparingInt(String::length));
        employeeList.sort(nameLengthComparator);
        employeeList.forEach(System.out::println);

    }


    private static void comparingXxx_ex(List<Employee> employeeList) {
        // Using Comparator.comparingInt
        System.out.println(" --------------- Sorting based on Age -----------------");
        Comparator<Employee> ageComparator = Comparator.comparingInt(Employee::getAge);
        employeeList.sort(ageComparator);
        employeeList.forEach(System.out::println);

        //Using Comparator.comparingDouble
        System.out.println(" --------------- Sorting based on Salary -----------------");
        Comparator<Employee> salaryComparator = Comparator.comparingDouble(Employee::getSalary);
        employeeList.sort(salaryComparator);
        employeeList.forEach(System.out::println);
    }

    //        Using Comparator.thenComparing
    //    With Comparator.thenComparing() method, we can use multiple comparators when sorting objects.
    //        Adding multiple sorting criteria, if age is same , go for cityName
    private static void thenComparing_ex(List<Employee> employeeList) {

        Comparator<Employee> ageThenCityNameComparator = Comparator.comparing(Employee::getAge)
                .thenComparing(Employee::getCity);

        System.out.println(" --------------- Sorting based on Age then Name -----------------");
        employeeList.sort(ageThenCityNameComparator);
        employeeList.forEach(System.out::println);
    }

    private static void thenComparing_ex_map() {

        int[]arr = {7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9};
        Map<Integer,Integer> freqMap = StringFrequencyUtility.getFrequencyMap(arr);

        List<Map.Entry<Integer,Integer>> entryList = new ArrayList<>(freqMap.entrySet());
        System.out.println("Original list = " + entryList);

        Comparator<Map.Entry<Integer,Integer>> valueComparator = Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder());
        Comparator<Map.Entry<Integer,Integer>> keyComparator = Comparator.comparing(Map.Entry::getKey, Comparator.reverseOrder());
        Comparator<Map.Entry<Integer,Integer>> valueThenKeyComparator = valueComparator.thenComparing(keyComparator);

        entryList.sort(valueThenKeyComparator);

        System.out.println("Sorted list = " + entryList);
    }
    private static void nullsLast_nullsFirst_ex() {
        List<Employee> employeeList = populateEmployeeList();
        employeeList.add(null);
        employeeList.add(null);

        Comparator<Employee> nameComparator = Comparator.comparing(Employee::getName);
        Comparator<Employee> employeeNameComparator_nullLast = Comparator.nullsLast(nameComparator);

        employeeList.sort(employeeNameComparator_nullLast);
        System.out.println(" --------------- List with name waise sorting with nullLast -----------------");
        employeeList.forEach(System.out::println);


        Comparator<Employee> cityComparator = Comparator.comparing(Employee::getCity);
        Comparator<Employee> cityComparator_nullFirst = Comparator.nullsFirst(cityComparator);

        employeeList.sort(cityComparator_nullFirst);
        System.out.println(" --------------- List with name waise sorting with nullLast -----------------");
        employeeList.forEach(System.out::println);

    }


    public static List<Employee> populateEmployeeList() {
        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee("Keith", 35, 4000.0, "Delhi"));
        employeeList.add(new Employee("John", 25, 3000.0, "Mumbai"));
        employeeList.add(new Employee("Austin", 22, 2000.0, "Pune"));
        employeeList.add(new Employee("Zeny", 25, 3500.0, "Kolkata"));
        employeeList.add(new Employee("Tim", 28, 5000.0, "Chennai"));
        return employeeList;
    }

}
