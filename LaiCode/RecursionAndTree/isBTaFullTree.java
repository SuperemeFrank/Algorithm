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
  public boolean isFull(TreeNode root) {
    if (root == null) {
      return false;
    }
    if (root.left != null && root.right != null) {
      return isFull(root.left) && isFull(root.right);
    }else if (root.left == null && root.right == null) {
      return true;
    }else {
      return false;
    }
  }
}

/* Time: O(n)  Space: O(height)
  1. from left and right, get if they are full tree
  2. in current, determine if its a full node
  3. return if current is full node, and both children are full tree
*/