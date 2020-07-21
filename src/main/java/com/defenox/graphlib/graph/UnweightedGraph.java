package com.defenox.graphlib.graph;

/**
 * The interface provide method addEgde for an unweighted graph.
 *
 * @param <T> type of vertex.
 */
public interface UnweightedGraph<T> extends Graph<T> {
    /**
     * Add unweighted edge and set weight of edge as 1.0.
     *
     * @param firstVertex fist vertex.
     * @param secondVertex second vertex.
     */
    void addEdge(T firstVertex, T secondVertex);
}
