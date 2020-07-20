package com.defenox.graphlib.graph;

import com.defenox.graphlib.common.Edge;

import java.util.List;

/**
 *
 * @param <T>
 */
public interface Graph<T> {
    /**
     *
     * @param vertex
     */
    void addVertex(T vertex);

    /**
     *
     * @param firstVertex
     * @param lastVertex
     * @return
     */
    List<Edge<T>> getPath(T firstVertex, T lastVertex);
}
