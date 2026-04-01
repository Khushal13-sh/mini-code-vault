/*
 add solution for defanging an IP address using string builder approach
*/

/**
 * Problem: Defanging an IP Address
 * Difficulty: Easy
 *
 * Description:
 * Given a valid IPv4 address, replace every '.' with '[.]'
 * and return the modified (defanged) string.
 *
 * Approach:
 * - Traverse each character of the string
 * - If character is '.', append "[.]"
 * - Otherwise, append the character as it is
 * - Use StringBuilder for efficient string manipulation
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class DefangingIPAddress {

    public String defangIPaddr(String address) {

        StringBuilder result = new StringBuilder();

        for (char ch : address.toCharArray()) {
            if (ch == '.') {
                result.append("[.]");
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        DefangingIPAddress obj = new DefangingIPAddress();

        // Example 1
        String address1 = "1.1.1.1";
        System.out.println("Output 1: " + obj.defangIPaddr(address1)); // 1[.]1[.]1[.]1

        // Example 2
        String address2 = "255.100.50.0";
        System.out.println("Output 2: " + obj.defangIPaddr(address2)); // 255[.]100[.]50[.]0
    }
}