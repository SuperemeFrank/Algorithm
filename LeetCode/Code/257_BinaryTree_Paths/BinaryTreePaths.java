/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        // Corner Case
        if (root == null) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        dfsHelper(res, root, "");
        return res;
    }
    
    private void dfsHelper(List<String> res, TreeNode root, String prefix) {
        if (root.left == null && root.right == null) {
            prefix = prefix + root.val;
            res.add(prefix.toString());
            return;
        }
        prefix = prefix + root.val + "->";
        if (root.left != null) {
            dfsHelper(res, root.left, prefix);
        }
        if (root.right != null) {
            dfsHelper(res, root.right, prefix);
        }
    }
}
// Time: O(n)   Space: O(height)