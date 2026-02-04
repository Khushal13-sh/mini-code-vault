/**
 * ------------------------------------------------------------
 * Class Name : MatrixCellsInDistanceOrder
 *
 * Description :
 * Returns all matrix cell coordinates sorted by their
 * Manhattan distance from a given center cell.
 *
 * ------------------------------------------------------------
 */
public class MatrixCellsInDistanceOrder {

    /**
     * Returns cells sorted by distance from (rCenter, cCenter).
     */
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int[][] result = new int[rows * cols][2];
        int index = 0;

        // Store all cell coordinates
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[index][0] = i;
                result[index][1] = j;
                index++;
            }
        }

        // Bubble sort based on Manhattan distance
        for (int i = 0; i < result.length - 1; i++) {
            for (int j = 0; j < result.length - 1 - i; j++) {

                int d1 = Math.abs(result[j][0] - rCenter)
                       + Math.abs(result[j][1] - cCenter);

                int d2 = Math.abs(result[j + 1][0] - rCenter)
                       + Math.abs(result[j + 1][1] - cCenter);

                if (d1 > d2) {
                    int tempRow = result[j][0];
                    int tempCol = result[j][1];

                    result[j][0] = result[j + 1][0];
                    result[j][1] = result[j + 1][1];

                    result[j + 1][0] = tempRow;
                    result[j + 1][1] = tempCol;
                }
            }
        }

        return result;
    }

    /**
     * Test cases.
     */
    public static void main(String[] args) {
        MatrixCellsInDistanceOrder solution = new MatrixCellsInDistanceOrder();

        print(solution.allCellsDistOrder(1, 2, 0, 0));
        print(solution.allCellsDistOrder(2, 2, 0, 1));
        print(solution.allCellsDistOrder(2, 3, 1, 2));
    }

    private static void print(int[][] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("[" + arr[i][0] + "," + arr[i][1] + "]");
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
