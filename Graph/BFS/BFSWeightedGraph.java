// BFS on a weighted graph

class BSFWeightedGraph{

	class Edge{
	   int from;
	   int to;
	   int cost;
	   Edge(int src, int dest, int weight){

	      from  = src;
	      to    = dest;
	      cost  = weight;
	   }
        }

	public Integer[] bfs(List<List<Edge>> graph, int start){

		int n = graph.size();
		boolean[] visited = new boolean[n];
		Integer[] prev    = new Integer[n];
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		visted[start] = true;
		while(!queue.isEmpty()){

	           int node = queue.poll();
		   for(Edge edge : graph.get(node)){

		       if(!visisted[edge.to]){
			    visited[edge.to] = true;
			    prev[edge.to]    = node;
			    queue.offer(edge.to);
		       }
		   }
		}
		return prev;
	}

	public List<Integer> reconstructPath(List<List<Edge>> graph, int start, int end){

		Integer[] prev = bfs(graph, start);
		List<Integer> result = new ArrayList<>();
		for(int at = end; at != null; at = prev[at])
                   list.add(0, at);
		return list.get(0) == start ? list : new ArrayList<>();
	}
}
