/**
 * ------------------------------------------------------------
 * Problem : Valid Mountain Array
 * Class   : MountainArrayValidator
 * ------------------------------------------------------------
 */

public class MountainArrayValidator {

    public boolean validMountainArray(int[] arr) {

        int n = arr.length;

        if (n < 3) return false;

        int i = 0;

        // Climb up
        while (i + 1 < n && arr[i] < arr[i + 1]) {
            i++;
        }

        // Peak check
        if (i == 0 || i == n - 1) return false;

        // Climb down
        while (i + 1 < n && arr[i] > arr[i + 1]) {
            i++;
        }

        return i == n - 1;
    }

    public static void main(String[] args) {

        MountainArrayValidator obj = new MountainArrayValidator();

        // Example 1
        int[] arr1 = {2,1};
        System.out.println("Output: " + obj.validMountainArray(arr1));
        // Expected: false

        // Example 2
        int[] arr2 = {3,5,5};
        System.out.println("Output: " + obj.validMountainArray(arr2));
        // Expected: false

        // Example 3
        int[] arr3 = {0,3,2,1};
        System.out.println("Output: " + obj.validMountainArray(arr3));
        // Expected: true
    }
}