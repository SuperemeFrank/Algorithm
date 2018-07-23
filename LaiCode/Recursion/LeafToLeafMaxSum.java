class Solution {
	int max = Integer.MIN_VALUE;
	public int maxSum(TreeNode root) {
		helper(root);
		return max;
	}

	private int helper(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return root.val;
		}
		int left = helper(root.left);
		int right = helper(root.right);
		if (root.left == null || root.right == null) {
			return root.left == null ? (right + root.val) : (left + root.val);
		}
		max = Math.max(max, left + right + root.val);
		return Math.max(left, right) + root.val;
	}
}



/*
	1. what do u want from lchild, rchild ?
		max root-leaf sum 
	2. what do u do in current level ?
		get the leaf to leaf maxSum of current node, and update the globle max
		(note: if node only have one child, it cannot update gmax)
	3. what do u return to parent ?
		return  the max root-leaf to parent

*/