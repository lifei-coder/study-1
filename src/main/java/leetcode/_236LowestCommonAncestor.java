package leetcode;

import apple.laf.JRSUIUtils;

/**
 *
 * @author lifei1@songguo7.com
 * @date 2022/2/18 10:30
 */
public class _236LowestCommonAncestor {

    /**
     * 二叉树的最近公共祖先, 寻找p和q的最近公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == q | root == p) {
            return root;
        }
        // 要点: 后序遍历
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 情况1: 如果p和q都在以root为根的树中，那么left和right一定分别是p和q
        if (left != null && right != null) {
            return root;
        }
        // 情况2: 如果p和q都不在以root为根的树中，直接返回null
        if (left == null && right == null) {
            return null;
        }
        // 情况3:，如果p和q只有一个存在于root为根的树中，函数返回该节点
        return left == null ? right : left;
    }



    class TreeNode {
        public TreeNode left;
        public TreeNode right;
        public int val;

    }

}
