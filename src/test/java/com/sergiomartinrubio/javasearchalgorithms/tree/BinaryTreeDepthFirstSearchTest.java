package com.sergiomartinrubio.javasearchalgorithms.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryTreeDepthFirstSearchTest {

    private BinaryTreeDepthFirstSearch binaryTreeDepthFirstSearch;

    @BeforeEach
    public void setup() {
        binaryTreeDepthFirstSearch = new BinaryTreeDepthFirstSearch();
        binaryTreeDepthFirstSearch.add(12);
        binaryTreeDepthFirstSearch.add(18);
        binaryTreeDepthFirstSearch.add(5);
        binaryTreeDepthFirstSearch.add(15);
        binaryTreeDepthFirstSearch.add(9);
        binaryTreeDepthFirstSearch.add(2);
        binaryTreeDepthFirstSearch.add(19);
        binaryTreeDepthFirstSearch.add(17);
    }

    @Test
    public void givenValueInBinaryTreeWhenSearchThenReturnTrue() {
        // WHEN
        boolean isFound = binaryTreeDepthFirstSearch.PreOrderSearch(15);

        // THEN
        assertThat(isFound).isTrue();
    }

    @Test
    public void givenValueNotInBinaryTreeWhenSearchThenReturnFalse() {
        // WHEN
        boolean isFound = binaryTreeDepthFirstSearch.PreOrderSearch(14);

        // THEN
        assertThat(isFound).isFalse();
    }

}