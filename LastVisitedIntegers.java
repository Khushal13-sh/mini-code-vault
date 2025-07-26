import java.util.*;

/**
 * Problem: Last Visited Integers
 * Difficulty: Easy
 *
 * Given an array of integers where each element is either a positive integer or -1,
 * return a list of integers corresponding to each -1, where the output is the k-th 
 * most recent positive integer added, or -1 if k exceeds the size of the seen list.
 */

public class LastVisitedIntegers {

    public List<Integer> lastVisitedIntegers(int[] nums) {
        List<Integer> seen = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int k = 0;

        for (int num : nums) {
            if (num == -1) {
                k++;
                if (k <= seen.size()) {
                    ans.add(seen.get(k - 1));
                } else {
                    ans.add(-1);
                }
            } else {
                seen.add(0, num); // Prepend the positive number to the seen list
                k = 0; // Reset k on encountering a positive number
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        LastVisitedIntegers solution = new LastVisitedIntegers();

        int[] test1 = {1, 2, -1, -1, -1};
        System.out.println("Output: " + solution.lastVisitedIntegers(test1)); // [2, 1, -1]

        int[] test2 = {1, -1, 2, -1, -1};
        System.out.println("Output: " + solution.lastVisitedIntegers(test2)); // [1, 2, 1]

        int[] test3 = {5, 4, -1, 3, -1, -1, -1};
        System.out.println("Output: " + solution.lastVisitedIntegers(test3)); // [4, 3, 4, -1]
    }
}
