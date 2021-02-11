package com.ds.intro.trie;

public class Main {
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("car");
		trie.insert("care");
		trie.insert("card");
		trie.insert("careful");
		trie.insert("egg");

		// trie.traverse();

		// trie.remove("ca");

		// System.out.println(trie.contains("car"));

		// System.out.println(trie.findWords("ca"));
		//System.out.println(trie.containsRecursive("egg"));
		System.out.println(trie.countWords());
	}
}