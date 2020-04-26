package com.sergiomartinrubio.javasearchalgorithms.array.unordered;

public class UnorderedLinearSearch {

    /**
     * Search value given an unordered array
     * @param elements unordered
     * @param value to be found
     * @return position of the value or -1 if not found
     */
    public int search(int[] elements, int value) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
