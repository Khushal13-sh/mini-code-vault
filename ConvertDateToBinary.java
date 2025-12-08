/**
 * Problem: Convert Date to Binary
 * Difficulty: Easy
 *
 * Convert the year, month, and day of the given date (yyyy-mm-dd format)
 * into their binary representations without leading zeros, and return them
 * in the format: binaryYear-binaryMonth-binaryDay.
 */

public class ConvertDateToBinary {

    public String convertDateToBinary(String date) {
        String[] parts = date.split("-");

        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);

        String yearBin = Integer.toBinaryString(year);
        String monthBin = Integer.toBinaryString(month);
        String dayBin = Integer.toBinaryString(day);

        return yearBin + "-" + monthBin + "-" + dayBin;
    }

    public static void main(String[] args) {
        ConvertDateToBinary solution = new ConvertDateToBinary();

        System.out.println(solution.convertDateToBinary("2080-02-29")); // Output: 100000100000-10-11101
        System.out.println(solution.convertDateToBinary("1900-01-01")); // Output: 11101101100-1-1
    }
}
