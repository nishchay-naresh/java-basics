package com.nishchay.core.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayToList {

    public static void main(String[] args) {

//        asListEx();
        arrayToList_listToArray_objectType();
//        arrayToList_listToArray_primitiveInt();
//        arrayToList_listToArray_primitiveChar();

    }

    // asList() -  Returns a fixed-size list backed by the specified array
    private static void asListEx() {
        String[] arr = {"Rohit", "Shikhar", "Kohli", "Iyyar", "Dhoni"};

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

        for (String s : list) {
            System.out.print(s + ",\t");
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

        List<Integer> integerList = Arrays.asList(0, 1, 2, 3, 4, 5);
        Integer[] intArray = integerList.toArray(new Integer[0]);
        System.out.println("integerList = " + integerList);
        System.out.println("intArray = " + Arrays.toString(intArray));

        // Note that this is a fixed-sized list that will still be backed by the array.
        // If you want a standard ArrayList you can simply instantiate one as so:
        Integer[] sourceArray = { 0, 1, 2, 3, 4, 5 };
        List<Integer> targetList = new ArrayList<Integer>(Arrays.asList(sourceArray));
        targetList.add(10);
        System.out.println("targetList = " + targetList);
    }


    private static void arrayToList_listToArray_primitiveInt() {
        int[] ints = {1, 2, 3, 4};

        List<Integer> intList = Arrays.stream(ints).boxed().collect(Collectors.toList());
        System.out.println("IntegerList - " + intList);

        int[] intArr = intList.stream().mapToInt(i -> i).toArray();
        System.out.println("intArray - " + Arrays.toString(intArr));
    }

    private static void arrayToList_listToArray_primitiveChar() {

        char[] chars = new char[]{'a', 'b', 'c', 'd', 'e', 'f'};

        List<Character> listOfCharacters = charArrayToListCharacters(chars);
        System.out.println("CharacterList - " + listOfCharacters);

        char[] charArray = listCharactersToCharArray(listOfCharacters);
        System.out.println("charArray - " + Arrays.toString(charArray));
    }

    private static List<Character> charArrayToListCharacters(char[] charArray) {
        List<Character> listOfCharacters =
                IntStream.range(0, charArray.length)
                        .mapToObj(i -> charArray[i])
                        .collect(Collectors.toList());
        return listOfCharacters;
    }

    public static char[] listCharactersToCharArray(final List<Character> list) {
        final char[] array = new char[list.size()];
        for (int i = 0; i < array.length; i++)
            array[i] = list.get(i);
        return array;
    }

}
