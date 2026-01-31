import java.util.Arrays;

/**
 * ------------------------------------------------------------
 * Class Name : WidestVerticalArea
 *
 * Description :
 * Finds the maximum distance between two vertical lines formed
 * by x-coordinates such that no points lie between them.
 *
 * ------------------------------------------------------------
 */
public class WidestVerticalArea {

    /**
     * Returns the widest vertical area.
     */
    public int maxWidthOfVerticalArea(int[][] points) {
        int n = points.length;
        int[] xCoords = new int[n];

        // Extract x-coordinates
        for (int i = 0; i < n; i++) {
            xCoords[i] = points[i][0];
        }

        // Sort x-coordinates
        Arrays.sort(xCoords);

        int maxWidth = 0;

        // Find maximum difference between consecutive x-values
        for (int i = 1; i < n; i++) {
            int width = xCoords[i] - xCoords[i - 1];
            if (width > maxWidth) {
                maxWidth = width;
            }
        }

        return maxWidth;
    }

    /**
     * Test cases.
     */
    public static void main(String[] args) {
        WidestVerticalArea solution = new WidestVerticalArea();

        int[][] points1 = {{8,7}, {9,9}, {7,4}, {9,7}};
        System.out.println("Example 1 Output: " +
                solution.maxWidthOfVerticalArea(points1)); // 1

        int[][] points2 = {{3,1}, {9,0}, {1,0}, {1,4}, {5,3}, {8,8}};
        System.out.println("Example 2 Output: " +
                solution.maxWidthOfVerticalArea(points2)); // 3
    }
}
