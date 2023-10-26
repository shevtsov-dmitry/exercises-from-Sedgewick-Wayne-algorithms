package chapter1.section3;

import java.util.Scanner;
import java.util.Stack;

public class Q9 {

    public static void main(String[] args) {
        // input:  1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )
        // desirable output: ( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) )
        // or ((1 + 2) * ((3 - 4) * (5 - 6)))
        String input = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";
        String result = addParentheses(input);
        System.out.println("result = " + result);
    }

    private static String addParentheses(String input) {
        var sb = new StringBuilder();
        var stack = new Stack<String>();
        String[] elements = input.split(" ");

        for (String el : elements) {
            if (el.equals(")")) {
                String operand2 = stack.pop();
                String operator = stack.pop();
                String operand1 = stack.pop();


                String expression = STR. "( \{ operand1 } \{ operator } \{ operand2 } ) " ;
                stack.push(expression);
            } else {
                stack.push(el);
            }
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }


        return sb.toString();
    }


}
