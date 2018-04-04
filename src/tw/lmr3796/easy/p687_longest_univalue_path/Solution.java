package tw.lmr3796.easy.p687_longest_univalue_path;

import tw.lmr3796.lib.binary_tree.TreeNode;

public class Solution {
    int searchAlong(TreeNode node, TreeNode parent) {
        if (node == null || node.val != parent.val) {
            return 0;
        }
        return 1 + Math.max(searchAlong(node.left, node) , searchAlong(node.right, node));
    }

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int withoutRoot = Math.max(longestUnivaluePath(root.left), longestUnivaluePath(root.right));
        return Math.max(withoutRoot, searchAlong(root.left, root) + searchAlong(root.right, root));
    }
}
