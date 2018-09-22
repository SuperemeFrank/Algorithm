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
  public boolean isCompleted(TreeNode root) {
    if (root == null) {
      return true;
    }
    Queue<TreeNode> q = new LinkedList<>();
    boolean flag = false;
    q.offer(root);
    while (!q.isEmpty()) {
      TreeNode cur = q.poll();
      if (cur.left != null) {
        if (flag) {
          return false;
        }else {
          q.offer(cur.left);
        }
      }else {
        flag = true;
      }
      
      if (cur.right != null) {
        if (flag) {
          return false;
        }else {
          q.offer(cur.right);
        }
      }else {
        flag = true;
      }
    }
    return true;
  }
}

/* Time: O(n)  Space: O(n)
  BFS
  if one node do not have left or right child, it must be the last parent
  so the following nodes should not have children
  
  use a flag the record the last parent
  use BFS, when a node is try to generate child
  if has child && flag, not a complete tree
  if has child && !flag, move on
  if don't have left or right child && !flag , flag set
*/
