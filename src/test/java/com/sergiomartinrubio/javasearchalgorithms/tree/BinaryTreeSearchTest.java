package com.sergiomartinrubio.javasearchalgorithms.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryTreeSearchTest {

    private BinaryTreeSearch<Integer> binaryTreeSearch;

    @BeforeEach
    public void setup() {
        binaryTreeSearch = new BinaryTreeSearch<>();
        binaryTreeSearch.insert(12);
        binaryTreeSearch.insert(18);
        binaryTreeSearch.insert(5);
        binaryTreeSearch.insert(15);
        binaryTreeSearch.insert(9);
        binaryTreeSearch.insert(2);
        binaryTreeSearch.insert(19);
        binaryTreeSearch.insert(17);
    }

    @Test
    public void givenBinaryTreeThatContainsValueWhenContainsThenReturnTrue() {

        // WHEN
        boolean isFound = binaryTreeSearch.contains(15);

        // THEN
        assertThat(isFound).isTrue();
    }

    @Test
    public void givenBinaryTreeThatDoesNotContainValueWhenContainsThenReturnFalse() {

        // WHEN
        boolean isFound = binaryTreeSearch.contains(10);

        // THEN
        assertThat(isFound).isFalse();
    }

    @Test
    public void givenBinaryTreeWithValuesWhenMinimumThenReturnMinimumValue() {

        // WHEN
        int minimum = binaryTreeSearch.minimum();

        // THEN
        assertThat(minimum).isEqualTo(2);
    }

    @Test
    public void givenBinaryTreeWithValuesWhenMaximumThenReturnMaximumValue() {

        // WHEN
        int maximum = binaryTreeSearch.maximum();

        // THEN
        assertThat(maximum).isEqualTo(19);
    }

    @Test
    public void givenBinaryTreeWithValuesWhenDeleteThenValueIsDeleted() {

        boolean isValueFound = binaryTreeSearch.contains(9);
        assertThat(isValueFound).isTrue();

        // WHEN
        binaryTreeSearch.delete(9);

        // THEN
        boolean isDeletedValueFound = binaryTreeSearch.contains(9);
        assertThat(isDeletedValueFound).isFalse();
    }

}