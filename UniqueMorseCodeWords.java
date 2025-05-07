/**
 * Problem Title: Unique Morse Code Words
 * Difficulty: Easy
 * 
 * ✅ Problem Description:
 * International Morse Code maps each letter to a series of dots and dashes:
 * - Example: 'a' -> ".-", 'b' -> "-...", 'c' -> "-.-.", etc.
 * 
 * You are given an array of strings 'words', where each word can be written 
 * as a concatenation of the Morse code of each letter. Your task is to find 
 * the number of **unique Morse code transformations** among all words.
 * 
 * 🔹 Important:
 * - Use only lowercase English letters.
 * 
 * 📥 Example 1:
 * Input:  words = ["gin", "zen", "gig", "msg"]
 * Output: 2
 * Explanation:
 * - "gin" -> "--...-."
 * - "zen" -> "--...-."
 * - "gig" -> "--...--."
 * - "msg" -> "--...--."
 * - Unique transformations: 2 ("--...-.", "--...--.")
 * 
 * 📥 Example 2:
 * Input:  words = ["a"]
 * Output: 1
 * 
 * 📌 Constraints:
 * - 1 <= words.length <= 100
 * - 1 <= words[i].length <= 12
 * - words[i] consists of lowercase English letters only.
 */

import java.util.*;

public class UniqueMorseCodeWords {

    /**
     * 🧠 Logic:
     * - Map each letter to its Morse code using an array.
     * - For each word, build its Morse code transformation.
     * - Store unique transformations using a HashSet.
     */
    public static int uniqueMorseRepresentations(String[] words) {
        // Step 1: Morse code for each alphabet ('a' to 'z')
        String[] morseOfAlph = {
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", 
            "....", "..", ".---", "-.-", ".-..", "--", "-.", 
            "---", ".--.", "--.-", ".-.", "...", "-", "..-", 
            "...-", ".--", "-..-", "-.--", "--.."
        };

        // Step 2: Use HashSet to store unique Morse transformations
        Set<String> uniqueMorse = new HashSet<>();

        // Step 3: Transform each word and add to the set
        for (String word : words) {
            StringBuilder morseWord = new StringBuilder();
            for (char ch : word.toCharArray()) {
                morseWord.append(morseOfAlph[ch - 'a']);  // Get Morse code for the character
            }
            uniqueMorse.add(morseWord.toString());  // Add transformed word to set
        }

        // Return the count of unique transformations
        return uniqueMorse.size();
    }

    // 🧪 Main method to test the logic
    public static void main(String[] args) {
        String[] words1 = {"gin", "zen", "gig", "msg"};
        System.out.println("Unique Morse Transformations: " + uniqueMorseRepresentations(words1));  // Expected: 2

        String[] words2 = {"a"};
        System.out.println("Unique Morse Transformations: " + uniqueMorseRepresentations(words2));  // Expected: 1
    }
}
