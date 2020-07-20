package com.defenox.graphlib.graph;

/**
 *
 * @param <T>
 */
public interface UnweightedGraph<T> extends Graph<T> {
    /**
     *
     * @param firstVertex
     * @param secondVertex
     */
    void addEdge(T firstVertex, T secondVertex);
}
