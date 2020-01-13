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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            if (root1 == null && root2 == null) {
                return true;
            }
            return false;
        }
        
        return root1.val == root2.val && (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right) || flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
    }
}

/*
Time: O (n)  because each node are unique, so each nodes will be compared one 

Space: O(k)  k is the height of the tree

    If current trees are flip equivalent, their children must be flip equivalent (a.left to b.left) or (a.left to b.right)
    
    1. get wheather either the a.left to b,left and a.right to b.right or a.left to b.right and a.riht to b.left are equivalent trees
    2. if the subtrees of current two nodes are somehow flip equivalent, consider whether current two nodes are equivalent
    3. return true if current nodes are equivalent and their subtrees are flip equivalent, otherwise false
    
*/