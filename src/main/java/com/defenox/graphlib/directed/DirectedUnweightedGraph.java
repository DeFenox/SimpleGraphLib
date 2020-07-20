package com.defenox.graphlib.directed;

import com.defenox.graphlib.graph.AbstractGraph;
import com.defenox.graphlib.common.Edge;
import com.defenox.graphlib.graph.UnweightedGraph;
import com.defenox.graphlib.search.Search;

import java.util.ArrayList;

public class DirectedUnweightedGraph<T> extends AbstractGraph<T> implements UnweightedGraph<T> {

    public DirectedUnweightedGraph() {
        super();
    }

    public DirectedUnweightedGraph(Search<T> search) {
        super(search);
    }

    @Override
    public void addEdge(T firstVertex, T secondVertex) {
        lock.lock();
        adjacencyList.putIfAbsent(firstVertex, new ArrayList<>());
        adjacencyList.putIfAbsent(secondVertex, new ArrayList<>());
        adjacencyList.get(firstVertex).add(new Edge<>(firstVertex, secondVertex));
        lock.unlock();
    }
}
