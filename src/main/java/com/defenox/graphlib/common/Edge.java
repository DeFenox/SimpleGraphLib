package com.defenox.graphlib.common;

import java.util.Objects;

public class Edge<T> {
    private final T startVertex;
    private final T endVertex;
    private final Double weight;

    public Edge(T startVertex, T endVertex, Double weight) {
        this.startVertex = startVertex;
        this.endVertex = endVertex;
        this.weight = weight;
    }

    public Edge(T startVertex, T endVertex) {
        this(startVertex, endVertex, 1.0);
    }

    public T getStartVertex() {
        return startVertex;
    }

    public T getEndVertex() {
        return endVertex;
    }

    public Double getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge<?> edge = (Edge<?>) o;
        return Objects.equals(startVertex, edge.startVertex) &&
                Objects.equals(endVertex, edge.endVertex) &&
                Objects.equals(weight, edge.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startVertex, endVertex, weight);
    }

    @Override
    public String toString() {
        return "(" + startVertex + ", " + endVertex + " : " + weight + ")";
    }
}
