package com.sergiomartinrubio.javasearchalgorithms.tree;

public class TernarySearchTree {

    private TernaryTreeNode root;

    static class TernaryTreeNode {
        char value;
        boolean isLeaf;
        TernaryTreeNode left;
        TernaryTreeNode middle;
        TernaryTreeNode right;

        public TernaryTreeNode(char value) {
            this.value = value;
        }
    }

    /**
     * Add string to ternary search tree with recursion
     *
     * @param word to be inserted
     */
    public void add(String word) {
        int position = 0;
        if (root == null) {
            root = new TernaryTreeNode(word.charAt(position++));
            if (position == word.length()) {
                root.isLeaf = true;
                return;
            }
        }
        recursiveInsert(root, word, position);
    }

    private void recursiveInsert(TernaryTreeNode node, String word, int position) {

        if (word.charAt(position) < node.value) {
            if (node.left != null) {
                recursiveInsert(node.left, word, position);
            } else {
                node.left = new TernaryTreeNode(word.charAt(position++));
                if (position == word.length()) {
                    node.left.isLeaf = true;
                } else {
                    recursiveInsert(node.left, word, position);
                }
            }
        } else if (word.charAt(position) > node.value) {
            if (node.right != null) {
                recursiveInsert(node.right, word, position);
            } else {
                node.right = new TernaryTreeNode(word.charAt(position++));
                if (position == word.length()) {
                    node.right.isLeaf = true;
                } else {
                    recursiveInsert(node.right, word, position);
                }
            }
        } else {
            if (node.middle != null) {
                recursiveInsert(node.middle, word, position);
            } else {
                node.middle = new TernaryTreeNode(word.charAt(position++));
                if (position == word.length()) {
                    node.middle.isLeaf = true;
                } else {
                    recursiveInsert(node.middle, word, position);
                }
            }
        }
    }

    /**
     * Search word in the ternary search tree
     *
     * @param word to be searched
     * @return true if word is found, otherwise return false
     */
    public boolean search(String word) {
        TernaryTreeNode currentNode = root;
        int position = 0;
        while (currentNode != null) {
            if (word.charAt(position) < currentNode.value) {
                currentNode = currentNode.left;
            } else if (word.charAt(position) > currentNode.value) {
                currentNode = currentNode.right;
            } else {
                if (position == word.length() - 1 && currentNode.isLeaf) {
                    return true;
                }
                if (currentNode.middle != null) {
                    currentNode = currentNode.middle;
                }
                position++;
            }
        }
        return false;
    }
}
