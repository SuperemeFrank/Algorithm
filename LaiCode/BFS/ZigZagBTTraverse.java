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
  public List<Integer> zigZag(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }
    List<Integer>  res = new ArrayList<>();
    Deque<TreeNode> dq = new LinkedList<>();
    dq.offerLast(root);
    boolean reverse = true;
    while (!dq.isEmpty()) {
      int size = dq.size();
      for (int i = 0; i < size; i++) {
        if (reverse) {
          TreeNode node = dq.pollFirst();
          res.add(node.key);
          if (node.right != null) {
            dq.offerLast(node.right);
          }
          if (node.left != null) {
            dq.offerLast(node.left);
          }
          
        } else {
          TreeNode node = dq.pollLast();
          res.add(node.key);
          if (node.left != null) {
            dq.offerFirst(node.left);
          }
          if (node.right != null) {
            dq.offerFirst(node.right);
          }
        }
        
      }
      reverse ^= true;
    }
    return res;
  }
}


// Time : O(n).  Space: O(1)