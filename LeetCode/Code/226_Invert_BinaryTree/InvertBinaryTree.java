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
    public TreeNode invertTree(TreeNode root) {
        // TODO: corner case
        if (root == null) {
            return root;
        }
        TreeNode node = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(node);
        
        return root;
    }
}


// Time: O(n)  Space: O(height)