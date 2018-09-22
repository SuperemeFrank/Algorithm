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
    
    List<Integer> res = new ArrayList<>();
    if (root == null) {
      return res;
    }
    Deque<TreeNode> dq = new LinkedList<>();
    dq.offerFirst(root);
    int level = 0;
    res.add(root.key);
    while (!dq.isEmpty()) {
      int size = dq.size();
      for (int i = 0; i < size; i++) {
        if (level % 2 == 0) {
          TreeNode cur = dq.pollFirst();
          if (cur.left != null) {
            res.add(cur.left.key);
            dq.offerLast(cur.left);
          }
          if (cur.right != null) {
            res.add(cur.right.key);
            dq.offerLast(cur.right);
          }
        }else {
          TreeNode cur = dq.pollLast();
          if (cur.right != null) {
            res.add(cur.right.key);
            dq.offerFirst(cur.right);
          }
          if (cur.left != null) {
            res.add(cur.left.key);
            dq.offerFirst(cur.left);
          }
        }
      }
      level++;
    }
    return res;
  }
}

/* Time: O(n)  Space: O(n)
  
  Cannot singly use queue or stack
  use two-way queue to store the elements
  BFS
  so, for even level get from left, generate left first, add from the right
  for odd level get from right, generate right first, add from the left
  
  |3 8
*/
