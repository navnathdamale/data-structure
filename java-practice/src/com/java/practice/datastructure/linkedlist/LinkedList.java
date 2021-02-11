package com.java.practice.datastructure.linkedlist;

public class LinkedList {

	private Node head;
	private Node tail;

	public LinkedList() {
		this.head = new Node("head");
		this.tail = head;
	}

	public Node head() {
		return this.head;
	}

	public Node tail() {
		return this.tail;
	}

	public void add(Node node) {
		this.tail.next = node;
		this.tail = node;
	}

	public Node getTail() {
		Node tail = this.head;
		while (tail.next != null) {
			tail = tail.next;
		}
		return tail;
	}

	public void print() {
		while (head != null) {
			System.out.println(head);
			head = head.next;
		}
	}

	public void print(Node head) {
		while (head != null) {
			System.out.println(head);
			head = head.next;
		}
	}

	public static LinkedList initLinearLinkedList() {
		LinkedList linkedList = new LinkedList();
		linkedList.add(new Node("1"));
		linkedList.add(new Node("2"));
		linkedList.add(new Node("3"));
		linkedList.add(new Node("4"));
		linkedList.add(new Node("5"));
		return linkedList;
	}

	public static class Node {
		private String data;
		private Node next;

		public Node(String data) {
			this.data = data;
		}

		public String getData() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + "]";
		}
	}

}
