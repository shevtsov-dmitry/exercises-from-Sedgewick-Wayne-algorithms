package chapter1.section3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

public class Q5 {
    public static void main(String[] args) {
        int N = 50;
        Stack<Integer> stack = new Stack<Integer>();
        while (N > 0) {
            stack.push(N % 2);
            N = N / 2;
        }
        for (int d : stack) StdOut.print(d);
        StdOut.println();
    }
}
