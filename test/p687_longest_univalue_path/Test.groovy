package p687_longest_univalue_path;

import spock.lang.Specification
import tw.lmr3796.easy.p687_longest_univalue_path.Solution
import tw.lmr3796.lib.binary_tree.TreeNode


class Test extends Specification {
    Solution s = new Solution()

    TreeNode treeOf(ArrayList<Integer> values, int i) {
        if (values == null || values.isEmpty()
                || values.size() <= i || values[i] == null) {
            return null
        }
        TreeNode root = new TreeNode(values[i])
        root.left  = treeOf(values, i * 2 + 1)
        root.right = treeOf(values, i * 2 + 2)

        return root
    }

    def 'test'() {
        given:
        TreeNode tree = treeOf(input as ArrayList, 0 as int)

        expect:
        s.longestUnivaluePath(tree) == ans

        where:
        ans | input
        0   | []
        0   | [1]
        2   | [1,4,5,4,4,5]
        2   | [5,4,5,1,1,5]
        4   | [26,26,26,26,26,24,26,25,25,25,27,23,25,25,27,24,26,24,26,24,24,null,28,null,null,26,null,null,26,26,28,25,null,25,27,null,null,null,null,null,23,null,null,29,27,null,null,null,null,25,null,27,27,24,26,24,26,26,26,null,22,28,null,26,26,null,null,26,null,28,28,25,null,null,null,25,25,25,27,25,25,27,25,null,null,null,null,null,null,null,27,27,27,null,null,27,29,24,26,26,26,null,26,null,26,null,null,null,24,24,24,null,26,24,26,null,null,null,26,null,null,null,28,null,30,null,23,27,null,null,null,null,null,null,null,null,null,null,null,23,25,25,25,27,25,23,25,null,null,null,null,null,null,29,null,null,null,26,null,22,null,null,26,24,26,null,26,28,null,null,26,22,null,null,null,null,null,null,null,null,null,null,25,23,null,null,null,null,27]
    }
}