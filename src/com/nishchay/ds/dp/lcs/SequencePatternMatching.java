package com.nishchay.ds.dp.lcs;

/*
 * Need to find that one sting is sub sequence in another string - true/false
 *
 * Examples :
 *		Input:  s1 = "AXY"
 *              s2 = "ADXCPY"
 *		Output: true
 *		is s1 subsequence in s2 - true
 *
 * */
public class SequencePatternMatching {

    public static void main(String[] args) {

        SequencePatternMatching ref = new SequencePatternMatching();

        String str1 = "AXY";
        String str2 = "ADXCPY";
        System.out.println("is str1 subsequence in str2 - " + ref.isSubsequence(str1, str2)); //true

        str1 = "ATY";
        str2 = "ATACTCGGA";
        System.out.println("is str1 subsequence in str2 - " + ref.isSubsequence(str1, str2)); //false

    }

    /*
     * LCS(str1,str2) =  0 to min(str1.legth,str2.legth)
     * Since here we need to find that - is str1  subsequence of str2
     *
     *		if( LCS(str1,str2) == str1.length())
     *			return  true;
     *		else
     *			return false;
     *
     * */
    private boolean isSubsequence(String str1, String str2) {

        // find lcs
        LongestCommonSubsequence ref = new LongestCommonSubsequence();
        int lcsCount = ref.lcsTabulation(str1, str2, str1.length(), str2.length());

        if (lcsCount == str1.length())
            return true;
        else
            return false;

    }
}
