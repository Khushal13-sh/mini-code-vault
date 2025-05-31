/**
 * Problem: Unique Email Addresses
 * Difficulty: Easy
 *
 * 🧠 Description:
 * Every email has a local part and domain part, separated by '@'.
 * Rules:
 * 1. In the local name, ignore dots ('.').
 * 2. In the local name, ignore everything after '+'.
 * 3. Domain remains unchanged.
 *
 * Return the count of unique actual email addresses that receive mails.
 *
 * 📥 Example:
 * Input: ["test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"]
 * Output: 2
 */

import java.util.*;

public class UniqueEmailAddresses {

    public static int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();

        for (String email : emails) {
            String[] parts = email.split("@");
            String local = parts[0];
            String domain = parts[1];

            // Remove everything after '+' and remove all '.'
            int plusIndex = local.indexOf('+');
            if (plusIndex != -1) {
                local = local.substring(0, plusIndex);
            }
            local = local.replace(".", "");

            uniqueEmails.add(local + "@" + domain);
        }

        return uniqueEmails.size();
    }

    // 🧪 Test the solution
    public static void main(String[] args) {
        String[] emails1 = {
            "test.email+alex@leetcode.com",
            "test.e.mail+bob.cathy@leetcode.com",
            "testemail+david@lee.tcode.com"
        };

        String[] emails2 = {
            "a@leetcode.com", "b@leetcode.com", "c@leetcode.com"
        };

        System.out.println(numUniqueEmails(emails1)); // Output: 2
        System.out.println(numUniqueEmails(emails2)); // Output: 3
    }
}
