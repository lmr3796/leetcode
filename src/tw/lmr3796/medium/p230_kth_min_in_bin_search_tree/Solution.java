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
