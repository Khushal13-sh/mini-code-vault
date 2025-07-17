/**
 * Problem: Find the Town Judge
 * Difficulty: Easy
 *
 * In a town of n people, return the label of the town judge if they exist.
 * The town judge trusts nobody and is trusted by everyone else.
 */

import java.util.*;

public class FindTownJudge {

    public int findJudge(int n, int[][] trust) {
        Set<Integer> trusters = new HashSet<>();
        Map<Integer, Integer> trustedCount = new HashMap<>();

        for (int[] t : trust) {
            trusters.add(t[0]);
            trustedCount.put(t[1], trustedCount.getOrDefault(t[1], 0) + 1);
        }

        for (int i = 1; i <= n; i++) {
            if (!trusters.contains(i) && trustedCount.getOrDefault(i, 0) == n - 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        FindTownJudge solution = new FindTownJudge();

        System.out.println(solution.findJudge(2, new int[][]{{1, 2}}));            // Output: 2
        System.out.println(solution.findJudge(3, new int[][]{{1, 3}, {2, 3}}));   // Output: 3
        System.out.println(solution.findJudge(3, new int[][]{{1, 3}, {2, 3}, {3, 1}})); // Output: -1
    }
}
