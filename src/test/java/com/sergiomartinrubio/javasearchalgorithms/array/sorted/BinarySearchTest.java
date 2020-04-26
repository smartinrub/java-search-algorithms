package com.sergiomartinrubio.javasearchalgorithms.array.sorted;

import com.sergiomartinrubio.javasearchalgorithms.array.sorted.BinarySearch;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BinarySearchTest {

    private static final int[] ELEMENTS = {16, 19, 20, 23, 45, 56, 78, 90, 96, 100};

    private BinarySearch binarySearch;

    @BeforeEach
    public void setup() {
        binarySearch = new BinarySearch();
    }

    @AfterEach
    public void tearDown() {
        binarySearch = null;
    }

    @Test
    public void givenArrayThatContainsElementWhenIterativeSearchThenReturnPositionOfElement() {
        // WHEN
        int position = binarySearch.iterativeSearch(ELEMENTS, 90);

        // THEN
        assertThat(position).isEqualTo(7);
    }

    @Test
    public void givenArrayThatDoesNotContainsElementWhenIterativeSearchThenReturnMinusOne() {
        // WHEN
        int position = binarySearch.iterativeSearch(ELEMENTS, 24);

        // THEN
        assertThat(position).isEqualTo(-1);
    }

    @Test
    public void givenArrayThatContainsElementWhenRecursiveSearchThenReturnPositionOfElement() {
        // WHEN
        int position = binarySearch.recursiveSearch(ELEMENTS, 90);

        // THEN
        assertThat(position).isEqualTo(7);
    }

    @Test
    public void givenArrayThatDoesNotContainsElementWhenRecursiveSearchThenReturnMinusOne() {
        // WHEN
        int position = binarySearch.recursiveSearch(ELEMENTS, 24);

        // THEN
        assertThat(position).isEqualTo(-1);
    }
}