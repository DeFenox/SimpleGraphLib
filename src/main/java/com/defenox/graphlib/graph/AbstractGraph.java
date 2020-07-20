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
 *
 * @param <T>
 */
public abstract class AbstractGraph<T> implements Graph<T> {

    protected Map<T, List<Edge<T>>> adjacencyList = new ConcurrentHashMap<>();
    protected final Search<T> search;
    protected final ReentrantLock lock = new ReentrantLock();

    /**
     *
     */
    public AbstractGraph() {
        this.search = new Dijkstra<>();
    }

    /**
     *
     * @param search
     */
    public AbstractGraph(Search<T> search) {
        this.search = search;
    }

    /**
     *
     * @param vertex
     */
    @Override
    public void addVertex(T vertex) {
        lock.lock();
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
        lock.unlock();
    }

    /**
     *
     * @param firstVertex
     * @param lastVertex
     * @return
     */
    @Override
    public List<Edge<T>> getPath(T firstVertex, T lastVertex) {
        lock.lock();
        validateVertices(firstVertex, lastVertex);
        List<Edge<T>> path = search.getPath(adjacencyList, firstVertex, lastVertex);
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
