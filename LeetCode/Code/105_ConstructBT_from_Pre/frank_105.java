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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        
        List<Integer> preList = IntStream.of(preorder).boxed().collect(Collectors.toList());
        List<Integer> inList = IntStream.of(inorder).boxed().collect(Collectors.toList());

        TreeNode res = new TreeNode(preList.get(0));
        helper(preList, inList, res);
        return res;
    }
    
    public void helper(List<Integer> preList, List<Integer> inList, TreeNode root) {
        int listSize = preList.size();
        if (listSize == 0) {
            return;
        }
        int rootVal = root.val;
        int rootPos = inList.indexOf(rootVal);
        if (rootPos > 0) {
            int leftVal = preList.get(1);
            root.left = new TreeNode(leftVal);
            helper(preList.subList(1,rootPos + 1), inList.subList(0, rootPos), root.left);
        }
        
        if (rootPos < preList.size() - 1) {
            int rightVal = preList.get(1 + rootPos);
            root.right = new TreeNode(rightVal);
            helper(preList.subList(1 + rootPos, listSize), inList.subList(rootPos + 1, listSize), root.right);
        }
        
        
        
        
    }
    
}
//take care of the function subList, subList(0,1) only takes one number