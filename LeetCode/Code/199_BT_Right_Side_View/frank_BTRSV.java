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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (! q.isEmpty()) {
            TreeNode node = q.peek();
            res.add(node.val);  // only add the first node of each level
            int size = q.size();
            for (int i = 0; i < size; i ++) { // poll all the nodes in the same level, and add their children
                node = q.poll();
                if (node.right != null) {
                    q.offer(node.right);
                }
                if (node.left != null) {
                    q.offer(node.left);
                }
            }
            
        }
        return res;
    }
}