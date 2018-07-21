class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        // corner case
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right; // 当且仅当curr.right != null 时，前一个while loop才会执行
        }
        return res;
    }
}


 /*InOder 遍历方法
 1. 将当前节点所有左子节点加入stack
 2. 当前节点没有左子节点，将当前节点加入到res中
 3. 当前节点的右节点作为当前节点，重复1
*/