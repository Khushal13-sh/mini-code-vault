/**
 * Problem Title: Min Cost Climbing Stairs
 * Difficulty: Easy
 * 
 * ✅ Problem Description:
 * You are given an integer array 'cost' where cost[i] represents the cost of 
 * the ith step on a staircase. After paying the cost, you can either:
 * - Climb 1 step
 * - Climb 2 steps
 * 
 * You can start either from step 0 or step 1.
 * Your goal is to find the **minimum cost to reach the top** of the floor.
 * 
 * 📥 Example 1:
 * Input:  cost = [10,15,20]
 * Output: 15
 * Explanation:
 * - Start at index 1, pay 15, and jump two steps to the top.
 * 
 * 📥 Example 2:
 * Input:  cost = [1,100,1,1,1,100,1,1,100,1]
 * Output: 6
 * Explanation:
 * - Start at index 0.
 * - Pay 1 and move two steps (index 2).
 * - Pay 1 and move two steps (index 4).
 * - Pay 1 and move two steps (index 6).
 * - Pay 1 and move one step (index 7).
 * - Pay 1 and move two steps (index 9).
 * - Pay 1 and move one step to the top.
 * - Total cost: 6.
 * 
 * 📌 Constraints:
 * - 2 <= cost.length <= 1000
 * - 0 <= cost[i] <= 999
 */

public class MinCostClimbingStairs {

    /**
     * 🧠 Logic:
     * - Use Dynamic Programming to calculate the minimum cost.
     * - Maintain two variables, prev1 and prev2, representing the minimum cost 
     *   to reach the current and previous steps respectively.
     * - Start calculating from the 2nd step and update the minimum cost at each step.
     * - Return the minimum cost to reach the top.
     */
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int prev1 = 0;  // Cost to reach the previous step
        int prev2 = 0;  // Cost to reach the step before the previous one

        // Iterate from the 2nd step to the top
        for (int i = 2; i <= n; i++) {
            int current = Math.min(prev1 + cost[i - 1], prev2 + cost[i - 2]);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    // 🧪 Main method to test the logic
    public static void main(String[] args) {
        int[] cost1 = {10, 15, 20};
        System.out.println("Minimum Cost to Reach the Top: " + minCostClimbingStairs(cost1));  // Expected: 15

        int[] cost2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println("Minimum Cost to Reach the Top: " + minCostClimbingStairs(cost2));  // Expected: 6
    }
}
