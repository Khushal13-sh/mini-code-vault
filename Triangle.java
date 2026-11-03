
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem: Triangle
 * LeetCode: 120
 * Difficulty: Medium
 *
 * Description:
 * Given a triangle array, find the minimum path sum
 * from the top row to the bottom row.
 *
 * At every position, we can move to either:
 * 1. The same index in the next row.
 * 2. The next index in the next row.
 *
 * Approach:
 * Bottom-Up Dynamic Programming with Space Optimization.
 *
 * We start from the last row and calculate the minimum
 * path sum for every position while moving towards the top.
 *
 * Time Complexity: O(n * n)
 * Space Complexity: O(n)
 */
public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {

        // Number of rows in the triangle.
        int n = triangle.size();

        // DP array stores the minimum path sum
        // from each position to the bottom.
        int[] dp = new int[n];

        // Step 1: Copy the last row into the DP array.
        // Every element in the last row is already
        // the minimum path sum from that position.
        for (int j = 0; j < n; j++) {

            dp[j] = triangle.get(n - 1).get(j);
        }

        // Step 2: Start from the second-last row
        // and move towards the top row.
        for (int i = n - 2; i >= 0; i--) {

            // Process every element in the current row.
            for (int j = 0; j <= i; j++) {

                /*
                 * From the current position, we can move to:
                 *
                 * dp[j]     -> Element directly below.
                 * dp[j + 1] -> Next element in the next row.
                 *
                 * Choose the smaller path and add
                 * the current triangle element.
                 */
                dp[j] = triangle.get(i).get(j)
                        + Math.min(dp[j], dp[j + 1]);
            }
        }

        // After processing all rows, dp[0] contains
        // the minimum path sum from the top to the bottom.
        return dp[0];
    }

    /**
     * Main method to test the solution.
     */
    public static void main(String[] args) {

        Triangle solution = new Triangle();

        // Test Case 1
        List<List<Integer>> triangle1 = new ArrayList<>();

        triangle1.add(Arrays.asList(2));
        triangle1.add(Arrays.asList(3, 4));
        triangle1.add(Arrays.asList(6, 5, 7));
        triangle1.add(Arrays.asList(4, 1, 8, 3));

        System.out.println("Triangle 1 Minimum Sum: "
                + solution.minimumTotal(triangle1));

        // Test Case 2: Single element
        List<List<Integer>> triangle2 = new ArrayList<>();

        triangle2.add(Arrays.asList(-10));

        System.out.println("\nTriangle 2 Minimum Sum: "
                + solution.minimumTotal(triangle2));

        // Test Case 3: Negative elements
        List<List<Integer>> triangle3 = new ArrayList<>();

        triangle3.add(Arrays.asList(-1));
        triangle3.add(Arrays.asList(2, 3));
        triangle3.add(Arrays.asList(1, -1, -3));

        System.out.println("\nTriangle 3 Minimum Sum: "
                + solution.minimumTotal(triangle3));
    }
}
