/**
 * Problem Title: Strong Password Checker II
 * Difficulty: Easy
 * 
 * ✅ Problem Description:
 * A password is considered strong if it satisfies all the following criteria:
 * 1. At least 8 characters.
 * 2. At least one lowercase letter.
 * 3. At least one uppercase letter.
 * 4. At least one digit.
 * 5. At least one special character from "!@#$%^&*()-+".
 * 6. No adjacent repeating characters.
 * 
 * 💡 Task:
 * Given a string password, return true if it is strong, otherwise return false.
 * 
 * 📥 Example 1:
 * Input: password = "IloveLe3tcode!"
 * Output: true
 * 
 * 📥 Example 2:
 * Input: password = "Me+You--IsMyDream"
 * Output: false
 * 
 * 📥 Example 3:
 * Input: password = "1aB!"
 * Output: false
 * 
 * 📌 Constraints:
 * - 1 <= password.length <= 100
 * - password consists of letters, digits, and special characters: "!@#$%^&*()-+"
 */

public class StrongPasswordCheckerII {

    /**
     * 🧠 Logic:
     * 1. Check if the password length is at least 8.
     * 2. Iterate through each character to verify:
     *    - At least one lowercase letter.
     *    - At least one uppercase letter.
     *    - At least one digit.
     *    - At least one special character.
     *    - No adjacent repeating characters.
     * 3. Return true if all conditions are met, otherwise false.
     */
    public boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8) return false;

        boolean hasLower = false, hasUpper = false, hasDigit = false, hasSpecial = false;
        String specialChars = "!@#$%^&*()-+";

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);

            if (Character.isLowerCase(ch)) hasLower = true;
            if (Character.isUpperCase(ch)) hasUpper = true;
            if (Character.isDigit(ch)) hasDigit = true;
            if (specialChars.indexOf(ch) != -1) hasSpecial = true;

            // Check for adjacent repeating characters
            if (i > 0 && password.charAt(i) == password.charAt(i - 1)) return false;
        }

        // Return true if all criteria are met
        return hasLower && hasUpper && hasDigit && hasSpecial;
    }

    // 🧪 Main method to test the logic
    public static void main(String[] args) {
        StrongPasswordCheckerII solution = new StrongPasswordCheckerII();

        // Test cases
        String[] testPasswords = {"IloveLe3tcode!", "Me+You--IsMyDream", "1aB!", "aA1!aA1!"};
        for (String password : testPasswords) {
            System.out.println("Password: \"" + password + "\" -> " + solution.strongPasswordCheckerII(password));
        }
    }
}
