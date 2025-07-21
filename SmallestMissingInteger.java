/**
 * Problem: Smallest Missing Integer Greater Than Sequential Prefix Sum
 * Difficulty: Easy
 *
 * Given an array of integers, find the smallest integer missing from the array
 * which is >= sum of the longest sequential prefix.
 */

import java.util.*;

public class SmallestMissingInteger {

    public int missingInteger(int[] nums) {
        int prefixSum = nums[0];
        int i = 1;

        while (i < nums.length && nums[i] == nums[i - 1] + 1) {
            prefixSum += nums[i];
            i++;
        }

        Arrays.sort(nums);

        int x = prefixSum;
        for (int num : nums) {
            if (num == x) x++;
            else if (num > x) break;
        }

        return x;
    }

    public static void main(String[] args) {
        SmallestMissingInteger solution = new SmallestMissingInteger();

        System.out.println(solution.missingInteger(new int[]{1, 2, 3, 2, 5}));       // Output: 6
        System.out.println(solution.missingInteger(new int[]{3, 4, 5, 1, 12, 14, 13})); // Output: 15
        System.out.println(solution.missingInteger(new int[]{2, 2, 3, 4, 5}));       // Output: 2
        System.out.println(solution.missingInteger(new int[]{1}));                   // Output: 2
    }
}
