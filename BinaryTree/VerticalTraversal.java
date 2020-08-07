/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    class Pair{

        TreeNode node;
        int index;
        Pair(TreeNode root, int val){
            node = root;
            index = val;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        if(root == null)
            return null;
        Map<Integer, List<Integer>> map = new HashMap<>();
        traverse(root, map);
        PriorityQueue<Map.Entry<Integer, List<Integer>>> pq = new PriorityQueue<>(
           (a, b) -> a.getKey() - b.getKey()
        );
        pq.addAll(map.entrySet());
        List<List<Integer>> result = new ArrayList<>();
        while(!pq.isEmpty()){

            result.add(pq.poll().getValue());
        }

        return result;
    }

    private void traverse(TreeNode root, Map<Integer, List<Integer>> map){

        if(root == null)
            return;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        Map<Integer, Map<Integer, PriorityQueue<Integer>>> newMap = new HashMap<>();
        int level = 0;
        while(!queue.isEmpty()){

            int size = queue.size();
            level++;
            for(int i = 0; i < size; i++){

                Pair pair     = queue.poll();
                TreeNode node = pair.node;
                int index     = pair.index;
                if(newMap.get(index) == null){
                       Map<Integer, PriorityQueue<Integer>> tmp = new HashMap<>();
                       newMap.put(index, tmp);
                }
                if(newMap.get(index).get(level) == null){

                    newMap.get(index).put(level, new PriorityQueue<>());
                }
                newMap.get(index).get(level).offer(node.val);
                if(node.left != null)
                    queue.offer(new Pair(node.left, index - 1));
                if(node.right != null)
                    queue.offer(new Pair(node.right, index + 1));
            }
        }

        for(Map.Entry<Integer, Map<Integer, PriorityQueue<Integer>>> entry : newMap.entrySet()){

            if(map.get(entry.getKey()) == null)
                map.put(entry.getKey(), new ArrayList<>());

            PriorityQueue<Map.Entry<Integer, PriorityQueue<Integer>>> newQueue =
                                  new PriorityQueue<Map.Entry<Integer, PriorityQueue<Integer>>>(
              (a, b) -> a.getKey() - b.getKey()
            );
            newQueue.addAll(entry.getValue().entrySet());
            while(!newQueue.isEmpty()){
                Map.Entry<Integer, PriorityQueue<Integer>> e = newQueue.poll();
                PriorityQueue<Integer> newPq = e.getValue();
                while(!newPq.isEmpty()){

                    map.get(entry.getKey()).add(newPq.poll());
                }
            }
        }
    }
}
