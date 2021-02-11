package com.ds.intro.queue;

import java.util.Arrays;

public class ArrayQueue {
	private int[] items;
	private int front;
	private int rear;

	public ArrayQueue(int capacity) {
		items = new int[capacity];
	}

	public void enqueue(int item) {
		items[rear] = item;
		rear = (rear + 1) % items.length;
	}

	public int dequeue() {
		int item = items[front];
		items[front] = 0;
		front = (front + 1) % items.length;
		return item;
	}

	@Override
	public String toString() {

		return "ArrayQueue [items=" + Arrays.toString(Arrays.copyOfRange(items, 0, items.length)) + ", rear=" + rear
				+ "]";
	}

}
