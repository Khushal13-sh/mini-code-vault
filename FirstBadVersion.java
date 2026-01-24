/**
 * ------------------------------------------------------------
 * Class Name : FirstBadVersion
 *
 * Description :
 * Uses Binary Search to find the first bad version among n versions
 * while minimizing API calls.
 *
 * ------------------------------------------------------------
 */
public class FirstBadVersion extends VersionControl {

    /**
     * Returns the first bad version number.
     */
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                right = mid;      // first bad is at mid or before
            } else {
                left = mid + 1;   // first bad is after mid
            }
        }
        return left;
    }

    /**
     * Test cases (API simulation).
     */
    public static void main(String[] args) {
        FirstBadVersion solution = new FirstBadVersion();

        solution.setBadVersion(4);
        System.out.println("Example 1 Output: " + solution.firstBadVersion(5)); // 4

        solution.setBadVersion(1);
        System.out.println("Example 2 Output: " + solution.firstBadVersion(1)); // 1
    }
}

/**
 * Simulated VersionControl class for local testing.
 */
class VersionControl {
    private int bad;

    void setBadVersion(int bad) {
        this.bad = bad;
    }

    boolean isBadVersion(int version) {
        return version >= bad;
    }
}
