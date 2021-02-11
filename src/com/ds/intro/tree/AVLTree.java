package com.ds.intro.tree;

public class AVLTree {
	private class AVLNode {
		private int value;
		private int height;
		private AVLNode left;
		private AVLNode right;

		public AVLNode(int value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "AVLNode [value=" + value + "]";
		}
	}

	private AVLNode root;

	public void insert(int value) {
		root = insert(root, value);
	}

	private AVLNode insert(AVLNode node, int value) {
		if (node == null) {
			return new AVLNode(value);
		}

		if (value < node.value) {
			node.left = insert(node.left, value);
		} else {
			node.right = insert(node.right, value);
		}

		setHeight(node);

		return balance(node);
	}

	private AVLNode balance(AVLNode node) {
		// balanceFactor = height(L) - height(R);
		// > 1 => left heavy
		// < -1 => right heavy

		if (isLeftHeavy(node)) {
			if (balanceFactor(node.left) < 0) {
				node.left = rotateLeft(node.left);
			}
			return rotateRight(node);
		} else if (isRightHeavy(node)) {
			if (balanceFactor(node.right) > 0) {
				node.right = rotateRight(node.right);
			}
			return rotateLeft(node);
		}

		return node;
	}

	private AVLNode rotateLeft(AVLNode node) {
		AVLNode newRoot = node.right;
		node.right = newRoot.left;
		newRoot.left = node;
		setHeight(node);
		setHeight(newRoot);
		return newRoot;
	}

	private AVLNode rotateRight(AVLNode node) {
		AVLNode newRoot = node.left;
		node.left = newRoot.right;
		newRoot.right = node;
		setHeight(node);
		setHeight(newRoot);
		return newRoot;
	}

	private void setHeight(AVLNode node) {
		node.height = Math.max(height(node.left), height(node.right)) + 1;
	}

	private boolean isLeftHeavy(AVLNode node) {
		return balanceFactor(node) > 1;
	}

	private boolean isRightHeavy(AVLNode node) {
		return balanceFactor(node) < -1;
	}

	private int balanceFactor(AVLNode node) {
		return (node == null) ? 0 : height(node.left) - height(node.right);
	}

	private int height(AVLNode node) {
		return (node == null) ? -1 : node.height;
	}

	public void print() {
		print(root);
	}

	private void print(AVLNode root) {
		if (root != null) {
			System.out.println(root);
		}

		if (root.left != null) {
			print(root.left);
		}
		if (root.right != null) {
			print(root.right);
		}
	}
}
