package com.ds.intro.stack;

public class Main {
	public static void main(String[] args) {

		String s = "abcd";
		System.out.println(new StringReverser().reverse(s));

		String exp = "(1+2)";
		System.out.println(new Expression().isBalanced(exp));

		Stack stack = new Stack();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.pop();
		stack.pop();
		stack.pop();
		System.out.println(stack);

		System.out.println(stack.peak());

	}
}