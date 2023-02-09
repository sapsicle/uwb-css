public class Car {
    private long odometer;
    private String make, model;

    public static void main(String[] args) {
        Car car1 = new Car();
        System.out.println(car1.toString());
        System.out.println(car1.thisToString());

        Car car2 = new Car("Toyota", "Corolla", 60_000);
        System.out.println(car2.toString());
        System.out.println(car2.thisToString());

        // the objects themselves are stored at the same memory address because they're the same object type
        // instance variables are stored elsewhere

        Car car3 = new Car("Chevy");

        Car car4 = new Car("Volvo", "XC90");
    }

    public Car(String make, String model, long odometer) {
        this.make = make;
        this.model = model;
        this.odometer = odometer;
    }

    public Car(String make) {
        this.make = make;
    }

    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public Car() {
        this.make = "Honda";
        this.model = "Civic";
        this.odometer = 0;
    }

    public String thisToString() {
        return this.toString();
    }
    
    @Override
    public String toString() {
        return "This car is a " + make + " " + model + " with " + odometer + " miles on it";
    }

    @Override
    public boolean equals(Object objIn) {
        if (objIn == null) return false;
        
        if (this.getClass() == objIn.getClass()) {
            return true;
        } else {
            return false;
        }
    }
}
