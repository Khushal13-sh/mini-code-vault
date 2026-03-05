/**
 * ------------------------------------------------------------
 * Problem : Number Of Rectangles That Can Form The Largest Square
 * Class   : LargestSquareRectangleCounter
 * ------------------------------------------------------------
 */

class LargestSquareRectangleCounter {

    public int countGoodRectangles(int[][] rectangles) {

        int maxLen = 0;
        int count = 0;

        // Step 1: Find largest possible square side
        for (int[] rect : rectangles) {
            int side = Math.min(rect[0], rect[1]);
            maxLen = Math.max(maxLen, side);
        }

        // Step 2: Count rectangles that can make that square
        for (int[] rect : rectangles) {
            int side = Math.min(rect[0], rect[1]);

            if (side == maxLen) {
                count++;
            }
        }

        return count;
    }
}