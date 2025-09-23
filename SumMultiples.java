/**
 * Problem: Sum Multiples
 * Difficulty: Easy
 *
 * Given a positive integer n, find the sum of all integers in the range [1, n] (inclusive)
 * that are divisible by 3, 5, or 7.
 *
 * Return the total sum of these numbers.
 *
 * Example 1:
 * Input: n = 7
 * Output: 21
 * Explanation: Numbers divisible by 3, 5, or 7 → {3, 5, 6, 7}. Sum = 21.
 *
 * Example 2:
 * Input: n = 10
 * Output: 40
 * Explanation: Numbers divisible by 3, 5, or 7 → {3, 5, 6, 7, 9, 10}. Sum = 40.
 *
 * Example 3:
 * Input: n = 9
 * Output: 30
 * Explanation: Numbers divisible by 3, 5, or 7 → {3, 5, 6, 7, 9}. Sum = 30.
 *
 * Constraints:
 * - 1 <= n <= 1000
 */
public class SumMultiples {

    public int sumOfMultiples(int n) {
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
                sum += i;
            }
        }

        return sum;
    }

    // Quick test
    public static void main(String[] args) {
        SumMultiples solution = new SumMultiples();

        System.out.println(solution.sumOfMultiples(7));  // 21
        System.out.println(solution.sumOfMultiples(10)); // 40
        System.out.println(solution.sumOfMultiples(9));  // 30
    }
}
