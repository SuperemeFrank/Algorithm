
public class Solution {
  public TreeNode reconstruct(int[] inOrder, int[] levelOrder) {
    
    return helper(inOrder, levelOrder, 0, 0, inOrder.length - 1);
  }
  
  private TreeNode helper(int[] inOrder, int[] levelOrder,
                          int index, int left, int right) {
    if (left > right) {
      return null;
    }
    TreeNode root = new TreeNode(levelOrder[index]);
    int inPos = left;
    for (int i = left; i <= right; i++) {
      if (inOrder[i] == root.key) {
        inPos = i;
        break;
      }
    }
    Set<Integer> lSet = new HashSet<>(); 
    Set<Integer> rSet = new HashSet<>();
    for (int i = left; i <= right; i++) {
      if (i < inPos) {
        lSet.add(inOrder[i]);
      }else if (i > inPos) {
        rSet.add(inOrder[i]);
      }
    }
    for (int i = index + 1; i < levelOrder.length; i++) {
      if (lSet.contains(levelOrder[i])) {
        root.left = helper(inOrder, levelOrder, i, left, inPos - 1);
        break;
      }
    }
    for (int i = index + 1; i < levelOrder.length; i++) {
      if (rSet.contains(levelOrder[i])) {
        root.right = helper(inOrder, levelOrder, i, inPos + 1, right);
        break;
      }
    }
    return root;
  }
}  

/* Time: O(n ^ 2)  Space: O(n)
  partition the left and right subtree
  The first element of levelOrder should be the root of current tree
  
  1. get the root of left and right subtree
  2. partition the left elements  and right elements of the current root
  3. return root;

*/