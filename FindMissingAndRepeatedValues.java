import java.util.HashSet;
import java.util.Set;

/**
 * ## Solution: Find Missing and Repeated Values
 *
 * This class provides a solution to the "Find Missing and Repeated Values" problem.
 * The challenge involves a 0-indexed n x n integer matrix (`grid`) where all
 * values are in the range [1, n^2]. In this grid, one number (`a`) appears
 * twice, while another number (`b`) is completely missing. The goal is to
 * efficiently identify and return both `a` and `b`.
 *
 * ### Approach
 *
 * The solution utilizes a **hash set** and mathematical properties of arithmetic series
 * to solve the problem in a single pass through the grid. This approach is highly efficient
 * with a time complexity of O(n^2) and a space complexity of O(n^2), where n is the
 * dimension of the grid.
 *
 * 1.  **Iterate and Track:** We first iterate through every element in the grid.
 * * We use a `HashSet` named `seen` to store each unique number we encounter.
 * * We also maintain a `totalSum` of all the numbers in the grid.
 * * During the iteration, if we find a number that is **already in the `seen` set**,
 * we've found our **repeated** value (`a`).
 *
 * 2.  **Calculate the Missing Value:** After iterating through the entire grid, we have the
 * `totalSum` of all elements, including the repeated number, and we have identified
 * the repeated number itself.
 * * The **expected sum** of all numbers from 1 to n^2 can be calculated using the
 * formula for the sum of an arithmetic series: `(n^2 * (n^2 + 1)) / 2`.
 * * The `totalSum` from our iteration is actually `(Expected Sum - Missing Value + Repeated Value)`.
 * * By rearranging this equation, we can isolate the missing value:
 * `Missing Value = Expected Sum - (Total Sum - Repeated Value)`.
 *
 * This method is both straightforward and performant, making it an excellent solution for the problem.
 */
public class FindMissingAndRepeatedValues {

    /**
     * Finds the repeated and missing numbers in a given grid.
     *
     * @param grid The 2D integer matrix of size n x n.
     * @return A 0-indexed integer array of size 2, where the first element
     * is the repeated number and the second is the missing number.
     */
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int nSquared = n * n;
        Set<Integer> seen = new HashSet<>();
        int repeated = -1;
        long totalSum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = grid[i][j];
                if (seen.contains(value)) {
                    repeated = value;
                }
                seen.add(value);
                totalSum += value;
            }
        }

        // The expected sum of numbers from 1 to n^2.
        long expectedSum = (long) nSquared * (nSquared + 1) / 2;
        
        // The missing number can be found by subtracting the sum of the
        // unique numbers from the expected sum. The sum of unique numbers is `totalSum - repeated`.
        int missing = (int) (expectedSum - (totalSum - repeated));

        return new int[]{repeated, missing};
    }

    public static void main(String[] args) {
        FindMissingAndRepeatedValues solution = new FindMissingAndRepeatedValues();

        // Example 1
        int[][] grid1 = {{1, 3}, {2, 2}};
        int[] result1 = solution.findMissingAndRepeatedValues(grid1);
        System.out.println("Example 1:");
        System.out.println("Input: grid = [[1,3],[2,2]]");
        System.out.println("Output: [" + result1[0] + "," + result1[1] + "]"); // Expected: [2, 4]
        System.out.println("Explanation: Number 2 is repeated and number 4 is missing.\n");

        // Example 2
        int[][] grid2 = {{9, 1, 7}, {8, 9, 2}, {3, 4, 6}};
        int[] result2 = solution.findMissingAndRepeatedValues(grid2);
        System.out.println("Example 2:");
        System.out.println("Input: grid = [[9,1,7],[8,9,2],[3,4,6]]");
        System.out.println("Output: [" + result2[0] + "," + result2[1] + "]"); // Expected: [9, 5]
        System.out.println("Explanation: Number 9 is repeated and number 5 is missing.\n");
    }
}