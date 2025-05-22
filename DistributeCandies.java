/**
 * Problem Title: Distribute Candies
 * Difficulty: Easy
 *
 * ✅ Problem Description:
 * Alice has `n` candies, where the `i-th` candy is of type `candyType[i]`.
 * Since she's gaining weight, her doctor allows her to eat only `n / 2` candies.
 *
 * Alice wants to maximize the **number of different types** of candies she eats,
 * while following the doctor's restriction.
 *
 * Return the maximum number of different types she can eat.
 *
 * 📥 Example 1:
 * Input: candyType = [1, 1, 2, 2, 3, 3]
 * Output: 3
 * Explanation: She can eat 3 candies, and there are 3 types. So she eats one of each type.
 *
 * 📥 Example 2:
 * Input: candyType = [1, 1, 2, 3]
 * Output: 2
 * Explanation: She can eat 2 candies. There are 3 types, but she can only eat 2 different ones.
 *
 * 📥 Example 3:
 * Input: candyType = [6, 6, 6, 6]
 * Output: 1
 * Explanation: All candies are of one type. Even though she can eat 2, they’ll be the same type.
 *
 * 📌 Constraints:
 * - n == candyType.length
 * - 2 <= n <= 10⁴ (and n is always even)
 * - -10⁵ <= candyType[i] <= 10⁵
 */

import java.util.*;

public class DistributeCandies {

    /**
     * 🧠 Logic:
     * - Use a HashSet to store unique candy types.
     * - The doctor allows Alice to eat only `n / 2` candies.
     * - So, the answer is the **minimum of:**
     *     1. Number of unique types
     *     2. Maximum candies she can eat (n / 2)
     */
    public static int distributeCandies(int[] candyType) {
        Set<Integer> uniqueTypes = new HashSet<>();

        for (int candy : candyType) {
            uniqueTypes.add(candy);
        }

        int maxAllowed = candyType.length / 2;
        return Math.min(uniqueTypes.size(), maxAllowed);
    }

    // 🧪 Main method for testing the solution
    public static void main(String[] args) {
        int[] candy1 = {1, 1, 2, 2, 3, 3};
        System.out.println("Max Different Types Alice Can Eat: " + distributeCandies(candy1));  // Expected: 3

        int[] candy2 = {1, 1, 2, 3};
        System.out.println("Max Different Types Alice Can Eat: " + distributeCandies(candy2));  // Expected: 2

        int[] candy3 = {6, 6, 6, 6};
        System.out.println("Max Different Types Alice Can Eat: " + distributeCandies(candy3));  // Expected: 1
    }
}
