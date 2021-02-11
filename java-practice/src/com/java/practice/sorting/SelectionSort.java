package com.java.practice.sorting;

import java.time.LocalTime;

public class SelectionSort {

	// 3,5,1,6,9,2

	public static void main(String[] args) {
		// int[] unsortedArray = { 3, 5, 1, 6, 9, 2 };
		// int[] unsortedArray = { 1, 2, 3, 4, 5, 6 };
		int[] unsortedArray = { 1, 1, 1, 1, 1, 1 };
		LocalTime timer1 = LocalTime.now();
		int[] sortedArray = new SelectionSort().selectionSort(unsortedArray, unsortedArray.length);
		for (int i : sortedArray) {
			System.out.print(i + " ");
		}

		// Time complexity => O(n^2)
		System.out.println("total time taken :" + timer1);

	}

	private int[] selectionSort(int[] array, int size) {

		// return if array size is less than 2
		if (size <= 1) {
			return array;
		}

		// iterate through whole array
		for (int i = 0; i < array.length - 1; i++) {
			int iMin = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[iMin]) {
					iMin = j;
				}
			}
			int temp = array[i];
			array[i] = array[iMin];
			array[iMin] = temp;
		}

		return array;
	}
}
