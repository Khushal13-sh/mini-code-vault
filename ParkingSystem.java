/**
 * Problem: Design Parking System
 * Difficulty: Easy
 * 
 * Description:
 * Simulate a parking lot with limited spaces for big, medium, and small cars.
 * The system should support initializing with fixed space counts and
 * adding cars of specific types.
 *
 * ✅ Constraints:
 * - carType: 1 -> big, 2 -> medium, 3 -> small
 * - Return true if the car fits, otherwise false
 * - Up to 1000 calls to addCar
 */

public class ParkingSystem {

    private int big;
    private int medium;
    private int small;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        return (carType == 1 && big-- > 0) ||
               (carType == 2 && medium-- > 0) ||
               (carType == 3 && small-- > 0);
    }

    // Optional test main method
    public static void main(String[] args) {
        ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
        System.out.println(parkingSystem.addCar(1)); // true
        System.out.println(parkingSystem.addCar(2)); // true
        System.out.println(parkingSystem.addCar(3)); // false
        System.out.println(parkingSystem.addCar(1)); // false
    }
}
