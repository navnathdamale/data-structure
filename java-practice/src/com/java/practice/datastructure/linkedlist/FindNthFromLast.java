package com.java.practice.datastructure.linkedlist;

import com.java.practice.datastructure.linkedlist.LinkedList.Node;

public class FindNthFromLast {

	public static void main(String[] args) {
		int i = 2;
		LinkedList linkedList = LinkedList.initLinearLinkedList();
		Node head = linkedList.head();
		Node nthNodeFromLast = new FindNthFromLast().findNthNodeFromLast(head, i);
		linkedList.print(head);
		System.out.println(i + "nd node from last :" + nthNodeFromLast);
	}

	private Node findNthNodeFromLast(Node head, int n) {
		if (head == null || n < 0) {
			return head;
		}
		Node first = head;
		Node last = head;

		for (int i = 0; i < n; i++) {
			first = first.getNext();
		}

		while (first != null) {
			first = first.getNext();
			last = last.getNext();
		}
		return last;
	}
}
