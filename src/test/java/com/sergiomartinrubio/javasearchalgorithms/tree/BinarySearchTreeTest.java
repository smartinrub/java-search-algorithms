package com.sergiomartinrubio.javasearchalgorithms.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BinarySearchTreeTest {

    private BinarySearchTree<Integer> binarySearchTree;

    @BeforeEach
    public void setup() {
        binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.insert(12);
        binarySearchTree.insert(18);
        binarySearchTree.insert(5);
        binarySearchTree.insert(15);
        binarySearchTree.insert(9);
        binarySearchTree.insert(2);
        binarySearchTree.insert(19);
        binarySearchTree.insert(17);
    }

    @Test
    public void givenBinaryTreeThatContainsValueWhenContainsThenReturnTrue() {

        // WHEN
        boolean isFound = binarySearchTree.contains(15);

        // THEN
        assertThat(isFound).isTrue();
    }

    @Test
    public void givenBinaryTreeThatDoesNotContainValueWhenContainsThenReturnFalse() {

        // WHEN
        boolean isFound = binarySearchTree.contains(10);

        // THEN
        assertThat(isFound).isFalse();
    }

    @Test
    public void givenBinaryTreeWithValuesWhenMinimumThenReturnMinimumValue() {

        // WHEN
        int minimum = binarySearchTree.minimum();

        // THEN
        assertThat(minimum).isEqualTo(2);
    }

    @Test
    public void givenBinaryTreeWithValuesWhenMaximumThenReturnMaximumValue() {

        // WHEN
        int maximum = binarySearchTree.maximum();

        // THEN
        assertThat(maximum).isEqualTo(19);
    }

    @Test
    public void givenBinaryTreeWithValuesWhenDeleteThenValueIsDeleted() {

        boolean isValueFound = binarySearchTree.contains(9);
        assertThat(isValueFound).isTrue();

        // WHEN
        binarySearchTree.delete(9);

        // THEN
        boolean isDeletedValueFound = binarySearchTree.contains(9);
        assertThat(isDeletedValueFound).isFalse();
    }

}