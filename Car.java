public class Car {
    private String make;
    private String model;

    private double fuelInTank;
    private double mpg;

    private double milesDriven = 0;

    public Car(){
        make = "";
        model = "";
        fuelInTank = 0;
        mpg = 0;
    }

    public Car(String Make, String Model, double FuelInTank, double MPG){
        make = Make;
        model = Model;
        fuelInTank = FuelInTank;
        mpg = MPG;
    }

    public void drive(double miles){
        double gallons = miles / mpg;

        if (gallons > fuelInTank){
            System.out.println("Not enough fuel in " + toString());
            return;
        }

        else{
            fuelInTank -= gallons;
            milesDriven += miles;
        }
    }

    public void addFuel(double gallons){
        fuelInTank += gallons;
    }


    public double getFuel(){
        return fuelInTank;
    }

    public double getMilesDriven(){
        return milesDriven;
    }

    public String toString(){
        return make + " " + model;
    }
}
