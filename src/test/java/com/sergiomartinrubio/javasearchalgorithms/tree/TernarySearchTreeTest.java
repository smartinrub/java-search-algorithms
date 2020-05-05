package com.sergiomartinrubio.javasearchalgorithms.tree;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TernarySearchTreeTest {

    @Test
    public void givenWordsWhenSearchThenReturnTreeIfFound() {
        // GIVEN
        TernarySearchTree ternarySearchTree = new TernarySearchTree();
        ternarySearchTree.add("engineering");
        ternarySearchTree.add("school");
        ternarySearchTree.add("hotel");
        ternarySearchTree.add("house");
        ternarySearchTree.add("traditional");

        // WHEN
        boolean isFoundFirst = ternarySearchTree.search("school");
        boolean isFoundSecond = ternarySearchTree.search("house");
        boolean isFoundThird = ternarySearchTree.search("engineering");

        // THEN
        assertThat(isFoundFirst).isTrue();
        assertThat(isFoundSecond).isTrue();
        assertThat(isFoundThird).isTrue();
    }

    @Test
    public void givenWordsWhenSearchThenReturnFalseIfNotFound() {
        // GIVEN
        TernarySearchTree ternarySearchTree = new TernarySearchTree();
        ternarySearchTree.add("engineering");
        ternarySearchTree.add("school");
        ternarySearchTree.add("hotel");
        ternarySearchTree.add("house");
        ternarySearchTree.add("traditional");

        // WHEN
        boolean isFoundFirst = ternarySearchTree.search("hot");
        boolean isFoundSecond = ternarySearchTree.search("boat");
        boolean isFoundThird = ternarySearchTree.search("houses");

        // THEN
        assertThat(isFoundFirst).isFalse();
        assertThat(isFoundSecond).isFalse();
        assertThat(isFoundThird).isFalse();
    }

}