/**
 * Problem: Maximum Number of Balls in a Box
 * Difficulty: Easy
 *
 * Each ball is placed in a box numbered by the sum of its digits.
 * Return the count of balls in the box with the maximum number.
 */

public class MaximumBallsInBox {

    public int countBalls(int lowLimit, int highLimit) {
        int[] boxes = new int[46]; // Max digit sum for numbers up to 99999 is 9*5 = 45

        for (int i = lowLimit; i <= highLimit; i++) {
            int boxNumber = digitSum(i);
            boxes[boxNumber]++;
        }

        int maxBalls = 0;
        for (int count : boxes) {
            maxBalls = Math.max(maxBalls, count);
        }

        return maxBalls;
    }

    // Helper method to calculate digit sum
    private int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += (num % 10);
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        MaximumBallsInBox solution = new MaximumBallsInBox();

        System.out.println(solution.countBalls(1, 10));   // Output: 2
        System.out.println(solution.countBalls(5, 15));   // Output: 2
        System.out.println(solution.countBalls(19, 28));  // Output: 2
        System.out.println(solution.countBalls(999, 10000)); // Stress test
    }
}
