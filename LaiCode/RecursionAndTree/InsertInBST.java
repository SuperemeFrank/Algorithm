public class Solution { // recursive
  public TreeNode insert(TreeNode root, int key) {
    if (root == null) {
      return new TreeNode(key);
    }
    if (root.key > key) {
      root.left = insert(root.left, key);
    }else if (root.key < key) {
      root.right = insert(root.right, key);
    }
    
    return root;
  }
}

/* Time: O(logn)  Space: (logn)
  1. get the new root of left or right subTree
  2. reconnect root to subTree, and if root = null, return TreeNode(key)
  3. return the root of current tree

*/


class Solution2 { // path search
  public TreeNode insert(TreeNode root, int key) {
    if (root == null) {
      return new TreeNode(key);
    }
    helper(root, key);
    return root;
  }
  
  private void helper(TreeNode root, int key) {
    if (root.key > key) {
      if (root.left == null) {
        root.left = new TreeNode(key);
        return;
      }else {
        helper(root.left, key);
      }
    }else if (root.key < key){
      if (root.right == null) {
        root.right = new TreeNode(key);
        return;
      }else {
        helper(root.right, key);
      }
    }
  }
}


/* Time: O(logn)  Space: O(logn)
  Solution1: 
    1. find the leaf where the key should be inserted to
    2. insert key to the leaf

*/