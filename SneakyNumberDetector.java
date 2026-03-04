/**
 * ------------------------------------------------------------
 * Problem : The Two Sneaky Numbers of Digitville
 * Class   : SneakyNumberDetector
 * ------------------------------------------------------------
 */
class SneakyNumberDetector {

    public int[] getSneakyNumbers(int[] nums) {

        int n = nums.length - 2;  // original size
        boolean[] seen = new boolean[n];

        int[] result = new int[2];
        int index = 0;

        for (int num : nums) {

            if (seen[num]) {
                result[index++] = num;  // duplicate found
            } else {
                seen[num] = true;
            }
        }

        return result;
    }
}