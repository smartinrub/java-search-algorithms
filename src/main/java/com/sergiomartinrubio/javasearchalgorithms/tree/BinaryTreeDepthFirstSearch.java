package com.sergiomartinrubio.javasearchalgorithms.tree;

import java.util.Stack;
import java.util.logging.Logger;

public class BinaryTreeDepthFirstSearch {

    private final Logger LOGGER = Logger.getLogger(BinaryTreeDepthFirstSearch.class.getName());

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
     * Check if binary tree is empty
     *
     * @return true if binary tree is empty otherwise return false
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Search value in Binary Tree using Depth First Search Algorithm
     *
     * @param value to be found
     * @return true if value is found otherwise return false
     */
    public boolean PreOrderSearch(int value) {
        Stack<Node> stack = new Stack<>();
        Node currentNode;
        stack.push(this.root);

        while (!stack.empty()) {
            currentNode = stack.pop();

            LOGGER.info(String.valueOf(currentNode.value));
            if (currentNode.value == value) {
                return true;
            }

            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }

            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }

        }
        return false;
    }

}
