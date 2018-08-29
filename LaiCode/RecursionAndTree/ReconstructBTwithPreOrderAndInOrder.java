
public class Solution {
  public TreeNode reconstruct(int[] inOrder, int[] preOrder) {
    
    return helper(inOrder, preOrder, 0, preOrder.length - 1, 0, inOrder.length - 1);
  }
  
  private TreeNode helper(int[] inOrder, int[] preOrder,
                          int lpre, int rpre,
                          int lin, int rin) {
    if (lpre > rpre || lin > rin) {
      return null;
    }
    TreeNode root = new TreeNode(preOrder[lpre]);
    int rootPos = lin;
    for (int i = lin; i <= rin; i++) {
      if (inOrder[i] == root.key) {
        rootPos = i;
        break;
      }
    }
    int mid = (rootPos - lin) + lpre;
    root.left = helper(inOrder, preOrder, lpre + 1, mid, lin, rootPos - 1);
    root.right = helper(inOrder, preOrder, mid + 1, rpre, rootPos + 1, rin);
    
    return root;
  }
}

/* Time: O(n ^ 2)   Space: O(n)
  recursively partition the preorder and inorder array,
  the first node of preorder array should be the root of current tree
  the left of that node in inorder array should be the left subtree of current tree
  the right of that node in inorder array should be the right subtree of current tree
  
  1. get the root of left and right subtree
  2. link current root with right and left subtree, partition the preorder array and inorder array
  3. return the current root

*/