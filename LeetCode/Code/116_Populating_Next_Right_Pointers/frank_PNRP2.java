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
        if (root == null) {
            return;
        }        
        TreeLinkNode start = root;  // restore the begin of each level to traverse
        while (start != null) {         
            TreeLinkNode cur = start;       // traverse point of each level
            while (cur != null) {
                if (cur.left != null && cur.right != null) {
                    cur.left.next = cur.right;
                }
                
                if (cur.left != null && cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            start = start.left;
        }
    }
}

// Traverse each level, and connect them