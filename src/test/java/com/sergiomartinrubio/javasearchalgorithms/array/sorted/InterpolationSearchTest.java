package com.sergiomartinrubio.javasearchalgorithms.array.sorted;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InterpolationSearchTest {

    @Test
    public void givenArrayThatContainsElementWhenSearchThenReturnPositionOfElement() {
        // GIVEN
        InterpolationSearch interpolationSearch = new InterpolationSearch();
        int[] elements = {16, 19, 20, 23, 45, 56, 78, 90, 96, 100};

        // WHEN
        int position = interpolationSearch.search(elements, 90);

        // THEN
        assertThat(position).isEqualTo(7);
    }

    @Test
    public void givenArrayThatDoesNotContainsElementWhenSearchThenReturnMinusOne() {
        // GIVEN
        InterpolationSearch interpolationSearch = new InterpolationSearch();
        int[] elements = {16, 19, 20, 23, 45, 56, 78, 90, 96, 100};

        // WHEN
        int position = interpolationSearch.search(elements, 24);

        // THEN
        assertThat(position).isEqualTo(-1);
    }

}