package DSA.trees.bst;


class TreeOperations {

    public static boolean isBalancedLinearComplexity(TreeNode root) {
        if (null == root) {
            return true;
        }
        return checkIfBalanced(root) != -1;
    }

    private static int checkIfBalanced(TreeNode node) {
        if (null == node)
            return 0;
        int leftHeight = checkIfBalanced(node.left);
        int rightHeight = checkIfBalanced(node.right);
        int bf = Math.abs(leftHeight - rightHeight);
        if (bf > 1 || leftHeight == -1 || rightHeight == -1)
            return -1;
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static boolean isBalancedSquareNComplexity(TreeNode root) {
        if (root == null)
            return true;
        if (Math.abs(calcHeight(root.left) - calcHeight(root.right)) > 1)    
            return false;
        return isBalancedSquareNComplexity(root.left) && isBalancedSquareNComplexity(root.right);
    }

    private static int calcHeight(TreeNode node) {
        if (node == null) 
            return 0;
        return 1 + Math.max(calcHeight(node.left), calcHeight(node.right));
    }
}