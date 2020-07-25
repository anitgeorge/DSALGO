import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
};

class CountAllPathSum {
  
  public static int countPaths(TreeNode root, int S) {

	  if(root == null)
		  return 0;
	  List<Integer> currentPath = new ArrayList<>();
	  return countPathsUtil(root, S, currentPath);
  }

  private static int countPathsUtil(TreeNode root, int S, List<Integer> currentPath){

	  if(root == null)
		  return 0;
	  currentPath.add(root.val);
	  int sum = 0, pathSum = 0;
	  ListIterator<Integer> itr = currentPath.listIterator(currentPath.size());
	  while(itr.hasPrevious()){

		  sum += itr.previous();
		  if(sum == S)
			  pathSum++;
	  }

	  pathSum += countPathsUtil(root.left, S, currentPath);
	  pathSum += countPathsUtil(root.right, S, currentPath);

	  currentPath.remove(currentPath.size() - 1);
	  return pathSum;
  }
}
