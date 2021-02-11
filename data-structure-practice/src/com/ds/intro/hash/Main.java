package com.ds.intro.hash;

public class Main {
	public static void main(String[] args) {
		HashTable hashTable = new HashTable();
		hashTable.put(6, "A"); // 1
		hashTable.put(8, "B"); // 3
		hashTable.put(11, "C"); // 1
		hashTable.put(6, "A+"); // 1
	
		System.out.println(hashTable.get(11));
	}
}