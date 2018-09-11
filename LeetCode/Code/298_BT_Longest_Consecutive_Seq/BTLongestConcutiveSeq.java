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
    public int longestConsecutive(TreeNode root) {
        
        int[] max = new int[1];
        helper(root, max);
        return max[0];
    }
    
    private int helper(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int cur = 1;
        int left = helper(root.left, max);
        int right = helper(root.right, max);
        if (root.left != null && root.left.val == root.val + 1) {
            cur += left;
        }
        if (root.right != null && root.right.val == root.val + 1) {
            cur = Math.max(cur, right + 1);
        }
        max[0] = Math.max(max[0], cur);
        return cur;
    }
}

/*  Time: O(n)  Space: O(height)   n is the total nodes of the tree
    1. get the longest length of consecutive path from children
    2. if current is 1 smaller than child, the current node is part of the path
    3. return the longest path including current 
*/