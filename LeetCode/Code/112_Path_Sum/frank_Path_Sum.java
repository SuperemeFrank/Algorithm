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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        int subSum = sum - root.val;
        if (subSum == 0 && root.left== null && root.right == null) {
            return true;
        }
        
        
        
        return hasPathSum(root.left, subSum) || hasPathSum(root.right, subSum);
        
    }
}