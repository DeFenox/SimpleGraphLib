package com.defenox.graphlib.graph;

import com.defenox.graphlib.common.Edge;

import java.util.List;

public interface Graph<T> {
    void addVertex(T vertex);
    List<Edge<T>> getPath(T firstVertex, T lastVertex);
}
