package com.sergiomartinrubio.javasearchalgorithms.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DepthFirstSearchTest {

    private DepthFirstSearch depthFirstSearch;

    @BeforeEach
    public void setup() {
        depthFirstSearch = new DepthFirstSearch();
        depthFirstSearch.add(12);
        depthFirstSearch.add(18);
        depthFirstSearch.add(5);
        depthFirstSearch.add(15);
        depthFirstSearch.add(9);
        depthFirstSearch.add(2);
        depthFirstSearch.add(19);
        depthFirstSearch.add(17);
    }

    @Test
    public void givenValueInBinaryTreeWhenSearchThenReturnTrue() {
        // WHEN
        boolean isFound = depthFirstSearch.PreOrderSearch(15);

        // THEN
        assertThat(isFound).isTrue();
    }

    @Test
    public void givenValueNotInBinaryTreeWhenSearchThenReturnFalse() {
        // WHEN
        boolean isFound = depthFirstSearch.PreOrderSearch(14);

        // THEN
        assertThat(isFound).isFalse();
    }

}