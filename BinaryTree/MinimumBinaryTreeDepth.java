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
public class MinimumBinaryTreeDepth {

    public static int findDepth(TreeNode root) {

        if(root == null)
            return 0;
        int minDepth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){

            ++minDepth;
            int size = queue.size();
            for(int i = 0; i < size; i++){

                TreeNode node = queue.poll();
                if(node.left == null && node.right == null)
                    return minDepth;
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }
        }
        return Integer.MAX_VALUE;
    }
}
