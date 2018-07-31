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

class Solution2 { // traverse
  public int closest(TreeNode root, int target) {

    int[] closest = new int[1];
    closest[0] = root.key;
    helper(root, target, closest);
    return closest[0];
  }
  
  private void helper(TreeNode root, int target, int[] close) {
    while (root != null) {
      close[0] = Math.abs(root.key - target) < Math.abs(close[0] - target) ?
                 root.key : close[0];
      if (root.key > target) {
        root = root.left;
      }else if (root.key < target) {
        root = root.right;
      }else {
        return;
      }
    }
  }
}


/* Time: O(logn)  Space: O(1);
  Solution 1:
  maintain a globle Closest
  for each traverse node, try to update the globle closest node
*/