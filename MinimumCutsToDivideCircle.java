/**
 * ------------------------------------------------------------
 * Class Name : MinimumCutsToDivideCircle
 *
 * Description :
 * Calculates the minimum number of cuts required to divide
 * a circle into n equal slices.
 *
 * ------------------------------------------------------------
 */
public class MinimumCutsToDivideCircle {

    /**
     * Returns the minimum number of cuts needed.
     */
    public int numberOfCuts(int n) {
        // If only one slice, no cuts needed
        if (n == 1) {
            return 0;
        }

        // Even slices can be formed with n/2 cuts
        if (n % 2 == 0) {
            return n / 2;
        }

        // Odd slices require n cuts
        return n;
    }

    /**
     * Test cases.
     */
    public static void main(String[] args) {
        MinimumCutsToDivideCircle solution = new MinimumCutsToDivideCircle();

        System.out.println("Input: 4, Output: " + solution.numberOfCuts(4)); // 2
        System.out.println("Input: 3, Output: " + solution.numberOfCuts(3)); // 3
        System.out.println("Input: 1, Output: " + solution.numberOfCuts(1)); // 0
    }
}
