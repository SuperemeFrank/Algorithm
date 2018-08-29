class Solution {
	public boolean isCousins(TreeNode root, TreeNode a, TreeNode b) {
		if (root == null) {
			return false;
		}
		boolean[] res = new boolean[1];
		return res[0]; 
	}

	private int cousinHelper(TreeNode root, TreeNode a, TreeNode b, int level) {
		if (root == null) {
			return -1;
		}
		if (root == a || root == b) {
			return level;
		}
		int left = cousinHelper(root.left, a, b, level + 1, res);
		int right = cousinHelper(root.right, a, b, level + 1, res);
		if (left == right && left != level + 1) {
			res[0] = true;
		}
		return Math.max(left, right);
	}
}

/*  Time: O(n) n is the number of nodes, Space: O(height)
	1. get level of target node from children, if child tree not contain, return -1
	2. if both children contains target nodes, determine if they are at the same level, and they are not the children of current node
	3. return current if current not is target or target nodes are cousin
*/


class Solution {
  public boolean isCousins(TreeNode root, TreeNode a, TreeNode b) {
    
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    while (!q.isEmpty()) {
      int size = q.size();
      boolean flag = false;
      for (int i = 0; i < size; i++) {
        TreeNode node = q.poll();
        if (node.left == a || node.left == b) {
            if (flag) {
              return true;
            }else {
              flag = true;
            }
            if (node.right == a || node.right = b) {
              return false;
            } 
          }
        if (node.right == a || node.right == b) {
          if (flag) {
            return true;
          }else {
            flag = true;
          }
        }
        if (node.left != null) {
          q.offer(node.left);
        }
        if (node.right != null) {
          q.offer(node.right);
        }
      }
      flag = false;
    }
    return false;
  }
}

//  Time: O(n) n is the number of nodes, Space: O(number of nodes in the last level) ~ O(n/2) = O(n)  worst case
