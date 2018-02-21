package tw.lmr3796.medium.p94_bin_tree_inorder_traversal;
import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> ans = inorderTraversal(root.left);
        ans.add(root.val);
        ans.addAll(inorderTraversal(root.right));
        return ans;
    }
}
