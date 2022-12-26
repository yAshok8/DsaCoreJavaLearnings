package DSA.trees.bst;

class TreeNode {
	
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode() {}
	public TreeNode(int val) {
		this.val = val;
	}

	public void addNode(int nodeVal) {
		addNode(this, nodeVal);
	}
	
	public TreeNode addNode(TreeNode root, int nodeVal) {
		if (root == null) {
			TreeNode node = new TreeNode();
			node.val = nodeVal;
			return node;
		}

		if (root.val < nodeVal) {
			root.right = addNode(root.right, nodeVal);
		} else {
			root.left = addNode(root.left, nodeVal);
		}
		
		return root;
	}
	
}