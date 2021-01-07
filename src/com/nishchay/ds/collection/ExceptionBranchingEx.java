package com.nishchay.ds.collection;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/*
*   java TestMe 1, @, 2, -4, ?, -6, ab, $, %, 9, 0, 1
*   should give output like
*   Numbers : In ascending order no duplicate
*   Non-Numbers : In the order of their arrival
*   -----------
*   args - [1, @, 2, -4, ?, -6, ab, $, %, 9, 0, 1]
*   Numbers - [-6, -4, 0, 1, 2, 9]
*   Non-Numbers - [@, ?, ab, $, %]
*
* */
public class ExceptionBranchingEx {

    public static void main(String[] args) {

        int number;
        String[] arguments = {"1", "@", "2", "-4", "?", "-6", "ab", "$", "%", "9", "0", "1", "de", "9", "12", "#", "5"};

        Set<Integer> numberTreeSet = new TreeSet<>();
        Set<String> stringLinkedHashSet = new LinkedHashSet<>();

        for(String element : arguments){
            try{
                number = Integer.parseInt(element);
                numberTreeSet.add(number); // add number to TS
            }catch (NumberFormatException e){
                stringLinkedHashSet.add(element); // add string to LHS
            }
        }

        System.out.println("arguments = " + Arrays.toString(arguments));
        System.out.println("Numbers = " + numberTreeSet);
        System.out.println("on-Numbers = " + stringLinkedHashSet);

    }
}
