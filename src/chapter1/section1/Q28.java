package chapter1.section1;

import java.util.*;
import java.util.stream.Collectors;

public class Q28 {

        // Recursive binary search function
        public static int binarySearch(int[] arr, int target) {
            return binarySearchRecursive(arr, target, 0, arr.length - 1);
        }

        private static int binarySearchRecursive(int[] arr, int target, int low, int high) {
            if (low <= high) {
                int mid = low + (high - low) / 2;

                // If the target is found, return its index
                if (arr[mid] == target) {
                    return mid;
                } else if (arr[mid] > target) {
                    // If the middle element is greater than the target,
                    // search the left half of the array
                    return binarySearchRecursive(arr, target, low, mid - 1);
                } else {
                    // If the middle element is smaller than the target,
                    // search the right half of the array
                    return binarySearchRecursive(arr, target, mid + 1, high);
                }
            }
            // If the target is not found, return -1
            return -1;
        }

        public static void main(String[] args) {
            int[] arr = {1, 3, 5, 7, 9, 11, 11, 11, 13, 15};
            Set<Integer> set = new HashSet<>();
            Arrays.stream(arr).forEach(set::add);
            List<Integer> newArray = Arrays.stream(arr).filter(set::contains).boxed().toList();
//            System.out.println("newArray = " + newArray);


            int target = 7;
            int result = binarySearch(arr, target);

//            if (result != -1) {
//                System.out.println("Target " + target + " found at index " + result);
//            } else {
//                System.out.println("Target " + target + " not found in the array.");
//            }
        }

}
