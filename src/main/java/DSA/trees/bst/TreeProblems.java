package DSA.trees.bst;

import java.util.List;

public class TreeProblems {
    public static void main(String[] args) {
        TreeNode root = giveMeATree();

        //check if BST is balanced
//        System.out.println(TreeOperations.isBalancedSquareNComplexity(root));

        //traverse level order
//        TreeOperations.levelOrder(root);

        //Level order traversal with list
        List<List<Integer>> ans = TreeOperations.levelOrderWithListData(root);
        System.out.println(ans);
    }

    private static TreeNode giveMeATree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);
        return root;
    }


}
