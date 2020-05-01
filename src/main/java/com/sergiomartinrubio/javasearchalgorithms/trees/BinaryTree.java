package com.sergiomartinrubio.javasearchalgorithms.trees;

public class BinaryTree<T> {

    private Node<T> root;

    private static class Node<T> {
        int value;
        Node<T> left;
        Node<T> right;
        Node<T> parent;

        private Node(int value) {
            this.value = value;
        }
    }

    /**
     * Add value in binary tree
     * @param value to be added
     */
    public void insert(int value) {
        Node<T> newNode = new Node<T>(value);
        Node<T> current = root;
        Node<T> leaf = null;

        while (current != null) {
            leaf = current;
            if (newNode.value < current.value) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        newNode.parent = leaf;

        if (leaf == null) {
            root = newNode;
        } else if (newNode.value < leaf.value) {
            leaf.left = newNode;
        } else {
            leaf.right = newNode;
        }
    }

    /**
     * Check if the binary tree contains a value
     * @param value to be found
     * @return true if value was found otherwise return false
     */
    public boolean contains(int value) {
        return recursiveSearch(root, value) != null;
    }

    private Node<T> recursiveSearch(Node<T> current, int value) {
        if (current == null || value == current.value) {
            return current;
        } else if (value < current.value) {
            return recursiveSearch(current.left, value);
        } else {
            return recursiveSearch(current.right, value);
        }
    }

    /**
     * Find minimum value in binary tree
     * @return the minimum value
     */
    public int minimum() {
        return findMinimum(root).value;
    }

    private Node<T> findMinimum(Node<T> root) {
        Node<T> current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    /**
     * Find maximum value in binary tree
     * @return maximum value
     */
    public int maximum() {
        return findMaximum(root).value;
    }

    private Node<T> findMaximum(Node<T> root) {
        Node<T> current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current;
    }

    /**
     * Delete value from binary tree
     * @param value value to be removed
     */
    public void delete(int value) {
        deleteNode(root, value);
    }

    private void deleteNode(Node<T> root, int value) {
        Node<T> nodeToDelete = recursiveSearch(root, value);
        if (nodeToDelete.left == null) {
            transplant(nodeToDelete, nodeToDelete.right);
        } else if (nodeToDelete.right == null) {
            transplant(nodeToDelete, nodeToDelete.left);
        } else {
            Node<T> min = findMinimum(nodeToDelete.right);
            if (min.parent != nodeToDelete) {
                transplant(min, min.right);
                min.right = nodeToDelete.right;
                min.right.parent = min;
            }
            transplant(nodeToDelete, min);
            min.left = nodeToDelete.left;
            min.left.parent = min;
        }
    }

    private void transplant(Node<T> nodeToDelete, Node<T> childNode) {
        if (nodeToDelete.parent == null) {
            root = childNode;
        } else if (nodeToDelete == nodeToDelete.parent.left) {
            nodeToDelete.parent.left = childNode;
        } else {
            nodeToDelete.parent.right = childNode;
        }
        if (childNode != null) {
            childNode.parent = nodeToDelete.parent;
        }
    }
}
