/**
 * Problem Title: Final Prices With a Special Discount in a Shop
 * Difficulty: Easy
 *
 * ✅ Problem Description:
 * You are given an integer array `prices` where prices[i] is the price of the i-th item in a shop.
 * 
 * There's a special discount rule:
 * - For the i-th item, look for the **first item after it** (j > i) such that prices[j] <= prices[i].
 * - If found, subtract prices[j] from prices[i] as a discount.
 * - If no such j exists, prices[i] remains unchanged.
 * 
 * Return the final price for each item.
 *
 * 📥 Example 1:
 * Input:  prices = [8, 4, 6, 2, 3]
 * Output: [4, 2, 4, 2, 3]
 * Explanation:
 * - 8 -> next smaller = 4 → 8 - 4 = 4
 * - 4 -> next smaller = 2 → 4 - 2 = 2
 * - 6 -> next smaller = 2 → 6 - 2 = 4
 * - 2, 3 → no smaller after them, remain unchanged
 *
 * 📥 Example 2:
 * Input:  prices = [1, 2, 3, 4, 5]
 * Output: [1, 2, 3, 4, 5]
 *
 * 📥 Example 3:
 * Input:  prices = [10, 1, 1, 6]
 * Output: [9, 0, 1, 6]
 *
 * 📌 Constraints:
 * - 1 <= prices.length <= 500
 * - 1 <= prices[i] <= 1000
 */

public class FinalPricesWithDiscount {

    /**
     * 🧠 Logic:
     * - For each price at index `i`, search for the next index `j > i` where prices[j] <= prices[i].
     * - If found, subtract prices[j] from prices[i].
     * - Use a nested loop to simulate this search.
     */
    public static int[] finalPrices(int[] prices) {
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] <= prices[i]) {
                    prices[i] = prices[i] - prices[j];
                    break;
                }
            }
        }
        return prices;
    }

    // 🧪 Main method for testing the solution
    public static void main(String[] args) {
        int[] prices1 = {8, 4, 6, 2, 3};
        System.out.println("Final Prices: " + java.util.Arrays.toString(finalPrices(prices1))); // [4, 2, 4, 2, 3]

        int[] prices2 = {1, 2, 3, 4, 5};
        System.out.println("Final Prices: " + java.util.Arrays.toString(finalPrices(prices2))); // [1, 2, 3, 4, 5]

        int[] prices3 = {10, 1, 1, 6};
        System.out.println("Final Prices: " + java.util.Arrays.toString(finalPrices(prices3))); // [9, 0, 1, 6]
    }
}
