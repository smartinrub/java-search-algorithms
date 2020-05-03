package com.sergiomartinrubio.javasearchalgorithms.tree;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TrieTest {

    @Test
    public void givenWordsWhenSearchReturnTrueIfIsFoundAndFalseIfIsNotFound() {
        // GIVEN
        Trie trie = new Trie();
        trie.add("engineering");
        trie.add("school");
        trie.add("hotel");
        trie.add("traditional");

        // WHEN
        boolean isFirstWordFound = trie.search("school");
        boolean isSecondWordFound = trie.search("house");
        boolean isThirdWordFound = trie.search("hot");

        // THEN
        assertThat(isFirstWordFound).isTrue();
        assertThat(isSecondWordFound).isFalse();
        assertThat(isThirdWordFound).isFalse();
    }

    @Test
    public void givenWordsAndPrefixWhenLookupThenReturnWordsMatchingPrefix() {
        // GIVEN
        Trie trie = new Trie();
        trie.add("engineering");
        trie.add("school");
        trie.add("hotel");
        trie.add("house");
        trie.add("traditional");

        // WHEN
        List<String> words = trie.lookup("ho");

        // THEN
        assertThat(words.size()).isEqualTo(2);
        assertThat(words).contains("hotel", "house");
    }

    @Test
    public void givenWordAndNotFoundPrefixWhenLookupThenReturnEmptyList() {
        // GIVEN
        Trie trie = new Trie();
        trie.add("engineering");
        trie.add("school");
        trie.add("hotel");
        trie.add("house");
        trie.add("traditional");

        // WHEN
        List<String> words = trie.lookup("pe");

        // THEN
        assertThat(words).isEmpty();
    }
}