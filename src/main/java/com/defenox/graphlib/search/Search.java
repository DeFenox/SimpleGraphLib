package com.defenox.graphlib.search;

import com.defenox.graphlib.common.Edge;

import java.util.List;
import java.util.Map;

/**
 * The <tt>Search</tt> interface provides method <code>getPath()</code>, which
 * should return list of edges between two vertices. If a path is not reachable,
 * it returns empty list.
 *
 * @param <T> type of edge.
 */
public interface Search<T> {
    /**
     *
     * @param adjacencyList - adjacency  list.
     * @param fromVertex - start vertex.
     * @param toVertex - end vertex.
     * @return - List of edge. If a path is not reachable,
     *  return empty list.
     */
    List<Edge<T>> getPath(Map<T, List<Edge<T>>> adjacencyList, T fromVertex, T toVertex);
}
