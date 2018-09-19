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
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // if no children, current max is root.val
        if (root.left == null && root.right == null) {
            return root.val;
        }
        
        int leftLev1 = 0;
        int leftLev2 = 0;
        int rightLev1 = 0;
        int rightLev2 = 0;
        
        if (root.left != null) {
            leftLev1 = rob(root.left);
            leftLev2 = rob(root.left.left) + rob(root.left.right);
        }
        
        if (root.right != null) {
            rightLev1 = rob(root.right);
            rightLev2 = rob(root.right.left) + rob(root.right.right);
        }
        // rob lev1 or not
        return Math.max(leftLev1 + rightLev1, leftLev2 + rightLev2 + root.val);
    }
}

/*  Time: O(n)  Space: O(height)  n is the number of nodes
    DP two properties: optimal substructure + overlap subproblems
    
    for this problem, there are no overlap subproblems, so we can't use dp
    
    we just use recursion to solve this problem
    1. we get the largest benifits from left and the children of left nodes, the same to the right
       Thus for ith node, we get the maxBenifits of its next level and next next level
    2. we compare whether rob current node or not so that can get current max benifits
    3. return current max benefits
    
    

*/