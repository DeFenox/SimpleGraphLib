package com.defenox.graphlib.undirected;

import com.defenox.graphlib.graph.AbstractGraph;
import com.defenox.graphlib.common.Edge;
import com.defenox.graphlib.graph.WeightedGraph;
import com.defenox.graphlib.search.Search;

import java.util.ArrayList;

/**
 *
 * @param <T>
 */
public class UndirectedWeightedGraph<T> extends AbstractGraph<T> implements WeightedGraph<T> {

    /**
     *
     */
    public UndirectedWeightedGraph() {
        super();
    }

    /**
     *
     * @param search
     */
    public UndirectedWeightedGraph(Search<T> search) {
        super(search);
    }

    /**
     *
     * @param firstVertex
     * @param secondVertex
     * @param weight
     */
    @Override
    public void addEdge(T firstVertex, T secondVertex, Double weight) {
        lock.lock();
        adjacencyList.putIfAbsent(firstVertex, new ArrayList<>());
        adjacencyList.putIfAbsent(secondVertex, new ArrayList<>());
        adjacencyList.get(firstVertex).add(new Edge<>(firstVertex, secondVertex, weight));
        adjacencyList.get(secondVertex).add(new Edge<>(secondVertex, firstVertex, weight));
        lock.unlock();
    }
}
