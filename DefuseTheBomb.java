import java.util.Arrays;

/**
 * Problem: Defuse the Bomb
 * Difficulty: Easy
 *
 * For each element, sum the next k (if k > 0) or previous k (if k < 0) elements,
 * considering the array as circular.
 * If k == 0, all values become 0.
 */

public class DefuseTheBomb {

    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] result = new int[n];

        if (k == 0) return result;

        for (int i = 0; i < n; i++) {
            int sum = 0;

            if (k > 0) {
                for (int j = 1; j <= k; j++) {
                    sum += code[(i + j) % n];
                }
            } else {
                for (int j = 1; j <= -k; j++) {
                    sum += code[(i - j + n) % n]; // wrap around left
                }
            }

            result[i] = sum;
        }

        return result;
    }

    public static void main(String[] args) {
        DefuseTheBomb solution = new DefuseTheBomb();

        int[] code1 = {5, 7, 1, 4}, code2 = {1, 2, 3, 4}, code3 = {2, 4, 9, 3};

        System.out.println(Arrays.toString(solution.decrypt(code1, 3)));  // Output: [12, 10, 16, 13]
        System.out.println(Arrays.toString(solution.decrypt(code2, 0)));  // Output: [0, 0, 0, 0]
        System.out.println(Arrays.toString(solution.decrypt(code3, -2))); // Output: [12, 5, 6, 13]
    }
}
