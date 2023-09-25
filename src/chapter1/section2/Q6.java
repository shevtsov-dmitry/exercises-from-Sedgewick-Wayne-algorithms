package chapter1.section2;

public class Q6 {
    public static void main(String[] args) {
        String s1 = "ACTGACG";
        String t1 = "TGACGAC";

        if (areCircularRotations(s1, t1)) {
            System.out.println("s1 and t1 are circular rotations of each other.");
        } else {
            System.out.println("s1 and t1 are NOT circular rotations of each other.");
        }
    }
    public static boolean areCircularRotations(String s, String t) {
        // Check if the lengths of the two strings are equal
        if (s.length() != t.length()) {
            return false;
        }

        // Concatenate s with itself to create a doubled string
        String doubledS = s + s;
        System.out.println("doubledS = " + doubledS);
        // Check if t is a substring of doubledS
        if (doubledS.contains(t)) {
            return true;

        }

        return false;
    }

}
