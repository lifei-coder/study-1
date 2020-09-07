package leetcode;

import java.util.LinkedList;
import java.util.Stack;

public class Test1 {

    public static void main(String[] args) {
        System.out.println(isValid("{[]}"));
    }

    public static Integer test(String aa){
        StringBuffer param = new StringBuffer(aa);
        String a = "()";
        int count = 0;
        while(true){
            int index = param.indexOf(a);
            if(index == -1){
                break;
            }
            count+=a.length();
            param.delete(index,index+a.length());
        }
        return count;
    }



    static Stack<Character> stack = new Stack<>();

    public static boolean isValid(String s) {
        for (int i = 0; i < s.length(); i++) {
            char input = s.charAt(i);
            if (input == '(' || input == '{' || input == '[') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    Character top = stack.pop();
                    if ((input == ')' && top != '(') || (input == ']' && top != '[') || (input == '}' && top != '{') ) {
                        return false;
                    } else if ((input == ')' && top == '(') || (input == '}' && top == '{') || (input == ']' && top == '[')) {

                    } else {
                        stack.push(top);
                    }
                }
            }
        }
        return stack.isEmpty();
    }

}
