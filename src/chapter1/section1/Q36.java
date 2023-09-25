package chapter1.section1;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Q36 {
    public static void main(String[] args) {
        int arrayLength = 4;
        double[] arr = new double[arrayLength];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        shuffleTest(arr, 5);
//        System.out.println("before shuffle = " + Arrays.toString(arr));
//        System.out.println("after shuffle = " + Arrays.toString(arr));
    }

    //  randomly shuffle the elements in an array of double value
    public static void shuffle(double[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) { // Exchange a[i] with random element in a[i..N-1]
            int r = i + StdRandom.uniformInt(N - i);
            double temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    public static void shuffleTest(double[] array, int shufflesAmount) {
        int[] shuffleMatches = new int[array.length];
        for (int i = 0; i < shufflesAmount; i++) {
            double[] arrBeforeShuffle = Arrays.copyOf(array, array.length);
            shuffle(array);
            for (int j = 0; j < array.length; j++) {
                if(array[j] == arrBeforeShuffle[j]) shuffleMatches[j]++;
            }
        }
        System.out.println("shuffleMatches = " + Arrays.toString(shuffleMatches));

    }
}
