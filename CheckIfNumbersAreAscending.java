/**
 * Problem: Check if Numbers Are Ascending in a Sentence
 * Difficulty: Easy
 *
 * A sentence contains words and numbers (positive, no leading zeros).
 * Return true if all numbers in the sentence appear in strictly increasing order.
 */

public class CheckIfNumbersAreAscending {
    public boolean areNumbersAscending(String s) {
        int prev = 0;
        StringBuilder number = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                number.append(ch);
            } else {
                if (number.length() > 0) {
                    int curr = Integer.parseInt(number.toString());
                    if (curr <= prev) return false;
                    prev = curr;
                    number.setLength(0); // reset
                }
            }
        }

        // Handle the last number if the sentence ends with a digit
        if (number.length() > 0) {
            int curr = Integer.parseInt(number.toString());
            if (curr <= prev) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        CheckIfNumbersAreAscending solution = new CheckIfNumbersAreAscending();

        String s1 = "1 box has 3 blue 4 red 6 green and 12 yellow marbles";
        String s2 = "hello world 5 x 5";
        String s3 = "sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s";

        System.out.println(solution.areNumbersAscending(s1)); // true
        System.out.println(solution.areNumbersAscending(s2)); // false
        System.out.println(solution.areNumbersAscending(s3)); // false
    }
}
