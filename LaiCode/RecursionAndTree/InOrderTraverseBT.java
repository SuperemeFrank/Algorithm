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
  public List<Integer> inOrder(TreeNode root) {
    
    List<Integer> res = new ArrayList<>();
    Deque<TreeNode> stack = new LinkedList<>(); 
    TreeNode curr = root;
    while (!stack.isEmpty() || curr != null) {
      while (curr != null) {
        stack.offerFirst(curr);
        curr = curr.left;
      }
      curr = stack.pollFirst();
      res.add(curr.key);
      curr = curr.right;
    }
    return res;
  }
}


/*
  left root right

  1. for each root, go left till the leaf
  2. print the leaf first
  3. if the leaf has right child, use the same process to traverse its right child
     if not, go back to its parent and do the 2 

*/