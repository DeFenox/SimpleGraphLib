package com.defenox.graphlib.graph;

public interface UnweightedGraph<T> extends Graph<T> {
    void addEdge(T firstVertex, T secondVertex);
}
