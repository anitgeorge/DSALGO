class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        if(numCourses == 0) return new int[]{};

        if(prerequisites == null || prerequisites.length == 0){

             int ret[] = new int[numCourses];
             for(int i = 0; i < numCourses; i++)
                ret[i] = numCourses - 1 - i;
             return ret;
        }

        List<Integer> result              = new ArrayList<>();
        Queue<Integer> queue              = new LinkedList<>();
        Map<Integer, Integer> inorder     = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int i = 0; i < numCourses; i++){
          graph.put(i, new ArrayList<>());
          inorder.put(i, 0);
        }

        for(int[] prerequisite : prerequisites ){

            int parent = prerequisite[1], child = prerequisite[0];
            graph.get(parent).add(child);
            inorder.put(child, inorder.get(child) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : inorder.entrySet())
           if(entry.getValue() == 0)
              queue.offer(entry.getKey());

        while(!queue.isEmpty()){

             int src = queue.poll();
             result.add(src);
             for(int dest : graph.get(src)){

                  inorder.put(dest, inorder.get(dest) - 1);
                  if(inorder.get(dest) == 0)
                     queue.offer(dest);
             }
        }

        return result.size() == numCourses ?
                  result.stream().mapToInt(i -> i).toArray() :
                  new int[]{};
    }
}
