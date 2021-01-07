package com.nishchay.ds.collection;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
* two charArray[] were there - source, target, both were having chars only
* while transferring data from source to target, few chars lost in transportation, help the person to find the missing chars
*
*   char[] source = {'a', 'b', 'c', 'd', 'e', 'f'};
*   char[] target = {'a', 'c', 'e', 'f'};
*   char[] missingChars = {b, d}
*
* */
public class CharArraySubtract {

    public static void main(String[] args) {

        char[] source = new char[] {'a', 'b', 'c', 'd', 'e', 'f'};
        char[] target = new char[] {'a', 'c', 'e', 'f'};

        char[] missingChars = getMissingCharsFromSourceArray(source, target);

        System.out.println("source = " + Arrays.toString(source));
        System.out.println("target = " + Arrays.toString(target));
        System.out.println("missingChars = " + Arrays.toString(missingChars));

    }

    private static char[] getMissingCharsFromSourceArray(char[] source, char[] target) {

        List<Character> list1 = charArrayToListCharacters(source);
        List<Character> list2 = charArrayToListCharacters(target);

        list1.removeAll(list2);

        return listCharactersToCharArray(list1);
    }

    private static List<Character> charArrayToListCharacters(char[] charArray) {
        List<Character> listOfCharacters =
                IntStream.range(0, charArray.length)
                        .mapToObj(i -> charArray[i])
                        .collect(Collectors.toList());
        return listOfCharacters;
    }

    public static char[] listCharactersToCharArray(final List<Character> list){
        final char[] array = new char[list.size()];
        for(int i = 0; i < array.length; i++)
            array[i] = list.get(i);
        return array;
    }
}
