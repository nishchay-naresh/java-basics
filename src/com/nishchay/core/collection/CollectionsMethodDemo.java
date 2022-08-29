package com.nishchay.core.collection;

import com.nishchay.core.collection.comparator.Employee;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public class CollectionsMethodDemo {

    public static void main(String[] args) {

        swapEx();
        nCopiesEx();

    }


    private static void swapEx() {
        List<String> list = Arrays.asList("a", "b", "c", "d", "e", "f");
        System.out.println("At index 1 & 2 = " + list.get(1) + " " + list.get(2));
        Collections.swap(list, 1, 2);
        System.out.println("At index 1 & 2 = " + list.get(1) + " " + list.get(2));
    }

    /*
     *   Collections.nCopies() is to return an immutable list which contains n copies of given object.
     *   This function helps if we want to create a list with n copies of given object.
     *   The newly allocated data object is tiny i.e, it contains a single reference to the data object.
     *
     *       public static <T> List<T> nCopies(int n, T o)
     *           int n : the number of elements in the returned list.
     *           T o : the element to appear repeatedly in the returned list.
     *           Exception : The function throws IllegalArgumentException if value of number is less than 0.
     *
     * */
    private static void nCopiesEx() {

        String stringToBeCopied = "java8";
        List<String> copyList = Collections.nCopies(5, stringToBeCopied);
        System.out.println("The list returned is: " + copyList);

        System.out.println("----------------Atomic Integer------------------");
        AtomicInteger ai = new AtomicInteger();
        List<AtomicInteger> list = Collections.nCopies(3, ai);
        System.out.println(list);
        ai.incrementAndGet();
        System.out.println(list);

        System.out.println("----------------------------------Employee------------------------------");
        Employee emp = new Employee("Rober Downey Jr ", "R&D", "Manager", 7900, "New York");
        List<Employee> empList = Collections.nCopies(4, emp);
        System.out.println(empList.get(0) + "\n" + empList.get(1) + "\n" + empList.get(2) + "\n" + empList.get(3));
        emp.setEmpName("Iron Man");
        emp.setEmpNo(9999);
        System.out.println(empList.get(0) + "\n" + empList.get(1) + "\n" + empList.get(2) + "\n" + empList.get(3));

    }


}

