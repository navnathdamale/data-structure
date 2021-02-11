package com.java.practice.random;

import java.util.ArrayList;
import java.util.List;

public class ShalowCopy {
	public static void main(String[] args) {
		List<String> firstList, secondList;
		firstList = new ArrayList<String>();
		firstList.add("Hello:");

		secondList = firstList;
		secondList.add("World");

		System.out.println("First :" + firstList);
		System.out.println("Second :" + secondList);
	}
}
