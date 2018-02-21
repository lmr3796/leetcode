package tw.lmr3796.medium.p230_kth_min_in_bin_search_tree;

import java.util.ArrayList;

public class Solution {
    void inOrderTraversal(TreeNode root, ArrayList<Integer> queue, int limit) {
        if (queue.size() >= limit) {
            return;
        }
        if (root.left != null) {
            inOrderTraversal(root.left, queue, limit);
        }
        if (queue.size() < limit) {
            queue.add(root.val);
        }
        if (root.right != null) {
            inOrderTraversal(root.right, queue, limit);
        }
    }
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> values = new ArrayList<>();
        inOrderTraversal(root, values, k);
        return values.get(k-1);
    }
}
