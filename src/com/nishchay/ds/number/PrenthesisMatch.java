package com.nishchay.ds.number;

import java.util.Stack;

public class PrenthesisMatch {

	public static void main(String[] args) {

		String expr = "{[}], [[()]], ({([])}), [[]), {{[]))]]), {[()]}, [[]])))";

		String[] values = expr.split(",");

		System.out.println("Expr String  : " + expr);

		for (String token : values) {
			// values[i] = validate(token) ? "YES" : "NO";
			System.out.println(validate(token));
		}

	}

	public static boolean validate(String token) {

		char[] charArr = token.trim().toCharArray();

		Stack<Character> stack = new Stack<>();

		for (char t : charArr) {

			switch (t) {
			case '{':
				stack.push(t);
				break;
			case '}':
				if (stack.empty() )
					return false;
				else if('}' != stack.pop())
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
