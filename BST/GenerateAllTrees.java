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
    public List<TreeNode> generateTrees(int n) {
        
        if(n == 0)
            return new ArrayList<>();
        return generateTreeUtil(1, n);
    }
    
    private List<TreeNode> generateTreeUtil(int start, int end){
        
        List<TreeNode> list = new ArrayList<>();
        if(start > end)
            list.add(null);
        
        for(int i = start ; i <= end; i++){
            
            List<TreeNode> leftTree =  generateTreeUtil(start , i - 1);
            List<TreeNode> rightTree = generateTreeUtil(i + 1, end);
            for(TreeNode left : leftTree)
	       for(TreeNode right : rightTree){
		   TreeNode root = new TreeNode(i);
		   root.left  = left;
		   root.right = right;
		   list.add(root);
	       }
        }
	return list;
    }
}
