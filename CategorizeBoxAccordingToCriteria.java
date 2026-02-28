/**
 * ------------------------------------------------------------
 * Class Name : CategorizeBoxAccordingToCriteria
 *
 * Description :
 * Determines whether a box is Bulky, Heavy,
 * Both, or Neither based on dimensions and mass.
 *
 * ------------------------------------------------------------
 */
public class CategorizeBoxAccordingToCriteria {

    /**
     * Returns box category.
     */
    public String categorizeBox(int length, int width,
                                int height, int mass) {

        boolean bulky = false;
        boolean heavy = false;

        long volume = 1L * length * width * height;

        // Check Bulky condition
        if (length >= 10000 || width >= 10000 ||
            height >= 10000 || volume >= 1_000_000_000L) {
            bulky = true;
        }

        // Check Heavy condition
        if (mass >= 100) {
            heavy = true;
        }

        // Final category
        if (bulky && heavy) return "Both";
        if (bulky) return "Bulky";
        if (heavy) return "Heavy";

        return "Neither";
    }

    /**
     * Test cases.
     */
    public static void main(String[] args) {

        CategorizeBoxAccordingToCriteria solution =
                new CategorizeBoxAccordingToCriteria();

        System.out.println(
            solution.categorizeBox(1000, 35, 700, 300)
        ); // Heavy

        System.out.println(
            solution.categorizeBox(200, 50, 800, 50)
        ); // Neither
    }
}