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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        
        TreeNode succ = null;
        while (root != null) {
            if (root.val <= p.val) {
                root = root.right;
            }else if (root.val > p.val) {
                succ = root;
                root = root.left;
            }
        }
        return succ;
    }
}

/* Time: O(height)  Space: O(1)
    
    To find the succesor in BST of the target is acctually to find the smallest node that is larger than target
*/

class Solution2 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return inorderSuccessor(root, p, false);
    }
    
    private TreeNode inorderSuccessor(TreeNode root, TreeNode p, boolean hasParent) {
        if (root == null) {
            return root;
        }
        if (root == p) {
            if (p.right == null) {
                return null;
            }else {
                TreeNode pRight = p.right;
                while (pRight.left != null) {
                    pRight = pRight.left;
                }
                return pRight;
            }
        }
        TreeNode left = inorderSuccessor(root.left, p, true);
        TreeNode right = inorderSuccessor(root.right, p, true);
        
        if (root.left == p && left == null) {
            return root;
        }
        if (root.right == p && right == null && hasParent) {
            return p;
        }
        if (left == p) {
            return root;
        }
        return left != null ? left : right;
    }
}

/*  Time: O(n)   Space: O(height)     This is a general solution for BT

    1. get the successor from left or right subtree if exists
    2. 
        1.0 if current node is target, return the left most node of its right subtree or null
        2.0 if target is the children of current
            2.1: if target is left child, and target has no right child, current is the successor
            2.2: if target is right child, and target has no right child, return target
    3. if no result from children, return null, else return non-null child


*/