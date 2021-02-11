package com.ds.intro.queue;

public class Main {
	public static void main(String[] args) {

		ArrayQueue arrayQueue = new ArrayQueue(6);
		arrayQueue.enqueue(10);
		arrayQueue.enqueue(20);
		arrayQueue.enqueue(30);
		arrayQueue.enqueue(40);
		System.out.println(arrayQueue.dequeue());
		System.out.println(arrayQueue.dequeue());
		arrayQueue.enqueue(50);
		arrayQueue.enqueue(60);
		arrayQueue.enqueue(70);
		System.out.println(arrayQueue);
	}
}
