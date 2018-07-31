/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 */
public class Solution {
  public TreeNode search(TreeNode root, int key) {
    if (root == null || root.key == key) {
      return root;
    }
    
    if (root.key > key) {
      return search(root.left, key);
    }else {
      return search(root.right, key);
    }
  }
}


/* Time: O(logn)  Space: O(logn)
  1. get the target node from left or right child
  2. compare current key with target
  3. return the result from current or from children

*/