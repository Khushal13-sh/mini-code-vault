/**
 * Problem: Make Array Elements Equal to Zero
 * Difficulty: Easy
 *
 * A starting index is only valid if nums[start] == 0.
 * We simulate two possible directions (left and right)
 * and follow the movement rules until the pointer exits the array.
 * If after the simulation all values in the array become zero,
 * that starting configuration is counted as valid.
 */

public class MakeArrayElementsZero {

    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int validCount = 0;

        for (int start = 0; start < n; start++) {
            if (nums[start] == 0) {
                // Try moving RIGHT first
                if (simulate(nums, start, 1)) validCount++;

                // Try moving LEFT
                if (simulate(nums, start, -1)) validCount++;
            }
        }

        return validCount;
    }

    // ------- SIMULATION LOGIC -------
    private boolean simulate(int[] nums, int start, int direction) {
        int[] arr = nums.clone(); // Work on copy
        int n = arr.length;
        int curr = start;

        while (curr >= 0 && curr < n) {
            if (arr[curr] == 0) {
                curr += direction; // Continue in same direction
            } else {
                arr[curr]--;       // Decrease value
                direction = -direction; // Reverse direction
                curr += direction;
            }
        }

        // Check if array is fully zero
        for (int val : arr) {
            if (val != 0) return false;
        }
        return true;
    }

    // ------------ MAIN METHOD FOR TESTING ------------
    public static void main(String[] args) {
        MakeArrayElementsZero sol = new MakeArrayElementsZero();

        int[] nums1 = {1, 0, 2, 0, 3};
        int[] nums2 = {2, 3, 4, 0, 4, 1, 0};

        System.out.println(sol.countValidSelections(nums1)); // Output: 2
        System.out.println(sol.countValidSelections(nums2)); // Output: 0
    }
}
