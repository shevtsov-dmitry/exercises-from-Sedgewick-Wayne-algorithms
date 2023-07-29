package chapter1.section1;

import java.util.Arrays;

public class Q29 {
    public static int runBinarySearchRecursively(int[] sortedArray, int key, int low, int high) {
        int middle = low + ((high - low) / 2);

        if (high < low) {
            return -1;
        }

        if (key == sortedArray[middle]) {
            return middle;
        } else if (key < sortedArray[middle]) {
            return runBinarySearchRecursively(
                    sortedArray, key, low, middle - 1);
        } else {
            return runBinarySearchRecursively(
                    sortedArray, key, middle + 1, high);
        }
    }

    // Count how many elements smaller than target
    private static int rank(int[] arr, int target) {
        int smallerAmount = 0;
        for (int i = 0; i < arr.length; i++) {
            int i1 = arr[i];
            if(i1 < target) smallerAmount++;
        }
        return smallerAmount;
    }

    // Count similar
    private static int count(int[] arr, int targetIndex){
        return (int) Arrays.stream(arr).filter(e -> e == targetIndex).count();
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,1,1,53,2,5,2,69};
//        int countSimilarOnes = count(arr, 1);
        Arrays.sort(arr);
        int find = 69;
        int target = runBinarySearchRecursively(arr, find, 0, arr.length - 1);
        int rank = rank(arr, target);
        System.out.println("rank = " + rank);


    }
}
