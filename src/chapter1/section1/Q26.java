package chapter1.section1;

public class Q26 {
    public static void main(String[] args){
        int a = 0, b = 0, c = 0, t = 0;
        if (a > b) { t = a; a = b; b = t; }
        if (a > c) { t = a; a = c; c = t; }
        if (b > c) { t = b; b = c; c = t; }
    }
}
