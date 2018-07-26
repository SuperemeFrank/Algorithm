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
public class Solution { // BFS solution
  public boolean isCousin(TreeNode root, int a, int b) {
    if (root == null) {
      return false;
    }
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    while (!q.isEmpty()) {
      int size = q.size();
      boolean findOne = false; 
      for (int i = 0; i < size; i++) {
        TreeNode node = q.poll();
        if (node.left != null && node.right != null) { // if the children of the parent node are targets
          if ((node.left.key == a || node.left.key == b) && 
              (node.right.key == a || node.right.key == b)) {
            return false;
          }
        }
        if (node.left != null) {
          q.offer(node.left);
        }
        if (node.right != null) {
          q.offer(node.right);
        }
        if (node.key == a || node.key == b) { // find target in the current level
          if (findOne) {
            return true;
          }else {
            findOne = true;
          }
        }
      }
    }
   return false;
  }
}

// Time: O(n). Space: O(n)