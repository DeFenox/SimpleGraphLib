package com.defenox.graphlib.common;

import java.util.Objects;

/**
 * An object contains two vertices and weight.
 * Weight of edge equals 1.0 by default for an unweighted graph.
 * @param <T> type of vertices.
 */
public class Edge<T> {
    private final T startVertex;
    private final T endVertex;
    private final Double weight;

    /**
     * A constructor with args
     * @param startVertex first vertex.
     * @param endVertex second vertex.
     * @param weight - weight of edge.
     */
    public Edge(T startVertex, T endVertex, Double weight) {
        this.startVertex = startVertex;
        this.endVertex = endVertex;
        this.weight = weight;
    }

    /**
     * A constructor with args. Set weight as 1.0.
     * @param startVertex first vertex.
     * @param endVertex second vertex.
     */
    public Edge(T startVertex, T endVertex) {
        this(startVertex, endVertex, 1.0);
    }

    /**
     *
     * @return
     */
    public T getStartVertex() {
        return startVertex;
    }

    /**
     *
     * @return
     */
    public T getEndVertex() {
        return endVertex;
    }

    /**
     *
     * @return Double - weight of edge.
     */
    public Double getWeight() {
        return weight;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge<?> edge = (Edge<?>) o;
        return Objects.equals(startVertex, edge.startVertex) &&
                Objects.equals(endVertex, edge.endVertex) &&
                Objects.equals(weight, edge.weight);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(startVertex, endVertex, weight);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "(" + startVertex + ", " + endVertex + " : " + weight + ")";
    }
}
