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
    public RT minDep = new RT(Integer.MAX_VALUE);
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        helper(root, minDep, 1);
        return minDep.res;
    }
    
    public void helper(TreeNode root, RT minDep, int currDepth) {
        if(root == null) {
            return;
        }
        
        if(root.left == null && root.right == null) {

            if(currDepth < minDep.res) {
                
                minDep.res = currDepth;
            }
        }
        helper(root.left, minDep, currDepth + 1);
        helper(root.right, minDep, currDepth + 1);
    }
}
class RT {
    public int res;
    public RT(int res) {
        this.res = res;
    }
}

//Due to the return type is int, which cannot be changed in recursion function, we need to define a ResultType RT