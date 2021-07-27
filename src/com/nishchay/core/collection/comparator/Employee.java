package com.nishchay.core.collection.comparator;

import java.util.ArrayList;
import java.util.List;

public class Employee implements Comparable<Employee> {

    private String empName;
    private String deptName;
    private String job;
    private int empNo;
    private String city;

    public Employee(){
    }

    public Employee(String empName, String deptName, String job, int empNo, String city) {
        this.empName = empName;
        this.deptName = deptName;
        this.job = job;
        this.empNo = empNo;
        this.city = city;
    }


    @Override
    // default ordering is base on - empNo
    public int compareTo(Employee emp) {
//        return this.getEmpNo() == emp.getEmpNo() ? 0 : this.getEmpNo() > emp.getEmpNo() ? 1 : -1;
        return Integer.compare(this.getEmpNo(), emp.getEmpNo());
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empName='" + empName + '\'' +
                ", deptName='" + deptName + '\'' +
                ", job='" + job + '\'' +
                ", empNo=" + empNo +
                ", city='" + city + '\'' +
                '}';
    }

    public static List<Employee> populateEmployeeList(){

        List<Employee> empList = new ArrayList<>();

        empList.add(new  Employee("ALLEN","SALES","SALESMAN",7499,"CHICAGO"));
        empList.add(new  Employee("CLARK","ACCOUNTING","MANAGER",7782,"NEW YORK"));
        empList.add(new  Employee("JAMES","SALES","CLERK",7900,"CHICAGO"));
        empList.add(new  Employee("KING","ACCOUNTING","PRESIDENT",7839,"NEW YORK"));
        empList.add(new  Employee("SMITH","RESEARCH","CLERK",7369,"DALLAS"));
        empList.add(new  Employee("TURNER","SALES","SALESMAN",7844,"CHICAGO"));

/*
        empList.add(new Employee("ADAMS", "RESEARCH", "CLERK", 7876, "DALLAS"));
        empList.add(new Employee("BLAKE", "SALES", "MANAGER", 7698, "CHICAGO"));
        empList.add(new Employee("FORD", "RESEARCH", "ANALYST", 7902, "DALLAS"));
        empList.add(new Employee("JONES", "RESEARCH", "MANAGER", 7566, "DALLAS"));
        empList.add(new Employee("MARTIN", "SALES", "SALESMAN", 7654, "CHICAGO"));
        empList.add(new Employee("MILLER", "ACCOUNTING", "CLERK", 7934, "NEW YORK"));
        empList.add(new Employee("SCOTT", "RESEARCH", "ANALYST", 7788, "DALLAS"));
        empList.add(new Employee("WARD", "SALES", "SALESMAN", 7521, "CHICAGO"));
*/
        return empList;
    }

}
