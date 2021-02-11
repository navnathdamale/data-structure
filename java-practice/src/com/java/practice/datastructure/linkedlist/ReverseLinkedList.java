package com.java.practice.datastructure.linkedlist;

import com.java.practice.datastructure.linkedlist.LinkedList.Node;

public class ReverseLinkedList {

	public static void main(String[] args) {
		LinkedList linkedList = LinkedList.initLinearLinkedList();
		Node itrHeadNode = linkedList.head();
		linkedList.print(itrHeadNode);

		System.out.println("Reverse list using iteration :");
		Node itrReverseHead = new ReverseLinkedList().reverseIteratively(itrHeadNode);
		linkedList.print(itrReverseHead);

		System.out.println("Reverse list using recursion :");
		Node recHeadNode = linkedList.head();
		Node recReverseHead = new ReverseLinkedList().reverseRecursively(recHeadNode);
		linkedList.print(recReverseHead);
	}

	private Node reverseIteratively(Node head) {
		if (head == null) {
			return head;
		}
		Node pointer = head;
		Node prev = null;
		Node current = null;

		while (pointer != null) {
			current = pointer;
			pointer = pointer.getNext();

			current.setNext(prev);
			prev = current;
			head = current;
		}

		return current;
	}

	private Node reverseRecursively(Node node) {
		Node newHead;
		if (node.getNext() == null) {
			return node;
		}
		newHead = reverseRecursively(node.getNext());
		node.getNext().setNext(node);
		node.setNext(null);
		return newHead;

	}
}