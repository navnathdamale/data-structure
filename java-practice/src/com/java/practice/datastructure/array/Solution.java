package com.java.practice.datastructure.array;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	// Complete the bfs function below.
	// n - number of nodes, m - number of edges, s- starting node
	static int[] bfs(int n, int m, int[][] edges, int start) {

		int[] result = new int[n - 1];
		int[] flatArray = new int[edges.length * edges[0].length];

		int k = 0;
		for (int i = 0; i < edges.length; i++) {
			for (int j = 0; j < edges[i].length; j++) {
				flatArray[k] = edges[i][j];
				k++;
			}
		}

		Arrays.sort(flatArray);
		int strPairCnt = 0;
		int intPairCnt = 0;

		int temp1 = flatArray[0];
		int temp2 = flatArray[0];
		for (int i = 0; i < flatArray.length; i++) {
			System.out.print(flatArray[i] + " ");
			if (flatArray[i] == start) {
				strPairCnt++;
			} else if (temp1 == flatArray[i] && temp2 != temp1) {
				intPairCnt++;
				temp2 = temp1;
			}
			temp1 = flatArray[i];
		}

		boolean putEnd = (n - start) > m;
		int i = 0;
		for (i = 0; i < strPairCnt; i++) {
			if (!putEnd && i == 0) {
				result[i] = -1;
				strPairCnt++;
			} else {
				result[i] = 6;
			}
		}

		if (intPairCnt > 0) {
			intPairCnt++;
			result[i] = 6 * (intPairCnt);
		}

		if (putEnd) {
			result[n - 2] = -1;
		}

		System.out.println();
		System.out.println("strPairCnt :" + strPairCnt + " intPairCnt :" + intPairCnt);

		return result;
	}

	public static void main(String[] args) {

		int[][] board = { { 1, 2 }, { 1, 3 } };
		// int[][] board = { { 1, 2 }, { 1, 3 }, { 3, 4 } };
		// int[][] board = { { 2, 3 } };
		int[] result = bfs(4, 2, board, 1);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}
}
