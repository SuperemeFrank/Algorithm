public class Solution {
  public int largestSmaller(TreeNode root, int target) {
    
    return helper(root, target, Integer.MIN_VALUE);
  }
  private int helper(TreeNode root, int target, int ls) {
    if (root == null) {
      return ls;
    }
    if (root.key >= target) {
      return helper(root.left, target, ls);
    }else {
      return helper(root.right, target, root.key);
    }
  }
}

/* Time: O(logn)  Space: O(logn)
  1. from left or right child, get the largestSmaller element
  2. maintain a buffle to keep currently largestSmaller element,
     Case 1: if target <= root.key, go left
     Case 2: if target > root.key, go right, update largestSmaller
     Case 3: root == null, return largestSmaller
  3. return current largestSmaller
*/


class Solution2 { // Traverse
  public int largestSmaller(TreeNode root, int target) {
    
    int[] ls = new int[1];
    ls[0] = Integer.MIN_VALUE;
    helper(root, target, ls);
    return ls[0];
  }
  
  private void helper(TreeNode root, int target, int[] ls) {
    while (root != null) {
      if (target > root.key && 
          ((long)target - root.key) < ((long)target - ls[0])) {
        ls[0] = root.key;
      }
      if (root.key >= target) {
        root = root.left;
      }else {
        root = root.right;
      }
    }
  }
}

/* Time: O(logn)  Space: O(1)
  mainTain a globle largestSmaller(ls),
  if the ls exists, it must in the traverse root
  when root.key == target, we go left
*/