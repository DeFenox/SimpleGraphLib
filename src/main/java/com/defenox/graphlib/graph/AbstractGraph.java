package com.defenox.graphlib.graph;

import com.defenox.graphlib.common.Edge;
import com.defenox.graphlib.search.Dijkstra;
import com.defenox.graphlib.search.Search;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Abstract class implements Graph interface and contains implementation of
 * Search interface. A field Search initialize by Dijkstra object by default.
 *
 * @see Search interface.
 *
 * @param <T> tupe of vertices.
 */
public abstract class AbstractGraph<T> implements Graph<T> {

    protected Map<T, List<Edge<T>>> adjacencyList = new ConcurrentHashMap<>();
    protected final Search<T> search;
    protected final ReentrantLock lock = new ReentrantLock();

    /**
     * Constructor init search by Dijkstra.
     */
    public AbstractGraph() {
        this.search = new Dijkstra<>();
    }

    /**
     * Constructor with param.
     * @param search implementation of Search.
     *
     * @see Search
     */
    public AbstractGraph(Search<T> search) {
        this.search = search;
    }

    /**
     * Add a vertex.
     * @param vertex type of vertex.
     */
    @Override
    public void addVertex(T vertex) {
        lock.lock();
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
        lock.unlock();
    }

    /**
     * Return path between two vertices.
     *
     * @param fromVertex start vertex.
     * @param toVertex end vertex.
     *
     * @return List of edge. If a path is not reachable,
     * return empty list.
     */
    @Override
    public List<Edge<T>> getPath(T fromVertex, T toVertex) {
        lock.lock();
        validateVertices(fromVertex, toVertex);
        List<Edge<T>> path = search.getPath(adjacencyList, fromVertex, toVertex);
        lock.unlock();
        return path;
    }

    protected final void validateVertices(T... vertices) {
        for (T vertex : vertices) {
            if (!adjacencyList.containsKey(vertex)) {
                throw new IllegalArgumentException("The graph doesn't have vertex: " + vertex);
            }
        }
    }
}
