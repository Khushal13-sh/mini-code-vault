import java.util.*;

public class ReformatString {
    public static String reformat(String s) {
        List<Character> letters = new ArrayList<>();
        List<Character> digits = new ArrayList<>();

        // Separate letters and digits
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                letters.add(c);
            } else {
                digits.add(c);
            }
        }

        // Impossible if the difference is more than 1
        if (Math.abs(letters.size() - digits.size()) > 1) {
            return "";
        }

        // Ensure letters list is the larger one (or either if equal)
        if (digits.size() > letters.size()) {
            List<Character> temp = letters;
            letters = digits;
            digits = temp;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                sb.append(letters.remove(0));
            } else {
                sb.append(digits.remove(0));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reformat("a0b1c2"));     // Possible: "a0b1c2" or "0a1b2c"
        System.out.println(reformat("leetcode"));   // Output: ""
        System.out.println(reformat("1229857369")); // Output: ""
        System.out.println(reformat("ab123"));      // Example: "a1b2" or "1a2b3"
        System.out.println(reformat("a"));          // Output: "a"
    }
}
