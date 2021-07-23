package com.nishchay.core.collection.comparator;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionSortDemo {

    public static void main(String[] args) {
        List<Employee> empList  = Employee.populateEmployeeList();

        System.out.println("######## Employee List #######");
        empList.forEach(System.out::println);

        Collections.sort(empList);
        System.out.println("######## Default(empNo) ordering #######");
        empList.forEach(System.out::println);

        System.out.println("######## Job wise ordering #######");
        Collections.sort(empList, (e1,e2) -> e1.getJob().compareTo(e2.getJob()));
        empList.forEach(System.out::println);


        System.out.println("######## Department wise ordering #######");
        Collections.sort(empList, (e1,e2) -> e1.getDeptName().compareTo(e2.getDeptName()));
        empList.forEach(System.out::println);


        System.out.println("######## City wise ordering #######");
//        Collections.sort(empList, (e1,e2) -> e1.getCity().compareTo(e2.getCity()));
//        (c1, c2) -> keyExtractor.apply(c1).compareTo(keyExtractor.apply(c2))
        Comparator<Employee> cityComparator = Comparator.comparing(Employee::getCity);

        empList.sort(cityComparator);
        empList.forEach(System.out::println);

    }

}
