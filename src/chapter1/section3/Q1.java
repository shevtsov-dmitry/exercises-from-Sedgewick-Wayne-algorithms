package chapter1.section3;

import java.util.Random;

public class Q1 {

    public static void main(String[] args) {
        int N = 20;
        Random random = new Random();
        var stack = new FixedCapacityStackOfStrings(N);
        while (!stack.isFool()) {
            int randomIntValue = random.nextInt(100);
            stack.push(String.valueOf(randomIntValue));
        }

        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    private static class FixedCapacityStackOfStrings {
        private String[] a; // stack entries
        private final int cap;
        private int N; // size

        public FixedCapacityStackOfStrings(int cap) {
            a = new String[cap];
            this.cap = cap;
        }

        public boolean isEmpty() {
            return N == 0;
        }

        public boolean isFool() {
            return N > cap - 1;
        }

        public int size() {
            return N;
        }

        public void push(String item) {
            a[N++] = item;
        }

        public String pop() {
            return a[--N];
        }
    }
}
