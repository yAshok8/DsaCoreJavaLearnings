package DSA.trees.bst;

public class TreeProblems {
    public static void main(String[] args) {
        TreeNode root = giveMeATree();

        System.out.println("check if BST is balanced");
        System.out.println(TreeOperations.isBalancedSquareNComplexity(root));

        System.out.println("traverse level order");
        TreeOperations.levelOrder(root);
        System.out.println();

        System.out.println("Level order traversal with list");
        System.out.println(TreeOperations.levelOrderWithListData(root));

        System.out.println("zigzag level order traversal");
        System.out.println(TreeOperations.zigzagLevelOrder(root));
    }

    private static TreeNode giveMeATree() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(1);
        root.left.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(4);
        return root;
    }


}
