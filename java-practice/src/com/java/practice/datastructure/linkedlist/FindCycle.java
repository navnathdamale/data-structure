package com.java.practice.datastructure.linkedlist;

import com.java.practice.datastructure.linkedlist.LinkedList.Node;

public class FindCycle {

	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.add(new Node("1"));
		Node cycle = new Node("2");
		linkedList.add(cycle);
		linkedList.add(new Node("3"));
		linkedList.add(new Node("4"));
		linkedList.add(cycle);
		linkedList.print();

		System.out.println("Is linkedlist contains cycle : " + new FindCycle().isCycle(linkedList.head()));
	}

	private boolean isCycle(Node head) {
		if (head == null) {
			return false;
		}

		Node slow = head;
		Node fast = head.getNext();
		while (fast != null && fast.getNext() != null) {
			if (slow == fast) {
				return true;
			}
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}
		return false;
	}

}
