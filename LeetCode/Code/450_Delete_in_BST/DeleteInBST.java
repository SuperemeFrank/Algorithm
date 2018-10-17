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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        }
        
        if (root.left != null && root.right != null) {
            TreeNode rightNode = root.right;
            TreeNode replaceNode = findSmallest(rightNode);
            root.right = deleteNode(rightNode, replaceNode.val);
            replaceNode.left = root.left;
            replaceNode.right = root.right;
            return replaceNode;
            
        }else {
            return root.left != null ? root.left : root.right;
        }
    }
    
    private TreeNode findSmallest(TreeNode root) {
        while (root.left != null) root = root.left;
        
        return root;
    }
}

/* Time: O(height)  Space: O(height)

1. get the new head of subtree from left and right child
2. in current level, consider these 3 cases and reform the current head if in need
3. return the head of current tree

we use the smallest node of deleteNode.right to replace deleteNode
    case1: root has no child
    case2: root has one child
    case3: root has two children:
        find the smallest node, then delete that node in right tree of the root


*/