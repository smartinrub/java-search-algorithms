package com.sergiomartinrubio.javasearchalgorithms.graph;

import org.junit.jupiter.api.Test;

class GraphDepthFirstSearchTest {

    @Test
    public void givenEdgesWhenTraversePrintAllEdges() {
        // GIVEN
        GraphDepthFirstSearch depthFirstSearch = new GraphDepthFirstSearch();
        depthFirstSearch.add(0, 1);
        depthFirstSearch.add(0, 2);
        depthFirstSearch.add(1, 2);
        depthFirstSearch.add(2, 0);
        depthFirstSearch.add(2, 3);
        depthFirstSearch.add(3, 3);
        depthFirstSearch.add(3, 4);

        // WHEN
        depthFirstSearch.traverse();
    }

}