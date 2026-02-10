package com.nishchay.java8.streams.qns;


import com.nishchay.java8.streams.qns.pojo.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 *
 * https://javaconceptoftheday.com/solving-real-time-queries-using-java-8-features-employee-management-system/
 * */
public class EmployeeSQL {


    public static void main(String[] args) {

        List<Employee> employeeList = Employee.employeeList;
        employeePrint(employeeList);

        genderCount(employeeList);
        departmentNames(employeeList);
        maleFemaleEmployeeAvgAge(employeeList);
        highestAndLeastPaidEmployee(employeeList);
        groupEmployeeDeptWise(employeeList);
        youngestMaleEmployeeFromADept();
        seniorMostEmployee();
        countMaleFemaleEmployeesInADept();
        averageSalaryMaleAndFemaleEmployees();
        employeeListFromEachDept();
        getSalaryStatistics();


        // self-practice
        youngestOldestEmployee();
        getEmpNameEmpMap();
        first3EmpNames();
        printEmpNamesStartingWtih_N();
        avgAndTotalSalaryOfFemaleEmployee();
        femaleEmployeeWithHighestSalary();
        getEmployeeYoungerThan25();
    }

    private static void employeePrint(List<Employee> empList) {
        System.out.println("================= Employee List =================");
        empList.forEach(System.out::println);
    }

    //Query 3.1: How many male and female employees are there in the organization
    private static void genderCount(List<Employee> empList) {
        long maleCount =
                empList.stream()
                        .map(e -> e.getGender())
                        .filter(e -> e.equals("Male"))
                        .count();

        long femaleCount =
                Employee.employeeList.stream()
                        .map(e -> e.getGender())
                        .filter(e -> e.equals("Female"))
                        .count();

        System.out.println("maleCount = " + maleCount);
        System.out.println("femaleCount = " + femaleCount);

        // grouping employee based on gender - applying groupingBy(-,-)
        Map<String, Long> genderMapUsingGroupBy =
                Employee.employeeList.stream()
                        .collect(Collectors.groupingBy(e -> e.getGender(), Collectors.counting()));
        System.out.println("genderMapUsingGroupBy = " + genderMapUsingGroupBy);

        Map<String, Long> genderMapUsingPartitionBy = empList.stream()
                .collect(Collectors.partitioningBy(
                        e -> e.getGender().equalsIgnoreCase("Male"),
                        Collectors.counting()
                )).entrySet().stream()
                .collect(Collectors.toMap(
                        e -> e.getKey() ? "Male" : " Female",
                        Map.Entry::getValue
                ));
        System.out.println("genderMapUsingPartitionBy = " + genderMapUsingPartitionBy);
    }

    //Query 3.2: Print the name of all departments in the organization
    private static void departmentNames(List<Employee> empList) {
        List<String> deptNames =
                empList.stream()
                        .map(e -> e.getDepartment())
                        .distinct()
                        .collect(Collectors.toList());

        System.out.println("----------------- Department Names --------------------");
        System.out.println("deptNames = " + deptNames);
    }

    //Query 3.3: What is the average age of male and female employees
    private static void maleFemaleEmployeeAvgAge(List<Employee> empList) {
        Map<String, Integer> totalAgeOfMaleAndFemaleEmployees =
                empList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.summingInt(Employee::getAge)));
        System.out.println(totalAgeOfMaleAndFemaleEmployees);

        Map<String, Double> avgAgeOfMaleAndFemaleEmployees =
                empList.stream()
                        .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
        System.out.println(avgAgeOfMaleAndFemaleEmployees);
    }

    // Query 3.4: Get the details of the highest and least paid employee in the organization
    private static void highestAndLeastPaidEmployee(List<Employee> empList) {
        Optional<Employee> highestPaidEmployee =
                empList.stream()
                        .max(Comparator.comparingDouble(Employee::getSalary));

        Optional<Employee> leastPaidEmployee =
                empList.stream()
                        .min(Comparator.comparingDouble(Employee::getSalary));

        System.out.println("================= Details Of Highest & Least Paid Employee =================");
        System.out.println("highestPaidEmployee = " + highestPaidEmployee.orElse(null));
        System.out.println("leastPaidEmployee = " + leastPaidEmployee.orElse(null));
    }

    //Query 3.5: Get the names of all employees who have joined after 2015
    private static void employeesJoinedAfter2015(List<Employee> empList) {
        empList.stream()
                .filter(e -> e.getYearOfJoining() > 2015)
                .map(Employee::getName)
                .forEach(System.out::println);
    }

    // Query 3.6: Count the number of employees in each department
    // Query 3.7: What is the average salary of each department?
    private static void groupEmployeeDeptWise(List<Employee> empList) {
        System.out.println("-------- employee count in each Department ------------------");
        Map<String, Long> deptCount =
                empList.stream()
                .collect(Collectors.groupingBy(
                        e -> e.getDepartment(),
                        Collectors.counting()
                ));
        System.out.println("deptCount = " + deptCount);

        System.out.println("-------- average salary of each Department ------------------");
        Map<String, Double> deptAvgSalary =
                empList.stream()
                .collect(Collectors.groupingBy(
                        e -> e.getDepartment(),
                        Collectors.averagingDouble(Employee::getSalary)
                ));
        System.out.println("deptAvgSalary = " + deptAvgSalary);
    }

    // Query 3.8: Get the details of youngest male employee in the "product development" department
    private static void youngestMaleEmployeeFromADept() {

        Optional<Employee> youngestMaleEmployeeInADept =
                Employee.employeeList.stream()
                        .filter(e -> e.getGender().equals("Male") && e.getDepartment().equals("Product Development"))
                        .min(Comparator.comparingInt(Employee::getAge));

        System.out.println("youngestMaleEmployeeInADept = " + youngestMaleEmployeeInADept.orElse(null));
    }

    // Query 3.9: Who has the senior most employee in the organization
    private static void seniorMostEmployee() {

        Optional<Employee> seniorMostEmp =
                Employee.employeeList.stream()
                        .sorted(Comparator.comparingInt(Employee::getYearOfJoining)).findFirst();

        System.out.println("seniorMostEmp = " + seniorMostEmp.orElse(null));

        Optional<Employee> seniorMostEmp1 =
                Employee.employeeList.stream()
                        .min(Comparator.comparingInt(Employee::getYearOfJoining));

        System.out.println("seniorMostEmp1 = " + seniorMostEmp1.orElse(null));
    }

    //  Query 3.10: How many male and female employees are there in the sales and marketing team
    private static void countMaleFemaleEmployeesInADept() {

        Map<String, Long> countMaleFemaleEmployeesInSalesMarketing =
                Employee.employeeList.stream()
                        .filter(e -> e.getDepartment().equals("Sales And Marketing"))
                        .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

        System.out.println(countMaleFemaleEmployeesInSalesMarketing);
    }

    // Query 3.11: What is the average salary of male and female employees
    private static void averageSalaryMaleAndFemaleEmployees() {
        Map<String, Double> avgSalaryOfMaleAndFemaleEmployees =
                Employee.employeeList.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getGender,
                                Collectors.averagingDouble(Employee::getSalary)
                        ));

        System.out.println(avgSalaryOfMaleAndFemaleEmployees);
    }

    //  Query 3.12: List down the names of all employees in each department
    private static void employeeListFromEachDept() {
        Map<String, List<Employee>> deptCount =
                Employee.employeeList.stream()
                        .collect(Collectors.groupingBy(e -> e.getDepartment()));

        System.out.println("Department Name " + " -> " + " Employee Count in Department ");
        System.out.println("--------------------------------------------------");

        for (Map.Entry<String, List<Employee>> entry : deptCount.entrySet()) {
            System.out.println("----------------Dept -  " + entry.getKey() + "-------------- ");
            entry.getValue().forEach(System.out::println);
        }
    }

    // Query 3.13: What is the average, total, min, max salary of the whole organization
    private static void getSalaryStatistics() {
        DoubleSummaryStatistics employeeSalaryStatistics =
                Employee.employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));

        System.out.println("Salary count = " + employeeSalaryStatistics.getCount());
        System.out.println("Total Salary = " + employeeSalaryStatistics.getSum());
        System.out.println("Min Salary = " + employeeSalaryStatistics.getMin());
        System.out.println("Max Salary = " + employeeSalaryStatistics.getMax());
        System.out.println("Average Salary = " + employeeSalaryStatistics.getAverage());
    }


    private static void youngestOldestEmployee() {
        Employee.employeeList.stream()
                .sorted(Comparator.comparingInt(Employee::getAge))
                .forEach(System.out::println);

        Optional<Employee> youngest = Employee.employeeList.stream()
                .min(Comparator.comparingInt(Employee::getAge));

        System.out.println("youngest = " + youngest.orElse(null));

        Optional<Employee> oldest = Employee.employeeList.stream()
                .max(Comparator.comparingInt(Employee::getAge));

        System.out.println("oldest = " + oldest.orElse(null));
    }

    private static void getEmpNameEmpMap() {


        Map<String, Employee> empMap = Employee.employeeList.stream()
                .collect(Collectors.toMap(e -> e.getName(), Function.identity()));

        System.out.println("----------------- Employee Map on name basis --------------------");
        empMap.forEach((key, value) -> System.out.println("[Key] : " + key + " [Value] : " + value));
    }


    private static void first3EmpNames() {

        // Collecting first 3 employee names in a string
        String first3EmployeeName = Employee.employeeList.stream()
                .limit(3)
                .map(Employee::getName)
                .collect(Collectors.joining(", "));

        System.out.println("first3EmployeeName = " + first3EmployeeName);// Jiya Brein, Paul Niksui, Martin Theron

    }

    private static void printEmpNamesStartingWtih_N() {

        System.out.println("printing employee name starting with latter - 'N' ");
        Employee.employeeList.stream()
                .map(Employee::getName)
                .filter(e -> e.startsWith("N"))
                .forEach(System.out::println);
    }

    private static void avgAndTotalSalaryOfFemaleEmployee() {

        double femaleSalaryTotal = Employee.employeeList.stream()
                .filter(e -> e.getGender().equals("Female"))
                .map(Employee::getSalary)
                .mapToDouble(i -> i)
                .sum();

        System.out.println("femaleSalaryTotal = " + femaleSalaryTotal);

        double femaleSalaryAverage = Employee.employeeList.stream()
                .filter(e -> e.getGender().equals("Female"))
                .map(Employee::getSalary)
                .mapToDouble(i -> i)
                .average().getAsDouble();

        System.out.println("femaleSalaryAverage = " + femaleSalaryAverage);
    }

    private static void femaleEmployeeWithHighestSalary() {

        Optional<Employee> optionalEmployee = Employee.employeeList.stream()
                .filter(e -> e.getGender().equals("Female"))
                .reduce((e1, e2) -> e1.getSalary() > e2.getSalary() ? e1 : e2);

        System.out.println("Female Employee With Highest Salary = " + optionalEmployee.get());

        optionalEmployee = Employee.employeeList.stream()
                .filter(e -> e.getGender().equals("Female"))
                .sorted(Comparator.comparing(Employee::getSalary, Comparator.reverseOrder()))
                .findFirst();

        System.out.println("optionalEmployee = " + optionalEmployee.get());

        optionalEmployee = Employee.employeeList.stream()
                .filter(e -> e.getGender().equals("Female"))
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .findFirst();

        System.out.println("optionalEmployee = " + optionalEmployee.get());
    }

    private static void getEmployeeYoungerThan25() {
        // Get me the list of employee, who all are younger than 25yrs (testing concept of filter & predicate)
        List<Employee> youngerEmpList = Employee.employeeList.stream()
                .filter(e -> e.getAge() < 25)
                .collect(Collectors.toList());
        System.out.println("youngerEmpList = " + youngerEmpList);

        //Get me the list of names of employee, who all are younger than 25yrs (testing concept of map)
        List<String> youngerEmpNameList = Employee.employeeList.stream()
                .filter(e -> e.getAge() < 25)
                .map(e -> e.getName())
                .collect(Collectors.toList());

        System.out.println("youngerEmpNameList = " + youngerEmpNameList);
    }
}
