package com.nishchay.core.collection;

import java.util.*;

public class IteratorDemo {

    public static void main(String[] args) {
        Collection<String> collection =  new ArrayList<>(Arrays.asList("two", "four", "six"));;

        System.out.println("-------------set element------------");
        Set<String> set = new HashSet<>(collection);
        genericCollectionPrint(set.iterator());

        ArrayList<String> list = new ArrayList<>(collection);
        list.add("ten");
        System.out.println("-------------lit element------------");
        genericCollectionPrint(list.iterator());
    }


    /*
    * =============== Iterator use case =================
    * To hold set of values, we wil try to have more generic collection
    * like will prefer Collection over List, Set, TreeSet
    * Similarly Iterator<> for all collection iteration
    * */
    private static void genericCollectionPrint(Iterator<String> iterator) {
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
        }
    }


}

