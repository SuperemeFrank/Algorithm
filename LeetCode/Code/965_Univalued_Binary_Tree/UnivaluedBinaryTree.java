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
    public boolean isUnivalTree(TreeNode root) {
        
        return helperFunc(root.val, root);
    }
    
    private boolean helperFunc(Integer preValue, TreeNode root) {
        if (root == null) {
            return true;
        }
                
        return root.val == preValue && helperFunc(root.val, root.left) && helperFunc(root.val, root.right);
    }
}

/*
Time: O(n)

Space: O(height)

*/