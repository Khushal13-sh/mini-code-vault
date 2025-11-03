/**
 * Problem: Maximum Containers on a Ship
 * Difficulty: Easy
 *
 * Description:
 * You are given:
 *   - n: the size of the cargo deck (n x n)
 *   - w: the weight of each container
 *   - maxWeight: maximum ship weight capacity
 *
 * Each cell can hold one container. Determine the maximum number of containers
 * that can be loaded without exceeding the ship’s maximum weight.
 *
 * Logic:
 *   - Total slots on deck = n * n
 *   - Containers possible by weight = maxWeight / w
 *   - The answer is the smaller of these two.
 *
 * Example 1:
 * Input: n = 2, w = 3, maxWeight = 15
 * Output: 4
 * Explanation: Total slots = 4, weight allows 5 containers (15/3 = 5),
 * but deck has only 4 slots → result = 4.
 *
 * Example 2:
 * Input: n = 3, w = 5, maxWeight = 20
 * Output: 4
 * Explanation: Total slots = 9, weight allows 4 containers (20/5 = 4),
 * so result = 4.
 */

public class MaximumContainersOnShip {

    public int maxContainers(int n, int w, int maxWeight) {
        int totalSlots = n * n;
        int maxByWeight = maxWeight / w;

        return Math.min(totalSlots, maxByWeight);
    }

    // --- main method for quick testing ---
    public static void main(String[] args) {
        MaximumContainersOnShip obj = new MaximumContainersOnShip();

        System.out.println(obj.maxContainers(2, 3, 15)); // Expected: 4
        System.out.println(obj.maxContainers(3, 5, 20)); // Expected: 4
        System.out.println(obj.maxContainers(4, 10, 500)); // Expected: 16
    }
}
