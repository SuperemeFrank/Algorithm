class Solution {
    public int closestValue(TreeNode root, double target) {
        
        int[] res = {root.val};
        helper(root, res, target);
        return res[0];
    }
    
    private void helper(TreeNode root, int[] res, double target) {
        if (root == null) {
            return;
        }
        res[0] = Math.abs(res[0] - target) > Math.abs(root.val - target) ? root.val : res[0];
        if (root.val > target) {
            helper(root.left, res, target);
        }
        
        if (root.val < target) {
            helper(root.right, res, target);
        }
    }
}

// Time: O(n). Space: O(1)


class Solution {
    public int closestValue(TreeNode root, double target) {
        
        return helper(root, target);
    }
    
    private int helper(TreeNode root, double target) {
        
        if (root.val > target && root.left != null) {
            int num = helper(root.left, target);
            return Math.abs(num - target) < Math.abs(root.val - target) ? num : root.val;
        }
        
        if (root.val < target && root.right != null) {
            int num = helper(root.right, target);
            return Math.abs(num - target) < Math.abs(root.val - target) ? num : root.val;
        }
        
        return root.val;
    }
}

// Time: O(n). Space: O(1)
// 1. the closest number .   
//2. compare the closest number from child with current, return the closest number
// 3. return the closest number to parent