import java.util.*;
/*
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
};
*/

public class ReverseLevelOrderTraversal {
    public List<List<Integer>> traverse(TreeNode root){

        if(root == null)
            return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){

            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++){

                 TreeNode node = queue.poll();
                 list.add(node.val);
                 if(node.left != null)
                     queue.offer(node.left);
                 if(node.right != null)
                     queue.offer(node.right);
            }
            result.add(0, list);
        }
        return result;
    }
}
