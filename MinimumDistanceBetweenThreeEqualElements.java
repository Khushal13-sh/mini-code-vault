/*
 add solution for minimum distance between three equal elements using index grouping
*/

/**
 * Problem: Minimum Distance Between Three Equal Elements I
 * Difficulty: Easy
 *
 * Description:
 * Find a good tuple (i, j, k) such that:
 * - nums[i] == nums[j] == nums[k]
 * - i, j, and k are distinct indices
 *
 * Distance of a tuple:
 * abs(i - j) + abs(j - k) + abs(k - i)
 *
 * Return the minimum possible distance among all good tuples.
 * If no good tuple exists, return -1.
 *
 * Key Insight:
 * For indices in sorted order:
 *
 * i < j < k
 *
 * Distance becomes:
 * (j - i) + (k - j) + (k - i)
 * = 2 × (k - i)
 *
 * So we only need the first and third indices
 * of every consecutive group of three equal values.
 *
 * Approach:
 * - Store all positions of each number.
 * - For every value appearing at least 3 times:
 *   - Check every consecutive triplet of indices.
 *   - Compute distance = 2 × (thirdIndex - firstIndex).
 * - Keep track of the minimum distance.
 *
 * Why this works:
 * The middle index cancels out in the formula.
 * Therefore, minimizing (k - i) minimizes the distance.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class MinimumDistanceBetweenThreeEqualElements {

    public int minimumDistance(int[] nums) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int ans = Integer.MAX_VALUE;

        for (List<Integer> positions : map.values()) {

            if (positions.size() < 3) {
                continue;
            }

            for (int i = 0; i + 2 < positions.size(); i++) {

                int distance =
                        2 * (positions.get(i + 2) - positions.get(i));

                ans = Math.min(ans, distance);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {

        MinimumDistanceBetweenThreeEqualElements obj =
                new MinimumDistanceBetweenThreeEqualElements();

        // Example 1
        int[] nums1 = {1, 2, 1, 1, 3};
        System.out.println(obj.minimumDistance(nums1)); // 6

        // Example 2
        int[] nums2 = {1, 1, 2, 3, 2, 1, 2};
        System.out.println(obj.minimumDistance(nums2)); // 8

        // Example 3
        int[] nums3 = {1};
        System.out.println(obj.minimumDistance(nums3)); // -1
    }
}