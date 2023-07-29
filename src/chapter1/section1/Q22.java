package chapter1.section1;

public class Q22 {
    public static int rank(int key, int[] a)
    { return rank(key, a, 0, a.length - 1); }
    public static int rank(int key, int[] a, int lo, int hi)
    { // Index of key in a[], if present, is not smaller than lo
      // and not larger than hi.
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) return rank(key, a, lo, mid - 1);
        else if (key > a[mid]) return rank(key, a, mid + 1, hi);
        else return mid;
    }
}

