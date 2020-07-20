package com.defenox.graphlib.search;

import com.defenox.graphlib.common.Edge;

import java.util.List;
import java.util.Map;

public interface Search<T> {
    List<Edge<T>> getPath(Map<T, List<Edge<T>>> adjacencyList, T firstVertex, T lastVertex);
}
