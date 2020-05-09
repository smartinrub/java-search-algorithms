package com.sergiomartinrubio.javasearchalgorithms.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.logging.Logger;

public class GraphDepthFirstSearch {

    private static final Logger LOGGER = Logger.getLogger(GraphDepthFirstSearch.class.getName());

    private final Map<Integer, LinkedList<Integer>> adjLists;

    public GraphDepthFirstSearch() {
        adjLists = new HashMap<>();
    }

    /**
     * Add edge to the graph
     *
     * @param origin      value
     * @param destination value
     */
    public void add(int origin, int destination) {
        adjLists.computeIfAbsent(origin, adjList -> new LinkedList<>());
        adjLists.computeIfAbsent(destination, adjList -> new LinkedList<>());
        adjLists.get(origin).add(destination);
    }

    /**
     * Traverse graph
     */
    public void traverse() {
        boolean[] visited = new boolean[adjLists.size()];

        for (Integer vertex : adjLists.keySet()) {
            if (!visited[vertex]) {
                recursive(vertex, visited);
            }
        }
    }

    public void recursive(int vertex, boolean[] visited) {
        visited[vertex] = true;

        LOGGER.info(String.valueOf(vertex));

        for (Integer adjVertex : adjLists.get(vertex)) {
            if (!visited[adjVertex]) {
                recursive(adjVertex, visited);
            }
        }
    }

}
