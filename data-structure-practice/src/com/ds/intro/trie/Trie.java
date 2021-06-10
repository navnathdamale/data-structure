package com.ds.intro.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Trie {

    private class Node {
        private char value;
        private boolean isEndOfWord;
        private HashMap<Character, Node> children = new HashMap<>();

        public Node(char value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node [value=" + value + "]";
        }

        public boolean hasChild(char ch) {
            return children.containsKey(ch);
        }

        public void addChild(char ch) {
            children.put(ch, new Node(ch));
        }

        public Node getChild(char ch) {
            return children.get(ch);
        }

        public Node[] getChildren() {
            return children.values().toArray(new Node[0]);
        }

        public boolean hasChildren() {
            return !children.isEmpty();
        }

        public void removeChild(char ch) {
            children.remove(ch);
        }
    }

    private Node root = new Node(' ');

    public void insert(String word) {
        Node current = root;
        for (char ch : word.toCharArray()) {
            if (!current.hasChild(ch)) {
                current.addChild(ch);
            }
            current = current.getChild(ch);
        }
        current.isEndOfWord = true;
    }

    public boolean contains(String word) {
        if (word == null)
            return false;

        Node current = root;
        for (char ch : word.toCharArray()) {
            if (!current.hasChild(ch)) {
                return false;
            }

            current = current.getChild(ch);
        }

        return current.isEndOfWord;
    }

    public boolean containsRecursive(String word) {
        if (word == null)
            return false;

        return containsRecursive(root, word, 0);
    }

    private boolean containsRecursive(Node node, String word, int index) {
        if (index == word.length() && !node.isEndOfWord) {
            return false;
        } else if (node.isEndOfWord) {
            return true;
        }

        char ch = word.charAt(index);
        Node child = node.getChild(ch);
        if (child == null) {
            return false;
        }
        return containsRecursive(child, word, index + 1);
    }

    public void remove(String word) {
        if (word == null) {
            return;
        }
        remove(root, word, 0);
    }

    private void remove(Node node, String word, int index) {
        if (index == word.length()) {
            node.isEndOfWord = false;
            return;
        }
        char ch = word.charAt(index);
        Node child = node.getChild(ch);
        if (child == null) {
            return;
        }
        remove(child, word, index + 1);

        if (!child.hasChildren() && !child.isEndOfWord) {
            node.removeChild(ch);
        }
    }

    public void traverse() {
        traverse(root);
    }

    private void traverse(Node node) {
        System.out.println(node);

        for (Node child : node.getChildren()) {
            traverse(child);
        }
    }

    public List<String> findWords(String prefix) {
        List<String> words = new ArrayList<String>();
        Node lastNode = findLastNodeOf(prefix);
        findWords(lastNode, prefix, words);
        return words;
    }

    private void findWords(Node node, String prefix, List<String> words) {
        if (node == null)
            return;

        if (node.isEndOfWord) {
            words.add(prefix);
        }

        for (Node child : node.getChildren()) {
            findWords(child, prefix + child.value, words);
        }
    }

    public Node[] getWords(String prefix) {
        Node lastNode = findLastNodeOf(prefix);
        return lastNode != null ? lastNode.getChildren() : null;
    }

    private Node findLastNodeOf(String prefix) {
        if (prefix == null) {
            return null;
        }

        Node current = root;
        for (char ch : prefix.toCharArray()) {
            Node child = current.getChild(ch);
            if (child == null) {
                return null;
            }
            current = child;
        }

        return current;
    }

    public int countWords() {
        List<String> countSet = new ArrayList<>();
        countWords(root, countSet);
        return countSet.size();
    }

    private void countWords(Node node, List<String> countSet) {
        if (node == null) {
            return;
        }
        if (node.isEndOfWord) {
            countSet.add("1");
        }

        for (Node child : node.getChildren()) {
            countWords(child, countSet);
        }
    }
}
