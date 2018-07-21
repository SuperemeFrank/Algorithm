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
    int sum = 0;        // global variable to record the sum
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root, 0);
        return sum;
    }
    
    public void helper(TreeNode root, int num) {
        num = num * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += num;
        }
        
        if (root.left != null) {
            helper(root.left, num);
        }
        
        if (root.right != null) {
            helper(root.right, num);
        }
    }
}

//DFS