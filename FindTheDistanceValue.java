/**
 * Problem: Find the Distance Value Between Two Arrays
 * Difficulty: Easy
 *
 * For each element in arr1, check if all elements in arr2 are at a distance > d.
 * If yes, count that element.
 */

public class FindTheDistanceValue {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;

        for (int num1 : arr1) {
            boolean isValid = true;
            for (int num2 : arr2) {
                if (Math.abs(num1 - num2) <= d) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        FindTheDistanceValue solution = new FindTheDistanceValue();

        int[] arr1_1 = {4, 5, 8}, arr2_1 = {10, 9, 1, 8}; int d1 = 2;
        int[] arr1_2 = {1, 4, 2, 3}, arr2_2 = {-4, -3, 6, 10, 20, 30}; int d2 = 3;
        int[] arr1_3 = {2, 1, 100, 3}, arr2_3 = {-5, -2, 10, -3, 7}; int d3 = 6;

        System.out.println(solution.findTheDistanceValue(arr1_1, arr2_1, d1)); // Output: 2
        System.out.println(solution.findTheDistanceValue(arr1_2, arr2_2, d2)); // Output: 2
        System.out.println(solution.findTheDistanceValue(arr1_3, arr2_3, d3)); // Output: 1
    }
}
