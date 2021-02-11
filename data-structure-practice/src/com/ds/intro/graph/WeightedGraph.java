package com.ds.intro.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

public class WeightedGraph {

	private class Node {
		private String label;

		private List<Edge> edges = new ArrayList<>();

		public Node(String label) {
			this.label = label;
		}

		public void addEdge(Node to, int weight) {
			edges.add(new Edge(this, to, weight));
		}

		public List<Edge> getEdges() {
			return edges;
		}

		@Override
		public String toString() {
			return label;
		}
	}

	private class Edge {
		private Node from;
		private Node to;
		private int weight;

		public Edge(Node from, Node to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return from + " -> " + to;
		}
	}

	private class NodeEntry {
		private Node node;
		private int priority;

		public NodeEntry(Node node, int priority) {
			this.node = node;
			this.priority = priority;
		}
	}

	private class Path {
		private List<String> nodes = new ArrayList<>();

		public void add(String node) {
			nodes.add(node);
		}

		@Override
		public String toString() {
			return nodes.toString();
		}

	}

	private Map<String, Node> nodes = new HashMap<String, Node>();

	public void addNode(String label) {
		Node node = new Node(label);
		nodes.putIfAbsent(label, node);
	}

	public void addEdge(String from, String to, int weight) {
		Node fromNode = nodes.get(from);
		if (fromNode == null) {
			throw new IllegalArgumentException();
		}

		Node toNode = nodes.get(to);
		if (toNode == null) {
			throw new IllegalArgumentException();
		}
		fromNode.addEdge(toNode, weight);
		toNode.addEdge(fromNode, weight);
	}

	public Path getShortestPath(String from, String to) {
		Node fromNode = nodes.get(from);
		Node toNode = nodes.get(to);

		if (fromNode == null || toNode == null) {
			throw new IllegalArgumentException();
		}

		Map<Node, Integer> distances = new HashMap<>();
		for (Node node : nodes.values()) {
			distances.putIfAbsent(node, Integer.MAX_VALUE);
		}
		distances.replace(fromNode, 0);
		Set<Node> visited = new HashSet<>();
		Map<Node, Node> previousMap = new HashMap<>();

		PriorityQueue<NodeEntry> queue = new PriorityQueue<>(Comparator.comparingInt(ne -> ne.priority));
		queue.add(new NodeEntry(fromNode, 0));

		while (!queue.isEmpty()) {
			Node current = queue.remove().node;
			visited.add(current);
			for (Edge edge : current.getEdges()) {
				if (visited.contains(edge.to)) {
					continue;
				}

				int newDistance = distances.get(current) + edge.weight;
				if (newDistance < distances.get(edge.to)) {
					distances.replace(edge.to, newDistance);
					queue.add(new NodeEntry(edge.to, newDistance));
					previousMap.put(edge.to, current);
				}
			}
		}

		return buildPath(previousMap, toNode);
	}

	private Path buildPath(Map<Node, Node> previousMap, Node toNode) {
		Stack<Node> stack = new Stack<>();
		stack.push(toNode);
		Node previous = previousMap.get(toNode);
		while (previous != null) {
			stack.push(previous);
			previous = previousMap.get(previous);
		}

		Path path = new Path();
		while (!stack.isEmpty()) {
			path.add(stack.pop().label);
		}
		return path;
	}

	public boolean hasCycle() {
		Set<Node> visited = new HashSet<>();
		for (Node node : nodes.values()) {
			if (!visited.contains(node) && hasCycle(node, null, visited)) {
				return true;
			}
		}

		return false;
	}

	private boolean hasCycle(Node node, Node parent, Set<Node> visited) {
		visited.add(node);

		for (Edge edge : node.getEdges()) {
			if (edge.to == parent) {
				continue;
			}
			if (visited.contains(edge.to) || hasCycle(edge.to, node, visited)) {
				return true;
			}
		}
		return false;

	}

	public void print() {
		for (Node node : nodes.values()) {
			List<Edge> edges = node.getEdges();
			if (!edges.isEmpty()) {
				System.out.println(node + " is connected to " + edges);
			}
		}
	}

}
