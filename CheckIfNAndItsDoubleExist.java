import java.util.HashSet;
import java.util.Set;

/**
 * Problem: Check If N and Its Double Exist
 * Difficulty: Easy
 *
 * Check whether there exist indices i and j such that
 * arr[i] == 2 * arr[j] and i != j.
 */
public class CheckIfNAndItsDoubleExist {

    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();

        for (int num : arr) {

            // Check if double or half already exists
            if (set.contains(2 * num)
                    || (num % 2 == 0 && set.contains(num / 2))) {
                return true;
            }

            set.add(num);
        }
        return false;
    }

    // Main method for testing
    public static void main(String[] args) {
        CheckIfNAndItsDoubleExist obj =
                new CheckIfNAndItsDoubleExist();

        int[] arr1 = {10, 2, 5, 3};
        System.out.println(obj.checkIfExist(arr1)); // true

        int[] arr2 = {3, 1, 7, 11};
        System.out.println(obj.checkIfExist(arr2)); // false
    }
}
