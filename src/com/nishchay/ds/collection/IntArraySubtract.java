package com.nishchay.ds.collection;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
* two charArray[] were there - source, target, both were having chars only
* while transferring data from source to target, few chars lost in transportation, help the person to find the missing chars
*
*   int[] source = {203, 203, 203, 204, 204, 204, 205, 205, 205, 205, 206, 206, 207, 208};
*   int[] target = {203, 203, 204, 204, 205, 205, 206, 206, 207};
*   int[] missingInts = {203, 204, 205, 205, 208}
*
* */
public class IntArraySubtract {

    public static void main(String[] args) {

//        int[] source = new int[] {203, 203, 203, 204, 204, 204, 205, 205, 205, 205, 206, 206, 207, 208};
        int[] source = {203, 203, 203, 204, 204, 204, 205, 205, 205, 205, 206, 206, 207, 208};
        int[] target = {203, 203, 204, 204, 205, 205, 206, 206, 207};

        int[] missingNumbers = getMissingNumbersFromSourceArray(source, target);

        System.out.println("source = " + Arrays.toString(source));
        System.out.println("target = " + Arrays.toString(target));
        System.out.println("missingChars = " + Arrays.toString(missingNumbers));

    }

    private static int[] getMissingNumbersFromSourceArray(int[] source, int[] target) {

        List<Integer> list1 = Arrays.stream(source).boxed().collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(target).boxed().collect(Collectors.toList());

        for(Integer e : list2){
            if(list1.contains(e)){
                list1.remove(e);
            }
        }
        return list1.stream().mapToInt(i -> i).toArray();
    }

}
