package DSA.trees.bst;


class TreeOperations {
    public static boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        if (Math.abs(calcHeight(root.left) - calcHeight(root.right)) > 1)    
            return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private static int calcHeight(TreeNode node) {
        if (node == null) 
            return 0;
        return 1 + Math.max(calcHeight(node.left), calcHeight(node.right));
    }
}