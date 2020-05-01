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
        return tail != null && tail.isLeaf;
    }

    public List<String> lookup(String prefix) {

        Map<Character, TrieNode> childNodes = root.childNodes;
        TrieNode tail = null;
        for (int i = 0; i < prefix.length(); i++) {
            char character = prefix.charAt(i);
            if (childNodes.containsKey(character)) {
                tail = childNodes.get(character);
                childNodes = tail.childNodes;
            } else {
                return List.of();
            }
        }
        Stack<TrieNode> stack = new Stack<>();
        stack.push(tail);
        TrieNode current = tail;
        while (!stack.empty()) {
            current = stack.pop();
            System.out.println(current.character);

            for (TrieNode trieNode : current.childNodes.values()) {
                stack.push(trieNode);
            }
        }

        List<String> words = new ArrayList<>();

        return words;
    }

}
