package com.nishchay.core.collection.comparator;

import com.nishchay.util.pojo.Student;

import java.util.*;

public class TreeSetSortDemo {

    public static void main(String[] args) {

        basicTreeSetDemo();
        treeSetDemoWithComparator();

    }

    private static void basicTreeSetDemo() {

        List<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("BBB");
        stringArrayList.add("JJJ");
        stringArrayList.add("ZZZ");
        stringArrayList.add("AAA");
        stringArrayList.add("QQQ");
        stringArrayList.add("III");

        Set<String> stringTreeSet = new TreeSet<>(stringArrayList);
        System.out.println("stringArrayList = " + stringArrayList);
        System.out.println("stringTreeSet = " + stringTreeSet);

    }

    private static void treeSetDemoWithComparator() {


        List<Student> studentList = Student.populateStudentList();

        Set<Student> studTSet = new TreeSet<>(studentList);
        System.out.println("                ######## Default(empNo) ordering #######");
        studTSet.forEach(System.out::println);

        studTSet = null;
        studTSet = new TreeSet<>(Comparator.comparing(Student::getStudName));
        studTSet.addAll(studentList);
        System.out.println("                ######## Name wise ordering #######");
        studTSet.forEach(System.out::println);

        studTSet = null;
        studTSet = new TreeSet<>(Comparator.comparing(Student::getCity));
        // TreeSet : emp with duplicate city name will be not gets added, only the first added entry will be there
        studTSet.addAll(studentList);
        System.out.println("                ######## City wise ordering #######");
        studTSet.forEach(System.out::println);
    }
}
/*
 * O/P =>
 *
 *	stringArrayList = [BBB, JJJ, ZZZ, AAA, QQQ, III]
 *	stringTreeSet = [AAA, BBB, III, JJJ, QQQ, ZZZ]
 *	                ######## Default(empNo) ordering #######
 *	Student{studName='SMITH', deptName='RESEARCH', job='CLERK', studNo=7369, city='DALLAS'}
 *	Student{studName='ALLEN', deptName='SALES', job='SALESMAN', studNo=7499, city='CHICAGO'}
 *	Student{studName='CLARK', deptName='ACCOUNTING', job='MANAGER', studNo=7782, city='NEW YORK'}
 *	Student{studName='KING', deptName='ACCOUNTING', job='PRESIDENT', studNo=7839, city='NEW YORK'}
 *	Student{studName='TURNER', deptName='SALES', job='SALESMAN', studNo=7844, city='CHICAGO'}
 *	Student{studName='JAMES', deptName='SALES', job='CLERK', studNo=7900, city='CHICAGO'}
 *	                ######## Name wise ordering #######
 *	Student{studName='ALLEN', deptName='SALES', job='SALESMAN', studNo=7499, city='CHICAGO'}
 *	Student{studName='CLARK', deptName='ACCOUNTING', job='MANAGER', studNo=7782, city='NEW YORK'}
 *	Student{studName='JAMES', deptName='SALES', job='CLERK', studNo=7900, city='CHICAGO'}
 *	Student{studName='KING', deptName='ACCOUNTING', job='PRESIDENT', studNo=7839, city='NEW YORK'}
 *	Student{studName='SMITH', deptName='RESEARCH', job='CLERK', studNo=7369, city='DALLAS'}
 *	Student{studName='TURNER', deptName='SALES', job='SALESMAN', studNo=7844, city='CHICAGO'}
 *	                ######## City wise ordering #######
 *	Student{studName='ALLEN', deptName='SALES', job='SALESMAN', studNo=7499, city='CHICAGO'}
 *	Student{studName='SMITH', deptName='RESEARCH', job='CLERK', studNo=7369, city='DALLAS'}
 *	Student{studName='CLARK', deptName='ACCOUNTING', job='MANAGER', studNo=7782, city='NEW YORK'}
 *
 * */

