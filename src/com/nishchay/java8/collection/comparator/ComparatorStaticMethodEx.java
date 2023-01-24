package com.nishchay.java8.collection.comparator;


import com.nishchay.ds.string.freq.StringFrequencyUtility;
import com.nishchay.util.pojo.Student;

import java.util.*;


public class ComparatorStaticMethodEx {

    public static void main(String[] args) {

        naturalOrderReverseOrderEx();

        List<Student> studentList = Student.populateStudentList();
        System.out.println(" ===================== Original List ===================== ");
        studentList.forEach(System.out::println);

        System.out.println(" ==================== comparingEx ======================== ");
        comparingEx(studentList);

        System.out.println(" ==================== comparingXxxEx ===================== ");
        comparingXxxEx(studentList);

        System.out.println(" ==================== thenComparingEx  ==================== ");
        thenComparingEx(studentList);

        System.out.println(" =================== nullsLastAndFirstEx  ================= ");
        nullsLastAndFirstEx(studentList);

        System.out.println(" ==================== thenComparingExMap  ================= ");
        thenComparingExMap();

    }


    //    Using Comparator.naturalOrder() & Comparator.reverseOrder()
    private static void naturalOrderReverseOrderEx() {

        List<String> animals = Arrays.asList("tiger", "lion", "bear", "panther", "zebra", "fox", "deer");

        System.out.println(" --------------- Original List -----------------");
        animals.forEach(System.out::println);

        System.out.println(" --------------- Natural Order Sorting -----------------");
        animals.sort(Comparator.naturalOrder());
        animals.forEach(System.out::println);

        System.out.println(" --------------- Reverse Order Sorting -----------------");
        animals.sort(Comparator.reverseOrder());
        animals.forEach(System.out::println);
    }

    private static void comparingEx(List<Student> studentList) {

        // Using Comparator.comparing(-)
        System.out.println(" --------------- Sorting based on StudName -----------------");
        Comparator<Student> nameComparator = (Student s1, Student s2) -> s1.getStudName().compareTo(s2.getDeptName());
        // Comparator<Student> nameComparator = Comparator.comparing(Student::getStudName);
        studentList.sort(nameComparator);
        studentList.forEach(System.out::println);

        System.out.println(" --------------- Sorting based on studNo -----------------");
        // Comparator<Student> noComparator = (Student s1, Student s2) -> s1.getStudNo() - s2.getStudNo();
        Comparator<Student> noComparator = Comparator.comparing(Student::getStudNo);
        studentList.sort(noComparator);
        studentList.forEach(System.out::println);

        System.out.println(" --------------- Sorting based on Names but in reverse order -----------------");
        Collections.sort(studentList, nameComparator.reversed());
        studentList.forEach(System.out::println);
        // Another way to achieve this Using Comparator.reverseOrder()
        nameComparator = Comparator.comparing(Student::getStudName, Comparator.reverseOrder());
        studentList.sort(nameComparator);
        studentList.forEach(System.out::println);

        // Using Comparator.comparing(-,-)
        System.out.println(" --------------- Sorting based on CityName length -----------------");
        // Comparator<Student> cityLengthComparator = Comparator.comparing(Student::getCity, (o1, o2) -> o1.length() - o2.length());
        // Comparator<Student> cityLengthComparator = Comparator.comparing(Student::getCity, Comparator.comparing(String::length));
        Comparator<Student> cityLengthComparator = Comparator.comparing(Student::getCity, Comparator.comparingInt(String::length));
        studentList.sort(cityLengthComparator);
        studentList.forEach(System.out::println);

    }


    private static void comparingXxxEx(List<Student> studentList) {
        // Using Comparator.comparingInt
        System.out.println(" --------------- Sorting based on StudNo -----------------");
        Comparator<Student> ageComparator = Comparator.comparingInt(Student::getStudNo);
        studentList.sort(ageComparator);
        studentList.forEach(System.out::println);

        //Using Comparator.comparingDouble
        System.out.println(" --------------- Sorting based on Marks -----------------");
        Comparator<Student> salaryComparator = Comparator.comparingDouble(Student::getMarks);
        studentList.sort(salaryComparator);
        studentList.forEach(System.out::println);
    }

    //    Comparator.thenComparing - composting two comparator using - thenComparing
    //    Adding multiple sorting criteria, if city is same then go for marks
    private static void thenComparingEx(List<Student> studentList) {

        Comparator<Student> cityThenMarksComparator = Comparator.comparing(Student::getCity)
                .thenComparing(Student::getMarks);

        System.out.println(" --------------- Sorting based on City then Marks -----------------");
        studentList.sort(cityThenMarksComparator);
        studentList.forEach(System.out::println);
    }

    private static void nullsLastAndFirstEx(List<Student> studentList) {

        studentList.add(null);
        studentList.add(null);

        Comparator<Student> nameComparator = Comparator.comparing(Student::getStudName);
        Comparator<Student> employeeNameComparator_nullLast = Comparator.nullsLast(nameComparator);

        studentList.sort(employeeNameComparator_nullLast);
        System.out.println(" --------------- List with name wise sorting with nullLast -----------------");
        studentList.forEach(System.out::println);


        Comparator<Student> cityComparator = Comparator.comparing(Student::getCity);
        Comparator<Student> cityComparator_nullFirst = Comparator.nullsFirst(cityComparator);

        studentList.sort(cityComparator_nullFirst);
        System.out.println(" --------------- List with City wise sorting with nullFirst -----------------");
        studentList.forEach(System.out::println);

    }

    private static void thenComparingExMap() {

        int[] arr = {7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9};
        Map<Integer,Integer> freqMap = StringFrequencyUtility.getFrequencyMap(arr);

        List<Map.Entry<Integer,Integer>> entryList = new ArrayList<>(freqMap.entrySet());
        System.out.println("Original list = " + entryList);

        Comparator<Map.Entry<Integer,Integer>> valueComparator = Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder());
        Comparator<Map.Entry<Integer,Integer>> keyComparator = Comparator.comparing(Map.Entry::getKey, Comparator.reverseOrder());
        Comparator<Map.Entry<Integer,Integer>> valueThenKeyComparator = valueComparator.thenComparing(keyComparator);

        entryList.sort(valueThenKeyComparator);
        System.out.println("Sorted list = " + entryList);
    }

}
