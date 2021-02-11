package com.ds.intro.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Graph {

	private class Node {
		private String label;

		public Node(String label) {
			this.label = label;
		}

		@Override
		public String toString() {
			return label;
		}
	}

	private Map<String, Node> nodes = new HashMap<>();
	private Map<Node, List<Node>> adjacencyList = new HashMap<>();

	public void addNode(String label) {
		Node node = new Node(label);
		nodes.putIfAbsent(label, node);
		adjacencyList.putIfAbsent(node, new ArrayList<>());
	}

	public void addEdge(String from, String to) {
		Node fromNode = nodes.get(from);
		if (fromNode == null) {
			throw new IllegalArgumentException();
		}

		Node toNode = nodes.get(to);
		if (toNode == null) {
			throw new IllegalArgumentException();
		}

		adjacencyList.get(fromNode).add(toNode);
	}

	public void removeNode(String label) {
		Node node = nodes.get(label);
		if (node == null) {
			return;
		}
		for (Node source : adjacencyList.keySet()) {
			adjacencyList.get(source).remove(node);
		}

		adjacencyList.remove(node);
		nodes.remove(label);
	}

	public void removeEdge(String from, String to) {

		Node fromNode = nodes.get(from);
		Node toNode = nodes.get(to);
		if (fromNode == null || toNode == null) {
			return;
		}
		adjacencyList.get(fromNode).remove(toNode);
	}

	public void print() {
		for (Node source : adjacencyList.keySet()) {
			List<Node> edges = adjacencyList.get(source);
			if (!edges.isEmpty()) {
				System.out.println(source + " is connected to " + edges);
			}
		}
	}

	public void traverseDFS(String root) {
		Node node = nodes.get(root);
		if (node == null) {
			return;
		}
		traverseDFSRec(node, new HashSet<>());
	}

	private void traverseDFSRec(Node node, Set<Node> visited) {
		System.out.println(node);
		visited.add(node);
		for (Node neighbour : adjacencyList.get(node)) {
			if (!visited.contains(neighbour)) {
				traverseDFSRec(neighbour, visited);
			}
		}
	}

	public void traverseDFSItr(String root) {
		Node node = nodes.get(root);
		if (node == null) {
			return;
		}

		Set<Node> visited = new HashSet<>();
		Stack<Node> stack = new Stack<Node>();
		stack.push(node);
		while (!stack.isEmpty()) {
			Node current = stack.pop();
			if (visited.contains(current)) {
				continue;
			}
			System.out.println(current);
			visited.add(current);
			for (Node neighbour : adjacencyList.get(current)) {
				stack.push(neighbour);
			}
		}
	}

	public void traverseBFS(String root) {
		Node node = nodes.get(root);
		if (node == null) {
			return;
		}

		Set<Node> visited = new HashSet<>();
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			Node current = queue.remove();
			if (visited.contains(current)) {
				continue;
			}
			System.out.println(current);
			visited.add(current);
			for (Node neighbour : adjacencyList.get(current)) {
				if (!visited.contains(neighbour)) {
					queue.add(neighbour);
				}
			}
		}
	}

	public List<String> topologicalSort() {
		Stack<Node> stack = new Stack<>();
		Set<Node> visited = new HashSet<>();
		for (Node node : nodes.values()) {
			topologicalSort(node, visited, stack);
		}

		List<String> sorted = new ArrayList<>();

		while (!stack.isEmpty()) {
			sorted.add(stack.pop().label);
		}

		return sorted;
	}

	private void topologicalSort(Node node, Set<Node> visited, Stack<Node> stack) {
		if (visited.contains(node)) {
			return;
		}
		visited.add(node);

		for (Node neighNode : adjacencyList.get(node)) {
			topologicalSort(neighNode, visited, stack);
		}
		stack.push(node);
	}

	public boolean hasCycle() {
		Set<Node> all = new HashSet<>(nodes.values());
		Set<Node> visiting = new HashSet<>();
		Set<Node> visited = new HashSet<>();
		while (!all.isEmpty()) {
			Node current = all.iterator().next();
			if (hasCycle(current, all, visiting, visited)) {
				return true;
			}
		}
		return false;
	}

	private boolean hasCycle(Node node, Set<Node> all, Set<Node> visiting, Set<Node> visited) {
		all.remove(node);
		visiting.add(node);

		for (Node neighbour : adjacencyList.get(node)) {
			if (visited.contains(neighbour)) {
				continue;
			}

			if (visiting.contains(neighbour)) {
				return true;
			}

			if (hasCycle(neighbour, all, visiting, visited)) {
				return true;
			}
		}
		visiting.remove(node);
		visited.add(node);

		return false;
	}

}
