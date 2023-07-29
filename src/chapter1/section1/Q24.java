package chapter1.section1;

import java.util.Scanner;

public class Q24 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("COUNT GCD \n");
        System.out.print("enter first number: ");
        int p = scanner.nextInt();
        System.out.print("Enter second one: ");
        int q = scanner.nextInt();
        int gcd = gcd(p, q);
        System.out.println("The greatest common divisor of " + p + " and " + q + " is " + gcd);
    }

    public static int gcd(int p, int q) {
        if (q == 0) {
            return p;
        } else {
            return gcd(q, p % q);
        }
    }

}
