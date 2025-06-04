/**
 * Problem: Shuffle the Array
 * Difficulty: Easy
 *
 * 🧠 Description:
 * Given an array nums of the form [x1,x2,...,xn,y1,y2,...,yn],
 * return the array in the form [x1,y1,x2,y2,...,xn,yn].
 *
 * 🧪 Example:
 * Input: nums = [2,5,1,3,4,7], n = 3
 * Output: [2,3,5,4,1,7]
 */

import java.util.Arrays;

public class ShuffleTheArray {

    public static int[] shuffle(int[] nums, int n) {
        int[] result = new int[nums.length];
        int index = 0;

        for (int i = 0; i < n; i++) {
            result[index++] = nums[i];     // x_i
            result[index++] = nums[i + n]; // y_i
        }

        return result;
    }

    public static void main(String[] args) {
        int[] input1 = {2, 5, 1, 3, 4, 7};
        int[] input2 = {1, 2, 3, 4, 4, 3, 2, 1};
        int[] input3 = {1, 1, 2, 2};

        System.out.println(Arrays.toString(shuffle(input1, 3))); // [2, 3, 5, 4, 1, 7]
        System.out.println(Arrays.toString(shuffle(input2, 4))); // [1, 4, 2, 3, 3, 2, 4, 1]
        System.out.println(Arrays.toString(shuffle(input3, 2))); // [1, 2, 1, 2]
    }
}
