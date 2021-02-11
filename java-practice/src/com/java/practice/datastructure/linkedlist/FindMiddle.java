package com.java.practice.datastructure.linkedlist;

public class FindMiddle {

	public void findMiddle() {
		LinkedList linkedList = LinkedList.initLinearLinkedList();
		LinkedList.Node current = linkedList.head();
		LinkedList.Node middle = current;
		int length = 0;

		while (current != null) {
			length++;
			if (length % 2 == 0) {
				middle = middle.getNext();
			}
			current = current.getNext();
		}

		if (length % 2 == 1) {
			middle = middle.getNext();
		}

		System.out.println("length of LinkedList: " + length);
		System.out.println("middle element of LinkedList : " + middle);
	}

	public static void main(String[] args) {
		new FindMiddle().findMiddle();
	}
}