package chapter1.section3;

import java.util.Stack;

public class Q10 {
    /*
    * Infix Expression: 3 + 4 * (5 - 2)

    Conversion to Postfix:

    Stack: [], Postfix: []
    Scan '3':
    Stack: [], Postfix: [3]
    Scan '+':
    Stack: ['+'], Postfix: [3]
    Scan '4':
    Stack: ['+'], Postfix: [3, 4]
    Scan '':
    Stack: ['+', ''], Postfix: [3, 4]
    Scan '(': (Push it onto the stack)
    Stack: ['+', '*', '('], Postfix: [3, 4]
    Scan '5':
    Stack: ['+', '*', '('], Postfix: [3, 4, 5]
    Scan '-':
    Stack: ['+', '*', '(', '-'], Postfix: [3, 4, 5]
    Scan '2':
    Stack: ['+', '*', '(', '-'], Postfix: [3, 4, 5, 2]
    Scan ')': (Pop operators from the stack until '(' is encountered and remove '(')
    Stack: ['+', '*'], Postfix: [3, 4, 5, 2, '-']
    Pop remaining operators from the stack:
    Stack: ['+'], Postfix: [3, 4, 5, 2, '-', '*']
    Pop the last operator:
    Stack: [], Postfix: [3, 4, 5, 2, '-', '*', '+']

    The postfix expression is: 3 4 5 2 - * +
    */

    public static void main(String[] args) {
        testParsing();
    }

    private static void testParsing() {
        String infix = "A + B * C + D";
        String postfix = infixToPostfix(infix);
        assert postfix.equals("ABC*+D+") : STR. "\{ infix } should be parsed to ABC*+D+ , but actual is \{ postfix }" ;

        infix = "3 + 4 * ( 5 - 2 )";
        postfix = infixToPostfix(infix);
        assert postfix.equals("3452-*+") : STR. "\{ infix } should be parsed to 3452-*+ , but actual is \{ postfix }" ;

        infix = "( (A + B ) – C * ( D / E ) ) + F";
        postfix = infixToPostfix(infix);
        assert postfix.equals("ABC*+D+") : STR. "\{ infix } should be parsed to ABC*+D+ , but actual is \{ postfix }" ;

    }

    public static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<String> stack = new Stack<>();
        String[] tokens = infix.split(" ");

        // write realization

        return postfix.toString();
    }

    public static int defineHierarchyLevel(String token) {
        int hierarchyLevel = -1;
        switch (token) {
            case "+", "-" -> hierarchyLevel = 0;
            case "*", "/" -> hierarchyLevel = 1;
            case "^" -> hierarchyLevel = 2; // ?
        }

        return hierarchyLevel;
    }
}
