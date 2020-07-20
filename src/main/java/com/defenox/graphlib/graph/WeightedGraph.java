package com.defenox.graphlib.graph;

/**
 *
 * @param <T>
 */
public interface WeightedGraph<T> extends Graph<T> {
    /**
     *
     * @param firstVertex
     * @param secondVertex
     * @param weight
     */
    void addEdge(T firstVertex, T secondVertex, Double weight);
}
