package com.nishchay.core.collection;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayToList {

    public static void main(String[] args) {

        asListEx();
        arrayToList_listToArray_objectType();
        arrayToList_listToArray_primitiveInt();

    }

    // asList() -  Returns a fixed-size list backed by the specified array
    private static void asListEx() {
        String arr[] = {"Rohit", "Shikhar", "Kohli", "Iyyar", "Dhoni"};

        List<String> list = Arrays.asList(arr);
        System.out.println("list = " + list);

//        any changes made to array will reflect in list as well
        arr[0] = "Agarwal";
        arr[1] = "Shaw";
        System.out.println("list = " + list);

//        any changes made to list will reflect in array as well
        list.set(0, "Rahul");
        list.set(1, "Gill");

        System.out.println("list = " + list);
        System.out.println("arr = " + Arrays.toString(arr));

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ",\t");
        }

//        Can't perform structure change operation like - add, remove, Throw - java.lang.UnsupportedOperationException
//        list.add("Shami");
//        list.remove(4);

    }

    private static void arrayToList_listToArray_objectType() {

        //         String [] -> List<String>
        //  returning immutable list, any changes (add/remove) will lead to UnsupportedException
        List<String> stringList = Arrays.asList("Rohit", "Shikhar", "Kohli", "Iyyar", "Rahul");
        //          List<String> -> String []
        String[] strArray = stringList.toArray(new String[stringList.size()]);

        System.out.println("stringList -" + stringList);
        System.out.println("strArray -" + Arrays.toString(strArray));
    }


    private static void arrayToList_listToArray_primitiveInt() {
        int[] ints = {1, 2, 3, 4};

        List<Integer> intList = Arrays.stream(ints).boxed().collect(Collectors.toList());
        System.out.println("intList -" + intList);

        int[] intArr = intList.stream().mapToInt(i -> i).toArray();
        System.out.println("strArray -" + Arrays.toString(intArr));
    }


}
