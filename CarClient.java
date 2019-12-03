public class CarClient {
    public static void main(String[] args) {
        Car car1 = new Car("Honda", "Accord", 0, 22.0);
        Car car2 = new Car("Ford", "Truck", 20, 14.5);
        Car car3 = new Car("Chevy", "Malibu", 25.2, 18.4);

        System.out.println(car1.toString() + " has driven "+ car1.getMilesDriven() + " miles.");
        car1.drive(10);
        car1.addFuel(10.5);
        car1.getFuel();
        car1.drive(25.1);
        System.out.println(car1.toString() + " has driven "+ car1.getMilesDriven() + " miles.");

        System.out.println();

        System.out.println(car2.toString() + " has "+car2.getFuel() + " gallons in its tank.");
        car2.drive(20.1);
        System.out.println(car2.toString() + " has "+car2.getFuel() + " gallons in its tank.");

        System.out.println();

        System.out.println("Car Three is a " + car3.toString());

    }
}
