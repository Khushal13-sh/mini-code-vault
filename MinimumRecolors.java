/**
 * Problem: Minimum Recolors to Get K Consecutive Black Blocks
 * Difficulty: Easy
 *
 * Given a string of black and white blocks, find the minimum number of white-to-black recolors
 * required to get at least one substring of length k consisting entirely of black ('B') blocks.
 */

public class MinimumRecolors {

    public int minimumRecolors(String blocks, int k) {
        int minRecolor = Integer.MAX_VALUE;

        for (int i = 0; i <= blocks.length() - k; i++) {
            String window = blocks.substring(i, i + k);
            int whiteCount = countWhite(window);
            minRecolor = Math.min(minRecolor, whiteCount);
        }

        return minRecolor;
    }

    private int countWhite(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == 'W') count++;
        }
        return count;
    }

    public static void main(String[] args) {
        MinimumRecolors solution = new MinimumRecolors();

        System.out.println(solution.minimumRecolors("WBBWWBBWBW", 7)); // Output: 3
        System.out.println(solution.minimumRecolors("WBWBBBW", 2));    // Output: 0
        System.out.println(solution.minimumRecolors("BBBBBBBB", 5));   // Output: 0
        System.out.println(solution.minimumRecolors("WWWWW", 3));      // Output: 3
    }
}
