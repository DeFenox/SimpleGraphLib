package com.defenox.graphlib.search;

import com.defenox.graphlib.common.Edge;
import com.defenox.graphlib.graph.directed.DirectedUnweightedGraph;
import com.defenox.graphlib.graph.directed.DirectedWeightedGraph;
import com.defenox.graphlib.graph.undirected.UndirectedUnweightedGraph;
import com.defenox.graphlib.graph.undirected.UndirectedWeightedGraph;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DijkstraTest {

    @Test
    void directedUnweightedGraphTest() {
        DirectedUnweightedGraph<String> graph = new DirectedUnweightedGraph<>(new Dijkstra<>());
        graph.addEdge("Homer", "Bart");
        graph.addEdge("Bart", "Lisa");
        graph.addEdge("Marge", "Bart");
        graph.addEdge("Lisa", "Maggie");
        graph.addEdge("Maggie", "Marge");
        graph.addEdge("Marge", "Homer");

        List<Edge<String>> expectedGraph = new LinkedList<>();
        expectedGraph.add(new Edge<>("Homer", "Bart"));
        expectedGraph.add(new Edge<>("Bart", "Lisa"));
        expectedGraph.add(new Edge<>("Lisa", "Maggie"));
        expectedGraph.add(new Edge<>("Maggie", "Marge"));

        assertEquals(expectedGraph, graph.getPath("Homer", "Marge"));
    }

    @Test
    void directedWeightedGraphTest() {
        DirectedWeightedGraph<String> graph = new DirectedWeightedGraph<>(new Dijkstra<>());
        graph.addEdge("Homer", "Bart", 5.0);
        graph.addEdge("Marge", "Bart", 6.0);
        graph.addEdge("Bart", "Lisa", 2.0);
        graph.addEdge("Lisa", "Maggie", 2.0);
        graph.addEdge("Maggie", "Marge", 80.0);
        graph.addEdge("Marge", "Homer", 40.0);

        List<Edge<String>> expectedGraph = new LinkedList<>();
        expectedGraph.add(new Edge<>("Homer", "Bart", 5.0));
        expectedGraph.add(new Edge<>("Bart", "Lisa", 2.0));
        expectedGraph.add(new Edge<>("Lisa", "Maggie", 2.0));
        expectedGraph.add(new Edge<>("Maggie", "Marge", 80.0));

        assertEquals(expectedGraph, graph.getPath("Homer", "Marge"));
    }

    @Test
    void undirectedUnweightedGraphTest() {
        UndirectedUnweightedGraph<String> graph = new UndirectedUnweightedGraph<>(new Dijkstra<>());
        graph.addEdge("Homer", "Bart");
        graph.addEdge("Bart", "Lisa");
        graph.addEdge("Bart", "Marge");
        graph.addEdge("Lisa", "Maggie");
        graph.addEdge("Maggie", "Marge");
        graph.addEdge("Homer", "Marge");

        List<Edge<String>> expectedGraph = new LinkedList<>();
        expectedGraph.add(new Edge<>("Homer", "Marge"));

        assertEquals(expectedGraph, graph.getPath("Homer", "Marge"));
    }

    @Test
    void undirectedWeightedGraphTest() {
        UndirectedWeightedGraph<String> graph = new UndirectedWeightedGraph<>(new Dijkstra<>());
        graph.addEdge("Homer", "Bart", 5.0);
        graph.addEdge("Bart", "Marge", 6.0);
        graph.addEdge("Bart", "Lisa", 2.0);
        graph.addEdge("Lisa", "Maggie", 2.0);
        graph.addEdge("Maggie", "Marge", 8.0);
        graph.addEdge("Homer", "Marge", 40.0);

        List<Edge<String>> expectedGraph = new LinkedList<>();
        expectedGraph.add(new Edge<>("Homer", "Bart", 5.0));
        expectedGraph.add(new Edge<>("Bart", "Marge", 6.0));

        assertEquals(expectedGraph, graph.getPath("Homer", "Marge"));
    }

    @Test
    void pathNotExistTest() {
        UndirectedUnweightedGraph<String> graph = new UndirectedUnweightedGraph<>();
        graph.addEdge("Homer", "Bart");
        graph.addEdge("Bart", "Lisa");
        graph.addEdge("Lisa", "Maggie");
        graph.addEdge("Maggie", "Marge");
        graph.addEdge("Homer", "Marge");

        graph.addEdge("Moe", "Lenny");
        graph.addEdge("Moe", "Carl");
        graph.addEdge("Moe", "Ned");

        assertTrue(graph.getPath("Homer", "Moe").isEmpty());
    }

    @Test
    void pathNotNotReachableTest() {
        DirectedUnweightedGraph<String> graph = new DirectedUnweightedGraph<>();
        graph.addEdge("Homer", "Bart");
        graph.addEdge("Bart", "Lisa");

        assertTrue(graph.getPath("Lisa", "Homer").isEmpty());
    }

    @Test
    void wrongVertexTest() {
        UndirectedUnweightedGraph<String> graph = new UndirectedUnweightedGraph<>();
        graph.addEdge("Homer", "Bart");
        graph.addEdge("Bart", "Lisa");
        graph.addEdge("Lisa", "Maggie");
        graph.addEdge("Maggie", "Marge");
        graph.addEdge("Homer", "Marge");

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> graph.getPath("Mr. Burns", "Maggie")
        );

        assertTrue(exception.getMessage().contains("The graph doesn't have vertex"));
    }

    @Test
    void negativeWeightTest() {
        UndirectedWeightedGraph<String> graph = new UndirectedWeightedGraph<>(new Dijkstra<>());
        graph.addEdge("Homer", "Bart", 5.0);
        graph.addEdge("Bart", "Lisa", -2.0);
        graph.addEdge("Lisa", "Maggie", 2.0);
        graph.addEdge("Maggie", "Marge", 8.0);
        graph.addEdge("Homer", "Marge", -80.0);

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> graph.getPath("Homer", "Marge")
        );

        assertTrue(exception.getMessage().contains("Dijkstra's algorithm couldn't work with negative weight"));
    }
}