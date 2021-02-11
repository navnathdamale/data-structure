package com.java.practice.datastructure.array;

import java.util.Scanner;

public class StringCompare {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		String[] testString = new String[tests];
		for (int i = 0; i < tests; i++) {
			testString[i] = sc.next().trim();
		}

		for (int i = 0; i < tests; i++) {
			System.out.print((isPalindrom(testString[i]) ? "yes" : "no") + " ");
		}
	}

	public static boolean isPalindrom(String source) {
		if (source.isEmpty()) {
			return true;
		}
		String ovel = "aeiou";
		StringBuilder tempString = new StringBuilder();
		char[] tempArray = source.toCharArray();
		for (int i = 0; i < source.length(); i++) {
			if (ovel.contains(String.valueOf(tempArray[i]))) {
				tempString = tempString.append(tempArray[i]);
			}
		}
		String target = tempString.toString();
		String reverse = "";
		for (int i = target.length() - 1; i >= 0; i--) {
			reverse = reverse + target.charAt(i);
		}
		return reverse.equals(target);
	}
}
