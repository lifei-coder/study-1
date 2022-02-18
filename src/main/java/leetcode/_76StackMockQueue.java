package leetcode;

import java.util.Stack;

/**
 * 用两个栈来模拟实现队列的功能
 * @author lifei1@songguo7.com
 * @date 2022/2/17 15:04
 */
public class _76StackMockQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    private void put(int val) {
        stack1.push(val);
    }

    private Integer get() {
        if (!stack1.empty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }
        return null;
    }
}
