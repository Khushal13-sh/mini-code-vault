/**
 * PROBLEM: Sum of Compatible Numbers in Range I
 * * Description:
 * Given two integers n and k, a positive integer x is called compatible if 
 * it satisfies both of the following conditions:
 * 1. abs(n - x) <= k
 * 2. (n & x) == 0
 * * Return the sum of all compatible integers x.
 * * Constraints:
 * 1 <= n <= 100
 * 1 <= k <= 100
 */
public class SumOfCompatibleNumbers {

    /**
     * Calculates the sum of all positive compatible integers x for given n and k.
     * * @param n The base integer.
     * @param k The maximum allowed absolute difference.
     * @return The sum of all compatible integers.
     */
    public int sumOfGoodIntegers(int n, int k) {
        int sum = 0;
        
        // The condition abs(n - x) <= k mathematically expands to: n - k <= x <= n + k.
        // Because the problem specifies x must be a *positive* integer, 
        // we use Math.max(1, ...) to prevent the lower bound from dropping below 1.
        int lowerBound = Math.max(1, n - k);
        int upperBound = n + k;
        
        // Loop through all potential candidates within the bounded range
        for (int x = lowerBound; x <= upperBound; x++) {
            
            // Check bitwise condition: n and x must share no common set bits (n & x == 0).
            // Parentheses around (n & x) are critical because '==' has higher precedence than '&'.
            if ((n & x) == 0) {
                sum += x; // Add to running total if both conditions are met
            }
        }
        
        return sum;
    }

    // Main method included for convenient local verification
    public static void main(String[] args) {
        SumOfCompatibleNumbers program = new SumOfCompatibleNumbers();
        
        // Example 1: Expected output is 10
        System.out.println("Test Case 1: " + program.sumOfGoodIntegers(2, 3));
        
        // Example 2: Expected output is 0
        System.out.println("Test Case 2: " + program.sumOfGoodIntegers(5, 1));
    }
}