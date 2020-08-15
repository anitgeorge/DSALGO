/**
 * Dijkstra's algorithm (or Dijkstra's Shortest Path First algorithm, SPF algorithm)
 * is an algorithm for finding the shortest paths between nodes in a graph
 *
 * @author anitgeorge
 */

import java.util.*;

class Dijkstra{

    class Edge{

        int from;
        int to;
        int cost;

        Edge(int src, int dest, int weight) {
            this.from = src;
            this.to = dest;
            this.cost = weight;
        }
    }

    class Node{

        int id;
        int value;

        Node(int idx, int val){

            id    = idx;
            value = v;
        }
    }

    public List<Integer> computePath(List<Integer, List<Edge>> graph, int nodeCount,
                                      int start, int end){

        Integer[] prev = new Integer[nodeCount];
        int distance = dijkstra(graph, start, end, nodeCount, prev);
        if(distance == Integer.MAX_VALUE)
            return new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        for(Integer at = end; at != null; at = prev[at])
            list.add(0, at);
        return list;
    }

    private int dijkstra(List<Integer, List<Edge>> graph, int start, int end
                          , int nodeCount, Integer[] prev){

        Integer[] dist = new Integer[nodeCount];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<Node>(
                (a, b) -> a.value - b.value
        );

        queue.offer(new Node(start, 0));
        boolean visited[] = new boolean[nodeCount];
        while(!queue.isEmpty()){

            Node node        = queue.poll();
            visited[node.id] = true;
            if(dist[node.id] < node.value)
                continue;
            for(Edge edge : graph.get(node.id)){

                // Can not get a lesser distance by traversing
                // an already existing path in a DAG with no
                // negative edges
                if(visited[edge.to])
                    continue;
                int newDist = dist[from] + edge.cost;
                if(newDist < dist[edge.to]){

                    prev[edge.to] = edge.from;
                    dist[edge.to] = newDist;
                    queue.offer(new Node(edge.to, newDist));
                }
            }

            if(node.id == end)
                return dist[end];
        }

        return Integer.MAX_VALUE;
    }
}