/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;
public class frank_MDBT{
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
    }
}
class Solution {
    public int minDepth(TreeNode root) {
        int res = 0;
        if (root == null) {
            return res;
        }
        //if a node has both child, the minDepth is the min of either child depth
        if (root.left != null && root.right != null) {
            res = Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        //Howver, if a node only has one child, its minDepth should be the longest child plus 1
        }else {
            res = minDepth(root.left) + minDepth(root.right) + 1;
        }
        return res;
    }
}

//Take care when using Traverse method. when the return type is basic type, it can not be changed even it's static data.