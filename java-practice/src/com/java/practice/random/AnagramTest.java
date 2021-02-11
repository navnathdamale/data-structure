package com.java.practice.random;

public class AnagramTest {
	public static void main(String[] args) {
		System.out.println("Ia anagram : " + new AnagramTest().isAnagram("SILENT", "LISTEN"));
	}

	private boolean isAnagram(String target, String source) {
		if (target.length() != source.length()) {
			return false;
		}
		/*
		 * char[] targetArray = target.toCharArray(); char[] sourceArray =
		 * source.toCharArray(); Arrays.sort(targetArray); Arrays.sort(sourceArray);
		 * return new String(targetArray).equals(new String(sourceArray));
		 */
		boolean isAnagram = false;

		char[] targetArray = target.toCharArray();
		for (int i = 0; i < targetArray.length; i++) {
			if (source.contains(String.valueOf(targetArray[i]))) {
				int position = source.indexOf(targetArray[i]);
				source = source.substring(0, position) + source.substring(position + 1);
			} else {
				isAnagram = false;
			}
			if (source.isEmpty() || source == null) {
				isAnagram = true;
			}
		}
		return isAnagram;
	}
}
