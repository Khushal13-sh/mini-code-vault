
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Problem: Permutations
 * Difficulty: Medium
 *
 * Given an array of distinct integers, return all possible
 * arrangements of its elements.
 *
 * Example:
 * Input:  [1, 2, 3]
 * Output: All 6 possible permutations.
 *
 * Approach: Backtracking
 *
 * We build one permutation at a time using a list called
 * current. A boolean array called used tracks which array
 * elements have already been selected.
 *
 * When current contains every element, we have completed
 * one permutation and add a copy of it to the result.
 *
 * Time Complexity: O(n * n!)
 * Space Complexity: O(n) auxiliary space, excluding output.
 */
public class Permutations {

    /*
     * Returns all possible permutations of the given array.
     *
     * nums   - Input array containing distinct integers.
     * result - Stores all completed permutations.
     * current - Stores the permutation being built.
     * used   - Tracks whether each input element is selected.
     */
    public static List<List<Integer>> permute(int[] nums) {

        // Stores all the completed permutations.
        List<List<Integer>> result = new ArrayList<>();

        // Stores the permutation currently being constructed.
        List<Integer> current = new ArrayList<>();

        // used[i] is true when nums[i] is already in current.
        boolean[] used = new boolean[nums.length];

        // Start generating permutations from an empty list.
        generatePermutations(nums, used, current, result);

        return result;
    }

    /*
     * Recursively generates permutations using backtracking.
     */
    private static void generatePermutations(
            int[] nums,
            boolean[] used,
            List<Integer> current,
            List<List<Integer>> result) {

        /*
         * Base case:
         * If current contains all input elements, one complete
         * permutation has been generated.
         */
        if (current.size() == nums.length) {

            /*
             * IMPORTANT:
             * Store a copy of current, not current itself.
             *
             * current will be modified during backtracking.
             * A copy ensures each saved permutation remains
             * unchanged when current is modified later.
             */
            result.add(new ArrayList<>(current));

            // Stop exploring this completed permutation.
            return;
        }

        /*
         * Try every input element as the next element
         * of the current permutation.
         */
        for (int i = 0; i < nums.length; i++) {

            // Skip elements that have already been selected.
            if (!used[i]) {

                // Step 1: Choose the current element.
                current.add(nums[i]);

                // Step 2: Mark this element as selected.
                used[i] = true;

                // Step 3: Recursively select the next element.
                generatePermutations(nums, used, current, result);

                /*
                 * Step 4: Backtrack.
                 *
                 * Remove the last selected element so it can
                 * be replaced by another choice.
                 */
                current.remove(current.size() - 1);

                // Step 5: Make this element available again.
                used[i] = false;
            }
        }
    }

    /*
     * Helper method to print all permutations.
     */
    private static void printPermutations(List<List<Integer>> result) {

        for (List<Integer> permutation : result) {
            System.out.println(permutation);
        }
    }

    // Test cases
    public static void main(String[] args) {

        // Test Case 1: Three elements
        int[] nums1 = {1, 2, 3};

        List<List<Integer>> result1 = permute(nums1);

        System.out.println("Test Case 1");
        System.out.println("Input: " + Arrays.toString(nums1));
        printPermutations(result1);
        System.out.println("Total permutations: " + result1.size());
        System.out.println("Expected: 6");
        System.out.println();

        // Test Case 2: Two elements
        int[] nums2 = {0, 1};

        List<List<Integer>> result2 = permute(nums2);

        System.out.println("Test Case 2");
        System.out.println("Input: " + Arrays.toString(nums2));
        printPermutations(result2);
        System.out.println("Total permutations: " + result2.size());
        System.out.println("Expected: 2");
        System.out.println();

        // Test Case 3: One element
        int[] nums3 = {1};

        List<List<Integer>> result3 = permute(nums3);

        System.out.println("Test Case 3");
        System.out.println("Input: " + Arrays.toString(nums3));
        printPermutations(result3);
        System.out.println("Total permutations: " + result3.size());
        System.out.println("Expected: 1");
    }
}
