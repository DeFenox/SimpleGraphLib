package com.defenox.graphlib.search;

import com.defenox.graphlib.common.Edge;

import java.util.*;

/**
 * Implement Search interface.
 * @see com.defenox.graphlib.search.Search
 * @param <T> type of vertex.
 */
public class Dijkstra<T> implements Search<T> {
    private Set<T> settledNodes;
    private Set<T> unSettledNodes;
    private Map<T, T> predecessors;
    private Map<T, Double> distance;
    private Map<T, List<Edge<T>>> adjacencyList;

    /**
     *
     * @param adjacencyList - adjacency  list.
     * @param fromVertex - start vertex.
     * @param toVertex - end vertex.
     * @return - List of edge. If a path is not reachable,
     *  return empty list.
     *
     * @throws IllegalArgumentException if weight of edge is negative.
     */
    @Override
    public List<Edge<T>> getPath(Map<T, List<Edge<T>>> adjacencyList, T fromVertex, T toVertex) {
        this.adjacencyList = adjacencyList;
        return calculate(fromVertex, toVertex);
    }


    private List<Edge<T>> calculate(T source, T destination) {
        settledNodes = new HashSet<>();
        unSettledNodes = new HashSet<>();
        distance = new HashMap<>();
        predecessors = new HashMap<>();
        distance.put(source, 0.0);
        unSettledNodes.add(source);
        while (unSettledNodes.size() > 0) {
            T node = getMinimum(unSettledNodes);
            settledNodes.add(node);
            unSettledNodes.remove(node);
            findMinimalDistances(node);
        }
        return getPath(destination);
    }

    private T getMinimum(Set<T> vertexes) {
        T minimum = null;
        for (T vertex : vertexes) {
            if (minimum == null) {
                minimum = vertex;
            } else {
                if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
                    minimum = vertex;
                }
            }
        }
        return minimum;
    }

    private Double getShortestDistance(T destination) {
        Double d = distance.get(destination);
        if (d == null) {
            return Double.POSITIVE_INFINITY;
        } else if (d < 0) {
            throw new IllegalArgumentException("Dijkstra's algorithm couldn't work with negative weight");
        } else {
            return d;
        }
    }

    private void findMinimalDistances(T node) {
        List<T> adjacentNodes = getNeighbors(node);
        for (T target : adjacentNodes) {
            if (getShortestDistance(target) > (getShortestDistance(node) + getDistance(node, target))) {
                distance.put(target, getShortestDistance(node) + getDistance(node, target));
                predecessors.put(target, node);
                unSettledNodes.add(target);
            }
        }
    }

    private List<T> getNeighbors(T node) {
        List<T> neighbors = new ArrayList<>();
        for (Edge<T> edge : adjacencyList.get(node)) {
            if (!isSettled(edge.getEndVertex())) {
                neighbors.add(edge.getEndVertex());
            }
        }
        return neighbors;
    }

    private boolean isSettled(T secondVertex) {
        return settledNodes.contains(secondVertex);
    }

    private Double getDistance(T node, T target) {
        for (Edge<T> edge : adjacencyList.get(node)) {
            if (edge.getEndVertex().equals(target)) {
                return edge.getWeight();
            }
        }
        throw new RuntimeException();
    }

    /*
     * This method returns the path from the source to the selected target and
     * Empty List if no path exists
     */
    private List<Edge<T>> getPath(T target) {
        List<Edge<T>> path = new LinkedList<>();
        T step = target;
        // check if a path exists
        if (predecessors.get(step) == null) {
            return path;
        }
        while (predecessors.get(step) != null) {
            T endVertex = step;
            step = predecessors.get(step);
            T startVertex = step;
            //path.add(new Edge<>(startVertex, endVertex));
            path.add(getEdge(startVertex, endVertex));
        }
        // Put it into the correct order
        Collections.reverse(path);
        return path;
    }

    private Edge<T> getEdge(T startVertex, T endVertex) {
        for (Edge<T> edge : adjacencyList.get(startVertex)) {
            if (edge.getStartVertex().equals(startVertex) && edge.getEndVertex().equals(endVertex)) {
                return edge;
            }
        }
        return null;
    }
}
