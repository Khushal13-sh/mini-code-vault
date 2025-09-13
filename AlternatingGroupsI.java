/**
 * Problem: Alternating Groups I
 * Difficulty: Easy
 *
 * There is a circle of red and blue tiles.
 * - colors[i] = 0 → tile i is red
 * - colors[i] = 1 → tile i is blue
 *
 * An alternating group is defined as 3 contiguous tiles in the circle
 * where the middle tile has a different color than both of its neighbors.
 *
 * Task:
 * Return the number of alternating groups.
 *
 * Example 1:
 * Input: colors = [1,1,1]
 * Output: 0
 *
 * Example 2:
 * Input: colors = [0,1,0,0,1]
 * Output: 3
 *
 * Constraints:
 * 3 <= colors.length <= 100
 * 0 <= colors[i] <= 1
 */
public class AlternatingGroupsI {

    /**
     * Function to count alternating groups
     *
     * @param colors array of colors (0 = red, 1 = blue)
     * @return number of alternating groups
     */
    public int numberOfAlternatingGroups(int[] colors) {
        int n = colors.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int left = colors[(i - 1 + n) % n];
            int mid = colors[i];
            int right = colors[(i + 1) % n];

            if (mid != left && mid != right) {
                count++;
            }
        }
        return count;
    }

    // Main method for quick testing
    public static void main(String[] args) {
        AlternatingGroupsI solution = new AlternatingGroupsI();

        int[] colors1 = {1, 1, 1};
        System.out.println(solution.numberOfAlternatingGroups(colors1)); // 0

        int[] colors2 = {0, 1, 0, 0, 1};
        System.out.println(solution.numberOfAlternatingGroups(colors2)); // 3

        int[] colors3 = {0, 1, 0};
        System.out.println(solution.numberOfAlternatingGroups(colors3)); // 3 (all form alternating groups)
    }
}
