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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) {
            return null; 
        }
        if (inorder.length != postorder.length || inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        List<Integer> inList = IntStream.of(inorder).boxed().collect(Collectors.toList());
        List<Integer> postList = IntStream.of(postorder).boxed().collect(Collectors.toList());
        int rootVal = postList.get(postList.size() - 1);
        TreeNode res = new TreeNode(rootVal);
        helper(inList, postList, res);
        return res;
    }
    
    public void helper(List<Integer> inList, List<Integer> postList, TreeNode root) {
        int rootPos = inList.indexOf(root.val);
        int listSize = inList.size();
        if (listSize == 0) {
            return;
        }
        if (rootPos > 0) {
            int leftVal = postList.get(rootPos - 1);
            TreeNode leftNode = new TreeNode(leftVal);
            root.left = leftNode;
            helper(inList.subList(0, rootPos), postList.subList(0, rootPos), leftNode);
        }
        
        if (rootPos < listSize - 1) {
            int rightVal = postList.get(listSize - 2);
            TreeNode rightNode = new TreeNode(rightVal);
            root.right = rightNode;
            helper(inList.subList(rootPos + 1, listSize), postList.subList(rootPos, listSize - 1), rightNode);
        }
    }
}