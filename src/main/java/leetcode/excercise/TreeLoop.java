package leetcode.excercise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeLoop {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    List<Integer> nums = new ArrayList<>();
    LinkedList<Node> stack = new LinkedList();

    public List<Integer> preorder(Node root) {
        if (root == null)
            return nums;

        stack.add(root);
        // 用栈来模拟数据的遍历
        while (!stack.isEmpty()) {
            Node o = stack.pollLast();
            nums.add(o.val);
            // 从右往左入栈。出栈顺序则是从左到右。
            for (int i = o.children.size() - 1; i >= 0; i--) {
                nums.add(o.children.get(i).val);
            }
        }
        return nums;
    }


}
