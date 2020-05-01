package com.sergiomartinrubio.javasearchalgorithms.trees;

import java.util.*;

public class Trie {

    private TrieNode root;

    private static class TrieNode {
        char character;
        Map<Character, TrieNode> childNodes;
        boolean isLeaf;
    }

    public void add(String word) {
        if (root == null) {
            root = new TrieNode();
            root.childNodes = new HashMap<>();
        }
        Map<Character, TrieNode> childNodes = root.childNodes;

        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            TrieNode tail;
            if (childNodes.containsKey(currentChar)) {
                tail = childNodes.get(currentChar);
            } else {
                tail = new TrieNode();
                tail.character = currentChar;
                tail.childNodes = new HashMap<>();
                childNodes.put(currentChar, tail);
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
            for (TrieNode trieNode : current.childNodes.values()) {
                stack.push(trieNode);
            }
        }
        return words;
    }

    private TrieNode getTrieNode(String word) {
        Map<Character, TrieNode> childNodes = root.childNodes;
        TrieNode tail = null;
        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            if (childNodes.containsKey(character)) {
                tail = childNodes.get(character);
                childNodes = tail.childNodes;
            } else {
                tail = null;
            }
        }
        return tail;
    }

}
