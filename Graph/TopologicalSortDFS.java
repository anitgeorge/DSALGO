class Solution {

    public boolean isCyclic(List<List<Integer>> graph){

        int V = graph.size();
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for(int i = 0; i < V; i++)
            if(!visited[i])
                if(isCyclic(graph, i, visited, recStack))
                    return true;

        return false;
    }

    private boolean isCyclic(List<List<Integer>> graph,
                             int src, boolean[] visited, boolean[] recStack){

        if(recStack[src])
            return true;
        if(visited[src])
            return false;

        visited[src] = recStack[src] = true;
        for(int dest : graph.get(src))
            if(isCyclic(graph, dest, visited, recStack))
                return true;

        recStack[src] = false;
        return false;
    }
    public int[] topologicalSort(List<List<Integer>> graph){

        int V = graph.size();
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        for(int i = 0; i < V; i++)
            if(!visited[i])
                topologicalSort(graph, i, visited, stack);

        int[] result = new int[V];
        int index = 0;
        while(!stack.isEmpty())
            result[index++] = stack.pop();
        return result;
    }

    private void topologicalSort(List<List<Integer>> graph,
                                 int src, boolean[] visited, Stack<Integer> stack){

        visited[src] = true;
        for(int dest : graph.get(src))
            if(!visited[dest])
                topologicalSort(graph, dest, visited, stack);

        stack.push(src);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        if(numCourses <= 0)
            return new int[]{};
        if(prerequisites == null || prerequisites.length == 0){

            int[] arr = new int[numCourses];
            for(int i = 0; i < numCourses; i++)
                arr[i] = i;
            return arr;
        }
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<>());

        for(int[] arr : prerequisites)
            graph.get(arr[1]).add(arr[0]);
        return isCyclic(graph) ? new int[]{} : topologicalSort(graph);
    }
}