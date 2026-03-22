/**
 * ------------------------------------------------------------
 * Problem : Latest Time by Replacing Hidden Digits
 * Class   : LatestTimeGenerator
 * ------------------------------------------------------------
 */

public class LatestTimeGenerator {

    public String maximumTime(String time) {

        char[] t = time.toCharArray();

        // Handle hour first digit
        if (t[0] == '?') {
            if (t[1] == '?' || t[1] <= '3') {
                t[0] = '2';
            } else {
                t[0] = '1';
            }
        }

        // Handle hour second digit
        if (t[1] == '?') {
            if (t[0] == '2') {
                t[1] = '3';
            } else {
                t[1] = '9';
            }
        }

        // Handle minutes
        if (t[3] == '?') {
            t[3] = '5';
        }

        if (t[4] == '?') {
            t[4] = '9';
        }

        return new String(t);
    }

    public static void main(String[] args) {

        LatestTimeGenerator obj = new LatestTimeGenerator();

        // Example 1
        System.out.println("Output: " + obj.maximumTime("2?:?0"));
        // Expected: 23:50

        // Example 2
        System.out.println("Output: " + obj.maximumTime("0?:3?"));
        // Expected: 09:39

        // Example 3
        System.out.println("Output: " + obj.maximumTime("1?:22"));
        // Expected: 19:22
    }
}