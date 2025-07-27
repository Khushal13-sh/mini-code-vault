import java.util.*;

/**
 * Problem: Count Items Matching a Rule
 * Difficulty: Easy
 *
 * Given a list of items where each item is described by [type, color, name],
 * and a rule defined by a key ("type", "color", or "name") and a value,
 * return the count of items that match the rule.
 */

public class CountItemsMatchingRule {

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;

        // Map ruleKey to the corresponding index in the item list
        Map<String, Integer> keyIndexMap = new HashMap<>();
        keyIndexMap.put("type", 0);
        keyIndexMap.put("color", 1);
        keyIndexMap.put("name", 2);

        int index = keyIndexMap.get(ruleKey);

        // Iterate through each item and check if it matches the rule
        for (List<String> item : items) {
            if (item.get(index).equals(ruleValue)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        CountItemsMatchingRule solution = new CountItemsMatchingRule();

        List<List<String>> test1 = Arrays.asList(
            Arrays.asList("phone", "blue", "pixel"),
            Arrays.asList("computer", "silver", "lenovo"),
            Arrays.asList("phone", "gold", "iphone")
        );
        System.out.println(solution.countMatches(test1, "color", "silver")); // Output: 1

        List<List<String>> test2 = Arrays.asList(
            Arrays.asList("phone", "blue", "pixel"),
            Arrays.asList("computer", "silver", "phone"),
            Arrays.asList("phone", "gold", "iphone")
        );
        System.out.println(solution.countMatches(test2, "type", "phone")); // Output: 2
    }
}
