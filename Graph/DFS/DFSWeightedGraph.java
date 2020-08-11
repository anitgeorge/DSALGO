// DFS on weighed Graph

class DFSWeightedGraph{

   class Edge{

      int from;
      int to;
      int weight;

      Edge(src, dest, cost){

	  from   = src;
	  to     = dest;
	  weight = cost;
      }
   }

   public int dfs(int src, Map<Integer, List<Edge>> graph){

      int n = grpah.size();
      boolean[] visited = new boolean[n];
      return dfs(src, visited, graph);
   }

   private int dfs(int src, boolean[] visited, Map<Integer, List<Edge>> graph){

      if(visited[src])
	      return 0;
      visited[src] = true;
      int count = 1;
      for(List<Edge> edges : graph.get(src))
	  for(Edge edge : edges)
             count += dfs(edge.to, visited, graph);
      return count;
   }
}
