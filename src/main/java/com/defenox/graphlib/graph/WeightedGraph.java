package com.defenox.graphlib.graph;

public interface WeightedGraph<T> extends Graph<T> {
    void addEdge(T firstVertex, T secondVertex, Double weight);
}
