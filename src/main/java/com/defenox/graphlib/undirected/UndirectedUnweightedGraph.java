package com.defenox.graphlib.undirected;

import com.defenox.graphlib.graph.AbstractGraph;
import com.defenox.graphlib.common.Edge;
import com.defenox.graphlib.graph.UnweightedGraph;
import com.defenox.graphlib.search.Search;

import java.util.ArrayList;

/**
 * The class extents AbstractGraph class and implements Graph and UnweightedGraph interfaces and contains implementation of
 * Search interface. A field Search initialize by Dijkstra object by default.
 *
 * @param <T> type of vertex.
 */
public class UndirectedUnweightedGraph<T> extends AbstractGraph<T> implements UnweightedGraph<T> {

    /**
     * Constructor init search by Dijkstra.
     */
    public UndirectedUnweightedGraph() {
        super();
    }

    /**
     * Constructor with param.
     * @param search implementation of Search.
     *
     * @see Search
     */
    public UndirectedUnweightedGraph(Search<T> search) {
        super(search);
    }

    /**
     * Add undirected weighted edge and set weight of edge as 1.0.
     *
     * @param firstVertex first vertex.
     * @param secondVertex second vertex.
     */
    @Override
    public void addEdge(T firstVertex, T secondVertex) {
        lock.lock();
        adjacencyList.putIfAbsent(firstVertex, new ArrayList<>());
        adjacencyList.putIfAbsent(secondVertex, new ArrayList<>());
        adjacencyList.get(firstVertex).add(new Edge<>(firstVertex, secondVertex));
        adjacencyList.get(secondVertex).add(new Edge<>(secondVertex, firstVertex));
        lock.unlock();
    }
}
