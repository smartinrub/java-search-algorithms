package com.sergiomartinrubio.javasearchalgorithms.array.sorted;

public class OrderedLinearSearch {

    /**
     * Search value given an ordered array
     * @param elements sorted
     * @param value to be found
     * @return position of the value or -1 if not found
     */
    public int search(int[] elements, int value) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == value) {
                return i;
            } else if (elements[i] > value) {
                return -1;
            }
        }
        return -1;
    }
}
