/**
 * Problem Title: Relative Ranks
 * Difficulty: Easy
 * 
 * Problem Description:
 * You are given an integer array 'score' of size n, where score[i] is the score of the i-th athlete.
 * All scores are unique.
 * 
 * Athletes are ranked based on their scores:
 * - 1st place: "Gold Medal"
 * - 2nd place: "Silver Medal"
 * - 3rd place: "Bronze Medal"
 * - 4th place and onward: Use the placement number as a string (e.g., "4", "5", etc.)
 * 
 * 🧠 Goal:
 * Return an array of strings where each element is the rank of the i-th athlete.
 * 
 * 📥 Example 1:
 * Input:  [5, 4, 3, 2, 1]
 * Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * 
 * 📥 Example 2:
 * Input:  [10, 3, 8, 9, 4]
 * Output: ["Gold Medal", "5", "Bronze Medal", "Silver Medal", "4"]
 * 
 * 📌 Constraints:
 * - 1 <= score.length <= 10^4
 * - 0 <= score[i] <= 10^6
 * - All values in score[] are unique
 */

import java.util.*;

public class RelativeRanks {

    public static String[] findRelativeRanks(int[] score) {
        // Step 1: Create a copy and sort it to determine rank
        int[] sortedScore = Arrays.copyOf(score, score.length);
        Arrays.sort(sortedScore);

        // Step 2: Map each score to its corresponding rank
        Map<Integer, String> scoreMap = new HashMap<>();
        int len = sortedScore.length;
        int rank = 4;

        for (int i = len - 1; i >= 0; i--) {
            if (i == len - 1) {
                scoreMap.put(sortedScore[i], "Gold Medal");
            } else if (i == len - 2) {
                scoreMap.put(sortedScore[i], "Silver Medal");
            } else if (i == len - 3) {
                scoreMap.put(sortedScore[i], "Bronze Medal");
            } else {
                scoreMap.put(sortedScore[i], String.valueOf(rank++));
            }
        }

        // Step 3: Build the result using the original order of scores
        String[] result = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            result[i] = scoreMap.get(score[i]);
        }

        return result;
    }

    // Test the logic with main method (Optional)
    public static void main(String[] args) {
        int[] input1 = {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(findRelativeRanks(input1)));

        int[] input2 = {10, 3, 8, 9, 4};
        System.out.println(Arrays.toString(findRelativeRanks(input2)));
    }
}
