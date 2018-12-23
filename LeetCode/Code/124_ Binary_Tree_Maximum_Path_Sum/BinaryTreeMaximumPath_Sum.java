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
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] res = {Integer.MIN_VALUE};
        getMaxPathSum(root, res);
        return res[0];
    }
    
    private int getMaxPathSum(TreeNode root, int[] res) {
        if (root == null)
            return 0;
        
        int left = getMaxPathSum(root.left, res);
        int right = getMaxPathSum(root.right, res);
        
        int max = root.val;
        if (left > 0)
            max += left;
        
        if (right > 0)
            max += right;
        
        res[0] = Math.max(res[0], max);
        
        int tmp = Math.max(left, right);
        if (tmp > 0)
            return root.val + tmp;
        else 
            return root.val;
        
    }
}


/*  Time: O(n)  Space: O(hight)
    The path can have at most one transition
    We can recusivly get the max sum if treat each node as the transition node, then get the max path sum
    
    1. get the max left and right children path sum from the children of root
    2. let the current root as transition node, get the largest path sum of it
    3. return the largest left path sum or right path sum


*/