package com.defenox.graphlib.undirected;

import com.defenox.graphlib.graph.AbstractGraph;
import com.defenox.graphlib.common.Edge;
import com.defenox.graphlib.graph.UnweightedGraph;
import com.defenox.graphlib.search.Search;

import java.util.ArrayList;

public class UndirectedUnweightedGraph<T> extends AbstractGraph<T> implements UnweightedGraph<T> {

    public UndirectedUnweightedGraph() {
        super();
    }

    public UndirectedUnweightedGraph(Search<T> search) {
        super(search);
    }

    @Override
    public void addEdge(T firstVertex, T secondVertex) {
        lock.lock();
        adjacencyList.putIfAbsent(firstVertex, new ArrayList<>());
        adjacencyList.putIfAbsent(secondVertex, new ArrayList<>());
        adjacencyList.get(firstVertex).add(new Edge<>(firstVertex, secondVertex));
        adjacencyList.get(secondVertex).add(new Edge<>(secondVertex, firstVertex));
        lock.unlock();
    }
}
