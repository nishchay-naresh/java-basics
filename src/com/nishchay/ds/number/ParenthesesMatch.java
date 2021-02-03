package com.nishchay.ds.number;

import java.util.Stack;


/*
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 *
 * Example 1:
 * Input: s = "()"
 * Output: true
 *
 * Example 2:
 * Input: s = "()[]{}"
 * Output: true
 *
 * Example 3:
 * Input: s = "(]"
 * Output: false
 *
 * Example 4:
 * Input: s = "([)]"
 * Output: false
 *
 * Example 5:
 * Input: s = "{[]}"
 * Output: true
* */

public class ParenthesesMatch {

	public static void main(String[] args) {

		doTestsPass();

/*
		String expr = "{[]}";
		System.out.println( expr  + " - " + validate(expr) );
*/

	}


	/**
	 * boolean doTestsPass()
	 * Returns true if all tests pass. Otherwise returns false.
	 */
	public static void doTestsPass() {

/*
		String expr = "{[}], [[()]], ({([])}), [[]), {{[]))]]), {[()]}, [[]])))";
		boolean[] outputs = {false, true, false, false, false, false, false};
*/
		String expr = "(), ()[]{}, (], ([)], {[]}";
		boolean[] outputs = {true, true, false, false, true};

		String[] inputs = expr.split(",");

		boolean result = true;
		for (int i = 0; i < inputs.length; i++) {
//			System.out.println( inputs[i]  + " - " + validate(inputs[i]) );
			result = result && outputs[i] == validate(inputs[i]) ;
			if (!result)
				System.out.println("Test failed for: " + inputs[i]);
			else
				System.out.println("Test passed for: " + inputs[i]);
		}
	}

	public static boolean validate(String exprStr) {

		char[] charArr = exprStr.trim().toCharArray();
		Stack<Character> stack = new Stack<>();

		for (char t : charArr) {

			switch (t) {
			case '{':
				stack.push(t);
				break;
			case '}':
				if (stack.empty() )
					return false;
				else if('{' != stack.pop())
					return false;
				break;
			case '[':
				stack.push(t);
				break;
			case ']':
				if (stack.empty() )
					return false;
				else if('[' != stack.pop())
					return false;
				break;
			case '(':
				stack.push(t);
				break;

			case ')':
				if (stack.empty() )
					return false;
				else if('(' != stack.pop())
					return false;
				break;
			default:
				return false;
			}
		}
		if (stack.empty()) {
			return true;
		}
		return false;
	}

}
