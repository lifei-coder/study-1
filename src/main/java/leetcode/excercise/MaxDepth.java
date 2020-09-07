package leetcode.excercise;

public class MaxDepth {

    class Node{
        int val;
        Node left;
        Node right;
        public Node(int x) {
            val = x;
        }
    }

    public int maxDept(Node n) {
        if (n == null) {
            return 0;
        } else {
            int left = maxDept(n.left);
            int right = maxDept(n.right);
            return Math.max(left, right) + 1;
        }
    }

}
