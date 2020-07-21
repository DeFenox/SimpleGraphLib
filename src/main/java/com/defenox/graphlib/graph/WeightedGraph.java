package com.defenox.graphlib.graph;

/**
 * The interface provide method addEgde for a weighted graph.
 *
 * @param <T> type of vertex.
 */
public interface WeightedGraph<T> extends Graph<T> {

    /**
     * Add weighted edge.
     *
     * @param firstVertex first vertex.
     * @param secondVertex second vertex.
     * @param weight Double a weight of edge.
     */
    void addEdge(T firstVertex, T secondVertex, Double weight);
}
