import java.util.ArrayList;
import java.util.List;

/**
 * Combination Sum
 *
 * Problem:
 * Given an array of distinct positive integers and a target integer,
 * find all unique combinations of candidates where the chosen numbers
 * add up to the target.
 *
 * The same number can be selected multiple times.
 *
 * Example:
 * Input:
 * candidates = [2, 3, 6, 7]
 * target = 7
 *
 * Output:
 * [[2, 2, 3], [7]]
 *
 * Approach:
 * This problem is solved using Backtracking.
 *
 * At every step:
 * 1. Choose a candidate.
 * 2. Reduce the target by the chosen candidate.
 * 3. Recursively find the remaining combination.
 * 4. Remove the chosen candidate to try another possibility.
 *
 * We pass the same index 'i' during recursion because
 * a candidate can be used unlimited times.
 *
 * Time Complexity:
 * Depends on the number of possible combinations.
 * In the worst case, it can be exponential.
 *
 * Space Complexity:
 * O(target) for the recursion depth and current combination,
 * excluding the space used by the result.
 */
public class CombinationSum {

    /**
     * Finds all unique combinations whose sum is equal to the target.
     *
     * @param candidates array of distinct positive integers
     * @param target target sum
     * @return list containing all valid combinations
     */
    public static List<List<Integer>> combinationSum(
            int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        findCombinations(
                candidates,
                target,
                0,
                new ArrayList<Integer>(),
                result
        );

        return result;
    }

    /**
     * Performs backtracking to find valid combinations.
     *
     * @param candidates array of candidate numbers
     * @param target remaining target
     * @param index starting index for selecting candidates
     * @param current current combination being constructed
     * @param result final list of combinations
     */
    private static void findCombinations(
            int[] candidates,
            int target,
            int index,
            List<Integer> current,
            List<List<Integer>> result) {

        // Target reached, so the current combination is valid.
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Target became negative, so this combination is invalid.
        if (target < 0) {
            return;
        }

        // Start from the current index to avoid duplicate combinations.
        for (int i = index; i < candidates.length; i++) {

            // Choose the current candidate.
            current.add(candidates[i]);

            // Pass 'i' instead of 'i + 1' because
            // the same candidate can be used again.
            findCombinations(
                    candidates,
                    target - candidates[i],
                    i,
                    current,
                    result
            );

            // Backtrack: remove the last selected candidate.
            current.remove(current.size() - 1);
        }
    }

    /**
     * Main method to test the Combination Sum solution.
     */
    public static void main(String[] args) {

        // Example 1
        int[] candidates1 = {2, 3, 6, 7};
        int target1 = 7;

        List<List<Integer>> result1 =
                combinationSum(candidates1, target1);

        System.out.println("Example 1:");
        System.out.println("Candidates: [2, 3, 6, 7]");
        System.out.println("Target: 7");
        System.out.println("Output: " + result1);

        System.out.println();

        // Example 2
        int[] candidates2 = {2, 3, 5};
        int target2 = 8;

        List<List<Integer>> result2 =
                combinationSum(candidates2, target2);

        System.out.println("Example 2:");
        System.out.println("Candidates: [2, 3, 5]");
        System.out.println("Target: 8");
        System.out.println("Output: " + result2);

        System.out.println();

        // Example 3
        int[] candidates3 = {2};
        int target3 = 1;

        List<List<Integer>> result3 =
                combinationSum(candidates3, target3);

        System.out.println("Example 3:");
        System.out.println("Candidates: [2]");
        System.out.println("Target: 1");
        System.out.println("Output: " + result3);
    }
}