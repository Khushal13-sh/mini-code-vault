import java.util.Arrays;
import java.util.Comparator;

/**
 * Problem: Sort Integers by Binary Reflection
 * Difficulty: Easy
 *
 * Sort integers based on their binary reflection.
 * If reflections are equal, sort by original value.
 */
public class SortIntegersByBinaryReflection {

    public int[] sortByReflection(int[] nums) {
        Integer[] arr = new Integer[nums.length];

        // Convert int[] to Integer[]
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }

        // Custom sorting
        Arrays.sort(arr, new Comparator<Integer>() {
            public int compare(Integer x, Integer y) {
                int rx = binaryReflection(x);
                int ry = binaryReflection(y);

                if (rx != ry) {
                    return rx - ry;
                }
                return x - y;
            }
        });

        // Copy back to original array
        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[i];
        }

        return nums;
    }

    // Compute binary reflection
    private int binaryReflection(int n) {
        int reflected = 0;

        while (n > 0) {
            reflected = reflected * 2 + (n % 2);
            n /= 2;
        }
        return reflected;
    }

    // Main method for testing
    public static void main(String[] args) {
        SortIntegersByBinaryReflection obj =
                new SortIntegersByBinaryReflection();

        int[] nums1 = {4, 5, 4};
        System.out.println(Arrays.toString(
                obj.sortByReflection(nums1))); // [4, 4, 5]

        int[] nums2 = {3, 6, 5, 8};
        System.out.println(Arrays.toString(
                obj.sortByReflection(nums2))); // [8, 3, 6, 5]
    }
}
