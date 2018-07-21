/*
  Check if a given binary tree is completed. 
  A complete binary tree is one in which every level of the binary tree is
   completely filled except possibly the last level. 
   Furthermore, all nodes are as far left as possible.
*/
public class Solution {
  public boolean isCompleted(TreeNode root) {
    // Write your solution here
    //corner case
    if (root == null) {
      return true;
    }
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    boolean flag = false; // the flag means there should be no child afterwards
    while (!q.isEmpty()) {
      TreeNode node = q.poll();
      if (node.left == null) {
        flag = true;
      }else if (flag) {
        return false;
      }else {
        q.offer(node.left);
      }
      
      if (node.right == null) {
        flag = true;
      }else if (flag) {
        return false;
      }else {
        q.offer(node.right);
      }
    }
    return true;
  }
}

/*
  Time: O(n)  Space: O(n)
*/