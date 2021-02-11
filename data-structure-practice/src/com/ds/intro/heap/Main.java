package com.ds.intro.heap;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Heap heap = new Heap();
		heap.insert(10);
		heap.insert(20);
		heap.insert(30);
		heap.insert(40);
		heap.insert(50);
		heap.remove();

		heap.print();

		int[] numbers = { 5, 3, 10, 1, 4, 2 };

		Heap maxHeap = new Heap();
		for (int i : numbers) {
			maxHeap.insert(i);
		}

		while (!maxHeap.isEmpty()) {
			System.out.println(" " + maxHeap.remove());
		}

		int[] numbers1 = { 5, 3, 10, 1, 4, 2 };
		System.out.println(Arrays.toString(numbers1));

		Heapify.heapify(numbers1);

		System.out.println(Arrays.toString(numbers1));

		System.out.println(Heapify.getKthLargest(numbers1, 6));

	}
}