package com.java.practice.random;

public class Fibonacci {

	public static void main(String[] args) {
		for (int i = 1; i < 10; i++) {
			System.out.print(new Fibonacci().recFibonacci(i) + " ");
		}
		System.out.println(" ===== ");

		for (int i = 1; i < 10; i++) {
			System.out.print(new Fibonacci().itrFibonacci(i) + " ");
		}
		
	}

	private int recFibonacci(int number) {
		if (number == 1 || number == 2) {
			return 1;
		}
		return recFibonacci(number - 1) + recFibonacci(number - 2);
	}

	private int itrFibonacci(int number) {
		if (number == 1 || number == 2) {
			return 1;
		}
		int fibo1 = 1, fibo2 = 1, fibo3 = 1;
		for (int i = 3; i <= number; i++) {
			fibo3 = fibo1 + fibo2;
			fibo1 = fibo2;
			fibo2 = fibo3;
		}
		return fibo3;
	}

}
