import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
};

class FindAllTreePaths {
  public static List<List<Integer>> findPaths(TreeNode root, int sum) {
  
    if(root == null || sum < root.val)
	return new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> currentPath  = new ArrayList<>();
    hasPathsum(result, currentPath, root, sum);
    return result;
  }

  private static void hasPathsum(List<List<Integer>> result, List<Integer> currentPath
		  , TreeNode root, int sum){
     if(root == null)
	return;
     currentPath.add(root.val);
     if(root.val == sum && root.left == null && root.right == null)
	  result.add(new ArrayList<>(currentPath));
     else{
	  hasPathsum(result, currentPath, root.left, sum - root.val);
	  hasPathsum(result, currentPath, root.right, sum - root.val);
     }
     currentPath.remove(currentPath.size() - 1);
  }
  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(4);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    int sum = 23;
    List<List<Integer>> result = FindAllTreePaths.findPaths(root, sum);
    System.out.println("Tree paths with sum " + sum + ": " + result);
  }
}

