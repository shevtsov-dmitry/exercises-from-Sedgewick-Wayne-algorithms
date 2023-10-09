package chapter1.section3;

import java.util.Stack;

public class Q4ValidParentheses {
    public static void main(String[] args) {
        boolean b = isValid("()[]{}");
        System.out.println(b);
//        isValid("(]");

    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char currentChar : s.toCharArray()) {
            if(currentChar == '(' || currentChar == '[' || currentChar == '{'){
                stack.push(currentChar);
            }
            else if(stack.isEmpty()){
                return false;
            }
            else if(currentChar == ')' && stack.peek() == '('
                || currentChar == ']' && stack.peek() == '['
                || currentChar == '}' && stack.peek() == '{'){
                stack.pop();
            }
            else{
                return false;
            }

        }
        return stack.isEmpty();
    }
}