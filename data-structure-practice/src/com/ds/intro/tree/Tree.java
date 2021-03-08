package com.ds.intro.tree;

import java.util.ArrayList;
import java.util.List;

public class Tree {

    private class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node [value=" + value + "]";
        }
    }

    private Node root;

    public void insert(int value) {
        Node node = new Node(value);
        if (root == null) {
            root = node;
            return;
        }

        Node current = root;
        while (true) {
            if (current.value > value) {
                if (current.left == null) {
                    current.left = node;
                    break;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = node;
                    break;
                }
                current = current.right;
            }
        }
    }

    public boolean find(int value) {
        Node current = root;
        while (current != null) {
            if (value < current.value) {
                current = current.left;
            } else if (value > current.value) {
                current = current.right;
            } else {
                return true;
            }
        }

        return false;
    }

    public void print() {
        print(root);
    }

    public void preOrder() {
        preOrder(root);
    }

    public void inOrder() {
        inOrder(root);
    }

    public void postOrder() {
        postOrder(root);
    }

    public int height() {
        return height(root);
    }

    private int height(Node root) {
        if (root == null) {
            return -1;
        }
        if (isLeaf(root)) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    private void preOrder(Node root) {
        // Node -> Left -> Right
        if (root == null) {
            return;
        }
        System.out.print(root);
        preOrder(root.left);
        preOrder(root.right);
    }

    private void inOrder(Node root) {
        // Node -> Left -> Right
        if (root == null) {
            return;
        }

        preOrder(root.left);
        System.out.print(root);
        preOrder(root.right);
    }

    private void postOrder(Node root) {
        // Node -> Left -> Right
        if (root == null) {
            return;
        }

        preOrder(root.left);
        preOrder(root.right);
        System.out.println(root);
    }

    public int min() {
        return min(root);
    }

    public int effMin() {
        Node current = root;
        Node last = current;
        while (current != null) {
            if (current.left == null) {
                last = current;
                break;
            }
            current = current.left;
        }
        return last.value;
    }

    public boolean equals(Tree other) {
        if (other == null) {
            return false;
        }
        return equals(root, other.root);
    }

    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public void swapRoot() {
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public List<Integer> printNodeAtDistance(int distance) {
        List<Integer> list = new ArrayList<Integer>();
        printNodeAtDistance(root, distance, list);
        return list;
    }

    private void printNodeAtDistance(Node node, int distance, List<Integer> list) {
        if (node == null) {
            return;
        }
        if (distance == 0) {
            list.add(node.value);
            return;
        }
        printNodeAtDistance(node.left, distance - 1, list);
        printNodeAtDistance(node.right, distance - 1, list);
    }

    private boolean isBinarySearchTree(Node node, int min, int max) {
        if (node == null) {
            return true;
        }
        if (node.value < min || node.value > max) {
            return false;
        }

        return isBinarySearchTree(node.left, min, node.value - 1)
                && isBinarySearchTree(node.right, node.value + 1, max);
    }

    private boolean equals(Node first, Node second) {
        if (first == null && second == null) {
            return true;
        }

        if (first != null && second != null) {
            return first.value == second.value && equals(first.left, second.left) && equals(first.right, second.right);
        }

        return false;
    }

    private int min(Node root) {
        if (isLeaf(root)) {
            return root.value;
        }

        int left = min(root.left);
        int right = min(root.right);

        return Math.min(Math.min(left, right), root.value);
    }

    public void traverseLevelOrder() {
        for (int i = 0; i <= height(); i++) {
            printNodeAtDistance(i).forEach(System.out::println);
        }
    }

    public int size() {
        return findSize(root);
    }

    private int findSize(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + findSize(root.left) + findSize(root.right);

    }


    public int countLeaves() {
        return countLeaves(root);
    }

    private int countLeaves(Node root) {
        if (root == null) {
            return 0;
        }
        if (isLeaf(root)) {
            return 1;
        }

        return countLeaves(root.left) + countLeaves(root.right);
    }

    private boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    public List<Integer> getAncestors(int value) {
        List<Integer> ancestors = new ArrayList<>();
        getAncestors(ancestors, root, value);
        return ancestors;
    }

    public List<Integer> getAncestors(List<Integer> ancestors, Node root, int value) {
        if (root == null) {
            return ancestors;
        }

        if (root.value < value) {
            getAncestors(ancestors, root.right, value);
            ancestors.add(root.value);
        } else if (root.value > value) {
            getAncestors(ancestors, root.left, value);
            ancestors.add(root.value);
        }

        return ancestors;
    }

    private void print(Node root) {
        if (root != null) {
            System.out.println(root);
        }

        if (root.left != null) {
            print(root.left);
        }
        if (root.right != null) {
            print(root.right);
        }
    }

}