package com.sergiomartinrubio.javasearchalgorithms.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryTreeBreadthFirstSearchTest {

    private BinaryTreeBreadthFirstSearch binaryTreeBreadthFirstSearch;

    @BeforeEach
    public void setup() {
        binaryTreeBreadthFirstSearch = new BinaryTreeBreadthFirstSearch();
        binaryTreeBreadthFirstSearch.add(12);
        binaryTreeBreadthFirstSearch.add(18);
        binaryTreeBreadthFirstSearch.add(5);
        binaryTreeBreadthFirstSearch.add(15);
        binaryTreeBreadthFirstSearch.add(9);
        binaryTreeBreadthFirstSearch.add(2);
        binaryTreeBreadthFirstSearch.add(19);
        binaryTreeBreadthFirstSearch.add(17);
    }

    @Test
    public void givenValueInBinaryTreeWhenSearchThenReturnTrue() {
        // WHEN
        boolean isFound = binaryTreeBreadthFirstSearch.search(15);

        // THEN
        assertThat(isFound).isTrue();
    }

    @Test
    public void givenValueNotInBinaryTreeWhenSearchThenReturnFalse() {
        // WHEN
        boolean isFound = binaryTreeBreadthFirstSearch.search(11);

        // THEN
        assertThat(isFound).isFalse();
    }

}