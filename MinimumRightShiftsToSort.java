/**
 * Problem: Minimum Right Shifts to Sort the Array
 * Difficulty: Easy
 *
 * Given an array of distinct integers, determine the minimum number of right shifts
 * required to make it sorted. If not possible, return -1.
 */

import java.util.*;

public class MinimumRightShiftsToSort {

    public int minimumRightShifts(List<Integer> nums) {
        int n = nums.size();
        int dropIndex = -1;

        for (int i = 0; i < n; i++) {
            if (nums.get(i) > nums.get((i + 1) % n)) {
                if (dropIndex != -1) {
                    return -1; // More than one drop, can't sort via rotation
                }
                dropIndex = i;
            }
        }

        // If no drop found, array is already sorted
        if (dropIndex == -1) return 0;

        // Otherwise, required right shifts = n - dropIndex - 1
        return n - dropIndex - 1;
    }

    public static void main(String[] args) {
        MinimumRightShiftsToSort solution = new MinimumRightShiftsToSort();

        System.out.println(solution.minimumRightShifts(Arrays.asList(3, 4, 5, 1, 2))); // Output: 2
        System.out.println(solution.minimumRightShifts(Arrays.asList(1, 3, 5)));       // Output: 0
        System.out.println(solution.minimumRightShifts(Arrays.asList(2, 1, 4)));       // Output: -1
        System.out.println(solution.minimumRightShifts(Arrays.asList(1, 2, 3, 4, 5))); // Output: 0
        System.out.println(solution.minimumRightShifts(Arrays.asList(4, 5, 1, 2, 3))); // Output: 2
    }
}
