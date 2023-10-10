package chapter1.section3;

import edu.princeton.cs.algs4.Queue;

import java.util.PriorityQueue;
import java.util.Stack;

public class Q6 {
    public static void main(String[] args) {
        Queue<String> q = new Queue<>();
        Stack<String> stack = new Stack<>();
        q.enqueue("STR");
        q.enqueue("STR");
        q.enqueue("STR");
        stack.push("FMT");
        stack.push("FMT");
        stack.push("FMT");
        while (!q.isEmpty())
            stack.push(q.dequeue());
        while (!stack.isEmpty())
            q.enqueue(stack.pop());
    }
}
