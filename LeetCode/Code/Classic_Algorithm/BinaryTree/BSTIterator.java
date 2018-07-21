/*
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*next() and hasNext() should run in average O(1) time and uses O(h) memory, 
where h is the height of the tree.*/

public class BSTIterator {
    private TreeNode root = null;
    private Stack<TreeNode> stack = new Stack<>();
    public BSTIterator(TreeNode root) {
        TreeNode dummy = new TreeNode(0);
        dummy.right = root;
        stack.push(dummy);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        TreeNode node = stack.pop();
        if (node.right != null) {
            stack.push(node.right);
            node = node.right;
            while (node.left != null) {
                stack.push(node.left);
                node = node.left;
            }
        }
        
        if (stack.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    /** @return the next smallest number */
    public int next() {
        if (stack.peek() == null) {
            return -1;
        } else {
            return stack.peek().val;
        }
    }
}