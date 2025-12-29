/**
 * Problem: Mirror Distance of an Integer
 * Difficulty: Easy
 *
 * The mirror distance is defined as:
 * abs(n - reverse(n))
 */
public class MirrorDistanceOfAnInteger {

    public int mirrorDistance(int n) {
        int reversed = 0;
        int temp = n;

        // Reverse the digits of n
        while (temp != 0) {
            int digit = temp % 10;
            reversed = reversed * 10 + digit;
            temp /= 10;
        }

        int difference = n - reversed;

        // Return absolute value
        if (difference < 0) {
            difference = -difference;
        }

        return difference;
    }

    // Main method for testing
    public static void main(String[] args) {
        MirrorDistanceOfAnInteger obj =
                new MirrorDistanceOfAnInteger();

        System.out.println(obj.mirrorDistance(25)); // 27
        System.out.println(obj.mirrorDistance(10)); // 9
        System.out.println(obj.mirrorDistance(7));  // 0
    }
}
