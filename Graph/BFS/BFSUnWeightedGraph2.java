// BFS using Adj List


public class BFSUnWeightedGraph2{

    public List<Integer> bfs(List<List<Integer>> graph, int src){

	int n = graph.size();
	boolean[] visited    = new boolean[n];
	List<Integer> result = new ArrayList<>();
	Queue<Integer> queue = new LinkedList<>();
	queue.offer(src);

	while(!queue.isEmpty()){

	    int val = queue.poll();
	    visited[val] = true;
	    result.add(val);
	    for(int dest : graph.get(val))
		if(!visited[dest])
		   queue.offer(dest);
	}
	return result;
    }
}
