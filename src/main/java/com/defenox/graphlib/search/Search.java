package com.defenox.graphlib.search;

import com.defenox.graphlib.common.Edge;

import java.util.List;
import java.util.Map;

/**
 *
 * @param <T>
 */
public interface Search<T> {
    /**
     *
     * @param adjacencyList
     * @param firstVertex
     * @param lastVertex
     * @return
     */
    List<Edge<T>> getPath(Map<T, List<Edge<T>>> adjacencyList, T firstVertex, T lastVertex);
}
