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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int h = findHeight(root);
        System.out.println(countLastLevel(root));
        return (1 << h - 1) - 1 + countLastLevel(root);
        
    }
    
    public int countLastLevel(TreeNode root) {
        int h = findHeight(root);
        if (h == 1) {
            return 1;
        }
        
        int count = 0;
        if (findHeight(root.right) == h - 1) {
            count = 1 << h - 2;
            count += countLastLevel(root.right);
        }else {
            count = countLastLevel(root.left);
        }
        return count;
    }
    
    public int findHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return findHeight(root.left) + 1;
    }
}

/*
    idea:   if the height of root.right = root - 1, then root.left is complete tree; So we just need to calculate the
            nodes of last level and (1 << h - 1) - 1

    Time: O(height^2)  Space: O(1)
*/

