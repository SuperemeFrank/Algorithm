/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root ==  null || root.left == null || root.right == null) {
            return;
        }
        helper(root);
        return;
    }
    //linked the node of left tree and the gap between left and right tree, then linked the node in right tree.
    public void helper(TreeLinkNode root) {
        
        if (root.left == null || root.right == null) {
            return;
        }
        
        root.left.next = root.right;    
        if (root.next != null) {        // link the node's right child with its next node's left child
            root.right.next = root.next.left;
        }
        
        helper(root.left);
        helper(root.right);
    }
}

// each level we traverse, the linked relationship has already been developed 