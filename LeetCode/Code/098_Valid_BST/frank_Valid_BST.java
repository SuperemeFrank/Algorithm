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
    public boolean isValidBST(TreeNode root) {
        boolean res = true;
        if (root == null) {
            return res;
        }
        List<Integer> searchRes = new ArrayList<>();
        helper(root,searchRes);
        for (int i = 0; i < searchRes.size() - 1; i++) {
            if (searchRes.get(i) >= searchRes.get(i + 1)) {
                res = false;
            }
        }
        return res;
    }
    
    public void helper(TreeNode root, List<Integer> searchRes) {
        if (root == null) {
            return;
        }
        helper(root.left, searchRes);
        searchRes.add(root.val);
        helper(root.right, searchRes);
    }
}