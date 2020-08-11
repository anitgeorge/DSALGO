//DFS using Adj List
//
class DFSUnWeightedGraph2{

    public List<Integer> dfs(List<List<Integer>> graph){

	int n = graph.size();
	boolean[] visited    = new boolean[n];
	List<Integer> result = new ArrayList<>();

	dfs(graph, 0, visited, result);
	return result;
    }

    public List<Integer> dfsConnected(List<List<Integer>> graph){

       int n = graph.size();
       boolean[] visited    = new boolean[n];
       List<Integer> result = new ArrayList<>();

       for(int i = 0; i < n; i++)
	       if(!visited[i])
		       dfs(graph, i, visited, result);
       return result;
    }

    private void dfs(List<List<Integer>> graph, int src, boolean[] visited, List<Integer> result){

       visited[src] = true;
       result.add(src);
       for(int dest : graph.get(src))
	       if(!visited[dest])
		       dfs(graph, dest, visited, result);
    }
}
