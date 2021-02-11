package com.ds.intro.heap;

import java.util.Arrays;

public class Heap {
	private int[] items = new int[10];
	private int size;

	public void insert(int value) {
		if (isFull()) {
			throw new IllegalStateException();
		}
		items[size++] = value;
		bubbleUp();
	}

	public int remove() {
		if (isEmpty()) {
			throw new IllegalStateException();
		}
		int root = items[0];
		items[0] = items[--size];
		bubbleDown();
		return root;
	}

	private void bubbleDown() {
		int index = 0;
		while (index <= size && !isValidParent(index)) {
			int largeChild = largeChildIndex(index);
			swap(index, largeChild);
			index = largeChild;
		}
	}

	public boolean isEmpty() {
		return size == 0;
	}

	private int largeChildIndex(int index) {
		if (!hasLeftChild(index)) {
			return index;
		}

		if (!hasRightChild(index)) {
			return leftIndex(index);
		}

		return (left(index) > right(index)) ? leftIndex(index) : rightIndex(index);
	}

	private boolean hasLeftChild(int index) {
		return leftIndex(index) <= size;
	}

	private boolean hasRightChild(int index) {
		return rightIndex(index) <= size;
	}

	private boolean isValidParent(int index) {
		if (!hasLeftChild(index)) {
			return true;
		}

		boolean isValid = items[index] >= left(index);
		if (hasRightChild(index)) {
			isValid = isValid && items[index] >= right(index);
		}

		return isValid;
	}

	private int left(int index) {
		return items[leftIndex(index)];
	}

	private int right(int index) {
		return items[rightIndex(index)];
	}

	private int leftIndex(int index) {
		return index * 2 + 1;
	}

	private int rightIndex(int index) {
		return index * 2 + 2;
	}

	public boolean isFull() {
		return size == items.length;
	}

	private void bubbleUp() {
		int index = size - 1;
		while (index > 0 && items[index] > items[parent(index)]) {
			swap(index, parent(index));
			index = parent(index);
		}
	}

	private int parent(int index) {
		return (index - 1) / 2;
	}

	private void swap(int first, int second) {
		int temp = items[first];
		items[first] = items[second];
		items[second] = temp;
	}

	public void print() {
		System.out.print("items=[");
		for (int i = 0; i < size; i++) {
			System.out.print(" " + items[i] + " ");
		}
		System.out.print("]");
	}

	public int max() {
		if (isEmpty()) {
			throw new IllegalStateException();
		}
		return items[0];
	}

	@Override
	public String toString() {
		return "Heap [items=" + Arrays.toString(items) + "]";
	}

}
