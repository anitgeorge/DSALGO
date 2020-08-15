/**
 * Kruskal's algorithm to solve flights with stops problems
 *
 * @author anitgeore
 */


import java.util.*;

class FlightsWithKStops {

    class Node{

        int id;
        int price;
        int stops;

        Node(int id, int price, int stops){

            this.id    = id;
            this.price = price;
            this.stops = stops;
        }
    }

    class Edge{

        int from;
        int to;
        int cost;

        Edge(int src, int dest, int weight){
            from = src;
            to = dest;
            cost = weight;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        if (n == 0 || flights == null || flights.length == 0
                || flights[0] == null || flights[0].length == 0
                || k > n
        )
            return -1;

        Map<Integer, List<Edge>> graph = new HashMap<>();
        for (int i = 0; i < n; i++)
            graph.put(i , new ArrayList<>());

        for(int[] flight: flights)
            graph.get(flight[0]).add(new Edge(flight[0], flight[1], flight[2]));
        PriorityQueue<Node> pq = new PriorityQueue<Node>(
                (a, b) -> a.price - b.price
        );

        pq.offer(new Node(src, 0, k + 1));
        while(!pq.isEmpty()){

            Node node = pq.poll();
            if(node.id == dst)
                return node.price;
            if(node.stops > 0)
                for(Edge edge: graph.get(node.id))
                    pq.offer(new Node(edge.to, node.price + edge.cost, k - 1));
        }

        return -1;
    }

    public static void main(String args[]){

        FlightsWithKStops obj = new FlightsWithKStops();
        int flight[][] = new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};

        System.out.println(obj.findCheapestPrice(3, flight, 0, 2, 2));
    }
}