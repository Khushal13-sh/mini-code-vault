/*
 add solution for forming smallest number from two digit arrays with example execution
*/

/**
 * Problem: Form Smallest Number From Two Digit Arrays
 * Difficulty: Easy
 *
 * Description:
 * Given two arrays of unique digits, find the smallest number that contains
 * at least one digit from each array.
 *
 * Approach:
 * - First, check if there is any common digit between both arrays.
 *      → If yes, return the smallest common digit (best possible answer)
 * - If no common digit:
 *      → Find the minimum digit from both arrays
 *      → Form the smallest two-digit number using them
 *
 * Example:
 * nums1 = [4,1,3], nums2 = [5,7]
 * → No common digit
 * → Smallest digits: 1 and 5 → Result: 15
 *
 * Time Complexity: O(n + m)
 * Space Complexity: O(n)
 */
import java.util.HashSet;
import java.util.Set;

public class FormSmallestNumber {

    public int minNumber(int[] nums1, int[] nums2) {

        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }

        int commonMin = 10;

        // Check for smallest common digit
        for (int num : nums2) {
            if (set.contains(num)) {
                commonMin = Math.min(commonMin, num);
            }
        }

        if (commonMin < 10) {
            return commonMin;
        }

        // No common digit → find smallest digits
        int min1 = 10, min2 = 10;

        for (int num : nums1) {
            min1 = Math.min(min1, num);
        }

        for (int num : nums2) {
            min2 = Math.min(min2, num);
        }

        // Form smallest possible number
        if (min1 < min2) {
            return min1 * 10 + min2;
        } else {
            return min2 * 10 + min1;
        }
    }

    public static void main(String[] args) {
        FormSmallestNumber obj = new FormSmallestNumber();

        // Example 1
        int[] nums1 = {4, 1, 3};
        int[] nums2 = {5, 7};
        System.out.println("Output 1: " + obj.minNumber(nums1, nums2)); // 15

        // Example 2
        int[] nums3 = {3, 5, 2, 6};
        int[] nums4 = {3, 1, 7};
        System.out.println("Output 2: " + obj.minNumber(nums3, nums4)); // 3
    }
}