/**
 * Problem: Check If All 1's Are at Least Length K Places Away
 * Difficulty: Easy
 *
 * 🎯 Goal:
 * Given a binary array, return true if all 1's are at least k distance apart.
 *
 * 🧠 Approach:
 * - Use a counter to track distance between 1s.
 * - If a new 1 appears and count < k → return false.
 *
 * 📘 Examples:
 * Input: [1,0,0,0,1,0,0,1], k = 2 → Output: true
 * Input: [1,0,0,1,0,1], k = 2     → Output: false
 */

public class CheckOnesKLengthApart {

    public static boolean kLengthApart(int[] nums, int k) {
        int count = k;  // Initialize to k to handle case when first element is 1

        for (int num : nums) {
            if (num == 1) {
                if (count < k) {
                    return false;  // 1s are too close
                }
                count = 0;  // Reset after finding 1
            } else {
                count++;  // Increment distance between 1s
            }
        }

        return true;  // All 1s are at least k apart
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 0, 0, 0, 1, 0, 0, 1};
        int k1 = 2;
        System.out.println("Result: " + kLengthApart(arr1, k1));  // true

        int[] arr2 = {1, 0, 0, 1, 0, 1};
        int k2 = 2;
        System.out.println("Result: " + kLengthApart(arr2, k2));  // false

        int[] arr3 = {1, 0, 0, 0, 0, 1};
        int k3 = 4;
        System.out.println("Result: " + kLengthApart(arr3, k3));  // true
    }
}
