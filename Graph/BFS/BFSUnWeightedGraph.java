// BFS on Matrix
import java.util.*;
class BFSUnWeightedGraph{

   public List<Integer> bfs(int[][] graph, int src){

      int n = graph.length;
      boolean[] visited    = new boolean[n];
      List<Integer> result = new ArrayList<>();
      Queue<Integer> queue = new LinkedList<>();
      queue.offer(src);

      while(!queue.isEmpty()){

	  int val = queue.poll();
	  visited[src] = true;
	  result.add(src);
	  for(int i = 0; i < n; i++)
	    if(graph[val][i] == 1 && !visited[i])
		 queue.offer(i);
      }
      return result;
   }
}
