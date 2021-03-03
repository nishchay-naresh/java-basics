package com.nishchay.java8.streams.query;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmployeeSQL {


    public static void main(String[] args) {

//        employeePrint();

//        maleFemaleEmployeeCount();
//        departmentNames();
//        maleFemaleEmployeeAvgAge();
//        highestAndLeastPaidEmployee();
//        employeesJoinedAfter2015();
//        countEmployeeInEachDept();
//        avgSalaryOfEachDept();
//        youngestMaleEmployeeFromADept();
//        seniorMostEmployee();
//        countMaleFemaleEmployeesInADept();
//        averageSalaryMaleAndFemaleEmployees();
//        employeeListFromEachDept();
//        getSalaryStatistics();


        // self practice
//        youngestOldestEmployee();
//         getEmpNameEmpMap();
//        first3EmpNames();
//        printEmpNamesStartingWtih_N();
        avgAndTotalSalaryOfFemaleEmployee();
//        femaleEmployeeWithHighestSalary();
    }


    private static void employeePrint() {
        System.out.println("================= Employee List =================");
        populateEmployeeList().forEach(System.out::println);
    }

    //Query 3.1 : How many male and female employees are there in the organization?
    private static void maleFemaleEmployeeCount() {

        long maleCount =
                populateEmployeeList().stream()
                        .map(e -> e.getGender())
                        .filter(e -> e.equals("Male"))
                        .count();

        long femaleCount =
                populateEmployeeList().stream()
                        .map(e -> e.getGender())
                        .filter(e -> e.equals("Female"))
                        .count();

        System.out.println("maleCount = " + maleCount);
        System.out.println("femaleCount = " + femaleCount);

        Map<String, Long> genderCount =
                populateEmployeeList().stream()
                        .collect(Collectors.groupingBy(e -> e.getGender(), Collectors.counting()));

        System.out.println("maleCount hm = " + genderCount.get("Male"));
        System.out.println("femaleCount hm = " + genderCount.get("Female"));

    }

    //Query 3.2 : Print the name of all departments in the organization?
    private static void departmentNames() {

        List<String> depts =
                populateEmployeeList().stream()
                        .map(e -> e.getDepartment())
                        .distinct()
                        .collect(Collectors.toList());

        System.out.println("----------------- Department Names --------------------");
        depts.forEach(System.out::println);
    }

    //Query 3.3 : What is the average age of male and female employees?
    private static void maleFemaleEmployeeAvgAge() {

        Map<String, Integer> totalAgeOfMaleAndFemaleEmployees = populateEmployeeList().stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.summingInt(Employee::getAge)));

        System.out.println(totalAgeOfMaleAndFemaleEmployees);

        Map<String, Double> avgAgeOfMaleAndFemaleEmployees =
                populateEmployeeList().stream()
                        .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));

        System.out.println(avgAgeOfMaleAndFemaleEmployees);

    }

    // Query 3.4 : Get the details of Highest and Least paid employee in the organization?
    private static void highestAndLeastPaidEmployee() {

        Optional<Employee> highestPaidEmployee =
                populateEmployeeList().stream()
                        .collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));

        Optional<Employee> leastPaidEmployee =
                populateEmployeeList().stream()
                        .collect(Collectors.minBy(Comparator.comparingDouble(Employee::getSalary)));

        populateEmployeeList().stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .map(Employee::getSalary)
                .forEach(System.out::println);


        System.out.println("================= Details Of Highest Paid Employee =================");
        System.out.println("highestPaidEmployee = " + highestPaidEmployee.get());

        Optional<Employee> highestPaidEmployee1 = populateEmployeeList().stream()
                .max(Comparator.comparingDouble(Employee::getSalary));
        System.out.println("highestPaidEmployee1 = " + highestPaidEmployee1.get());

        System.out.println("================= Details Of Least Paid Employee =================");
        System.out.println("leastPaidEmployee = " + leastPaidEmployee.get());

        Optional<Employee> leastPaidEmployee1 = populateEmployeeList().stream()
                .min(Comparator.comparingDouble(Employee::getSalary));
        System.out.println("leastPaidEmployee1 = " + leastPaidEmployee1.get());

    }

    //Query 3.5 : Get the names of all employees who have joined after 2015?
    private static void employeesJoinedAfter2015() {
        populateEmployeeList().stream()
                .filter(e -> e.getYearOfJoining() > 2015)
                .map(Employee::getName)
                .forEach(System.out::println);
    }

    // Query 3.6 : Count the number of employees in each department?
    private static void countEmployeeInEachDept() {

        // Count employee in each Department
        Map<String, Long> deptCount =
                populateEmployeeList().stream()
                        .collect(Collectors.groupingBy(e -> e.getDepartment(), Collectors.counting()));

        System.out.println("Department Name " + " -> " + " Employee Count in Department ");
        System.out.println("--------------------------------------------------");

        for (Map.Entry<String, Long> entry : deptCount.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

    }


    //    Query 3.7 : What is the average salary of each department?
    private static void avgSalaryOfEachDept() {

        Map<String, Double> deptAvgSalary =
                populateEmployeeList().stream()
                        .collect(Collectors.groupingBy(e -> e.getDepartment(), Collectors.averagingDouble(Employee::getSalary)));

        System.out.println(deptAvgSalary);

        System.out.println("Dept Name \t\t\t\t\t\t   Avg Salary");
        deptAvgSalary.forEach((key, value) -> System.out.println(key + "\t\t --->\t " + value));
    }

    // Query 3.8 : Get the details of youngest male employee in the "product development" department?
    private static void youngestMaleEmployeeFromADept() {

        Optional<Employee> youngestMaleEmployeeInADept =
                populateEmployeeList().stream()
                        .filter(e -> e.getGender() == "Male" && e.getDepartment() == "Product Development")
                        .min(Comparator.comparingInt(Employee::getAge));

        System.out.println("youngestMaleEmployeeInADept = " + youngestMaleEmployeeInADept.get());
    }

    //    Query 3.9 : Who has the enior most employee in the organization?
    private static void seniorMostEmployee() {

        Optional<Employee> seniorMostEmp =
                populateEmployeeList().stream()
                        .sorted(Comparator.comparingInt(Employee::getYearOfJoining)).findFirst();

        System.out.println("seniorMostEmp = " + seniorMostEmp.get());

        Optional<Employee> seniorMostEmp1 =
                populateEmployeeList().stream()
                        .min(Comparator.comparingInt(Employee::getYearOfJoining));

        System.out.println("seniorMostEmp1 = " + seniorMostEmp1.get());
    }

    //  Query 3.10 : How many male and female employees are there in the sales and marketing team?
    private static void countMaleFemaleEmployeesInADept() {

        Map<String, Long> countMaleFemaleEmployeesInSalesMarketing =
                populateEmployeeList().stream()
                        .filter(e -> e.getDepartment() == "Sales And Marketing")
                        .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

        System.out.println(countMaleFemaleEmployeesInSalesMarketing);

    }

    // Query 3.11 : What is the average salary of male and female employees?
    private static void averageSalaryMaleAndFemaleEmployees() {
        Map<String, Double> avgSalaryOfMaleAndFemaleEmployees =
                populateEmployeeList().stream()
                        .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));

        System.out.println(avgSalaryOfMaleAndFemaleEmployees);
    }

    //  Query 3.12 : List down the names of all employees in each department?
    private static void employeeListFromEachDept() {
        Map<String, List<Employee>> deptCount =
                populateEmployeeList().stream()
                        .collect(Collectors.groupingBy(e -> e.getDepartment()));

        System.out.println("Department Name " + " -> " + " Employee Count in Department ");
        System.out.println("--------------------------------------------------");

        for (Map.Entry<String, List<Employee>> entry : deptCount.entrySet()) {
            System.out.println("----------------Dept -  " + entry.getKey() + "-------------- ");
            entry.getValue().forEach(System.out::println);
        }
    }

    // Query 3.13 : What is the average, total, min, max salary of the whole organization?
    private static void getSalaryStatistics() {

        DoubleSummaryStatistics employeeSalaryStatistics =
                populateEmployeeList().stream().collect(Collectors.summarizingDouble(Employee::getSalary));

        System.out.println("Salary count = " + employeeSalaryStatistics.getCount());
        System.out.println("Total Salary = " + employeeSalaryStatistics.getSum());
        System.out.println("Min Salary = " + employeeSalaryStatistics.getMin());
        System.out.println("Max Salary = " + employeeSalaryStatistics.getMax());
        System.out.println("Average Salary = " + employeeSalaryStatistics.getAverage());

    }


    private static void youngestOldestEmployee() {

        populateEmployeeList().stream()
                .sorted(Comparator.comparingInt(Employee::getAge))
                .forEach(System.out::println);

        Optional<Employee> youngest = populateEmployeeList().stream()
                .min(Comparator.comparingInt(Employee::getAge));

        System.out.println("youngest = " + youngest.get());

        Optional<Employee> oldest = populateEmployeeList().stream()
                .max(Comparator.comparingInt(Employee::getAge));

        System.out.println("oldest = " + oldest.get());

    }

    private static void getEmpNameEmpMap() {


        Map<String, Employee> empMap = populateEmployeeList().stream()
                .collect(Collectors.toMap(e -> e.getName(), Function.identity()));

        System.out.println("----------------- Employee Map on name basis --------------------");
        empMap.forEach((key, value) -> System.out.println("[Key] : " + key + " [Value] : " + value));
    }


    private static void first3EmpNames() {

//        Collecting first 3 employee name in a string
        String first3EmployeeName = populateEmployeeList().stream()
                .limit(3)
                .map(Employee::getName)
                .collect(Collectors.joining(", "));

        System.out.println("first3EmployeeName = " + first3EmployeeName);// Jiya Brein, Paul Niksui, Martin Theron

    }

    private static void printEmpNamesStartingWtih_N() {

        System.out.println("printing employee name starting with latter - 'N' ");
        populateEmployeeList().stream()
                .map(Employee::getName)
                .filter(e -> e.startsWith("N"))
                .forEach(System.out::println);
    }

    private static void avgAndTotalSalaryOfFemaleEmployee() {

        double femaleSalaryTotal = populateEmployeeList().stream()
                .filter(e -> e.getGender().equals("Female"))
                .map(Employee::getSalary)
                .mapToDouble(i -> i)
                .sum();

        System.out.println("femaleSalaryTotal = " + femaleSalaryTotal);

        double femaleSalaryAverage = populateEmployeeList().stream()
                .filter(e -> e.getGender().equals("Female"))
                .map(Employee::getSalary)
                .mapToDouble(i -> i)
                .average().getAsDouble();

        System.out.println("femaleSalaryAverage = " + femaleSalaryAverage);

    }




    public static List<Employee> populateEmployeeList() {

        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 37000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

        return employeeList;
    }

}
