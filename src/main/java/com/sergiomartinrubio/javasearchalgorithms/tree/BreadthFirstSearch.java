package com.sergiomartinrubio.javasearchalgorithms.tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.logging.Logger;

public class BreadthFirstSearch {

    private final Logger LOGGER = Logger.getLogger(BreadthFirstSearch.class.getName());

    private Node root;

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    /**
     * Add value to binary tree
     *
     * @param value value to be added
     */
    public void add(int value) {
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node current, int value) {

        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        }

        return current;
    }

    /**
     * Search value in Binary Tree using Breadth First Search Algorithm
     *
     * @param value to be found
     * @return true if value is found otherwise return false
     */
    public boolean search(int value) {
        Queue<Node> queue = new ArrayDeque<>();

        queue.add(this.root);
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            LOGGER.info(String.valueOf(currentNode.value));
            if (currentNode.value == value) {
                return true;
            }

            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }

            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
        return false;
    }
}
