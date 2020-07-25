import java.util.*;

class AllTaskSchedulingOrders{
  
    public static void printOrders(int tasks, int[][] prerequisites) {
      
         if( tasks == 0 || prerequisites == null 
             || prerequisites.length == 0 || prerequisites[0] == null
             || prerequisites[0].length == 0
         )
            return;
      
         Map<Integer, Integer> indegree    = new HashMap<>();
         Map<Integer, List<Integer>> graph = new HashMap<>();
         Queue<Integer> queue              = new LinkedList<>();
         List<Integer> sortedOrder         = new ArrayList<>();
      
         for(int i = 0 ; i < tasks; i++){
            
             indegree.put(i, 0);
             graph.put(i, new ArrayList<>());
         }
      
         for(int prerequisite : prerequisites){
           
             int parent = prerequisite[0], child = prerequisite[1];
             graph.get(parent).add(child);
             indegree.put(child, indegree.get(child) + 1);
         }
      
         for(Map.Entry<Integer, Integer> entry : indegree.entrySet())
           if(entry.getValue() == 0)
              queue.offer(entry.getKey());
      
         trace(graph, indegree, queue, sortedOrder, tasks);
    }
  
    private void trace(Map<Integer, List<Integer>> graph, Map<Integer, Integer> indegree,
                       Queue<Integer> queue, List<Integer> sortedOrder, int tasks
                      ){
      
         if(!queue.isEmpty()){
           
            for(Integer src : queue){
              
                sortedOrder.add(src);
                Queue<Integer> newQueue = clone(queue);
                newQueue.remove(src);
                for(int child : graph.get(src)){
                  
                     indegree.put(child, indegree.get(child) - 1);
                     if(indegree.get(child) ==  0)
                        newQueue.offer(child);
                }
                trace(graph, indegree, newQueue, sortedOrder, tasks);
                sortedOrder.remove(src);
                for(int child : graph.get(src))
                   indegree.put(child, indegree.get(child) + 1);
            }
         }
      
         if(tasks == sortedOrder.size())
            System.out.println(sortedOrder);
    }
  
    private Queue<Integer> clone(Queue<Integer> queue){
      
         Queue<Integer> clone = new LinkedList<>();
         for(Integer src : queue)
           clone.offer(src);
         return clone;
    }
}
