import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Pascal's Triangle
 * Difficulty: Easy
 *
 * Generate the first numRows of Pascal's Triangle,
 * where each element is the sum of the two elements above it.
 */
public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            // First element is always 1
            row.add(1);

            // Compute inner elements using previous row
            for (int j = 1; j < i; j++) {
                int value = triangle.get(i - 1).get(j - 1)
                        + triangle.get(i - 1).get(j);
                row.add(value);
            }

            // Last element is always 1 (except for the first row)
            if (i > 0) {
                row.add(1);
            }

            triangle.add(row);
        }

        return triangle;
    }

    // Main method for testing
    public static void main(String[] args) {
        PascalsTriangle obj = new PascalsTriangle();

        System.out.println(obj.generate(5));
        // [[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1]]

        System.out.println(obj.generate(1));
        // [[1]]
    }
}
