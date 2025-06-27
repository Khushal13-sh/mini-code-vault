/**
 * Problem: Fair Candy Swap
 * Difficulty: Easy
 *
 * Alice and Bob want to exchange one candy box each so that their total candy counts are equal.
 * We find the difference in their totals, divide it by 2 to get the offset (delta).
 * Then we find a pair (a, b) such that a - b = delta.
 */

import java.util.*;

public class FairCandySwap {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sumA = 0, sumB = 0;

        for (int a : aliceSizes) sumA += a;
        for (int b : bobSizes) sumB += b;

        int delta = (sumA - sumB) / 2;

        Set<Integer> setB = new HashSet<>();
        for (int b : bobSizes) {
            setB.add(b);
        }

        for (int a : aliceSizes) {
            int b = a - delta;
            if (setB.contains(b)) {
                return new int[]{a, b};
            }
        }

        return new int[0]; // guaranteed to have an answer
    }

    public static void main(String[] args) {
        FairCandySwap solution = new FairCandySwap();

        int[] a1 = {1, 1}, b1 = {2, 2};
        System.out.println(Arrays.toString(solution.fairCandySwap(a1, b1))); // [1, 2]

        int[] a2 = {1, 2}, b2 = {2, 3};
        System.out.println(Arrays.toString(solution.fairCandySwap(a2, b2))); // [1, 2]

        int[] a3 = {2}, b3 = {1, 3};
        System.out.println(Arrays.toString(solution.fairCandySwap(a3, b3))); // [2, 3]
    }
}
