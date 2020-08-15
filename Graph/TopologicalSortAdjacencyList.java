/**
 * @author anitgeorge
 */

import java.util.*;
import java.lang.*;
import java.io.*;

class TopologicalSortAdjacencyList{

    class Edge{

        int from;
        int to;
        int dist;

        Edge(int src, int dest, int weight){

            from = src;
            to   = dest;
            dist = weight;
        }
    }

    public int[] topologicalSort(Map<Integer, List<Edge>> graph, int nodes){

        int[] path = new int[nodes];
        boolean[] visited = new boolean[nodes];
        int index = nodes - 1;
        for(int i = 0; i < nodes; i++)
            if(!visited[i])
                index = dfs(i, index, visited, path, graph);
        return path;
    }

    private int dfs(int src, int index, boolean[] visited, int[] path,
                    Map<Integer, List<Edge>> graph){
        visited[src] = true;
        List<Edge> edges = graph.get(src);
        for(Edge edge : edges)
            if(!visited[edge.to])
                index = dfs(edge.to, index, visited, path, graph);
        path[index] = src;
        return index - 1;
    }

    public Integer[] pathFinder(Map<Integer, List<Edge>> graph, int nodes, int start){

        int[] path = topologicalSort(graph, nodes);
        Integer[] dist = new Integer[nodes];
        dist[start] = 0;

        for(int i = 0; i < nodes; i++){

            int nodeIndex = path[i];
            if(dist[nodeIndex] != null){

                List<Edge> edges = graph.get(nodeIndex);
                for(Edge edge : edges){

                    int newDist = dist[nodeIndex] + edge.dist;
                    dist[edge.to] = dist[edge.to] == null ? newDist :
                            Math.min(dist[edge.to], newDist);
                }
            }
        }

        return dist;
    }

    public Map<Integer, List<Edge>> getGraph(int N){
        Map<Integer, List<Edge>> graph = new HashMap<>();
        for (int i = 0; i < N; i++) graph.put(i, new ArrayList<>());
        graph.get(0).add(new Edge(0, 1, 3));
        graph.get(0).add(new Edge(0, 2, 2));
        graph.get(0).add(new Edge(0, 5, 3));
        graph.get(1).add(new Edge(1, 3, 1));
        graph.get(1).add(new Edge(1, 2, 6));
        graph.get(2).add(new Edge(2, 3, 1));
        graph.get(2).add(new Edge(2, 4, 10));
        graph.get(3).add(new Edge(3, 4, 5));
        graph.get(5).add(new Edge(5, 4, 7));

        return graph;
    }

    public static void main(String[] args){

        int N = 7;
        TopologicalSortAdjacencyList obj = new TopologicalSortAdjacencyList();
        Map<Integer, List<Edge>> graph = obj.getGraph(N);
        Integer[] dist = obj.pathFinder(graph, N, 0);
        System.out.println(dist[4]);
    }
}