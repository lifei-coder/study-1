package leetcode.excercise;

public class CheckBST {


    class TreeNode{
        int val;
        TreeNode left;
        TreeNode  right;
        public TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST(TreeNode node) {
        return isBST(node, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isBST(TreeNode node, long minValue, long maxValue) {
        if (node == null)
            return true;

        if (node.val < minValue)
            return false;

        if (node.val > maxValue)
            return false;

        if (!isBST(node.left, minValue, node.val))
            return false;
        if (!isBST(node.right, node.val, maxValue))
            return false;

        return true;
    }


}
