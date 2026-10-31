
import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Subsets
 * LeetCode: 78
 * Difficulty: Medium
 *
 * Description:
 * Given an array of unique integers, return all possible
 * subsets (the power set).
 *
 * Approach:
 * Backtracking.
 *
 * At every recursive call:
 * 1. Add the current subset to the result.
 * 2. Try selecting each remaining element.
 * 3. Recursively generate further subsets.
 * 4. Backtrack by removing the selected element.
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {

        // Stores all possible subsets.
        List<List<Integer>> result = new ArrayList<>();

        // Stores the subset currently being generated.
        List<Integer> current = new ArrayList<>();

        // Start generating subsets from index 0.
        generateSubsets(nums, 0, current, result);

        return result;
    }

    /**
     * Generates all possible subsets using backtracking.
     *
     * @param nums    Input array containing unique elements.
     * @param index   Starting index for the current recursion.
     * @param current Current subset being generated.
     * @param result  Stores all generated subsets.
     */
    private void generateSubsets(
            int[] nums,
            int index,
            List<Integer> current,
            List<List<Integer>> result) {

        // Add a copy of the current subset.
        // We use a copy because current will change during backtracking.
        result.add(new ArrayList<>(current));

        // Explore all remaining elements.
        for (int i = index; i < nums.length; i++) {

            // Choose the current element.
            current.add(nums[i]);

            // Recursively generate subsets using the next index.
            // i + 1 ensures that an element is not selected again.
            generateSubsets(nums, i + 1, current, result);

            // Backtrack: remove the last selected element.
            // This allows us to explore other combinations.
            current.remove(current.size() - 1);
        }
    }

    /**
     * Main method to test the solution.
     */
    public static void main(String[] args) {

        Subsets solution = new Subsets();

        // Test Case 1
        int[] nums1 = {1, 2, 3};

        System.out.println("Input: [1, 2, 3]");
        System.out.println("Output: " + solution.subsets(nums1));

        // Test Case 2
        int[] nums2 = {0};

        System.out.println("\nInput: [0]");
        System.out.println("Output: " + solution.subsets(nums2));

        // Test Case 3
        int[] nums3 = {1, 2};

        System.out.println("\nInput: [1, 2]");
        System.out.println("Output: " + solution.subsets(nums3));
    }
}
