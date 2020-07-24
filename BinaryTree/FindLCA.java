import java.util.*;

class FindLCA{

	public TreeNode findLCA(TreeNode root, int n1, int n2){
	
		if(root == null)
			return null;
		if(root.val == n1 || root.val == n2)
			return root;
		TreeNode leftLca  = findLCA(root.left, n1, n2);
		TreeNode rightLca = findLCA(root.right, n1, n2);

		if(leftLCA != null && rightLCA != null)
			return root;
		return leftLCA == null ? rightLCA : leftLCA;
        }
}
