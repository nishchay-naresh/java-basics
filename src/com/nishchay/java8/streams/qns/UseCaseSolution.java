package com.nishchay.java8.streams.qns;

import com.nishchay.util.pojo.Student;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UseCaseSolution {

    public static void main(String[] args) {
        getStudents(Arrays.asList(5, 7, 9, 1, 2));
    }

    /*
     *	There is a Student{long id; String name; int age;} class, you need to write this method
     *		 private List<Student>  getStudents(List<Long> idList){}
     *	You need to maintain the order of students as per the order of ids
     *	Don't have the DB call for each ID, Instead identify the new rows in table and bring them in 1 DB hit
     *
     *	This is a very common real-world backend problem + interview problem
     *	Key requirements are:
     *		-	Input ->  List<Long> idList (order matters)
     *		-	Output ->  List<Student> in the same order as idList
     *		-	Only ONE DB call
     *		-	DB returns students in random order
     *		-	Efficient & clean Java 8+ solution
     *
     *
     * Complexity Analysis
     *       DB fetch → O(n)
     *       Map creation → O(n)
     *       Ordered reconstruction → O(n)
     *  Total = O(n)
     *
     * */

    private static List<Student> getStudents(List<Integer> idList) {

        // 1 DB hit
        List<Student> studDBList = fetchStudentsFromDB(idList);

        // Map for fast lookup
        Map<Integer, Student> studentMap =
                studDBList.stream()
                        .collect(Collectors.toMap(
                                Student::getStudNo,
                                Function.identity()
                        ));

        // Maintain order of ids
        return idList.stream()
                .map(studentMap::get)
                .filter(Objects::nonNull) // in case some IDs not found
                .collect(Collectors.toList());
    }

    private static List<Student> fetchStudentsFromDB(List<Integer> idList) {
        return Student.populateStudentList();
    }

}
