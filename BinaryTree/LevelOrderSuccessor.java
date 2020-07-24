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

public class LevelOrderSuccessor {

    public TreeNode findSuccessor(TreeNode root, int key) {

        if(root == null)
            return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){

            int size = queue.size();
            for(int i = 0; i < size; i++){

                 TreeNode node = queue.poll();
                 if(node.left != null)
                     queue.offer(node.left);
                 if(node.right !=null)
                     queue.offer(node.right);
                 if(node.val == key)
                     break;
            }
        }
        return queue.peek();
    }
}
