package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LC988SmallestStringStartingFromLeaf {
    private static List<String> allStrs = new ArrayList<>();

    public static void main(String[] args) {
/*        TreeNode root = new TreeNode(25);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(2);*/

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

/*        TreeNode root = new TreeNode(25, new TreeNode(1, new TreeNode(1, null, null), new TreeNode(3, null, null)),
                new TreeNode(3, new TreeNode(0, null, null), new TreeNode(2, null, null)));*/
        System.out.println(smallestFromLeaf(root));
    }

    private static String smallestFromLeaf(TreeNode root) {
        dfs(root, "");
        allStrs.sort(Comparator.naturalOrder());
        return allStrs.get(0);
    }

    private static void dfs(TreeNode root, String currStr) {
        if (root == null) return;
        currStr += (char)('a' + root.val);
        if (root.left == null && root.right == null) {
            allStrs.add(new StringBuilder(currStr).reverse().toString());
            return;
        }
        dfs(root.left, currStr);
        dfs(root.right, currStr);
    }
}
