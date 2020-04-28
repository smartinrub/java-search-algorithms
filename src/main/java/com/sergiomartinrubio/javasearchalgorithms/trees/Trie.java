package com.sergiomartinrubio.javasearchalgorithms.trees;

import java.util.ArrayList;
import java.util.List;

public class Trie {

    private TrieNode head;

    private static class TrieNode {
        Character character;
        List<TrieNode> childNodes;
    }

    public void addEntry(String word) {
        if (head == null) {
            head = new TrieNode();
            head.childNodes = new ArrayList<>();
        }

        TrieNode tail = head;

        for (int i = 0; i < word.length(); i++) {
            boolean found = false;

            for (TrieNode trieNode : tail.childNodes) {
                if (trieNode.character.equals(word.charAt(i))) {
                    tail = trieNode;
                    found = true;
                    break;
                }
            }

            if (!found) {
                TrieNode newTrieNode = new TrieNode();
                newTrieNode.childNodes = new ArrayList<>();
                newTrieNode.character = word.charAt(i);
                tail.childNodes.add(newTrieNode);
                tail = newTrieNode;
            }
        }
    }

    public boolean lookup(String string) {
        TrieNode tail = head;

        for (int i = 0; i < string.length(); i++) {
            if (tail.childNodes.size() == 0) {
                return true;
            }

            boolean found = false;

            for (TrieNode trieNode : tail.childNodes) {
                if (trieNode.character.equals(string.charAt(i))) {
                    found = true;
                    tail = trieNode;
                    break;
                }
            }

            if (!found) {
                return false;
            }
        }
        return false;
    }
}
