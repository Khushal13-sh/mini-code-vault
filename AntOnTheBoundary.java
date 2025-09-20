/**
 * Problem: Ant on the Boundary
 * Difficulty: Easy
 *
 * An ant is on a boundary. It sometimes goes left and sometimes right.
 *
 * You are given an array of non-zero integers nums. The ant starts reading nums
 * from the first element to the end. At each step:
 * - If nums[i] < 0, it moves left by -nums[i] units.
 * - If nums[i] > 0, it moves right by nums[i] units.
 *
 * Return the number of times the ant returns exactly to the boundary (position 0).
 *
 * Notes:
 * - Infinite space exists on both sides of the boundary.
 * - We only check if the ant is on the boundary after finishing nums[i] movement.
 * - Crossing the boundary mid-step does not count.
 *
 * Example 1:
 * Input: nums = [2,3,-5]
 * Output: 1
 *
 * Example 2:
 * Input: nums = [3,2,-3,-4]
 * Output: 0
 *
 * Constraints:
 * - 1 <= nums.length <= 100
 * - -10 <= nums[i] <= 10
 * - nums[i] != 0
 */
public class AntOnTheBoundary {
    public int returnToBoundaryCount(int[] nums) {
        int position = 0;
        int count = 0;

        for (int num : nums) {
            position += num;
            if (position == 0) {
                count++;
            }
        }
        return count;
    }
}

/*
================= Git Commands =================
# Save file and run the following in terminal:

git add AntOnTheBoundary.java
git commit -m "Added Ant on the Boundary solution (Easy)"
git push origin main
================================================
*/
