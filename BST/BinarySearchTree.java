class BinarySearchTree{

   class TreeNode{
     int val;
     Node left, right;

     Node(int val){
       this.val = val;
       left     = null;
       right    = null;
     }
   }

   public TreeNode search(TreeNode root, int val){
      if(root == null || root.val == val)
	 return root;
      if(val > root.val)
	 return search(root.right, val);
      return search(root.left, val);
   }

   public TreeNode insert(TreeNode root, int val){
      if(root == null)
	  return new TreeNode(val);
      if(val < root.val)
	  root.left = insert(root.left, val);
      else if(val > root.val)
          root.right = insert(root.right, val);
      return root;
   }

   public TreeNode delete(TreeNode root, int val){
      if(root == null)
	 return null;
      if(val < root.val)
	 root.left = delete(root.left, val);
      else if(val > root.val)
	 root.right = delete(root.right, val);
      else{
	 if(root.left == null)
            return root.right;
	 if(root.right == null)
	    return root.left;
	 root.val = findInOrderSuccessor(root.right);
	 root.right = delete(root.right, root.key);
      }
      return root;
   }

   private int findInOrderSuccessor(TreeNode root){
     int min = root.val;
     while(root.left != null){
	root = root.left;
	min = root.val;
     }
     return min;
   }
}
