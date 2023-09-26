package chapter1.section2;

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Q9 {
    public static void main(String[] args) {

        Counter counter = new Counter("myCounter");

        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        rank(88,arr,counter);
    }

    public static int rank(int key, int[] a,Counter counter) { // Array must be sorted.
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) { // Key is in a[lo..hi] or not present.
            counter.increment();
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else {
                System.out.println("counter = " + counter.tally());
                return mid;
            }
        }
        return -1;
    }

//    public static void main(String[] args) {
//        int[] whitelist = In.readInts(args[0]);
//        Arrays.sort(whitelist);
//        while (!StdIn.isEmpty()) { // Read key, print if not in whitelist.
//            int key = StdIn.readInt();
//            if (rank(key, whitelist) < 0)
//                StdOut.println(key);
//        }
//    }

}

