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
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        return isValidBST(root.left, min, (long)root.val - 1) && isValidBST(root.right, (long)root.val + 1, max) &&
                root.val >= min && root.val <= max;
    }
}

/*   Time: O(n)  Space: O(height)
    there's a boundary for each node,
    boundary of left subtree of root is [Min, root.key)
    Thus all the nodes are valid the BST can be valid
    
    1. get if left and right subtree are valid BST
    2. determine if current BST is valid
    3. return if current tree is valid BST

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