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