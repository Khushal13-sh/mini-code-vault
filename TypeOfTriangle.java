/**
 * Problem: Type of Triangle
 * Difficulty: Easy
 *
 * Description:
 * You are given an integer array nums of size 3 that represents the lengths of the sides of a triangle.
 * The task is to determine the type of triangle:
 *  - "equilateral" → all sides equal
 *  - "isosceles"   → exactly two sides equal
 *  - "scalene"     → all sides different
 *  - "none"        → if the given sides cannot form a triangle
 *
 * Note: A valid triangle must satisfy the triangle inequality:
 *       a + b > c, a + c > b, b + c > a
 *
 * Example 1:
 * Input:  nums = [3, 3, 3]
 * Output: "equilateral"
 *
 * Example 2:
 * Input:  nums = [3, 4, 5]
 * Output: "scalene"
 *
 * Constraints:
 * - nums.length == 3
 * - 1 <= nums[i] <= 100
 *
 * Approach:
 * 1. Extract sides a, b, c.
 * 2. Check triangle inequality; if not satisfied → return "none".
 * 3. Check equality of sides:
 *      - All equal → "equilateral"
 *      - Exactly two equal → "isosceles"
 *      - All different → "scalene"
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */
public class TypeOfTriangle {

    /**
     * Determines the type of triangle.
     *
     * @param nums array of 3 integers representing triangle sides
     * @return type of triangle as a string
     */
    public String triangleType(int[] nums) {
        int a = nums[0], b = nums[1], c = nums[2];

        // Step 1: Check triangle inequality
        if (a + b <= c || a + c <= b || b + c <= a) {
            return "none";
        }

        // Step 2: Check side equality
        if (a == b && b == c) {
            return "equilateral";
        } else if (a == b || b == c || a == c) {
            return "isosceles";
        } else {
            return "scalene";
        }
    }

    /**
     * Main method for testing.
     */
    public static void main(String[] args) {
        TypeOfTriangle solution = new TypeOfTriangle();

        System.out.println("Output [3,3,3]: " + solution.triangleType(new int[]{3, 3, 3})); // equilateral
        System.out.println("Output [3,4,5]: " + solution.triangleType(new int[]{3, 4, 5})); // scalene
        System.out.println("Output [2,2,3]: " + solution.triangleType(new int[]{2, 2, 3})); // isosceles
        System.out.println("Output [1,2,3]: " + solution.triangleType(new int[]{1, 2, 3})); // none
    }
}
