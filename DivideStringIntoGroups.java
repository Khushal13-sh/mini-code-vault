/**
 * ------------------------------------------------------------
 * Class Name : DivideStringIntoGroups
 *
 * Description :
 * Divides a string into groups of size k.
 * If the last group is incomplete, it is filled
 * with the given fill character.
 *
 * ------------------------------------------------------------
 */
public class DivideStringIntoGroups {

    /**
     * Returns the grouped string array.
     */
    public String[] divideString(String s, int k, char fill) {
        int length = s.length();

        // Calculate number of groups needed
        int groups;
        if (length % k == 0) {
            groups = length / k;
        } else {
            groups = (length / k) + 1;
        }

        String[] result = new String[groups];
        int index = 0;

        // Build each group
        for (int i = 0; i < groups; i++) {

            String group = "";

            for (int j = 0; j < k; j++) {
                if (index < length) {
                    group = group + s.charAt(index);
                    index++;
                } else {
                    group = group + fill;
                }
            }

            result[i] = group;
        }

        return result;
    }

    /**
     * Test cases.
     */
    public static void main(String[] args) {
        DivideStringIntoGroups solution = new DivideStringIntoGroups();

        print(solution.divideString("abcdefghi", 3, 'x'));
        print(solution.divideString("abcdefghij", 3, 'x'));
    }

    private static void print(String[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("\"" + arr[i] + "\"");
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
