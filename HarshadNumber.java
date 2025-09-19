/**
 * Problem: Harshad Number
 * Difficulty: Easy
 *
 * An integer divisible by the sum of its digits is called a Harshad number.
 * You are given an integer x.
 * Return the sum of the digits of x if x is a Harshad number,
 * otherwise, return -1.
 *
 * Example 1:
 * Input: x = 18
 * Output: 9
 * Explanation: The sum of digits of 18 is 9. Since 18 is divisible by 9, it is a Harshad number.
 *
 * Example 2:
 * Input: x = 23
 * Output: -1
 * Explanation: The sum of digits of 23 is 5. Since 23 is not divisible by 5, it is not a Harshad number.
 *
 * Constraints:
 * - 1 <= x <= 100
 */

public class HarshadNumber {
    
    // Method to check Harshad number and return sum of digits or -1
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int original = x;
        int sum = 0;

        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }

        return (original % sum == 0) ? sum : -1;
    }

    // Main method to test
    public static void main(String[] args) {
        HarshadNumber obj = new HarshadNumber();

        int x1 = 18;
        System.out.println("Input: " + x1 + " → Output: " + obj.sumOfTheDigitsOfHarshadNumber(x1));
        
        int x2 = 23;
        System.out.println("Input: " + x2 + " → Output: " + obj.sumOfTheDigitsOfHarshadNumber(x2));
        
        int x3 = 100;
        System.out.println("Input: " + x3 + " → Output: " + obj.sumOfTheDigitsOfHarshadNumber(x3));
    }
}
