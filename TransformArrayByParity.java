/**
 * Problem: Check If Digits Are Equal in String After Operations I
 * Difficulty: Easy
 *
 * Given a string s consisting of digits, repeatedly perform the following:
 *  - For each pair of consecutive digits, compute (digit1 + digit2) % 10.
 *  - Replace the string with the sequence of these new digits.
 * Continue until only two digits remain.
 *
 * Return true if the final two digits are equal, otherwise false.
 */

public class TransformArrayByParity {
    public int[] transformArray(int[] nums) {
        // Step 1: Replace evens with 0 and odds with 1
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0)
                nums[i] = 0;
            else
                nums[i] = 1;
        }

        // Step 2: Sort using bubble sort (valid for small arrays)
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        return nums;
    }

    // --- test ---
    public static void main(String[] args) {
        TransformArrayByParity sol = new TransformArrayByParity();
        System.out.println(Arrays.toString(sol.transformArray(new int[]{4, 3, 2, 1}))); // [0, 0, 1, 1]
        System.out.println(Arrays.toString(sol.transformArray(new int[]{1, 5, 1, 4, 2}))); // [0, 0, 1, 1, 1]
    }
}
