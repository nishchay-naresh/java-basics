package com.nishchay.core.collection.comparator;

public class Employee implements Comparable<Employee> {

    private String empName;
    private String deptName;
    private String job;
    private int empNo;
    String city;

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
        return this.getEmpNo() == emp.getEmpNo() ? 0 : this.getEmpNo() > emp.getEmpNo() ? 1 : -1;
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

}
