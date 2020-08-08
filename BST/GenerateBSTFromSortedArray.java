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
class GenerateBSTFromSortedArray {
    public TreeNode sortedArrayToBST(int[] nums) {
        
        if(nums == null || nums.length == 0)
            return null;
        return insert(nums, 0, nums.length - 1);
    }
    
    private TreeNode insert(int[] arr, int start, int end){
        
        if(start > end)
            return null;
        int mid       = start + (end - start) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left     = insert(arr, start, mid - 1);
        root.right    = insert(arr, mid + 1, end);
        return root;
    }
}
