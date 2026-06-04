/*
 add greedy solution for minimum cost of buying candies with discount
*/

/**
 * Problem: Minimum Cost of Buying Candies With Discount
 * Difficulty: Easy
 *
 * Description:
 * For every two candies purchased, you can get one additional candy
 * for free, provided its cost is less than or equal to the cheaper
 * of the two purchased candies.
 *
 * Return the minimum cost required to buy all candies.
 *
 * Key Insight:
 * - To maximize savings, we should make the most expensive candies
 *   part of the "buy two" group.
 * - After sorting in descending order:
 *   - Pay for first candy
 *   - Pay for second candy
 *   - Get third candy for free
 * - Repeat this pattern.
 *
 * Approach:
 * - Sort the array in ascending order.
 * - Traverse from the largest candy to the smallest.
 * - Every third candy is taken for free.
 * - Add the cost of all other candies.
 *
 * Why this works:
 * By grouping the largest available candies together,
 * the third candy in each group becomes the maximum possible
 * free candy, resulting in the minimum total purchase cost.
 *
 * Time Complexity: O(n log n)
 * - Sorting dominates the runtime.
 *
 * Space Complexity: O(1)
 * - Ignoring sorting space used by Java.
 */
public class MinimumCostOfBuyingCandies {

    public int minimumCost(int[] cost) {

        Arrays.sort(cost);

        int totalCost = 0;
        int count = 0;

        for (int i = cost.length - 1; i >= 0; i--) {

            count++;

            // Every third candy is free
            if (count % 3 == 0) {
                continue;
            }

            totalCost += cost[i];
        }

        return totalCost;
    }

    public static void main(String[] args) {
        MinimumCostOfBuyingCandies obj =
                new MinimumCostOfBuyingCandies();

        // Example 1
        int[] cost1 = {1, 2, 3};
        System.out.println(obj.minimumCost(cost1)); // 5

        // Example 2
        int[] cost2 = {6, 5, 7, 9, 2, 2};
        System.out.println(obj.minimumCost(cost2)); // 23

        // Example 3
        int[] cost3 = {5, 5};
        System.out.println(obj.minimumCost(cost3)); // 10
    }
}