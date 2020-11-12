package com.nishchay.core.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListDemo {

    public static void main(String[] args) {

        List<String> strList = new ArrayList<>();
        strList.add("element1");
        strList.add("element2");
        strList.add("element3");
        strList.add("element4");
        strList.add("element5");

        System.out.println("strList - " + strList);

        // access via index
        System.out.println("\n Accessing list via index");
        for (int i = 0; i < strList.size(); i++) {
            System.out.print(strList.get(i) + "\t");
        }

        // access via Iterator
        System.out.println("\n Accessing list via Iterator");
        Iterator<String> iterator = strList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + "\t");
        }

        // access via new for-loop
        System.out.println("\n Accessing list via for-loop");
        for (String s : strList) {
            System.out.print(s + "\t");
        }

    }

}
