package com.sergiomartinrubio.javasearchalgorithms.array.sorted;

public class InterpolationSearch {

    /**
     * Search value given an ordered array
     *
     * @param elements sorted
     * @param value    to be found
     * @return position of the value or -1 if not found
     */
    public int search(int[] elements, int value) {
        int lowerBound = 0;
        int upperBound = elements.length - 1;

        while (lowerBound < upperBound
                && elements[lowerBound] <= value
                && elements[upperBound] >= value) {
            int constant = (value - elements[lowerBound]) /
                    (elements[upperBound] - elements[lowerBound]);
            int midPoint = lowerBound + (upperBound - lowerBound) * constant;

            if (elements[midPoint] == value) {
                return midPoint;
            } else if (elements[midPoint] < value) {
                lowerBound = midPoint + 1;
            } else {
                upperBound = midPoint - 1;
            }
        }

        return -1;
    }
}
