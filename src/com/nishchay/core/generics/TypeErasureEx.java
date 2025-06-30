package com.nishchay.core.generics;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
*  Type Erasure at Runtime: Java uses type erasure to ensure compatibility with older versions of Java that do not support generics (before Java 5).
*  This means that generic type information is erased at compile time and replaced with the most specific applicable type.
*
* */
public class TypeErasureEx {

    public static void main(String[] args) {
        TypeErasureEx ref = new TypeErasureEx();
        List<String> strList = Arrays.asList("java", "generics");
        ref.printLength(strList); // 2
    }


    private <T> void printLength(List<T> names){
        System.out.println(names.size());
    }

    // Compiler error - printLength(List<T>)' clashes with 'printLength(List)'; both methods have same erasure
    // because after type erasure, both the method will be become same

    // private void printLength(List list){
    //    System.out.println(list.size());
    //}

    public <T> T getFirst(List<T> list) {
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    // At runtime, due to type erasure, List<T> becomes just List, and T is replaced with Object. Thus, the method is compiled to:
    public Object getFirst_afterTypeErasure(List list) {
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

}
