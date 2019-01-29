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
    TreeNode res = null;
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        //corner case
        
        if (root == null || root.left == null) return root;
        
        TreeNode returnNode = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return returnNode;
    }
}

// Time: O(logn)  Space: O(logn)