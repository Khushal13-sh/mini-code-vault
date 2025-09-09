import java.util.Arrays;

/**
 * Problem: Apple Redistribution into Boxes
 * Difficulty: Easy
 *
 * You are given:
 * - An array `apple[]` of size n → number of apples in each pack.
 * - An array `capacity[]` of size m → capacity of each box.
 *
 * Goal:
 * Find the minimum number of boxes required to redistribute all apples.
 * Note: Apples from the same pack can be split across boxes.
 *
 * Example 1:
 * Input: apple = [1,3,2], capacity = [4,3,1,5,2]
 * Output: 2
 *
 * Example 2:
 * Input: apple = [5,5,5], capacity = [2,4,2,7]
 * Output: 4
 *
 * Constraints:
 * 1 <= n, m <= 50
 * 1 <= apple[i], capacity[i] <= 50
 * Redistribution is always possible.
 */
public class AppleRedistribution {

    /**
     * Method to calculate minimum number of boxes required.
     *
     * @param apple    number of apples in each pack
     * @param capacity capacities of boxes
     * @return minimum number of boxes needed
     */
    public int minimumBoxes(int[] apple, int[] capacity) {
        int totalApples = sumArray(apple);

        Arrays.sort(capacity); // sort capacities in ascending order

        int sum = 0;
        int used = 0;
        for (int i = capacity.length - 1; i >= 0; i--) {
            sum += capacity[i];
            used++;
            if (sum >= totalApples) {
                return used;
            }
        }
        return used; // fallback
    }

    /**
     * Helper method to calculate sum of an array.
     */
    private int sumArray(int[] arr) {
        int sum = 0;
        for (int num : arr) sum += num;
        return sum;
    }

    /**
     * Main method for quick testing.
     */
    public static void main(String[] args) {
        AppleRedistribution solution = new AppleRedistribution();

        int[] apple1 = {1, 3, 2};
        int[] capacity1 = {4, 3, 1, 5, 2};
        System.out.println(solution.minimumBoxes(apple1, capacity1)); // 2

        int[] apple2 = {5, 5, 5};
        int[] capacity2 = {2, 4, 2, 7};
        System.out.println(solution.minimumBoxes(apple2, capacity2)); // 4
    }
}
