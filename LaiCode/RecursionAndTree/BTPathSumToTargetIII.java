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
  public boolean exist(TreeNode root, int target) {
    return helper(root, target, target);
  }
  private boolean helper(TreeNode root, int target, int sum) {
    if (root == null) {
      return false;
    }
    if (sum == root.key) {
      return true;
    }
    return helper(root.left, target, sum - root.key) || helper(root.right, target, sum - root.key)
          || helper(root.left, target, target) || helper(root.right, target, target);
  }
}

// Time: O(n)  Space: O(height)

/*
  1. left and child return if they contians path sum to target
  2. check if current node equals to the rest of target
  3. return if starting from current node there is a path, or to current node there is a path 
     satisfy the requirement
*/
