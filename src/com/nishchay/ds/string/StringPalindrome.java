package com.nishchay.ds.string;

public class StringPalindrome {

    public static void main(String[] args) {

        System.out.println("  isPalindrome(\"madam\") - " +  isPalindrome("madam"));
        System.out.println("  isPalindrome(\"radar\") - " +  isPalindrome("radar"));
        System.out.println("  isPalindrome(\"satya\") - " +  isPalindrome("satya"));
        System.out.println("  isPalindrome(\"nitin\") - " +  isPalindrome("nitin"));
        System.out.println("  isPalindrome(\"nolemonnomelon\") - " +  isPalindrome("nolemonnomelon"));
    }

    public static boolean isPalindrome(String string) {
        char[] charArray = string.toCharArray();

        for (int i = 0, j = charArray.length - 1; i < j; i++, j--) {
            if(charArray[i] != charArray[j]){
                return false;
            }
        }
        return true;
    }
}
