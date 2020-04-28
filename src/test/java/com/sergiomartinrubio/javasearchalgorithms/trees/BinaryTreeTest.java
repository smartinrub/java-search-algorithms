package com.sergiomartinrubio.javasearchalgorithms.trees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryTreeTest {

    private BinaryTree<Integer> binaryTree;

    @BeforeEach
    public void setup() {
        binaryTree = new BinaryTree<>();
        binaryTree.insert(12);
        binaryTree.insert(18);
        binaryTree.insert(5);
        binaryTree.insert(15);
        binaryTree.insert(9);
        binaryTree.insert(2);
        binaryTree.insert(19);
        binaryTree.insert(17);
    }

    @Test
    public void givenBinaryTreeThatContainsValueWhenContainsThenReturnTrue() {

        // WHEN
        boolean isFound = binaryTree.contains(15);

        // THEN
        assertThat(isFound).isTrue();
    }

    @Test
    public void givenBinaryTreeThatDoesNotContainValueWhenContainsThenReturnFalse() {

        // WHEN
        boolean isFound = binaryTree.contains(10);

        // THEN
        assertThat(isFound).isFalse();
    }

    @Test
    public void givenBinaryTreeWithValuesWhenMinimumThenReturnMinimumValue() {

        // WHEN
        int minimum = binaryTree.minimum();

        // THEN
        assertThat(minimum).isEqualTo(2);
    }

    @Test
    public void givenBinaryTreeWithValuesWhenMaximumThenReturnMaximumValue() {

        // WHEN
        int maximum = binaryTree.maximum();

        // THEN
        assertThat(maximum).isEqualTo(19);
    }

    @Test
    public void givenBinaryTreeWithValuesWhenDeleteThenValueIsDeleted() {

        boolean isValueFound = binaryTree.contains(9);
        assertThat(isValueFound).isTrue();

        // WHEN
        binaryTree.delete(9);

        // THEN
        boolean isDeletedValueFound = binaryTree.contains(9);
        assertThat(isDeletedValueFound).isFalse();
    }

}