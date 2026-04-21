/*
 add solution for minimum deletions to keep at most k distinct characters using frequency sorting
*/

/**
 * Problem: Minimum Deletions for At Most K Distinct Characters
 * Difficulty: Easy
 *
 * Description:
 * Remove minimum characters so that the string contains at most k distinct characters.
 *
 * Approach:
 * - Count frequency of each character
 * - Store non-zero frequencies in a list
 * - If distinct characters ≤ k → return 0
 * - Sort frequencies in descending order
 * - Keep top k frequencies, delete rest
 *
 * Why this works:
 * To minimize deletions, keep characters with highest frequency
 * and remove smaller frequency ones.
 *
 * Time Complexity: O(n + 26 log 26)
 * Space Complexity: O(1)
 */
import java.util.*;

public class MinDeletionKDistinct {

    public int minDeletion(String s, int k) {

        int[] freq = new int[26];

        // Count frequency
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        List<Integer> list = new ArrayList<>();

        // Collect non-zero frequencies
        for (int f : freq) {
            if (f > 0) {
                list.add(f);
            }
        }

        // If already valid
        if (list.size() <= k) {
            return 0;
        }

        // Sort descending
        Collections.sort(list, Collections.reverseOrder());

        int deletions = 0;

        // Remove extra characters
        for (int i = k; i < list.size(); i++) {
            deletions += list.get(i);
        }

        return deletions;
    }

    public static void main(String[] args) {
        MinDeletionKDistinct obj = new MinDeletionKDistinct();

        // Example 1
        String s1 = "abc";
        System.out.println("Output 1: " + obj.minDeletion(s1, 2)); // 1

        // Example 2
        String s2 = "aabb";
        System.out.println("Output 2: " + obj.minDeletion(s2, 2)); // 0

        // Example 3
        String s3 = "yyyzz";
        System.out.println("Output 3: " + obj.minDeletion(s3, 1)); // 2
    }
}