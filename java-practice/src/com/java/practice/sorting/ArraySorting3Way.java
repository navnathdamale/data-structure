package com.java.practice.sorting;

public class ArraySorting3Way {

	public static void main(String[] args) {

		int[] a = { 1, 2, 2, 0, 0, 1, 2, 2, 1 };
		sort(a);
		for (int val : a) {
			System.out.print(val + " ");
		}

	}

	public static void sort(int[] a) {

		int low = 0, mid = 0, high = a.length - 1;
		while (mid <= high) {
			if (a[mid] == 0) {
				a[low] = swap(a[mid], a[mid] = a[low]);
				mid++;
				low++;
			} else if (a[mid] == 2) {
				a[high] = swap(a[mid], a[mid] = a[high]);
				high--;
			} else {
				mid++;
			}
		}
	}

	public static int swap(int i, int j) {
		return i;
	}
}
