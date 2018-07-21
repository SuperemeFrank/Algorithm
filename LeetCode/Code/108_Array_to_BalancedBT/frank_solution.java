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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        TreeNode res = helper(nums, 0, nums.length - 1);
        return res;
        
    }
    
    public TreeNode helper(int[] nums, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return null;
        }
        int mid = (startIndex + endIndex)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, startIndex, mid - 1);
        root.right = helper(nums, mid + 1, endIndex);
        return root;
        
    }
}