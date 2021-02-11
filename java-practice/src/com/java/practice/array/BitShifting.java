package com.java.practice.array;

import java.math.BigInteger;
import java.util.Stack;

public class BitShifting {

	public static void main(String[] args) {
		int a = 8; // 1 0 0 0
		int b = a << 2; // 1 0 0 0 0 0
		System.out.println(a + " >> " + b);

		System.out.println(calculateStepsRequired(1001));

		System.out.println(Integer.toBinaryString(-16));
		
		decimalToBinary(16);
	}

	public static long calculateStepsRequired(long number) {
		int bit = number < 0 ? 1 : 0;
		BigInteger result = BigInteger.valueOf(bit);
		for (int i = 0; i < 63; i++) {
			number = number << 1;
			int sign = number < 0 ? 1 : 0;
			bit = (bit + sign) % 2;
			result = result.shiftLeft(1).add(BigInteger.valueOf(bit));
		}
		return result.longValue();
	}

	public static void decimalToBinary(int num) {
		Stack<Integer> stack = new Stack<Integer>();
		while (num != 0) {
			int d = num % 2;
			stack.push(d);
			num /= 2;
		}

		System.out.print("\nBinary representation is:");
		while (!(stack.isEmpty())) {
			System.out.print(stack.pop());
		}

	}

}
