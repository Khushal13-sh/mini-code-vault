/**
 * Problem: Fruits Into Baskets II
 * Difficulty: Easy
 *
 * You are given two arrays of integers, fruits and baskets, each of length n.
 * - fruits[i] represents the quantity of the ith type of fruit.
 * - baskets[j] represents the capacity of the jth basket.
 *
 * Rules:
 * 1. Each fruit type must be placed in the leftmost available basket
 *    with a capacity >= quantity of that fruit type.
 * 2. Each basket can hold only one type of fruit.
 * 3. If a fruit type cannot be placed in any basket, it remains unplaced.
 *
 * Return the number of fruit types that remain unplaced.
 *
 * Example 1:
 * Input: fruits = [4,2,5], baskets = [3,5,4]
 * Output: 1
 *
 * Example 2:
 * Input: fruits = [3,6,1], baskets = [6,4,7]
 * Output: 0
 *
 * Constraints:
 * n == fruits.length == baskets.length
 * 1 <= n <= 100
 * 1 <= fruits[i], baskets[i] <= 1000
 */
public class FruitsIntoBasketsII {

    /**
     * Function to return number of unplaced fruit types
     *
     * @param fruits  array of fruit quantities
     * @param baskets array of basket capacities
     * @return number of unplaced fruit types
     */
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        boolean[] used = new boolean[n];
        int unplaced = 0;

        // Try to place each fruit in the leftmost available basket
        for (int fruit : fruits) {
            boolean placed = false;
            for (int j = 0; j < n; j++) {
                if (!used[j] && baskets[j] >= fruit) {
                    used[j] = true; // mark basket as used
                    placed = true;
                    break;
                }
            }
            if (!placed) {
                unplaced++;
            }
        }
        return unplaced;
    }

    // Main method for quick testing
    public static void main(String[] args) {
        FruitsIntoBasketsII solution = new FruitsIntoBasketsII();

        int[] fruits1 = {4, 2, 5};
        int[] baskets1 = {3, 5, 4};
        System.out.println(solution.numOfUnplacedFruits(fruits1, baskets1)); // 1

        int[] fruits2 = {3, 6, 1};
        int[] baskets2 = {6, 4, 7};
        System.out.println(solution.numOfUnplacedFruits(fruits2, baskets2)); // 0

        int[] fruits3 = {5, 7, 8};
        int[] baskets3 = {4, 6, 5};
        System.out.println(solution.numOfUnplacedFruits(fruits3, baskets3)); // 3
    }
}
