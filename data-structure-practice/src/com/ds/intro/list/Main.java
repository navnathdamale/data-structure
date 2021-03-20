package com.ds.intro.list;

public class Main {
    int id;

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        linkedList.addLast(5);
        linkedList.addLast(6);
        System.out.println(linkedList.indexOf(5));
        System.out.println(linkedList.contains(2));

        //System.out.println(linkedList.size());
        linkedList.printFromEnd(linkedList.getFirst());

        // linkedList.removeLast();
        // linkedList.reverse();
        // linkedList.reverse();

        //linkedList.print();
        System.out.println(linkedList.getKthFromEnd(6));

        // System.out.println(Arrays.toString(linkedList.toArray()));
    }
}