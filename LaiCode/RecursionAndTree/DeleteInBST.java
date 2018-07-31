/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 */
public class Solution { // replace node delete
  public TreeNode delete(TreeNode root, int key) {
    if (root == null) {
      return null;
    }
    if (root.key > key) {
      root.left = delete(root.left, key);
    }else if (root.key < key) {
      root.right = delete(root.right, key);
    }else {
      if (root.left != null && root.right != null) {
        TreeNode right = root.right; 
        if (right.left == null) {
          right.left = root.left;
          return right;
        }else {
          while (right.left != null) {
            right = right.left;
          }
          delete(root.right, right.key);
          TreeNode newNode = new TreeNode(key); // replace node 
          newNode.left = root.left;
          newNode.right = root.right;
          return newNode;
        }
      }else {
        return root.left == null ? root.right : root.left;
      }  
    }
    return root;
  }
}
/* Time: O(height)  Space: O(height)
                      7
                    / 
                   3
                  / \ 
                 2   5
                /   / \ 
               1   4   6
                
    1. find the node we want to delete
    2. 
      case1: if the delete node has no child, just delete it
      case2: if has one child, replace delete node with its child node
      case3: if has both children
           3.1: if node.right has no left child, replace node with node.right
           3.2: if node.right has left child:
                 find the smallest node of node.right
                 replace the delNode with that node
                 delete that node with the same logic
    
    For recursion:
    1. get the roots from left and right subTree
    2. consider the above cases
    3. return current root
    
*/


class Solution2 { // value change delete
  public TreeNode delete(TreeNode root, int key) {
    if (root == null) {
      return null;
    }
    if (root.key > key) {
      root.left = delete(root.left, key);
    }else if (root.key < key) {
      root.right = delete(root.right, key);
    }else {
      if (root.left != null && root.right != null) {
        TreeNode right = root.right; 
        if (right.left == null) {
          right.left = root.left;
          return right;
        }else {
          while (right.left != null) {
            right = right.left;
          }
          root.key = right.key;
          delete(root.right, right.key);
        }
      }else {
        return root.left == null ? root.right : root.left;
      }  
    }
    return root;
  }
}



/* Time: O(height)  Space: O(height)
   
   same above 
*/