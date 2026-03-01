/**
 * ------------------------------------------------------------
 * Class Name : CouponCodeValidator
 *
 * Description :
 * Validates coupon codes based on format,
 * business category, and active status.
 * Returns sorted valid coupon codes.
 *
 * ------------------------------------------------------------
 */
import java.util.*;

public class CouponCodeValidator {

    /**
     * Returns list of valid coupon codes.
     */
    public List<String> validateCoupons(String[] code,
                                         String[] businessLine,
                                         boolean[] isActive) {

        List<String> order = Arrays.asList(
                "electronics",
                "grocery",
                "pharmacy",
                "restaurant"
        );

        Set<String> validBusiness = new HashSet<>(order);

        Map<String, List<String>> map = new HashMap<>();
        for (String b : order) {
            map.put(b, new ArrayList<>());
        }

        for (int i = 0; i < code.length; i++) {

            if (!isActive[i]) continue;

            String c = code[i];
            String b = businessLine[i];

            if (c == null || c.isEmpty()) continue;
            if (!c.matches("[a-zA-Z0-9_]+")) continue;
            if (!validBusiness.contains(b)) continue;

            map.get(b).add(c);
        }

        List<String> result = new ArrayList<>();

        for (String b : order) {
            List<String> list = map.get(b);
            Collections.sort(list);
            result.addAll(list);
        }

        return result;
    }

    /**
     * Test cases.
     */
    public static void main(String[] args) {

        CouponCodeValidator solution =
                new CouponCodeValidator();

        String[] code = {"SAVE20","","PHARMA5","SAVE@20"};
        String[] business = {"restaurant","grocery",
                             "pharmacy","restaurant"};
        boolean[] active = {true,true,true,true};

        System.out.println(
            solution.validateCoupons(code, business, active)
        );
    }
}