package com.defenox.graphlib.directed;

import com.defenox.graphlib.graph.AbstractGraph;
import com.defenox.graphlib.common.Edge;
import com.defenox.graphlib.graph.UnweightedGraph;
import com.defenox.graphlib.search.Search;

import java.util.ArrayList;

/**
 *
 * @param <T>
 */
public class DirectedUnweightedGraph<T> extends AbstractGraph<T> implements UnweightedGraph<T> {

    /**
     *
     */
    public DirectedUnweightedGraph() {
        super();
    }

    /**
     *
     * @param search
     */
    public DirectedUnweightedGraph(Search<T> search) {
        super(search);
    }

    /**
     *
     * @param firstVertex
     * @param secondVertex
     */
    @Override
    public void addEdge(T firstVertex, T secondVertex) {
        lock.lock();
        adjacencyList.putIfAbsent(firstVertex, new ArrayList<>());
        adjacencyList.putIfAbsent(secondVertex, new ArrayList<>());
        adjacencyList.get(firstVertex).add(new Edge<>(firstVertex, secondVertex));
        lock.unlock();
    }
}
