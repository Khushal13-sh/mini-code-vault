/**
 * ------------------------------------------------------------
 * Class Name : FindMaximumDivisibilityScore
 *
 * Description :
 * Finds the divisor having the highest divisibility score.
 * If multiple divisors have the same score,
 * returns the smallest divisor.
 *
 * ------------------------------------------------------------
 */
public class FindMaximumDivisibilityScore {

    /**
     * Returns divisor with maximum divisibility score.
     */
    public int maxDivScore(int[] nums, int[] divisors) {

        int maxScore = -1;
        int result = Integer.MAX_VALUE;

        // Check each divisor
        for (int divisor : divisors) {

            int score = 0;

            // Count divisible numbers
            for (int num : nums) {
                if (num % divisor == 0) {
                    score++;
                }
            }

            // Update result
            if (score > maxScore ||
               (score == maxScore && divisor < result)) {

                maxScore = score;
                result = divisor;
            }
        }

        return result;
    }

    /**
     * Test cases.
     */
    public static void main(String[] args) {

        FindMaximumDivisibilityScore solution =
                new FindMaximumDivisibilityScore();

        System.out.println(solution.maxDivScore(
                new int[]{2,9,15,50},
                new int[]{5,3,7,2}
        )); // 2

        System.out.println(solution.maxDivScore(
                new int[]{4,7,9,3,9},
                new int[]{5,2,3}
        )); // 3
    }
}