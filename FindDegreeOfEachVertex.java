/*
 add solution for finding degree of each vertex using adjacency matrix
*/

/**
 * Problem: Find the Degree of Each Vertex
 * Difficulty: Easy
 *
 * Description:
 * Given an adjacency matrix of an undirected graph,
 * return the degree of every vertex.
 *
 * The degree of a vertex is the number of edges
 * connected to that vertex.
 *
 * Key Insight:
 * In an adjacency matrix:
 * - matrix[i][j] = 1 means an edge exists
 * - Degree of a vertex equals the sum of its row
 *
 * Approach:
 * - Traverse each row of the matrix
 * - Count total number of 1s in that row
 * - Store the count in answer array
 *
 * Why this works:
 * Each row represents all connections of a vertex.
 * Summing the row directly gives its degree.
 *
 * Time Complexity: O(n²)
 * n = number of vertices
 *
 * Space Complexity: O(1)
 * (excluding output array)
 */
public class FindDegreeOfEachVertex {

    public int[] findDegrees(int[][] matrix) {

        int n = matrix.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {

            int degree = 0;

            for (int j = 0; j < n; j++) {
                degree += matrix[i][j];
            }

            ans[i] = degree;
        }

        return ans;
    }

    public static void main(String[] args) {

        FindDegreeOfEachVertex obj =
                new FindDegreeOfEachVertex();

        // Example 1
        int[][] matrix1 = {
                {0, 1, 1},
                {1, 0, 1},
                {1, 1, 0}
        };

        int[] result1 = obj.findDegrees(matrix1);

        System.out.print("Output 1: ");
        for (int num : result1) {
            System.out.print(num + " ");
        }

        System.out.println();

        // Example 2
        int[][] matrix2 = {
                {0, 1, 0},
                {1, 0, 0},
                {0, 0, 0}
        };

        int[] result2 = obj.findDegrees(matrix2);

        System.out.print("Output 2: ");
        for (int num : result2) {
            System.out.print(num + " ");
        }

        System.out.println();

        // Example 3
        int[][] matrix3 = {
                {0}
        };

        int[] result3 = obj.findDegrees(matrix3);

        System.out.print("Output 3: ");
        for (int num : result3) {
            System.out.print(num + " ");
        }
    }
}