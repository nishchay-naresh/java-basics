package com.nishchay.ds.dp.mcm;

/*
 *	===========Palindrome Partitioning Problem===========
 *
 * Given a string, a partitioning of the string is a palindrome partitioning if every substring of the partition is a palindrome.
 * For example, “aba|b|bbabb|a|b|aba” is a palindrome partitioning of “ababbbabbababa”.
 * Determine the fewest cuts needed for a palindrome partitioning of a given string.
 *
 * For example, minimum of 3 cuts are needed for “ababbbabbababa”. The three cuts are “a|babbbab|b|ababa”.
 * If a string is a palindrome, then minimum 0 cuts are needed.
 * If a string of length n containing all different characters, then minimum n-1 cuts are needed.
 *
 * Examples :
 *		Input : str = “geek”
 *		Output : 2
 *		We need to make minimum 2 cuts, i.e., “g ee k”
 *		Input : str = “nitin”
 *		Output : 0
 *		The string is already a palindrome.
 *		Input : str = “abcde”
 *		Output : 4
 *		Input : str = “abbac”
 *		Output : 1
 *
 * https://www.geeksforgeeks.org/palindrome-partitioning-dp-17/
 *
 * */
public class PalindromePartitioning {

    public static void main(String[] args) {

        System.out.println("------------Recursion-------------");
        minPalindromeRecursionEx();
/*
        System.out.println("------------TopDown-------------");
        minPalindromDPTopDown();
        System.out.println("------------BottomUp-------------");
        minPalindromDPBottomUp();
*/

    }

    private static void minPalindromeRecursionEx() {

        PalindromePartitioning ref = new PalindromePartitioning();

        String str = "ababbbabbababa";
        System.out.println("Min cuts needed for Palindrome Partitioning is " +
                ref.minPalPartitionRecursion(str, 0, str.length() - 1)); // 3

        str = "abcde";
        System.out.println("Min cuts needed for Palindrome Partitioning is " +
                ref.minPalPartitionRecursion(str, 0, str.length() - 1)); // 4

        str = "nitin";
        System.out.println("Min cuts needed for Palindrome Partitioning is " +
                ref.minPalPartitionRecursion(str, 0, str.length() - 1)); // 0
    }


    /*
     * Recursive solution
     *
     * // i is the starting index and j is the ending index. i must be passed as 0 and j as n-1
     * minPalPartion(str, i, j) = 0 if i == j. // When string is of length 1.
     * minPalPartion(str, i, j) = 0 if str[i..j] is palindrome.
     *
     * // If none of the above conditions is true, then minPalPartion(str, i, j) can be
     * // calculated recursively using the following formula.
     * minPalPartion(str, i, j) = Min { minPalPartion(str, i, k)
     *                                 +	minPalPartion(str, k+1, j)
     * 								+	1							}
     * 								where k varies from i to j-1
     *
     * */
    private int minPalPartitionRecursion(String string, int i, int j) {

        if( i >= j || isPalindrome(string, i, j) )
            return 0;

        int min = Integer.MAX_VALUE, curr;
        for(int k = i; k < j; k++)
        {
            curr = minPalPartitionRecursion(string, i, k) +
                    minPalPartitionRecursion(string, k + 1, j) + 1;

            min = Math.min(min, curr);
        }
        return min;


    }

    private static boolean isPalindrome(String string, int i, int j) {
        while (i < j) {
            if (string.charAt(i) != string.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
