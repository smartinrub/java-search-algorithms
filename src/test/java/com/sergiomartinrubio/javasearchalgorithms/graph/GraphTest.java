package com.sergiomartinrubio.javasearchalgorithms.graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GraphTest {

    private Graph graph;

    @BeforeEach
    public void setup() {
        graph = new Graph();
        Node twentyFive = new Node(25);
        Node three = new Node(3);
        Node five = new Node(5);
        Node two = new Node(2);
        Node eight = new Node(8);
        Node one = new Node(1);
        Node twelve = new Node(12);
        Node six = new Node(6);
        Node four = new Node(4);
        Node nine = new Node(9);

        graph.addEdge(three, five);
        graph.addEdge(three, eight);
        graph.addEdge(three, twentyFive);
        graph.addEdge(five, one);
        graph.addEdge(five, two);
        graph.addEdge(twentyFive, twelve);
        graph.addEdge(twentyFive, eight);
        graph.addEdge(twelve, six);
        graph.addEdge(six, four);
        graph.addEdge(six, nine);
    }

    @Test
    public void givenGraphWithNodesWhenDepthFirstSearchThenReturnTrueIfNodeIsFound() {
        // GIVEN
        Node eight = new Node(8);

        // WHEN
        boolean isFound = graph.depthFirstSearch(eight);

        // THEN
        assertThat(isFound).isTrue();
    }

    @Test
    public void givenGraphWithNodesWhenDepthFirstSearchThenReturnFalseIfNodeIsNotFound() {
        // GIVEN
        Node fourteen = new Node(14);

        // WHEN
        boolean isFound = graph.depthFirstSearch(fourteen);

        // THEN
        assertThat(isFound).isFalse();
    }

    @Test
    public void givenGraphWithNodesWhenBreadthFirstSearchThenReturnTrueIfNodeIsFound() {
        // GIVEN
        Node six = new Node(6);

        // WHEN
        boolean isFound = graph.breadthFirstSearch(six);

        // THEN
        assertThat(isFound).isTrue();
    }

    @Test
    public void givenGraphWithNodesWhenBreadthFirstSearchThenReturnFalseIfNodeIsNotFound() {
        // GIVEN
        Node fourteen = new Node(14);

        // WHEN
        boolean isFound = graph.breadthFirstSearch(fourteen);

        // THEN
        assertThat(isFound).isFalse();
    }

}