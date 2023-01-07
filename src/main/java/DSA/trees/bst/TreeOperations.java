package DSA.trees.bst;


import java.util.*;

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

    public static void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode head = queue.peek();
            if (head.left != null) {
                queue.add(head.left);
            }
            if (head.right != null) {
                queue.add(head.right);
            }
            System.out.print(queue.remove().val + " ");
        }
    }

    /**
     * Leetcode problem link:
     * https://leetcode.com/problems/binary-tree-level-order-traversal/
     * @param root the root element
     * @return The level order list
     */
    public static List<List<Integer>> levelOrderWithListData(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        res.add(Arrays.asList(root.val));
        List<TreeNode> nextLevelNodes = childrenOf(Arrays.asList(root));
        List<Integer> innerRes = null;
        while (nextLevelNodes.size() != 0) {
            innerRes = new ArrayList<>();
            for (TreeNode node: nextLevelNodes) {
                innerRes.add(node.val);
            }
            res.add(innerRes);
            nextLevelNodes = childrenOf(nextLevelNodes);
        }
        return res;
    }

    private static List<TreeNode> childrenOf(List<TreeNode> asList) {
        List<TreeNode> res = new ArrayList<>();
        for (TreeNode node: asList) {
            if (null != node.left) {
                res.add(node.left);
            }
            if (null != node.right) {
                res.add(node.right);
            }
        }
        return res;
    }

    /**
     * Leetcode 103
     * @param root the root node of the tree
     * @return the list of list of elements
     */
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        boolean flip = false;
        s.push(root);
        while (!s.isEmpty()) {
            Stack<TreeNode> temp = new Stack<>();
            List<Integer> tempList = new ArrayList<>();
            if (flip) {
                while (!s.isEmpty()) {
                    TreeNode node = s.pop();
                    tempList.add(node.val);
                    if (null != node.left)
                        temp.push(node.left);
                    if (null != node.right)
                        temp.push(node.right);
                }
            } else {
                while (!s.isEmpty()) {
                    TreeNode node = s.pop();
                    tempList.add(node.val);
                    if (null != node.right)
                        temp.push(node.right);
                    if (null != node.left)
                        temp.push(node.left);
                }
            }
            res.add(tempList);
            flip = !flip;
            s = temp;
        }
        return res;
    }
}