import java.util.*;

/**
 * Problem: Minimum Operations to Collect Elements
 * Difficulty: Easy
 *
 * You are given an array `nums` and an integer `k`.
 * In one operation, you remove the last element and add it to your collection.
 * Return the minimum number of operations needed to collect elements 1 to k.
 */

public class MinimumOperationsToCollect {

    public int minOperations(List<Integer> nums, int k) {
        Set<Integer> collected = new HashSet<>();
        int operations = 0;

        for (int i = nums.size() - 1; i >= 0; i--) {
            operations++;
            int current = nums.get(i);

            if (current <= k) {
                collected.add(current);
            }

            if (collected.size() == k) {
                return operations;
            }
        }

        return -1; // In case it's not possible (as per constraints, this won't occur)
    }

    public static void main(String[] args) {
        MinimumOperationsToCollect solution = new MinimumOperationsToCollect();

        List<Integer> test1 = Arrays.asList(3, 1, 5, 4, 2);
        System.out.println(solution.minOperations(test1, 2)); // Output: 4

        List<Integer> test2 = Arrays.asList(3, 1, 5, 4, 2);
        System.out.println(solution.minOperations(test2, 5)); // Output: 5

        List<Integer> test3 = Arrays.asList(3, 2, 5, 3, 1);
        System.out.println(solution.minOperations(test3, 3)); // Output: 4
    }
}
