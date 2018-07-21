public TreeNode delete(TreeNode root, int target) {
	if (root == null) {
		return null;
	}
	// find target node
	if (root.val > target) {
		delete(root.left, target);
		return root;
	}else if (root.val < target) {
		delete(root.right, target);
		return root;
	}

	// root.val == target
	// case 1: deleteNode has one child or none
	if (root.left == null) {
		return root.right;
	} else if (root.right == null) {
		return root.left;
	}

	// case 2: if deleteNode has two children
	// case 2.1: if deleteNode.right.left == null, just take deleteNode.right.right to replace deleteNode
	if (root.right.left == null) {
		root.right.left = root.left;
		return root.right;
	}

	// case 2.2: 
	// 1. find and delete smallest node in root.right
	TreeNode smallest = deleteSmallest(root.right);
	// 2. connect the smallest node with root.left and root.right
	smallest.left = root.left;
	smallest.right = root.right;
	// 3. return the smallest node
	return smallest;
}

private TreeNode deleteSmallest(TreeNode cur) {
	TreeNode prev = cur;
	cur = cur.left;
	while (cur.left != null) {
		prev = cur;
		cur = cur.left;
	}
	// cur is the smallest one, and prev is its parent
	prev.left = prev.left.right;
	return cur;
}
