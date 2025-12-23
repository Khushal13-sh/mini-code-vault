/**
 * Problem: Count Pairs That Form a Complete Day I
 * Difficulty: Easy
 *
 * Count pairs (i, j) where i < j and
 * (hours[i] + hours[j]) is a multiple of 24.
 */

public class CountPairsThatFormACompleteDay {

    public int countCompleteDayPairs(int[] hours) {
        int[] count = new int[24];
        int result = 0;

        for (int h : hours) {
            int rem = h % 24;
            int needed = (24 - rem) % 24;

            result += count[needed];
            count[rem]++;
        }

        return result;
    }

    // Main method for testing
    public static void main(String[] args) {
        CountPairsThatFormACompleteDay obj =
                new CountPairsThatFormACompleteDay();

        int[] hours1 = {12, 12, 30, 24, 24};
        System.out.println("Output: " +
                obj.countCompleteDayPairs(hours1)); // 2

        int[] hours2 = {72, 48, 24, 3};
        System.out.println("Output: " +
                obj.countCompleteDayPairs(hours2)); // 3
    }
}
