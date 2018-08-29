
public class Solution { // better
  public TreeNode reconstruct(int[] post) {
    
    int index[] = {post.length - 1};
    
    return helper(post, index, Integer.MIN_VALUE);
  }
  
  private TreeNode helper(int[] post, int[] index, int lbaffle) {
    if (index[0] < 0 || post[index[0]] < lbaffle) {
      return null;
    }
    TreeNode root = new TreeNode(post[index[0]]);
    index[0] -= 1;
    root.right = helper(post, index, root.key);
    root.left = helper(post, index, lbaffle);
    return root;
  }
}


/* Time: O(n)  Space: O(height)

  we need a to record where the pointer traverse to 
  also we need a baffle to record the min value that can be inserted into current node 
  1. get the root from right and left child
  2. if the value node is valid, create new node for current
  3. return current node

*/

public class Solution {
  public TreeNode reconstruct(int[] post) {
    if (post.length == 0) {
      return null;
    }
    TreeNode root = new TreeNode(post[post.length - 1]);    
    helper(post, root, Integer.MIN_VALUE, post.length - 2);
    return root;
  }
  
  private int helper(int[] post, TreeNode root, int left, int index) {
    if (index < 0) {
      return -1;
    }
    int num = post[index];
    if (num > root.key) {
      root.right = new TreeNode(num);
      index = helper(post, root.right, root.key, index - 1);
    }
    if (index < 0) {
      return -1;
    }
    num = post[index];
    if (num > left) {
      root.left = new TreeNode(num);
      index = helper(post, root.left, left, index - 1);
    }
    
    return index;
  }
}


/* Time: O(n)  Space: O(height)

  we need a to record where the pointer traverse to 
  also we need a baffle to record the left 
  1. get the next index from right child
  2. if > current, create right node, if < current and > baffle, create left node
  3. return next traverse index

*/