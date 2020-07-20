package com.defenox.graphlib.common;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EdgeTest {

    @Test
    void defaultWeightTest() {
        Edge<String> edge = new Edge<>("A", "B");
        assertEquals(1.0, edge.getWeight());
    }

    @Test
    void toStringTest() {
        Edge<String> edge = new Edge<>("A", "B");
        assertEquals("(A, B : 1.0)", edge.toString());
    }

    @Test
    void equalsTest() {
        Edge<String> edgeA = new Edge<>("A", "B");
        Edge<String> edgeB = new Edge<>("A", "B");
        assertEquals(edgeA, edgeB);
        edgeA = new Edge<>("A", "B", 1.2);
        edgeB = new Edge<>("A", "B", 1.2);
        assertEquals(edgeA, edgeB);
    }
}