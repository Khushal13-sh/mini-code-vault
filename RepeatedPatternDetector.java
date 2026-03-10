/**
 * ------------------------------------------------------------
 * Problem : Detect Pattern of Length M Repeated K or More Times
 * Class   : RepeatedPatternDetector
 * ------------------------------------------------------------
 */

class RepeatedPatternDetector {

    public boolean containsPattern(int[] arr, int m, int k) {

        int count = 0;

        for (int i = 0; i + m < arr.length; i++) {

            if (arr[i] == arr[i + m]) {
                count++;

                if (count == m * (k - 1)) {
                    return true;
                }

            } else {
                count = 0;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        RepeatedPatternDetector obj = new RepeatedPatternDetector();

        // Example 1
        int[] arr1 = {1,2,4,4,4,4};
        System.out.println(obj.containsPattern(arr1, 1, 3)); 
        // Expected Output: true

        // Example 2
        int[] arr2 = {1,2,1,2,1,1,1,3};
        System.out.println(obj.containsPattern(arr2, 2, 2)); 
        // Expected Output: true

        // Example 3
        int[] arr3 = {1,2,1,2,1,3};
        System.out.println(obj.containsPattern(arr3, 2, 3)); 
        // Expected Output: false
    }
}