package com.ds.intro.list;

import java.util.NoSuchElementException;

public class LinkedList {

	private Node first;
	private Node last;
	private int size;

	public void addFirst(int item) {
		Node node = new Node(item);
		if (isEmpty()) {
			first = last = node;
		} else {
			node.next = first;
			first = node;
		}
		size++;
	}

	public void addLast(int item) {
		Node node = new Node(item);
		if (isEmpty()) {
			first = last = node;
		} else {
			last.next = node;
			last = node;
		}
		size++;
	}

	public int indexOf(int item) {
		int index = 0;
		Node current = first;
		while (current != null) {
			if (current.value == item) {
				return index;
			}
			current = current.next;
			index++;
		}
		return -1;
	}

	public boolean contains(int item) {
		return indexOf(item) != -1;
	}

	public void removeFirst() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}

		if (first == last) {
			first = last = null;
		} else {
			Node second = first.next;
			first.next = null;
			first = second;
		}
		size--;
	}

	public void removeLast() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}

		if (first == last) {
			first = last = null;
		} else {
			Node previousNode = getPreviousNode(last);
			last = previousNode;
			last.next = null;
		}

		size--;
	}

	public int size() {
		return size;
	}

	public int[] toArray() {
		int[] array = new int[size];
		int index = 0;
		Node current = first;
		while (current != null) {
			array[index++] = current.value;
			current = current.next;
		}
		return array;
	}

	public void reverse() {
		if (isEmpty()) {
			return;
		}

		Node prev = first;
		Node current = first.next;
		while (current != null) {
			Node next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		last = first;
		last.next = null;
		first = prev;
	}

	public Node getKthFromEnd(int k) {

		if (k > size) {
			throw new IllegalArgumentException();
		}
		Node f = first;
		Node s = first;

		for (int i = 0; i < k; i++) {
			f = f.next;
		}

		while (f != null) {
			f = f.next;
			s = s.next;
		}

		return s;
	}

	public Node printMiddle(Node head) {
		Node slowPointer, fastPointer;
		slowPointer = fastPointer = first;

		while (fastPointer != null) {
			fastPointer = fastPointer.next;
			if (fastPointer != null && fastPointer.next != null) {
				slowPointer = slowPointer.next;
				fastPointer = fastPointer.next;
			}
		}
		return slowPointer;
	}

	public boolean hasLoop() {
		Node fast, slow;
		fast = slow = first;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				return true;
			}
		}
		return false;
	}

	private Node getPreviousNode(Node node) {
		Node current = first;
		while (current != null) {
			if (current.next == node) {
				return current;
			}
			current = current.next;
		}
		return null;
	}

	private boolean isEmpty() {
		return first == null;
	}

	public void print() {
		Node current = first;
		while (current != null) {
			System.out.print(current.value + " -> ");
			current = current.next;
		}
	}

	private class Node {
		private int value;
		private Node next;

		public Node(int value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "Node [value=" + value + ", next=" + next + "]";
		}
	}
}
