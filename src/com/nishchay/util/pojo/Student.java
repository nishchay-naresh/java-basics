package com.nishchay.util.pojo;

import java.util.ArrayList;
import java.util.List;

public class Student implements Comparable<Student> {

    private int studNo;
    private String studName;
    private String deptName;
    private Double marks;
    private String city;

    public Student(){
    }

    public Student(int studNo, String studName, String deptName, Double marks, String city) {
        this.studName = studName;
        this.deptName = deptName;
        this.marks = marks;
        this.studNo = studNo;
        this.city = city;
    }

    public static List<Student> populateStudentList(){

        List<Student> studentList = new ArrayList<>();

        studentList.add(new Student(7499, "ALLEN","SCIENCE",55.25, "CHICAGO"));
        studentList.add(new Student(7782, "CLARK","COMMERCE",75.32, "NEW YORK"));
        studentList.add(new Student(7900, "JAMES","ART",62.48, "CHICAGO"));
        studentList.add(new Student(7839, "KING","SCIENCE",32.65, "NEW YORK"));
        studentList.add(new Student(7369, "SMITH","ART",98.85, "DALLAS"));
        studentList.add(new Student(7844, "TURNER","SCIENCE",83.00, "CHICAGO"));

/*
        studentList.add(new Student(7876, "ALLEN","SCIENCE",55.00, "DALLAS"));
        studentList.add(new Student(7698, "CLARK","COMMERCE",75.25, "CHICAGO"));
        studentList.add(new Student(7902, "FORD","ART",62.12, "DALLAS"));
        studentList.add(new Student(7566, "JONES","COMMERCE",32.15, "DALLAS"));
        studentList.add(new Student(7654, "MARTIN","ART",42.65, "CHICAGO"));
        studentList.add(new Student(7934, "MILLER","SCIENCE",36.78, "NEW YORK"));
        studentList.add(new Student(7788, "SCOTT","ART",56.63, "DALLAS"));
        studentList.add(new Student(7521, "WARD","COMMERCE",92.00, "CHICAGO"));
*/

        return studentList;
    }

    @Override
    // default ordering is base on - StudNo
    public int compareTo(Student student) {
        // return this.getStudNo() == student.getStudNo() ? 0 : this.getStudNo() > student.getStudNo() ? 1 : -1;
        return Integer.compare(this.getStudNo(), student.getStudNo());
    }

    public String getStudName() {
        return studName;
    }

    public void setStudName(String studName) {
        this.studName = studName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Double getMarks() {
        return marks;
    }

    public void setMarks(Double marks) {
        this.marks = marks;
    }

    public int getStudNo() {
        return studNo;
    }

    public void setStudNo(int studNo) {
        this.studNo = studNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studNo=" + studNo +
                ", studName='" + studName + '\'' +
                ", deptName='" + deptName + '\'' +
                ", marks=" + marks +
                ", city='" + city + '\'' +
                '}';
    }

}
