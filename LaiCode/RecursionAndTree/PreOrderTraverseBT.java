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
  public List<Integer> preOrder(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    Deque<TreeNode> stack = new LinkedList<>(); 
    TreeNode curr = root;
    while (!stack.isEmpty() || curr != null) {
      while (curr != null) {
        stack.offerFirst(curr);
        res.add(curr.key);
        curr = curr.left;
      }  
      curr = stack.pollFirst();
      curr = curr.right;
    }
    return res;
  }
}
