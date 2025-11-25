/**
 * Problem: Points That Intersect With Cars
 * Difficulty: Easy
 *
 * Count how many unique integer points on the number line
 * are covered by at least one car. Each car covers a range
 * from start to end (inclusive). We mark covered points in
 * a boolean array of size 101 since constraints are small.
 */

import java.util.*;

public class PointsThatIntersectWithCars {

    public int numberOfPoints(List<List<Integer>> nums) {
        boolean[] covered = new boolean[101];  // Range is 1 to 100
        int count = 0;

        // Iterate over each car's start and end range
        for (List<Integer> car : nums) {
            int start = car.get(0);
            int end = car.get(1);

            for (int p = start; p <= end; p++) {

                // Mark point if not already counted
                if (!covered[p]) {
                    covered[p] = true;
                    count++;
                }
            }
        }

        return count;
    }

    // ------------ MAIN METHOD FOR TESTING ------------
    public static void main(String[] args) {
        PointsThatIntersectWithCars sol = new PointsThatIntersectWithCars();

        List<List<Integer>> nums1 = Arrays.asList(
            Arrays.asList(3, 6),
            Arrays.asList(1, 5),
            Arrays.asList(4, 7)
        );

        List<List<Integer>> nums2 = Arrays.asList(
            Arrays.asList(1, 3),
            Arrays.asList(5, 8)
        );

        System.out.println(sol.numberOfPoints(nums1)); // Output: 7
        System.out.println(sol.numberOfPoints(nums2)); // Output: 7
    }
}
