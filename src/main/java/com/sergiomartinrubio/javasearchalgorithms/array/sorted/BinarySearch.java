package com.sergiomartinrubio.javasearchalgorithms.array.sorted;

public class BinarySearch {

    /**
     * Search value with iteration given an ordered array
     *
     * @param elements sorted
     * @param value    to be found
     * @return position of the value or -1 if not found
     */
    public int iterativeSearch(int[] elements, int value) {
        int lowerBound = 0;
        int upperBound = elements.length - 1;
        int midPoint;

        while (lowerBound <= upperBound) {
            midPoint = lowerBound + (upperBound - lowerBound) / 2;

            if (value == elements[midPoint]) {
                return midPoint;
            } else if (value < elements[midPoint]) {
                upperBound = midPoint - 1;
            } else {
                lowerBound = midPoint + 1;
            }
        }
        return -1;
    }

    /**
     * Search value with recursion given an ordered array
     * @param elements sorted
     * @param value to be found
     * @return position of the value or -1 if not found
     */
    public int recursiveSearch(int[] elements, int value) {
        return searchRecursively(elements, value, 0, elements.length - 1);
    }

    private int searchRecursively(int[] elements, int value, int lowerBound, int upperBound) {
        int midPoint = lowerBound + (upperBound - lowerBound) / 2;

        if (lowerBound > upperBound) {
            return -1;
        }

        if (elements[midPoint] == value) {
            return midPoint;
        } else if (value < elements[midPoint]) {
            return searchRecursively(elements, value, lowerBound, midPoint - 1);
        } else {
            return searchRecursively(elements, value, midPoint + 1, upperBound);
        }
    }
}
