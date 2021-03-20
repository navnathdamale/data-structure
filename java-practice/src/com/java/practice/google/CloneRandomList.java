package com.java.practice.google;

/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 */
public class CloneRandomList {

    public Node copyRandomList(Node head) {
        Node original = head;

        while (original != null) {
            Node temp = original.next;
            original.next = new Node(original.val);
            original.next.next = temp;
            original = temp;
        }

        original = head;

        while (original != null) {
            if (original.next != null) {
                original.next.random = (original.random != null) ? original.random.next : original.random;
            }

            original = (original.next != null) ? original.next.next : original.next;
        }

        original = head;
        Node copy = head.next, temp;
        temp = copy;

        while (original != null && copy != null) {
            original.next = (original.next != null) ? original.next.next : original.next;
            copy.next = (copy.next != null) ? copy.next.next : copy.next;

            original = original.next;
            copy = copy.next;
        }

        return temp;
    }
}

class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
