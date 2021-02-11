package com.java.practice.datastructure.linkedlist;

import java.util.Arrays;
import java.util.List;

public class SortedArrayToBalancedBST {

	public static void main(String[] args) {
		List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6);
		TreeNode root = sortedArrayToBST(values);
		traverseInorder(root);

	}

	private static TreeNode sortedArrayToBST(List<Integer> values) {
		if (values.isEmpty()) {
			return null;
		}

		return insertBalanced(values, 0, values.size() - 1);
	}

	private static TreeNode insertBalanced(List<Integer> values, int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = (start + end) / 2;
		TreeNode node = new TreeNode(values.get(mid));
		node.setLeft(insertBalanced(values, start, mid - 1));
		node.setRight(insertBalanced(values, mid + 1, end));
		return node;
	}

	private static void traverseInorder(TreeNode root) {
		if (root == null) {
			return;
		}
		traverseInorder(root.getLeft());
		System.out.print(root.getVal() + " ");
		traverseInorder(root.getRight());
	}
}

class TreeNode {
	private int val;
	private TreeNode left;
	private TreeNode right;

	public TreeNode(int val) {
		this.val = val;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}
}