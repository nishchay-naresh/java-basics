package com.nishchay.core.collection.comparator;


import com.nishchay.util.pojo.Student;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionSortDemo {

    public static void main(String[] args) {

        List<Student> studentList = Student.populateStudentList();

        System.out.println("######## Student List #######");
        studentList.forEach(System.out::println);

        Collections.sort(studentList);
        System.out.println("######## Default(studNo) ordering #######");
        studentList.forEach(System.out::println);

        System.out.println("######## Marks wise ordering #######");
        Collections.sort(studentList, Comparator.comparingDouble(Student::getMarks));
        studentList.forEach(System.out::println);


        System.out.println("######## Department wise ordering #######");
        Collections.sort(studentList, (e1, e2) -> e1.getDeptName().compareTo(e2.getDeptName()));
        studentList.forEach(System.out::println);


        System.out.println("######## City wise ordering #######");
        //Collections.sort(studentList, (e1, e2) -> e1.getCity().compareTo(e2.getCity()));
        Comparator<Student> cityComparator = Comparator.comparing(Student::getCity);

        studentList.sort(cityComparator);
        studentList.forEach(System.out::println);

    }

}
