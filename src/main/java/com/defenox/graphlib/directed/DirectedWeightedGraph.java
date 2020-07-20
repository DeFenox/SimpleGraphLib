package com.defenox.graphlib.directed;

import com.defenox.graphlib.graph.AbstractGraph;
import com.defenox.graphlib.common.Edge;
import com.defenox.graphlib.graph.WeightedGraph;
import com.defenox.graphlib.search.Search;

import java.util.ArrayList;
public class DirectedWeightedGraph<T> extends AbstractGraph<T> implements WeightedGraph<T> {

    public DirectedWeightedGraph() {
        super();
    }

    public DirectedWeightedGraph(Search<T> search) {
        super(search);
    }

    @Override
    public void addEdge(T firstVertex, T secondVertex, Double weight) {
        lock.lock();
        adjacencyList.putIfAbsent(firstVertex, new ArrayList<>());
        adjacencyList.putIfAbsent(secondVertex, new ArrayList<>());
        adjacencyList.get(firstVertex).add(new Edge<>(firstVertex, secondVertex, weight));
        lock.unlock();
    }
}
