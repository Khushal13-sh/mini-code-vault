/*
 add solution for finding smallest pair with different frequencies
*/

/**
 * Problem: Smallest Pair With Different Frequencies
 * Difficulty: Easy
 *
 * Description:
 * Given an integer array nums, find two distinct values
 * x and y such that:
 *
 * - x < y
 * - frequency(x) != frequency(y)
 *
 * Among all valid pairs:
 * - Choose the smallest possible x
 * - If multiple pairs have the same x,
 *   choose the smallest possible y
 *
 * Return [x, y].
 * If no valid pair exists, return [-1, -1].
 *
 * Key Insight:
 * - Count frequency of every distinct value.
 * - Sort distinct values.
 * - Check pairs in increasing order.
 * - The first valid pair automatically satisfies
 *   the required ordering conditions.
 *
 * Approach:
 * 1. Build frequency map.
 * 2. Store distinct values in a list.
 * 3. Sort the list.
 * 4. Iterate through all pairs (x, y).
 * 5. Return first pair having different frequencies.
 *
 * Why this works:
 * Sorted traversal guarantees:
 * - Smallest x is checked first.
 * - For the same x, smallest y is checked first.
 *
 * Therefore, the first valid pair is the answer.
 *
 * Time Complexity: O(d²)
 * d = number of distinct values
 *
 * Space Complexity: O(d)
 */
public class SmallestPairWithDifferentFrequencies {

    public int[] minDistinctFreqPair(int[] nums) {

        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<Integer> values = new ArrayList<>(freq.keySet());
        Collections.sort(values);

        for (int i = 0; i < values.size(); i++) {

            int x = values.get(i);

            for (int j = i + 1; j < values.size(); j++) {

                int y = values.get(j);

                if (!freq.get(x).equals(freq.get(y))) {
                    return new int[]{x, y};
                }
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {

        SmallestPairWithDifferentFrequencies obj =
                new SmallestPairWithDifferentFrequencies();

        // Example 1
        int[] nums1 = {1, 1, 2, 2, 3, 4};
        int[] ans1 = obj.minDistinctFreqPair(nums1);

        System.out.println(
                "Output 1: [" + ans1[0] + ", " + ans1[1] + "]"
        );

        // Example 2
        int[] nums2 = {1, 5};
        int[] ans2 = obj.minDistinctFreqPair(nums2);

        System.out.println(
                "Output 2: [" + ans2[0] + ", " + ans2[1] + "]"
        );

        // Example 3
        int[] nums3 = {7};
        int[] ans3 = obj.minDistinctFreqPair(nums3);

        System.out.println(
                "Output 3: [" + ans3[0] + ", " + ans3[1] + "]"
        );
    }
}