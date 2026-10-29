
import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Combinations
 * Difficulty: Medium
 *
 * Approach:
 * Use backtracking to generate every combination
 * of k numbers selected from 1 to n.
 *
 * Each recursive call chooses the next number.
 * After exploring that choice, remove it to explore
 * other possible combinations.
 */
public class Combinations {

    public List<List<Integer>> combine(int n, int k) {

        // Stores all valid combinations.
        List<List<Integer>> result = new ArrayList<>();

        // Stores the combination currently being built.
        List<Integer> current = new ArrayList<>();

        // Start choosing numbers from 1.
        findCombinations(1, n, k, current, result);

        return result;
    }

    private void findCombinations(
            int start,
            int n,
            int k,
            List<Integer> current,
            List<List<Integer>> result) {

        // Base case:
        // When k numbers have been selected, the combination
        // is complete and can be added to the result.
        if (current.size() == k) {

            // Add a copy because current will be modified
            // during later backtracking steps.
            result.add(new ArrayList<>(current));

            return;
        }

        // Try every available number from start to n.
        for (int i = start; i <= n; i++) {

            // Step 1: Choose the current number.
            current.add(i);

            // Step 2: Choose the next number.
            // Use i + 1 so numbers are not repeated and
            // combinations are generated in increasing order.
            findCombinations(
                i + 1,
                n,
                k,
                current,
                result
            );

            // Step 3: Backtrack.
            // Remove the last selected number so that
            // the next possible choice can be explored.
            current.remove(current.size() - 1);
        }
    }

    // Helper method to print the combinations.
    private static void printCombinations(
            List<List<Integer>> combinations) {

        System.out.println(combinations);
    }

    // Main method for testing.
    public static void main(String[] args) {

        Combinations solution = new Combinations();

        // Test Case 1: Choose 2 numbers from 1 to 4.
        System.out.println("Test Case 1:");
        printCombinations(solution.combine(4, 2));
        // Expected:
        // [[1, 2], [1, 3], [1, 4],
        //  [2, 3], [2, 4], [3, 4]]

        // Test Case 2: Choose 1 number from 1 to 1.
        System.out.println("\nTest Case 2:");
        printCombinations(solution.combine(1, 1));
        // Expected: [[1]]

        // Test Case 3: Choose all numbers.
        System.out.println("\nTest Case 3:");
        printCombinations(solution.combine(4, 4));
        // Expected: [[1, 2, 3, 4]]

        // Test Case 4: Choose 3 numbers from 1 to 5.
        System.out.println("\nTest Case 4:");
        printCombinations(solution.combine(5, 3));
        // Expected:
        // [[1, 2, 3], [1, 2, 4], [1, 2, 5],
        //  [1, 3, 4], [1, 3, 5], [1, 4, 5],
        //  [2, 3, 4], [2, 3, 5], [2, 4, 5],
        //  [3, 4, 5]]
    }
}
