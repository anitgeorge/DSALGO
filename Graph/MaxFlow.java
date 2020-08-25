class MaxFLow{

    int dataRoute(int resource, int server, int[][] network) {

        if(network == null || network.length == 0
                || network[0] == null || network[0].length == 0
        )
            return 0;
        int[][] residualNetwork = new int[network.length][network[0].length];
        int[] parent = new int[network.length];
        int size = network.length, u = 0, v = 0, maxFlow = 0;

        //Initilize the residual Matrix
        for(int i = 0; i < network.length; i++)
            for(int j = 0; j < network[0].length; j++)
                residualNetwork[i][j] = network[i][j];

        while(bfs(residualNetwork, resource, server, parent)){

            int pathFlow = Integer.MAX_VALUE;
            for(v = server; v != resource; v = parent[v]){
                u = parent[v];
                pathFlow = Math.min(pathFlow, residualNetwork[u][v]);
            }

            for(v = server; v != resource; v = parent[v]){
                u = parent[v];
                residualNetwork[u][v] -= pathFlow;
                residualNetwork[v][u] += pathFlow;
            }

            maxFlow += pathFlow;
        }

        return maxFlow;
    }

    private boolean bfs(int[][] rGraph, int src, int dest, int[] parent){

        int size = rGraph.length;
        boolean[] visited = new boolean[size];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        visited[src]  = true;
        parent[src]   = -1;

        while(!queue.isEmpty()){

            int vertex = queue.poll();
            for(int u = 0; u < size; u++)
                if(!visited[u] && rGraph[vertex][u] > 0){
                    queue.offer(u);
                    visited[u] = true;
                    parent[u]  = vertex;
                }
        }
        return visited[dest];
    }

}