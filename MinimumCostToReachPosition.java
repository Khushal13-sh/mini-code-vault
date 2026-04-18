/*
 add solution for minimum cost to reach every position using prefix minimum logic
*/

/**
 * Problem: Minimum Cost to Reach Every Position
 * Difficulty: Easy
 *
 * Description:
 * You start from the end and want to reach each position.
 * Moving forward (towards index 0) costs money, but moving backward is free.
 *
 * Key Insight:
 * - To reach position i, you only need to pay the minimum cost among [0...i]
 * - Because after paying once, you can move freely forward
 *
 * Approach:
 * - Traverse the array
 * - Maintain minimum cost seen so far
 * - Store it for each index
 *
 * Why this works:
 * Once you pay the smallest cost person, you can reach all further positions for free.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class MinimumCostToReachPosition {

    public int[] minCosts(int[] cost) {

        int n = cost.length;
        int[] answer = new int[n];

        int minSoFar = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            minSoFar = Math.min(minSoFar, cost[i]);
            answer[i] = minSoFar;
        }

        return answer;
    }

    public static void main(String[] args) {
        MinimumCostToReachPosition obj = new MinimumCostToReachPosition();

        // Example 1
        int[] cost1 = {5, 3, 4, 1, 3, 2};
        int[] res1 = obj.minCosts(cost1);
        System.out.print("Output 1: ");
        for (int val : res1) {
            System.out.print(val + " ");
        }
        // Expected: 5 3 3 1 1 1

        System.out.println();

        // Example 2
        int[] cost2 = {1, 2, 4, 6, 7};
        int[] res2 = obj.minCosts(cost2);
        System.out.print("Output 2: ");
        for (int val : res2) {
            System.out.print(val + " ");
        }
        // Expected: 1 1 1 1 1
    }
}