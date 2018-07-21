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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean zigSign = true;
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (zigSign) {
                    levList.add(node.val);
                }else {
                    levList.add(0, node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            zigSign = zigSign ? false : true;
            res.add(levList);
        }
        return res;
    }
}

//just set a sign to do the back and force
//If it reverses, just insert the value to the head of the Arraylist