package com.ds.intro.array;

public class Main {
	public static void main(String[] args) {

		Array numbers = new Array(3);
		numbers.insert(1);
		numbers.insert(2);
		numbers.insert(3);
		numbers.insert(4);
		numbers.insert(5);
		numbers.insert(6);
		numbers.insert(7);
		numbers.insert(8);
		numbers.insert(9);

		System.out.println("MAX:" + numbers.max());
		// System.out.println(numbers.indexOf(4));
		// numbers.removeAt(1);
		
		numbers.insertAt(10, 6);
		//numbers.reverse();
		numbers.print();

		int[] intr = { 2, 5, 7 };
		for (int i : numbers.intersect(intr)) {
			System.out.println(" " + i);
		}
	}
}