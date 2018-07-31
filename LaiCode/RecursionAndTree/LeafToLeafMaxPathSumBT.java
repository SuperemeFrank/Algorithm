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
  public int maxPathSum(TreeNode root) {
    
    int[] max = new int[1];
    max[0] = Integer.MIN_VALUE;
    helper(root, max);
    return max[0];
  }
  private int helper(TreeNode root, int[] max) {
    if (root == null) {
      return 0;
    }
    if (root.left == null && root.right == null) {
      return root.key;
    }
    int left = helper(root.left, max);
    int right = helper(root.right, max);
    
    if (root.left != null && root.right != null) {
      max[0] = Math.max(max[0], left + right + root.key);
      return left > right ? left + root.key : right + root.key;
    }else {
      return root.left == null ? right + root.key : left + root.key;
    }
  }
}



/* Time: O(n)  Space: O(height)
  maintain a globleMax 
  only the node have both left and right child can update the globleMax
  1. get the largest sum of left and right child, that the path should from child node to a leaf
  2. get the leaf-leaf sum of current node, and check if it can update the globleMax
  3. return the largest path sum from current to a leaf

*/