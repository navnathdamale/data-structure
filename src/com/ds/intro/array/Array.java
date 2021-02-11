package com.ds.intro.array;

public class Array {
	private int[] items;

	private int count;

	public Array(int size) {
		items = new int[size];
	}

	public void insert(int item) {
		if (items.length == count) {
			int[] newItems = new int[count * 2];
			for (int i = 0; i < count; i++) {
				newItems[i] = items[i];
			}
			items = newItems;
		}
		items[count++] = item;
	}

	public void removeAt(int index) {
		if (index < 0 || index >= count) {
			throw new IllegalArgumentException();
		}

		for (int i = index; i < count; i++) {
			items[i] = items[i + 1];
		}
		count--;
	}

	public int indexOf(int item) {
		for (int i = 0; i < count; i++) {
			if (items[i] == item) {
				return i;
			}
		}
		return -1;
	}

	public int max() {
		int max = 0;
		for (int i = 0; i < count; i++) {
			if (max < items[i]) {
				max = items[i];
			}
		}
		return max;
	}

	public int[] intersect(int[] target) {
		int[] intersect = new int[count];
		int k = 0;
		for (int i = 0; i < count; i++) {
			for (int j = 0; j < target.length; j++) {
				if (items[i] == target[j]) {
					intersect[k++] = items[i];
				}
			}
		}

		return intersect;
	}

	public void reverse() {
		int j = 0;
		for (int i = count - 1; i >= count / 2; i--) {
			int temp = items[i];
			items[i] = items[j];
			items[j] = temp;
			j++;
		}
	}

	public void insertAt(int item, int index) {
		if (index < 0 || index > count) {
			throw new IllegalArgumentException();
		}
		count++;
		for (int i = count - 1; i > index; i--) {
			items[i] = items[i - 1];
		}
		items[index] = item;
	}

	public void print() {
		for (int i = 0; i < count; i++) {
			System.out.println(items[i]);
		}
	}
}
