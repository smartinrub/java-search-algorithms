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

    public boolean search(String word) {
        TrieNode tail = getTrieNode(word);
        return tail != null && tail.isLeaf;
    }

    public List<String> lookup(String prefix) {
        TrieNode tail = getTrieNode(prefix);
        if (tail == null) {
            return List.of();
        }
        Stack<TrieNode> stack = new Stack<>();
        stack.push(tail);
        TrieNode current;
        StringBuilder word = new StringBuilder();
        word.append(prefix, 0, prefix.length() - 1);
        List<String> words = new ArrayList<>();
        while (!stack.empty()) {
            current = stack.pop();
            word.append(current.character);
            if (current.isLeaf) {
                words.add(word.toString());
                word = new StringBuilder();
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
