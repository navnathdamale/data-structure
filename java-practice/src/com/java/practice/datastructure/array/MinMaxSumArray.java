package com.java.practice.datastructure.array;

import java.util.Arrays;
import java.util.Scanner;

public class MinMaxSumArray {

	static void miniMaxSum(int[] arr) {
		Arrays.sort(arr);
		long maxSum = 0;
		long minSum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i > 0) {
				maxSum = maxSum + arr[i];
			}
			if (i < arr.length - 1) {
				minSum = minSum + arr[i];
			}
		}
		System.out.print(minSum + " " + maxSum);

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int[] arr = new int[5];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < 5; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		miniMaxSum(arr);
		scanner.close();
	}
}
