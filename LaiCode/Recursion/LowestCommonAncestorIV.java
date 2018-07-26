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
  public TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
    Set<TreeNode> set = new HashSet<>();
    for (int i = 0; i < nodes.size(); i++) {
      set.add(nodes.get(i));
    }
    return helper(root, set);
  }
  
  private TreeNode helper(TreeNode root, Set<TreeNode> set) {
    if (root == null) {
      return null;
    }
    if (set.contains(root)) {
      return root;
    }
    TreeNode left = helper(root.left, set);
    TreeNode right = helper(root.right, set);
    if (left != null && right != null) {
      return root;
    }else {
      return left == null ? right : left;
    }
  }
}

// Time: O(n) n is the total node in the tree  Space: O(k)  k is the target nodes
/*
  put nodes in a set
  1. left and right: the most closest node exists in the set or null
  2. if left and right are not null, return root
     if root exists in the set, return root
     if one null another not null, return not null
  3. return the above

*/