package com.sergiomartinrubio.javasearchalgorithms.trees;

import org.junit.jupiter.api.Test;

class TrieTest {

    @Test
    public void test() {
        Trie trie = new Trie();

        trie.addEntry("co");
        trie.addEntry("eng");
        trie.addEntry("ro");
        trie.addEntry("trad");
        trie.addEntry("ch");
        trie.addEntry("ru");

        System.out.println("Lookup (engineering): " + trie.lookup("engineering")); //should return true
        System.out.println("Lookup (en): " + trie.lookup("en")); //should return false
        System.out.println("Lookup (school): " + trie.lookup("school")); //should return false
        System.out.println("Lookup (traditional): " + trie.lookup("traditional")); //should return true
        System.out.println("Lookup (fetch): " + trie.lookup("fetch")); //should return false
    }

}