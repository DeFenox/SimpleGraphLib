package com.defenox.graphlib.graph.directed;

import com.defenox.graphlib.graph.AbstractGraph;
import com.defenox.graphlib.common.Edge;
import com.defenox.graphlib.graph.WeightedGraph;
import com.defenox.graphlib.search.Search;

import java.util.ArrayList;

/**
 * The class extents AbstractGraph class and implements Graph and WeightedGraph interfaces and contains implementation of
 * Search interface. A field Search initialize by Dijkstra object by default.
 *
 * @param <T> type of vertex.
 */
public class DirectedWeightedGraph<T> extends AbstractGraph<T> implements WeightedGraph<T> {

    /**
     * Constructor init search by Dijkstra.
     */
    public DirectedWeightedGraph() {
        super();
    }

    /**
     * Constructor with param.
     * @param search implementation of Search.
     *
     * @see Search
     */
    public DirectedWeightedGraph(Search<T> search) {
        super(search);
    }

    /**
     * Add directed weighted edge.
     *
     * @param firstVertex first vertex.
     * @param secondVertex second vertex.
     * @param weight Double a weight of edge.
     */
    @Override
    public void addEdge(T firstVertex, T secondVertex, Double weight) {
        lock.lock();
        adjacencyList.putIfAbsent(firstVertex, new ArrayList<>());
        adjacencyList.putIfAbsent(secondVertex, new ArrayList<>());
        adjacencyList.get(firstVertex).add(new Edge<>(firstVertex, secondVertex, weight));
        lock.unlock();
    }
}
