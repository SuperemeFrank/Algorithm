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
  public TreeNode lowestCommonAncestor(TreeNode root,
      TreeNode one, TreeNode two) {
    if (root == null) {
      return root;
    }
    if (root == one || root == two) {
      return root;
    }
    TreeNode left = lowestCommonAncestor(root.left, one, two);
    TreeNode right = lowestCommonAncestor(root.right, one, two);
    if (left != null && right != null) {
      return root;
    }else {
      return left == null ? right : left;
    }
  }
}
// Time: O(n) Space: O(height)

/*
  case1: one if the ancestor of another
  case2: they have exclusive ancestor
  
  current root:
    case 1: root is one or two, return root
    case 2: onechild return one or two
        2.1: another child return another:
          return root
        2.2: another child return null:
          return one or two
    case 3: both return null
          return null
    case 4: one child return not null, one, two; another return null
          return not null child
*/
    
