package com.ds.intro.tree;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(2);
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);
        tree.insert(12);
        tree.insert(11);

        //tree.print();
        //tree.preOrder();
        //tree.inOrder();
        //tree.postOrder();

        // System.out.println(tree.height());
        //System.out.println(tree.effMin());
        // System.out.println(tree.min());
        //tree.traverseLevelOrder();

        //  System.out.println(tree.find(10));
        //System.out.println(tree.size());
        //System.out.println(tree.countLeaves());
        System.out.println(tree.getAncestors(9));

        Tree tree1 = new Tree();
        tree1.insert(7);
        tree1.insert(4);
        tree1.insert(9);
        tree1.insert(1);
        tree1.insert(6);
        tree1.insert(8);
        tree1.insert(10);

        //System.out.println(tree.equals(tree1));

        // tree1.swapRoot();
        //System.out.println(tree1.isBinarySearchTree());

        //System.out.println(tree1.printNodeAtDistance(2));
        // tree1.printNodeAtDistance(2);

        AVLTree avlTree = new AVLTree();
        avlTree.insert(10);
        avlTree.insert(20);
        avlTree.insert(30);
        avlTree.insert(40);
        avlTree.insert(50);
        avlTree.insert(60);
        avlTree.insert(70);

        //avlTree.print();

    }

}
