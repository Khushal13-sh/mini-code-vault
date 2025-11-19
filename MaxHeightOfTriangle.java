public class Solution {

    public int maxHeightOfTriangle(int red, int blue) {
        
        // Try starting with Red and also with Blue
        int heightStartingRed = computeHeight(red, blue, true);
        int heightStartingBlue = computeHeight(red, blue, false);

        // Return the maximum possible height
        return Math.max(heightStartingRed, heightStartingBlue);
    }

    // Helper to calculate height based on starting color
    private int computeHeight(int red, int blue, boolean startWithRed) {
        int row = 1;                // row size starts from 1
        boolean useRed = startWithRed;

        while (true) {
            if (useRed) {
                if (red >= row) {
                    red -= row;      // allocate red balls for this row
                } else {
                    break;           // cannot form next row
                }
            } else {
                if (blue >= row) {
                    blue -= row;     // allocate blue balls for this row
                } else {
                    break;
                }
            }

            // switch color for next row
            useRed = !useRed;

            // move to next row
            row++;
        }

        // last successful row is (row - 1)
        return row - 1;
    }

    // Main method for example usage
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.maxHeightOfTriangle(2, 4)); // Output: 3
        System.out.println(sol.maxHeightOfTriangle(2, 1)); // Output: 2
        System.out.println(sol.maxHeightOfTriangle(1, 1)); // Output: 1
        System.out.println(sol.maxHeightOfTriangle(10, 1)); // Output: 2
    }
}
