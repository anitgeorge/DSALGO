/*

/**
 * Brute Force
 *
class Solution {
    public List<List<Integer>> criticalConnections(int n,
                                                   List<List<Integer>> connections) {

        if(n <= 0 || connections == null || connections.size() == 0)
           return new ArrayList<>();

       List<List<Integer>> result = new ArrayList<>();
       List<List<Integer>> graph  = new ArrayList<>();
       for(int i = 0; i < n; i++)
          graph.add(new ArrayList<>());
       for(List<Integer> connection : connections){

            graph.get(connection.get(0)).add(connection.get(1));
            graph.get(connection.get(1)).add(connection.get(0));
       }

       for(List<Integer> connection : connections){

            graph.get(connection.get(0)).remove(
                                Integer.valueOf(connection.get(1)));
            graph.get(connection.get(0)).remove(
                                Integer.valueOf(connection.get(1)));
            List<Integer> list = new ArrayList<>();
            dfs(graph,n,list);
            if(list.size() != n)
                result.add(new ArrayList<>(Arrays.asList(connection.get(0),
                                                connection.get(1))));
            graph.get(connection.get(0)).add(connection.get(1));
            graph.get(connection.get(1)).add(connection.get(0));
       }

       return result;
    }

    private void dfs(List<List<Integer>> graph,int n, List<Integer> list){

        boolean[] visited = new boolean[n];
        dfsUtil(graph, visited, list, 0);
    }

    private void dfsUtil(List<List<Integer>> graph,boolean[] visited,
                           List<Integer> list, int src){
        visited[src] = true;
        list.add(src);
        for(int dest : graph.get(src)){

            if(!visited[dest])
                dfsUtil(graph, visited, list, dest);
        }
    }
}
*/

/**
 * https://www.youtube.com/watch?v=aZXi1unBdJA
 */
class ConnectedComponents {
    public List<List<Integer>> criticalConnections(int n,
                                                   List<List<Integer>> connections) {

       if(n <= 0 || connections == null || connections.size() == 0)
           return new ArrayList<>();

       List<List<Integer>> result = new ArrayList<>();
       List<List<Integer>> graph  = new ArrayList<>();
       for(int i = 0; i < n; i++)
          graph.add(new ArrayList<>());
       for(List<Integer> connection : connections){

            graph.get(connection.get(0)).add(connection.get(1));
            graph.get(connection.get(1)).add(connection.get(0));
       }

       int[] ids = new int[n];
       int[] low = new int[n];
       boolean[] visited = new boolean[n];

       for(int i = 0; i < n; i++)
          if(!visited[i])
             dfs(graph, i, -1, 0, ids, low, visited, result);
       return result;
    }

    private void dfs(List<List<Integer>> graph, int src, int parent, int time,
                      int[] ids, int low[], boolean[] visited, List<List<integer>> result){

          low[src] = ids[src] = time;
          visited[src] = true;
          for(int dest : graph.get(src)){

              if(dest == parent)
                 continue;
              if(!visited[dest]){

                  dfs(graph, dest, src, time + 1, ids, low, visited, result);
                  low[src] = Math.min(low[src], low[dest]);
                  if(ids[src] < low[dest])
                     result.add(new ArrayList<>(Arrays.asList(src, dest)));
              } else{

                  low[src] = Math.min(low[src], ids[dest]);
              }
          }
    }
}
