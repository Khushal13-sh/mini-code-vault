/**
 * Problem: Rectangle Overlap
 * Difficulty: Easy
 *
 * Given two axis-aligned rectangles, determine if they overlap.
 */

public class RectangleOverlap {

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int xOverlap = min(rec1[2], rec2[2]) - max(rec1[0], rec2[0]);
        int yOverlap = min(rec1[3], rec2[3]) - max(rec1[1], rec2[1]);

        return xOverlap > 0 && yOverlap > 0;
    }

    private int max(int a, int b) {
        return (a > b) ? a : b;
    }

    private int min(int a, int b) {
        return (a < b) ? a : b;
    }

    public static void main(String[] args) {
        RectangleOverlap solution = new RectangleOverlap();

        System.out.println(solution.isRectangleOverlap(new int[]{0, 0, 2, 2}, new int[]{1, 1, 3, 3})); // true
        System.out.println(solution.isRectangleOverlap(new int[]{0, 0, 1, 1}, new int[]{1, 0, 2, 1})); // false
        System.out.println(solution.isRectangleOverlap(new int[]{0, 0, 1, 1}, new int[]{2, 2, 3, 3})); // false
    }
}
