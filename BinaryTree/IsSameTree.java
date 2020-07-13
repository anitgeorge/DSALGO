import java.util.*;

class IsSameTree{

	public boolean isSameTree(TreeNode node1, TreeNode node2){
     
		if(node1 == null) return node2 == null;
		if(node2 == null) return false;

		return node1.value == node2.value ? isSameTree(node1.left, node2.left) 
			                            && isSameTree(node1.right, node2.right) : false;
	}
}
