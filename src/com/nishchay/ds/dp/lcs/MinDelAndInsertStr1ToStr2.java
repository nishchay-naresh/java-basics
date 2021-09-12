package com.nishchay.ds.dp.lcs;


/*
 *	===========Minimum number of deletions and insertions to transform one string into another===========
 *
 * Given two strings ‘str1’ and ‘str2’ of size m and n respectively.
 * The task is to remove/delete and insert the minimum number of characters from/in str1 to transform it into str2.
 * It could be possible that the same character needs to be removed/deleted from one point of str1 and inserted to some another point.
 *
 *	Example 1:
 *
 *	Input :
 *	str1 = "heap", str2 = "pea"
 *	Output :
 *	Minimum Deletion = 2 and
 *	Minimum Insertion = 1
 *	Explanation:
 *	p and h deleted from heap
 *	Then, p is inserted at the beginning
 *	One thing to note, though p was required yet
 *	it was removed/deleted first from its position and
 *	then it is inserted to some other position.
 *	Thus, p contributes one to the deletion_count
 *	and one to the insertion_count.
 *
 * 	Input :
 * 	str1 = "geeksforgeeks", str2 = "geeks"
 * 	Output :
 * 	Minimum Deletion = 8
 * 	Minimum Insertion = 0
 *
 * https://www.geeksforgeeks.org/minimum-number-deletions-insertions-transform-one-string-another/
 * */
public class MinDelAndInsertStr1ToStr2 {

    public static void main(String[] args) {

        MinDelAndInsertStr1ToStr2 ref = new MinDelAndInsertStr1ToStr2();

        String str1 = "heap";
        String str2 = "pea";
        ref.printMinDelAndInsert(str1, str2); //2,1

        str1 = "geeksforgeeks";
        str2 = "geeks";
        ref.printMinDelAndInsert(str1, str2); //8,0

    }

    /*
     * function to find minimum number of deletions and insertions
     *	Algorithm:
     *
     *	str1 and str2 be the given strings.
     *	m and n be their lengths respectively.
     *	len be the length of the longest common subsequence of str1 and str2
     *	minimum number of deletions minDel = m – len
     *	minimum number of Insertions minInsert = n – len
     * */
    private void printMinDelAndInsert(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        // find lcs
        LongestCommonSubsequence ref = new LongestCommonSubsequence();
        int lcsCount = ref.lcsTabulation(str1, str2, str1.length(), str2.length());

        System.out.println("Minimum number of deletions = " + (m - lcsCount));

        System.out.println("Minimum number of insertions = " + (n - lcsCount));

        System.out.println("-----------------------------------");
    }

}
