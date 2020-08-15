/**
 *
 * Compute Single Source Shortest Path with negative edges
 *
 * @author anitgeorge
 */


import java.util.*;

class BellmanFord{

    class Edge{

        int from;
        int to;
        int cost;
        Edge(int src, int dst, int weight){

            from = src;
            to   = dst;
            cost = weight;
        }
    }

    public int[] bellbanFord(List<Edge> graph, int V, int start){

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        boolean isChanging = true;
        for(int i = 0; i < V; i++){

            isChanging = false;
            for(Edge edge : graph){

                if(dist[edge.from] + edge.cost < dist[edge.to]){
                    dist[edge.to] = dist[edge.from] + edge.cost;
                    isChanging = true;
                }
            }
        }

        //The graph should be at optimal distance by now.

        boolean isChanging = true;
        for(int i = 0; i < V; i++){

            isChanging = false;
            for(Edge edge : graph){

                if(dist[edge.from] + edge.cost < dist[edge.to]){
                    dist[edge.to] = Integer.MIN_VALUE;
                    isChanging = true;
                }
            }
        }

        return dist;
    }
}