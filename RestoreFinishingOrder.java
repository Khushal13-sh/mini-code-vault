import java.util.Arrays;

/**
 * Problem: Restore Finishing Order
 * Difficulty: Easy
 *
 * Description:
 * You are given:
 * - An array `order` of size n representing the race finishing order of participants (IDs 1 to n).
 * - An array `friends` containing the IDs of your friends (sorted in increasing order).
 *
 * Goal:
 * Return the finishing order of your friends as they appear in the race order.
 *
 * Approach:
 * - Iterate over `order`.
 * - For each participant, check if they are in `friends`.
 * - If yes, add them to the result in the order they appear.
 *
 * Time Complexity: O(n * m), where n = order.length, m = friends.length
 * Space Complexity: O(m) for the result
 *
 * Example 1:
 * Input: order = [3,1,2,5,4], friends = [1,3,4]
 * Output: [3,1,4]
 *
 * Example 2:
 * Input: order = [1,4,5,3,2], friends = [2,5]
 * Output: [5,2]
 */
public class RestoreFinishingOrder {

    public int[] recoverOrder(int[] order, int[] friends) {
        int[] result = new int[friends.length];
        int index = 0;

        for (int runner : order) {
            for (int friend : friends) {
                if (runner == friend) {
                    result[index++] = runner;
                }
            }
        }
        return result;
    }

    // Main method to test the examples
    public static void main(String[] args) {
        RestoreFinishingOrder solution = new RestoreFinishingOrder();

        // Example 1
        int[] order1 = {3, 1, 2, 5, 4};
        int[] friends1 = {1, 3, 4};
        System.out.println("Example 1 Output: " + Arrays.toString(solution.recoverOrder(order1, friends1)));
        // Expected: [3, 1, 4]

        // Example 2
        int[] order2 = {1, 4, 5, 3, 2};
        int[] friends2 = {2, 5};
        System.out.println("Example 2 Output: " + Arrays.toString(solution.recoverOrder(order2, friends2)));
        // Expected: [5, 2]

        // Extra Example 3 (custom test)
        int[] order3 = {2, 3, 1};
        int[] friends3 = {1, 3};
        System.out.println("Example 3 Output: " + Arrays.toString(solution.recoverOrder(order3, friends3)));
        // Expected: [3, 1]
    }
}
