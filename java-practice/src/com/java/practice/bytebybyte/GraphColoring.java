package com.java.practice.bytebybyte;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class GraphColoring {
    public static void main(String[] args) {
        Graph g1 = new Graph(5);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 2);
        g1.addEdge(1, 3);
        g1.addEdge(2, 3);
        g1.addEdge(3, 4);
        System.out.println("Coloring of graph 1");
        g1.greedyColoring();
    }
}

class Graph {
    private int v;
    private LinkedList<Integer> adjList[];

    public Graph(int v) {
        this.v = v;
        adjList = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int d) {
        adjList[s].add(d);
        adjList[d].add(s);
    }

    public void greedyColoring() {
        //create the  array to store the results
        int[] result = new int[v];
        Arrays.fill(result, -1);
        result[0] = 0;

        boolean[] available = new boolean[v];
        Arrays.fill(available, true);

        for (int i = 1; i < v; i++) {
            Iterator<Integer> itr = adjList[i].iterator();
            while (itr.hasNext()) {
                int node = itr.next();
                if (result[node] != -1) {
                    available[result[node]] = false;
                }
            }
            int clr;
            for (clr = 0; clr < v; clr++) {
                if (available[clr]) {
                    break;
                }
            }
            result[i] = clr;

            Arrays.fill(available, true);
        }

        for (int u = 0; u < v; u++)
            System.out.println("Vertex " + u + " --->  Color "
                    + result[u]);
    }
}