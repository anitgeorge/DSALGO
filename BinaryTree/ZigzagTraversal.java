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

public class ZigzagTraversal {

    public List<List<Integer>> traverse(TreeNode root){

         if(root == null)
             return new ArrayList<>();
         List<List<Integer>> result = new ArrayList<>();
         Queue<TreeNode> queue = new LinkedList<>();
         queue.offer(root);
         boolean rtl = false;
         while(!queue.isEmpty()){
             int size = queue.size();
             List<Integer> list = new ArrayList<>();
             for(int  i= 0; i < size; i++){

                 TreeNode node = queue.poll();
                 if(rtl == false)
                     list.add(node.val);
                 else
                     list.add(0, node.val);
                 if(node.left != null)
                     queue.offer(node.val);
                 if(node.right != null)
                     queue.offer(node.right);
             }
             result.add(list);
             rtl = rtr == true ? false : true;
         }
         return result;
    }
}
