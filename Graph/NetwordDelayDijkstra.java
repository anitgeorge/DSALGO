/**
 * https://leetcode.com/problems/network-delay-time/
 *
 * There are N network nodes, labelled 1 to N.
 *
 * Given times, a list of travel times as directed edges times[i] = (u, v, w),
 * where u is the source node, v is the target node, and w is the time it
 * takes for a signal to travel from source to target.
 *
 * Now, we send a signal from a certain node K. How long will it take for
 * all nodes to receive the signal? If it is impossible, return -1.
 *
 * @author anitgeorge
 */

import java.util.*;
class NetworkDelayDijkstra{

    class Node{

        int id;
        int value;

        Node(int id, int val){

            this.id    = id;
            this.value = val;
        }
    }

    class Edge{

        int from;
        int to;
        int cost;

        Edge(int src, int dst, int weight){
            from = src;
            to = dst;
            cost = weight;
        }
    }

    public int networkDelayTime(int[][] times, int N, int K) {

        if(times == null || times.length == 0
                || times[0] == null || times[0].length == 0
        )
            return 0;


        Integer[] dist    = new Integer[N + 1];
        boolean[] visited = new boolean[N + 1];
        Map<Integer, List<Edge>> graph = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<Node>(
                (a, b) -> a.value - b.value
        );
        for(int i = 0; i <= N; i++)
            graph.put(i, new ArrayList<>());

        for(int[] time : times)
            graph.get(time[0]).add(new Edge(time[0], time[1], time[2]));

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K] = 0;
        pq.offer(new Node(K, 0));

        while(!pq.isEmpty()){
            Node node = pq.poll();
            visited[node.id] = true;
            for(Edge edge : graph.get(node.id)){

                if(dist[edge.to] < edge.cost
                        || visited[edge.to]
                )
                    continue;
                int newDist = node.value + edge.cost;
                dist[edge.to] = Math.min(newDist, dist[edge.to]);
                pq.offer(new Node(edge.to, dist[edge.to]));
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= N; i++){

            max = Math.max(dist[i], max);
        }

        return max == Integer.MAX_VALUE ? -1: max;
    }
}