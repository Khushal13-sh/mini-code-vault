/**
 * Problem: Earliest Finish Time for Land and Water Rides I
 * Difficulty: Easy
 *
 * Description:
 * You are given two categories of theme park attractions:
 *  - Land rides: have start times (landStartTime[i]) and durations (landDuration[i])
 *  - Water rides: have start times (waterStartTime[j]) and durations (waterDuration[j])
 *
 * The tourist must complete exactly one ride from each category, in either order:
 *   → Land → Water, OR Water → Land.
 *
 * A ride can only start at or after its start time.
 * Once a ride finishes, the tourist can start the next immediately if it's open, 
 * or wait until it opens.
 *
 * Goal:
 * Return the earliest possible finish time after completing one ride from each category.
 *
 * Example 1:
 * Input:
 *   landStartTime = [2,8]
 *   landDuration = [4,1]
 *   waterStartTime = [6]
 *   waterDuration = [3]
 * Output: 9
 *
 * Explanation:
 *   - Best plan: Land ride 0 → Water ride 0
 *     Start land 0 at 2 → finish 6
 *     Start water 0 at 6 → finish 9 ✅
 *
 * Example 2:
 * Input:
 *   landStartTime = [5]
 *   landDuration = [3]
 *   waterStartTime = [1]
 *   waterDuration = [10]
 * Output: 14
 *
 * Explanation:
 *   - Best plan: Water ride 0 → Land ride 0
 *     Start water 0 at 1 → finish 11
 *     Start land 0 at 11 → finish 14 ✅
 *
 * Approach:
 * - Try every possible pair of (land ride, water ride).
 * - Compute earliest finish for both orders (land→water and water→land).
 * - Track the smallest final finish time.
 *
 * Time Complexity: O(n * m)
 * Space Complexity: O(1)
 */

public class EarliestFinishTimeRides {

    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {

        int minFinish = Integer.MAX_VALUE;

        for (int i = 0; i < landStartTime.length; i++) {
            for (int j = 0; j < waterStartTime.length; j++) {

                // Case 1: Land ride first → Water ride next
                int endLand = landStartTime[i] + landDuration[i];
                int startWater = Math.max(endLand, waterStartTime[j]);
                int finishLandFirst = startWater + waterDuration[j];

                // Case 2: Water ride first → Land ride next
                int endWater = waterStartTime[j] + waterDuration[j];
                int startLand = Math.max(endWater, landStartTime[i]);
                int finishWaterFirst = startLand + landDuration[i];

                // Pick the smaller finish time for this (i, j) pair
                int currentMin = Math.min(finishLandFirst, finishWaterFirst);

                // Update global minimum finish time
                minFinish = Math.min(minFinish, currentMin);
            }
        }

        return minFinish;
    }

    // main() method for testing
    public static void main(String[] args) {
        EarliestFinishTimeRides solution = new EarliestFinishTimeRides();

        int[] landStart1 = {2, 8};
        int[] landDur1 = {4, 1};
        int[] waterStart1 = {6};
        int[] waterDur1 = {3};
        System.out.println("Example 1 Output: " +
            solution.earliestFinishTime(landStart1, landDur1, waterStart1, waterDur1));
        // Expected: 9

        int[] landStart2 = {5};
        int[] landDur2 = {3};
        int[] waterStart2 = {1};
        int[] waterDur2 = {10};
        System.out.println("Example 2 Output: " +
            solution.earliestFinishTime(landStart2, landDur2, waterStart2, waterDur2));
        // Expected: 14
    }
}
