/**
 * ------------------------------------------------------------
 * Class Name : DivisibleAndNonDivisibleSumsDifference
 *
 * Description :
 * Calculates the difference between the sum of numbers
 * not divisible by m and the sum of numbers divisible by m
 * in range [1, n].
 *
 * ------------------------------------------------------------
 */
public class DivisibleAndNonDivisibleSumsDifference {

    /**
     * Returns num1 - num2.
     */
    public int differenceOfSums(int n, int m) {

        int num1 = 0;
        int num2 = 0;

        // Traverse numbers from 1 to n
        for (int i = 1; i <= n; i++) {

            if (i % m == 0) {
                num2 += i;   // divisible by m
            } else {
                num1 += i;   // not divisible by m
            }
        }

        return num1 - num2;
    }

    /**
     * Test cases.
     */
    public static void main(String[] args) {

        DivisibleAndNonDivisibleSumsDifference solution =
                new DivisibleAndNonDivisibleSumsDifference();

        System.out.println(solution.differenceOfSums(10, 3)); // 19
        System.out.println(solution.differenceOfSums(5, 6));  // 15
        System.out.println(solution.differenceOfSums(5, 1));  // -15
    }
}