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
    public boolean isBalanced(TreeNode root) {
        
        return balanceHelper(root) != -2; 
    }
    
    private int balanceHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = balanceHelper(root.left);
        int right = balanceHelper(root.right);
        if (Math.abs(right - left) > 1 || right == -2 || left == -2) {
            return -2;
        }
        return Math.max(right, left) + 1;
    }
}

/*  Time: O(n)  Space: O(height)
    1. get if left and right subtree is balanced, and their height
    2. in current, determine if the current tree is balanced and calculate its current height
    3. return balanced and height
    
    if current tree is not balanced, set its height to be -1
*/

class ResultType{
    public boolean isBalanced;
    public int maxDepth;
    public ResultType(boolean isBalanced, int maxDepth) {
        this.isBalanced = isBalanced;
        this.maxDepth = maxDepth;
    }
}
class Solution {
    public boolean isBalanced(TreeNode root) {
        return helper(root).isBalanced;
    }
    
    public ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(true, 0);
        }
        boolean isBalanced;
        int maxDepth;
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        isBalanced = left.isBalanced && right.isBalanced && (Math.abs(left.maxDepth - right.maxDepth) <= 1);
        maxDepth = Math.max(left.maxDepth, right.maxDepth) + 1;
        return new ResultType(isBalanced, maxDepth);
    }
}
//We need multiple return values, so we define a ResultType-----(Divided & Conquer solotion)
//We also can conbine D&C and Traverse together to solve this problem

