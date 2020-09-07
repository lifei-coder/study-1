package leetcode.excercise;

import java.util.Stack;

public class LongestValidParentheses {

    public static void main(String[] args) {
        LongestValidParentheses test = new LongestValidParentheses();
        test.longestValidParentheses(")()())");
    }

    public int longestValidParentheses(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (a == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }

}
