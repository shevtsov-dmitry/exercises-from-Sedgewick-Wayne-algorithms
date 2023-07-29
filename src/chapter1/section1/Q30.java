package chapter1.section1;

import java.util.Random;

public class Q30 {
    public static void main(String[] args) {
        boolean[][] array = createArray(fillTwoDimArray());
        printBooleanArray(array);

    }
    private static void printBooleanArray(boolean[][] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print("|");
            for (int j = 0; j < arr.length; j++) {
                System.out.printf("%5b |", arr[i][j]);
            }
            System.out.println();
        }
    }
    private static int[][] fillTwoDimArray(){
        Random random = new Random();
        int[][] arr =new int[5][5];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j]=random.nextInt(5);
            }
        }
        return arr;
    }
    private static boolean[][] createArray(int[][] arr){
        int n = arr.length;
        boolean[][] boolArr = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolArr[i][j] = isAppropriate(i,j);
            }
        }
        return boolArr;
    }

    private static boolean isAppropriate(int a, int b){
        return a != b || a == 0;
    }
}

