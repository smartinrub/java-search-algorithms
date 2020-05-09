package com.sergiomartinrubio.javasearchalgorithms.graph;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.logging.Logger;

public class Graph {

    private static final Logger LOGGER = Logger.getLogger(Graph.class.getName());

    private final Map<Node, LinkedList<Node>> neighborsByNode;

    public Graph() {
        neighborsByNode = new HashMap<>();
    }

    /**
     * Add edge to the graph
     *
     * @param origin      value
     * @param destination value
     */
    public void addEdge(Node origin, Node destination) {
        if (!neighborsByNode.containsKey(origin)) {
            neighborsByNode.put(origin, null);
        }
        if (!neighborsByNode.containsKey(destination)) {
            neighborsByNode.put(destination, null);
        }

        add(origin, destination);
        add(destination, origin);
    }

    private void add(Node origin, Node destination) {
        LinkedList<Node> neighbors = neighborsByNode.get(origin);

        if (neighbors != null) {
            neighborsByNode.remove(origin);
        } else {
            neighbors = new LinkedList<>();
        }
        neighbors.add(destination);
        neighborsByNode.put(origin, neighbors);
    }

    /**
     * Search node in graph with recursion
     *
     * @param node to be found
     * @return true if found, otherwise return false
     */
    public boolean depthFirstSearch(Node node) {
        for (Node currentNode : neighborsByNode.keySet()) {

            if (node.value == currentNode.value) {
                return true;
            }
            if (!currentNode.visited) {
                if (depthFirstSearchRecursive(currentNode, node)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean depthFirstSearchRecursive(Node currentNode, Node node) {

        currentNode.visited = true;

        LinkedList<Node> allNeighbors = neighborsByNode.get(currentNode);
        if (allNeighbors == null) {
            return false;
        }

        for (Node neighbor : allNeighbors) {
            LOGGER.info(String.valueOf(currentNode.value));
            if (node.value == neighbor.value) {
                return true;
            }
            if (!neighbor.visited) {
                depthFirstSearchRecursive(neighbor, node);
            }
        }
        return false;
    }

    /**
     * Search node in graph
     *
     * @param node to be found
     * @return true if found otherwise return false
     */
    public boolean breadthFirstSearch(Node node) {

        Node firstNode = neighborsByNode.keySet().iterator().next();

        if (firstNode == null) {
            return false;
        }

        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(firstNode);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();

            // Check if node was found.
            LOGGER.info(String.valueOf(currentNode.value));
            if (currentNode.value == node.value) {
                return true;
            }

            if (currentNode.visited) {
                continue;
            }

            currentNode.visited = true;
            LinkedList<Node> allNeighbors = neighborsByNode.get(currentNode);

            if (allNeighbors == null) {
                continue;
            }

            for (Node neighbor : allNeighbors) {
                if (!neighbor.visited) {
                    queue.add(neighbor);
                }
            }
        }
        return false;
    }

}
