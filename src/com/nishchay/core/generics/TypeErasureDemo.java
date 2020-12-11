package com.nishchay.core.generics;

import java.util.Collections;
import java.util.List;

public class TypeErasureDemo {

    public static void main(String[] args) {

        new TypeErasureDemo().getAverageLength(Collections.emptyList());

    }


    public void getAverageLength(List<String> names){
        System.out.println(12);
    }

    // Compile time error/ runtime error - Its Compile time only
    // getAverageLength(List<String>)' clashes with 'getAverageLength(List)'; both methods have same erasure
/*
    public void getAverageLength(List names){
        System.out.println(15);
    }
*/

}
