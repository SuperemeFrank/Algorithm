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
        helper(root);
        return;
    }
    
    public void helper(TreeLinkNode root) {
        TreeLinkNode start = root;
        while (start != null) {
            TreeLinkNode cur = start;
            while (cur != null) {
                if (cur.left != null && cur.right != null) {
                    cur.left.next = cur.right;
                }
                
                if (cur.next != null && (cur.left != null || cur.right != null)) {
                    TreeLinkNode node = cur.right != null ? cur.right : cur.left;
                    TreeLinkNode curNext = cur.next;
                    while (curNext != null) {           // The neighbour node might not have children, 
                                                        //so find the first neighbour which has at least one child
                        if (curNext.left != null || curNext.right != null) {
                            node.next = curNext.left != null ? curNext.left : curNext.right;
                            break;
                        } 
                        curNext = curNext.next;
                    }
                }
                
                cur = cur.next;
            }
            while (start != null && start.left == null && start.right == null) { // find the start point
                start = start.next;
            }
            
            if (start != null) {
                start = start.left != null ? start.left : start.right;
            }
        }
    }
}  


// It's not a perfect tree, so DFS cannot be used.
// The start should be the child of the first node that has child