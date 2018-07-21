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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<Integer>(), sum, root);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> list, int target, TreeNode root) {
        if (root == null) {
            return;
        }
        
        list.add(root.val);
        if (root.left == null && root.right == null && target == root.val) {       //if its the leaf node, and the sum == target
            res.add(new ArrayList<>(list));
        }  
        helper(res, list, target - root.val, root.left);
        helper(res, list, target - root.val, root.right);
        list.remove(list.size() - 1);
    }
}