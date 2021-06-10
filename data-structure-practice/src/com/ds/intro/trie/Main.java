package com.ds.intro.trie;

public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
		/*trie.insert("car");
		trie.insert("care");
		trie.insert("card");
		trie.insert("careful");
		trie.insert("egg");*/

        // trie.traverse();

        // trie.remove("ca");

        // System.out.println(trie.contains("car"));

        // System.out.println(trie.findWords("ca"));
        //System.out.println(trie.containsRecursive("egg"));

        //trie.insert("can");
        //trie.insert("cat");

        //System.out.println(trie.contains("c"));

        System.out.println(trie.countWords());

        String[] dictionary = {"test", "tree", "cat", "can"};

        for (String word : dictionary) {
            trie.insert(word);
        }
        String userInput = "etgeshhtrveev";
        StringBuilder sb = new StringBuilder();
        for (char ch : userInput.toCharArray()) {
            sb.append(ch);
            if (trie.getWords(sb.toString()) == null) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        System.out.println("Word matched ==>> " + sb.toString());
    }
}