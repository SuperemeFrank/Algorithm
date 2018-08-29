
public class Solution {
  public int maxPathSum(TreeNode root) {
    
    int[] max = new int[1];
    max[0] = Integer.MIN_VALUE;
    helper(root, max);
    return max[0];
  }
  
  private int helper(TreeNode root, int[] max) {
    if (root == null) {
      return 0;
    }
    int left = helper(root.left, max);
    int right = helper(root.right, max);
    int sum = root.key;
    if (left < 0 && right < 0) {
      max[0] = max[0] > sum ? max[0] : sum;
      return root.key;
    }else {
      sum = left > right ? sum + left : sum + right;
      max[0] = max[0] > sum ? max[0] : sum;
      return left > right ? root.key + left : root.key + right;
    }
  }
}


/* Time: O(n)   Space: O(1)
  There must be no more than one transition for the path from one node to another
  we can maintain a globle max to record the max path sum
  each node can update the max sum
  1. get the max path from left and right child, inclusive
  2. calculate the max sum from current node to any node in its subtrees
  3. return the single path max sum include current node


*/