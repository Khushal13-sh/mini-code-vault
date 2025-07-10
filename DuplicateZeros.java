/**
 * Problem: Duplicate Zeros
 * Difficulty: Easy
 *
 * Duplicate each occurrence of zero in the array and shift the remaining elements to the right.
 * Modifications must be done in-place and elements beyond original length are ignored.
 */

public class DuplicateZeros {

    public void duplicateZeros(int[] arr) {
        int len = arr.length;

        for (int i = 0; i < len - 1; i++) {
            if (arr[i] == 0) {
                // Shift elements to the right from the end
                for (int j = len - 2; j >= i + 1; j--) {
                    arr[j + 1] = arr[j];
                }
                arr[i + 1] = 0; // Duplicate the zero
                i++; // Skip the duplicated zero
            }
        }
    }

    public static void main(String[] args) {
        DuplicateZeros solution = new DuplicateZeros();

        int[] arr1 = {1, 0, 2, 3, 0, 4, 5, 0};
        solution.duplicateZeros(arr1);
        System.out.println(java.util.Arrays.toString(arr1)); // [1, 0, 0, 2, 3, 0, 0, 4]

        int[] arr2 = {1, 2, 3};
        solution.duplicateZeros(arr2);
        System.out.println(java.util.Arrays.toString(arr2)); // [1, 2, 3]

        int[] arr3 = {0, 0, 0, 0, 0, 0, 0};
        solution.duplicateZeros(arr3);
        System.out.println(java.util.Arrays.toString(arr3)); // [0, 0, 0, 0, 0, 0, 0]
    }
}
