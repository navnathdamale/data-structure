package com.java.practice.datastructure.linkedlist;

public class QueueUsingLinkedList {

	private Node front, rear;
	private int currentSize;

	public QueueUsingLinkedList() {
		front = null;
		rear = null;
		currentSize = 0;
	}

	public Node dequeue() {
		Node removedData = front;
		front = front.next;
		if (isEmpty()) {
			rear = null;
		}
		currentSize--;
		System.out.println(removedData + " - removed from queue.");
		return removedData;
	}

	public void enqueue(Node node) {
		Node oldRear = rear;
		rear = node;
		rear.next = null;
		if (isEmpty()) {
			front = rear;
		} else {
			oldRear.next = rear;
		}
		System.out.println(node + " - added to the queue.");
		currentSize++;
	}

	public boolean isEmpty() {
		return (currentSize == 0);
	}

	public static class Node {
		private String data;
		private Node next;

		public Node(String data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + "]";
		}
	}

	public static void main(String[] args) {
		QueueUsingLinkedList queueUsingLinkedList = new QueueUsingLinkedList();
		queueUsingLinkedList.enqueue(new Node("1"));
		queueUsingLinkedList.enqueue(new Node("2"));
		queueUsingLinkedList.enqueue(new Node("3"));
		queueUsingLinkedList.dequeue();
		queueUsingLinkedList.dequeue();
		queueUsingLinkedList.dequeue();

	}
}
