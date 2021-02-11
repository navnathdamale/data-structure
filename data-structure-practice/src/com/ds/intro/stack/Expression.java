package com.ds.intro.stack;

public class Expression {
	public boolean isBalanced(String input) {

		if (input == null) {
			throw new IllegalArgumentException();
		}
		java.util.Stack<Character> stack = new java.util.Stack<Character>();

		for (Character character : input.toCharArray()) {

			if (character == '(')
				stack.push(character);

			if (character == ')') {
				if(stack.empty())
					return false;
				stack.pop();
			}
		}
		return stack.empty();
	}

}
