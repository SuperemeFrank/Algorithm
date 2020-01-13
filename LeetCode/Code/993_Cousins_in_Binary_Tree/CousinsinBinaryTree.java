/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//DF:
sclass Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null || root.val ==x || root.val == y) {
            return false;
        }
        
        return helperFunc(root, x, y) != -1;
    }
    
    
    private int helperFunc(TreeNode root, int x, int y) {
        if (root == null) {
            return -1;
        }
        
        
        
        int left = helperFunc(root.left, x, y);
        int right = helperFunc(root.right, x, y);
        
        if (root.val == x || root.val == y) {
            if (left != -1) {
                return -1;
            }else if (right != -1) {
                return -1;
            }else {
                return 0;
            }
            
        }
        
        if (left == -1 && right == -1) {
            return -1;
        }else if (left == -1) {
            return right + 1;
        }else if (right == -1) {
            return left + 1;
        }else {
            if (right == left && right != 0) {
                return right + 1;
            }
            return -1;
        }
    }
}


//BFS:
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (q.size() > 0) {
            int size = q.size();
            int existCount = 0;
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (cur.left != null && cur.right != null) {
                    if ((cur.left.val == x || cur.left.val == y) && (cur.right.val == x || cur.right.val == y)) {
                        return false;
                    }
                }
                if (cur.val == x || cur.val == y) {
                    existCount++;
                }
                
                if (existCount == 2) {
                    return true;
                }
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            if (existCount == 1) {
    return false;
}
        }
        return false;
    }
    
}



/*
Time: O(n)
Space: O(height)

    1. are they at the same level?
    2. do they have different parents?
    s
    
    1. get the depth of target nodes from left and right
    2. if both are not -1, compare if they are at the same level and their depth are not 0
    3. if (root.val == x,y && right != -1) || (root.val == x,y && right != -1), they are not cousin, return -1
    
        a (depth from left), b (depth from right)   -1 represents no target in the subtree or they are not cousin
        a != -1 && b != -1 : 
        if a == b and a != 0 , return a + 1;
        a == -1 && b != -1 (b == -1 the same)
        return b + 1;
        a == - 1 && b == -1 
        return -1;

*/