//https://leetcode.com/problems/maximum-width-of-binary-tree/

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
class BinaryTreeWidth {
    public int widthOfBinaryTree(TreeNode root) {

        if(root == null) return 0;
        int max = Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> qIndex  = new LinkedList<>();
        queue.offer(root);
        qIndex.offer(1);
        while(!queue.isEmpty()){
            int start = -1, end = -1;
            int size = queue.size();
            for(int i = 0; i < size; i++){

                TreeNode node = queue.poll();
                int index = qIndex.poll();
                if(i == 0) start = index;
                if(i == size -1) end = index;
                if(node.left !=null){

                    queue.offer(node.left);
                    qIndex.offer(2 * index);
                }
                if(node.right !=null){

                    queue.offer(node.right);
                    qIndex.offer((2 * index) + 1);
                }
            }

            max = Math.max(max, end - start + 1);
        }
        return max == Integer.MIN_VALUE? 0 : max;
    }
}
