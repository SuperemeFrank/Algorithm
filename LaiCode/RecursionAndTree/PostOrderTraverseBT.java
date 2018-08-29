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
  public List<Integer> postOrder(TreeNode root) {
    
    Deque<TreeNode> stack = new ArrayDeque<>();
        Set<TreeNode> set = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.offerFirst(curr);
                curr = curr.left;
            }
            curr = stack.peekFirst();
            if (curr.right == null || set.contains(curr.right)) 
            {
                res.add(curr.key);
                set.add(curr);
                stack.pollFirst();
                curr = null; // prevent deadpool
            } else {
                curr = curr.right;
            }
        }
        return res;

  }
}


/* Time: O (n)  Space: O(n)
  left right root
  the key point is that:
  if           5  
             /  \
            3    8
             \
              1    
   for each subtree we cannot directly pop the root out of stack, 
   because the root is the last node to print. However, if we do not
   pop it, there might be a dead loop.
   
   So use a set to track the printed elements
*/