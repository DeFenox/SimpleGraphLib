package com.defenox.graphlib.graph;

import com.defenox.graphlib.common.Edge;

import java.util.List;

/**
 * The interface provide addVertex and getPath methods.
 * @param <T> type of vertex.
 */
public interface Graph<T> {
    /**
     * Add a vertex.
     * @param vertex type of vertex.
     */
    void addVertex(T vertex);

    /**
     * Return path between two vertices.
     *
     * @param fromVertex start vertex.
     * @param toVertex end vertex.
     *
     * @return List of edge. If a path is not reachable,
     * return empty list.
     */
    List<Edge<T>> getPath(T fromVertex, T toVertex);
}
