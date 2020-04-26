package com.sergiomartinrubio.javasearchalgorithms.array.unordered;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UnorderedLinearSearchTest {

    @Test
    public void givenArrayThatContainsElementWhenSearchThenReturnIndexPositionOfElement() {
        // GIVEN
        UnorderedLinearSearch linearSearch = new UnorderedLinearSearch();
        int[] elements = {16, 19, 20, 23, 45, 56, 78, 90, 96, 100};

        // WHEN
        int position = linearSearch.search(elements, 90);

        // THEN
        assertThat(position).isEqualTo(7);
    }

    @Test
    public void givenArrayThatDoesNotContainElementWhenSearchThenReturnMinusOne() {
        // GIVEN
        UnorderedLinearSearch linearSearch = new UnorderedLinearSearch();
        int[] elements = {16, 19, 20, 23, 45, 56, 78, 90, 96, 100};

        // WHEN
        int position = linearSearch.search(elements, 24);

        // THEN
        assertThat(position).isEqualTo(-1);
    }

}