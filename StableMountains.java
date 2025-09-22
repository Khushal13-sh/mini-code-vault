import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Find Indices of Stable Mountains
 * Difficulty: Easy
 *
 * You are given an integer array `height` where height[i] represents the height of mountain i,
 * and an integer `threshold`.
 *
 * A mountain is called stable if the mountain just before it (if it exists)
 * has a height strictly greater than threshold.
 * Note: Mountain 0 is never stable.
 *
 * Return an array containing the indices of all stable mountains in any order.
 *
 * Example 1:
 * Input: height = [1,2,3,4,5], threshold = 2
 * Output: [3,4]
 *
 * Example 2:
 * Input: height = [10,1,10,1,10], threshold = 3
 * Output: [1,3]
 *
 * Example 3:
 * Input: height = [10,1,10,1,10], threshold = 10
 * Output: []
 *
 * Constraints:
 * - 2 <= n == height.length <= 100
 * - 1 <= height[i] <= 100
 * - 1 <= threshold <= 100
 */
public class StableMountains {

    public List<Integer> stableMountains(int[] height, int threshold) {
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i < height.length; i++) {
            if (height[i - 1] > threshold) {
                result.add(i);
            }
        }
        return result;
    }

    // Quick test
    public static void main(String[] args) {
        StableMountains solution = new StableMountains();

        int[] h1 = {1, 2, 3, 4, 5};
        System.out.println(solution.stableMountains(h1, 2)); // [3, 4]

        int[] h2 = {10, 1, 10, 1, 10};
        System.out.println(solution.stableMountains(h2, 3)); // [1, 3]

        int[] h3 = {10, 1, 10, 1, 10};
        System.out.println(solution.stableMountains(h3, 10)); // []
    }
}
