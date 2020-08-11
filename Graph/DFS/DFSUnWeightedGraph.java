// Adjuscency Matrix Impl
//

class DFSUnWeightedGraph{

    public List<Integer> dfs(int[][] graph){

	int n = graph.length;
	boolean visited = new boolean[n];
        List<Integer> result = new ArrayList<>();
	dfs(graph, 0, visited, result);
	return result;
    }

    public List<Integer> dfsConnected(int[][] graph){

       int n = graph.length;
       boolean visited[] = new boolean[n];
       List<Integer> result = new ArrayList<>();

       for(int i = 0; i < n; i++)
	       if(!visited[i])
		       dfs(graph, i, visited, result);
       return result;
    }

    private void dfs(int[][] graph, int src, boolean[] visited, List<Integer> list){

        visited[src] = true;
	list.add(src);
	int n = graph[src].length;

	for(int i = 0; i < n; i++)
		if(graph[src][i] == 1 && !visited[i])
			dfs(graph, i, visited, list);
    }
}
