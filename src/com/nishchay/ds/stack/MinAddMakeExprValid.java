package com.nishchay.ds.stack;


/*
 *	=========== Minimum Add to Make Parentheses Valid ===========
 *
 * Given a string S of parentheses '(' or ')' where, 0≤len(S)≤1000.
 * The task is to find a minimum number of parentheses '(' or ')' (at any positions)
 * We must add to make the resulting parentheses string is valid.
 *
 *
 * Input: str = "())"
 * Output: 1
 * One '(' is required at beginning.
 *
 * Input: str = "((("
 * Output: 3
 * Three ')' is required at end.
 *
 * Input: str = ")("
 * Output: 2
 * One ')' & One '(' is required
 *
 *
 * https://www.geeksforgeeks.org/minimum-number-of-parentheses-to-be-added-to-make-it-valid/
 * https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/description/
 *
 * */

public class MinAddMakeExprValid {

    public static void main(String[] args) {

        String[] inputs = {"())", "(((", "(()", "()", ")(", "))(("};
        int[] outputs = {1, 3, 1, 0, 2, 4};


        boolean result = true;
        for (int i = 0; i < inputs.length; i++) {
            result = result && minAddToMakeValid(inputs[i]) == outputs[i];
            if (!result)
                System.out.println("Test failed for: " + inputs[i]);
            else
                System.out.println("Test passed for: " + inputs[i]);
        }
    }

    /*
     * ========= Iterative approach =========
     *  the number of '(' minus the number of ')'
     *      Result == 0 : string is valid
     *      Result == negative : means '(' that many required
     *      Result == positive : means ')' that many required
     *
     * Time Complexity : O(n).
     * Space Complexity: O(1).
     *
     * */
    public static int minAddToMakeValid(String s) {
        int additionsRequired = 0;
        int balanceCount = 0;      // Keep track of the balance between opening and closing brackets

        for (char character : s.toCharArray()) {
            if (character == '(') {
                // for an opening parenthesis
                balanceCount++;
            } else if (balanceCount > 0) {
                // for a closing parenthesis, if it comes after the opening parenthesis
                balanceCount--;
            } else {
                // for a closing parenthesis, if it comes prior the opening parenthesis
                additionsRequired++;
            }
        }
        additionsRequired = additionsRequired  + balanceCount;

        // Return the total number of additions required to make the string valid
        return additionsRequired;
    }

}
