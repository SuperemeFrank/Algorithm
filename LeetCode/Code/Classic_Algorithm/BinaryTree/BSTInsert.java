// Recursion
public TreeNode insert(TreeNode root, int key) {
	if (root == null) { // the newNode should be a leaf node for BST
		TreeNode newRoot = new TreeNode(key);
		return newRoot;
	}
	if (root.key > key) {
		root.left = insert(root.left, key);
	}else if (root.key < key) { // if key exists do not insert it
		root.right = insert(root.right, key);
	}
	return root; // important to relink all the nodes
}


/*
	Time: O(height)  Space: O(height)
*/

// Iterative
public TreeNode insert(TreeNode root, int target) {
	TreeNode newNode = new TreeNode(target);
	if (root == null) {
		return newNode;
	}
	TreeNode current = root;
	while (current.key != target) {
		if (current.key > target) {
			if (current.left != null) {
				current = current.left;
			} else {
				current.left = newNode;
				break;
			}
		}else {
			if (current.right != null) {
				current = current.right;
			}else {
				current.right = newNode;
				break;
			}
		}
	}
	return root;
}

/*
	Time: O(height)  Space: O(1)
*/