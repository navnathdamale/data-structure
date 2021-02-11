package com.ds.intro.graph;

public class Main {
	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.addNode("X");
		graph.addNode("A");
		graph.addNode("B");
		graph.addNode("P");
		graph.addEdge("X", "A");
		graph.addEdge("X", "B");
		graph.addEdge("A", "P");
		graph.addEdge("B", "P");
		// graph.addEdge("P", "X");

		// graph.removeEdge("A", "C");

		// graph.print();

		// graph.traverseDFS("G");
		// graph.traverseDFSItr("A");
		// graph.traverseBFS("X");

		// System.out.println(graph.topologicalSort());
		// System.out.println(graph.hasCycle());

		WeightedGraph weightedGraph = new WeightedGraph();
		weightedGraph.addNode("A");
		weightedGraph.addNode("B");
		weightedGraph.addNode("C");
		weightedGraph.addNode("D");
		weightedGraph.addEdge("A", "B", 1);
		weightedGraph.addEdge("B", "C", 2);
		weightedGraph.addEdge("A", "C", 10);
		weightedGraph.addEdge("C", "D", 3);
		weightedGraph.addEdge("A", "D", 19);

		// System.out.println(weightedGraph.getShortestPath("A", "D"));
		System.out.println(weightedGraph.hasCycle());

		// weightedGraph.print();
	}
}