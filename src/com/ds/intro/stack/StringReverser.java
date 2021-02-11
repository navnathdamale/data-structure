package com.ds.intro.stack;

public class StringReverser {

	public String reverse(String input) {
		if (input == null) {
			throw new IllegalArgumentException();
		}
		java.util.Stack<Character> stack = new java.util.Stack<Character>();

		for (Character character : input.toCharArray()) {
			stack.push(character);
		}

		StringBuilder buffer = new StringBuilder();
		while (!stack.isEmpty()) {
			buffer.append(stack.pop());
		}
		return buffer.toString();
	}
}
