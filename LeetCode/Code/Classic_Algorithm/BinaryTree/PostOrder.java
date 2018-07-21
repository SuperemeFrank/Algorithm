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
        public List<Integer> postorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        Set<TreeNode> set = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.offerFirst(curr);
                curr = curr.left;
            }
            curr = stack.peekFirst();
            if ((curr.left == null || set.contains(curr.left)) && // to print
                (curr.right == null || set.contains(curr.right))) 
            {
                res.add(curr.val);
                set.add(curr);
                stack.pollFirst();
                curr = null; // prevent deadpool
            } else {
                curr = curr.right;
            }
        }
        return res;
    }
}