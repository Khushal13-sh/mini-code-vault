/**
 * Problem: Find the Pivot Integer
 * Difficulty: Easy
 *
 * Given a positive integer n, find the pivot integer x such that:
 * The sum of all elements between 1 and x inclusively equals
 * the sum of all elements between x and n inclusively.
 *
 * Return the pivot integer x. If no such integer exists, return -1.
 * It is guaranteed that there will be at most one pivot index for the given input.
 *
 * Example 1:
 * Input: n = 8
 * Output: 6
 * Explanation: 1 + 2 + 3 + 4 + 5 + 6 = 6 + 7 + 8 = 21
 *
 * Example 2:
 * Input: n = 1
 * Output: 1
 * Explanation: 1 = 1
 *
 * Example 3:
 * Input: n = 4
 * Output: -1
 * Explanation: No pivot integer exists.
 *
 * Constraints:
 * 1 <= n <= 1000
 *
 * Approach:
 * - Total sum from 1 to n = n * (n + 1) / 2
 * - Iterate from 1 to n, maintain prefix sum.
 * - At index i, leftSum = sum(1..i), rightSum = total - leftSum + i
 * - If leftSum == rightSum, return i.
 */
public class FindPivotInteger {

    public int pivotInteger(int n) {
        int total = n * (n + 1) / 2;
        int leftSum = 0;

        for (int i = 1; i <= n; i++) {
            leftSum += i;
            int rightSum = total - leftSum + i;

            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }

    // Quick test cases
    public static void main(String[] args) {
        FindPivotInteger solution = new FindPivotInteger();

        System.out.println(solution.pivotInteger(8));  // 6
        System.out.println(solution.pivotInteger(1));  // 1
        System.out.println(solution.pivotInteger(4));  // -1
        System.out.println(solution.pivotInteger(10)); // -1
    }
}
