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
        
        int nodeVal;
        int vIndex;
        Pair(int val, int index){
            nodeVal  = val;
            vIndex   = index;
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        if(root == null)
            return new ArrayList<>();
        Map<Integer, PriorityQueue<Pair>> map = new HashMap<>();
        traverse(root,0, 0, map);
        PriorityQueue<Map.Entry<Integer, PriorityQueue<Pair>>> queue =
            new PriorityQueue<Map.Entry<Integer, PriorityQueue<Pair>>>(
           (a, b) -> a.getKey() - b.getKey()
        );
        queue.addAll(map.entrySet());
        List<List<Integer>> result = new ArrayList<>();
        while(!queue.isEmpty()){
            
            PriorityQueue<Pair> q = queue.poll().getValue();
            List<Integer> list = new ArrayList<>();
            while(!q.isEmpty()){
                
                list.add(q.poll().nodeVal);
            }
            result.add(list);
        }
            
        return result;
        
    }

    private void traverse(TreeNode root, int index, int level
	                 , Map<Integer, PriorityQueue<Pair>> map){
        
     
        if(root == null)
            return;
        if(map.get(index) == null){
            
            PriorityQueue<Pair> pq = new PriorityQueue<Pair>(
              (a, b) -> a.vIndex == b.vIndex ? a.nodeVal - b.nodeVal : a.vIndex - b.vIndex
            );
            map.put(index, pq);
        }
        map.get(index).offer(new Pair(root.val, level));
        traverse(root.left, index - 1, level + 1, map);
        traverse(root.right, index + 1, level +1, map);
    }
}
