package com.sergiomartinrubio.javasearchalgorithms.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BreadthFirstSearchTest {

    private BreadthFirstSearch breadthFirstSearch;

    @BeforeEach
    public void setup() {
        breadthFirstSearch = new BreadthFirstSearch();
        breadthFirstSearch.add(12);
        breadthFirstSearch.add(18);
        breadthFirstSearch.add(5);
        breadthFirstSearch.add(15);
        breadthFirstSearch.add(9);
        breadthFirstSearch.add(2);
        breadthFirstSearch.add(19);
        breadthFirstSearch.add(17);
    }

    @Test
    public void givenValueInBinaryTreeWhenSearchThenReturnTrue() {
        // WHEN
        boolean isFound = breadthFirstSearch.search(15);

        // THEN
        assertThat(isFound).isTrue();
    }

    @Test
    public void givenValueNotInBinaryTreeWhenSearchThenReturnFalse() {
        // WHEN
        boolean isFound = breadthFirstSearch.search(11);

        // THEN
        assertThat(isFound).isFalse();
    }

}