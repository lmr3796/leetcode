package tw.lmr3796.easy.p671_2nd_min_in_binary_tree;


import tw.lmr3796.lib.binary_tree.TreeNode;

public class Solution {
    static final int INVALID = -1;
    int search(TreeNode node, int min, int secondMin) {
        if (node == null) {
            return INVALID;
        } else if (node.val > min) {
            return secondMin == INVALID
                    ? node.val
                    : Math.min(node.val, secondMin);
        }


        int left = node.left == null ? INVALID : search(node.left, min, secondMin);
        int right = node.right == null ? INVALID : search(node.right, min, secondMin);

        if (left == INVALID && right == INVALID) {
            return INVALID;
        } else if (left != INVALID && right != INVALID) {
            return Math.min(left, right);
        } else {
            return Math.max(left, right);
        }
    }
    public int findSecondMinimumValue(TreeNode root) {
        return search(root, root.val, -1);
    }
}
