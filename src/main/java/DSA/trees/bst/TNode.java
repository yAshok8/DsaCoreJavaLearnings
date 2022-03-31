package DSA.trees.bst;

class TNode {
	
	public int val;
	public TNode left;
	public TNode right;
	
	public void addNode(int nodeVal) {
		addNode(this, nodeVal);
	}
	
	public TNode addNode(TNode root, int nodeVal) {
		if (root == null) {
			TNode node = new TNode();
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