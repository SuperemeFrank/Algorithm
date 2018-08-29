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
  public TreeNode reverse(TreeNode root) {
    if (root == null) {
      return null;
    }
    if (root.left == null) {
      return root;
    }
    TreeNode newHead = reverse(root.left);
    TreeNode node = root.left;
    node.left = root;
    node.right = root.right;
    root.left = null;
    root.right = null;
    return newHead;
  }
}



/* Time: O(height)  Space: O(height)
                      1
                    /   \  
                -------  5
                  2     
                 /  \  
                3    4

    1. get the newHead of the tree from left child 
    2. reverse the nodes at current node
       
       node.left.right = node.right
       node.left.left  = node
       node.left = null
       node.right = null
    3. return the newHead got from left child
*/