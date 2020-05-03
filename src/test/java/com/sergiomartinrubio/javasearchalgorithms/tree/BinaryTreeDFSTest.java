package com.sergiomartinrubio.javasearchalgorithms.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryTreeDFSTest {

    private BinaryTreeDFS binaryTreeDFS;

    @BeforeEach
    public void setup() {
        binaryTreeDFS = new BinaryTreeDFS();
        binaryTreeDFS.add(12);
        binaryTreeDFS.add(18);
        binaryTreeDFS.add(5);
        binaryTreeDFS.add(15);
        binaryTreeDFS.add(9);
        binaryTreeDFS.add(2);
        binaryTreeDFS.add(19);
        binaryTreeDFS.add(17);
    }

    @Test
    public void givenValueInBinaryTreeWhenSearchThenReturnTrue() {
        // WHEN
        boolean isFound = binaryTreeDFS.PreOrderSearch(12);

        // THEN
        assertThat(isFound).isTrue();
    }

    @Test
    public void givenValueNotInBinaryTreeWhenSearchThenReturnFalse() {
        // WHEN
        boolean isFound = binaryTreeDFS.PreOrderSearch(14);

        // THEN
        assertThat(isFound).isFalse();
    }

}