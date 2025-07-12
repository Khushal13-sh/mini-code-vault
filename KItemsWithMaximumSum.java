/**
 * Problem: K Items With the Maximum Sum
 * Difficulty: Easy
 *
 * We are given the number of 1s, 0s, and -1s in a bag and we want to pick `k` items to
 * maximize the total sum. Always prioritize:
 * 1s ➝ then 0s ➝ then -1s.
 */

public class KItemsWithMaximumSum {

    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int sum = 0;

        int takeOnes = Math.min(numOnes, k);
        sum += takeOnes;
        k -= takeOnes;

        int takeZeros = Math.min(numZeros, k);
        k -= takeZeros;

        int takeNegOnes = Math.min(numNegOnes, k);
        sum -= takeNegOnes;

        return sum;
    }

    public static void main(String[] args) {
        KItemsWithMaximumSum solution = new KItemsWithMaximumSum();

        System.out.println(solution.kItemsWithMaximumSum(3, 2, 0, 2)); // Output: 2
        System.out.println(solution.kItemsWithMaximumSum(3, 2, 0, 4)); // Output: 3
        System.out.println(solution.kItemsWithMaximumSum(1, 1, 3, 3)); // Output: 0 (1+0-1)
        System.out.println(solution.kItemsWithMaximumSum(0, 0, 5, 3)); // Output: -3
        System.out.println(solution.kItemsWithMaximumSum(2, 1, 1, 4)); // Output: 2 (1+1+0+-1)
    }
}
