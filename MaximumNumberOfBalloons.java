/**
 * Problem: Maximum Number of Balloons
 * Difficulty: Easy
 *
 * Determine the maximum number of times the word "balloon"
 * can be formed using characters from the given string.
 */
public class MaximumNumberOfBalloons {

    public int maxNumberOfBalloons(String text) {

        int b = 0, a = 0, l = 0, o = 0, n = 0;

        // Count required characters
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch == 'b') b++;
            else if (ch == 'a') a++;
            else if (ch == 'l') l++;
            else if (ch == 'o') o++;
            else if (ch == 'n') n++;
        }

        // 'l' and 'o' are required twice
        l /= 2;
        o /= 2;

        // Find minimum count
        int min = b;
        if (a < min) min = a;
        if (l < min) min = l;
        if (o < min) min = o;
        if (n < min) min = n;

        return min;
    }

    // Main method for testing
    public static void main(String[] args) {
        MaximumNumberOfBalloons obj = new MaximumNumberOfBalloons();

        System.out.println(obj.maxNumberOfBalloons("nlaebolko"));        // 1
        System.out.println(obj.maxNumberOfBalloons("loonbalxballpoon")); // 2
        System.out.println(obj.maxNumberOfBalloons("leetcode"));         // 0
    }
}
