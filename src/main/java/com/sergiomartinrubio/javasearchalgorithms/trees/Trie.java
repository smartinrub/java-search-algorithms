package com.sergiomartinrubio.javasearchalgorithms.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Stack;

public class Trie {

    private TrieNode root;

    private static class TrieNode {
        char character;
        List<TrieNode> childNodes;
        boolean isLeaf;
    }

    /**
     * Add word to trie
     * @param word to add to trie
     */
    public void add(String word) {
        if (root == null) {
            root = new TrieNode();
            root.childNodes = new ArrayList<>();
        }
        List<TrieNode> childNodes = root.childNodes;

        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            TrieNode tail;
            Optional<TrieNode> trieNode = childNodes.stream()
                    .filter(node -> node.character == currentChar)
                    .findFirst();
            if (trieNode.isPresent()) {
                tail = trieNode.get();
            } else {
                tail = new TrieNode();
                tail.character = currentChar;
                tail.childNodes = new ArrayList<>();
                childNodes.add(tail);
            }
            childNodes = tail.childNodes;

            if (i == word.length() - 1) {
                tail.isLeaf = true;
            }
        }
    }

    /**
     * Search word in trie
     * @param word to search in trie
     * @return true if the word was found otherwise return false
     */
    public boolean search(String word) {
        TrieNode tail = getTrieNode(word);
        return tail != null && tail.isLeaf;
    }

    /**
     * Use _Depth First Search_ (DFS) to go down the trie while building string for each subtrie.
     * @param prefix use to find words
     * @return list of words that match the prefix
     */
    public List<String> lookup(String prefix) {
        // Use the previous function to find the last node of the prefix
        TrieNode tail = getTrieNode(prefix);
        if (tail == null) {
            return List.of();
        }
        Stack<TrieNode> stack = new Stack<>();
        stack.push(tail);
        TrieNode current;
        StringBuilder word = new StringBuilder();
        // Start building the first word with the prefix
        word.append(prefix, 0, prefix.length() - 1);
        List<String> words = new ArrayList<>();
        while (!stack.empty()) {
            current = stack.pop();
            word.append(current.character);
            // End of the word?
            if (current.isLeaf) {
                words.add(word.toString());
                word = new StringBuilder();
                // The prefix is added for each new word
                word.append(prefix);
            }
            for (TrieNode trieNode : current.childNodes) {
                stack.push(trieNode);
            }
        }
        return words;
    }

    private TrieNode getTrieNode(String word) {
        List<TrieNode> childNodes = root.childNodes;
        TrieNode tail = null;
        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            Optional<TrieNode> trieNode = childNodes.stream()
                    .filter(node -> node.character == character)
                    .findFirst();
            if (trieNode.isPresent()) {
                tail = trieNode.get();
                childNodes = tail.childNodes;
            } else {
                return null;
            }
        }
        return tail;
    }

}
