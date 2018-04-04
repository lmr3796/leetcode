package p671_2nd_min_in_binary_tree;

import spock.lang.Specification
import tw.lmr3796.easy.p671_2nd_min_in_binary_tree.Solution
import tw.lmr3796.easy.p671_2nd_min_in_binary_tree.TreeNode
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
        s.findSecondMinimumValue(tree) == ans

        where:
        ans | input
//        -1  | []
//        -1  | [1]
//        -1  | [2, 2, 2, 2, 2, null, null]
        5   | [2,2,5,null,null,5,7]
    }
}