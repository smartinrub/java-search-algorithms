package com.sergiomartinrubio.javasearchalgorithms.trees;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TrieTest {

    @Test
    public void givenWordsWhenSearchReturnTrueIfFoundAndFalseIfNotFound() {
        Trie trie = new Trie();
        trie.add("engineering");
        trie.add("school");
        trie.add("hotel");
        trie.add("traditional");

        assertThat(trie.search("school")).isTrue();
        assertThat(trie.search("house")).isFalse();
        assertThat(trie.search("hot")).isFalse();
    }

    @Test
    public void test() {
        Trie trie = new Trie();
        trie.add("engineering");
        trie.add("school");
        trie.add("hotel");
        trie.add("house");
        trie.add("traditional");

        trie.lookup("ho");


    }
}