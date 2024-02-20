import java.util.Arrays;

public class Dealership {
    
    private Car[] cars;


    public Dealership(Car[] cars) {
        this.cars = new Car[cars.length];
        for (int i = 0; i < cars.length; i++) {
            this.cars[i] = new Car((cars[i]));
        }
    }

    public void sell(int index){
        this.cars[index].drive();
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < this.cars.length; i++) {
            temp += "Parking Spot: " + i + "\n";
            String carDescription = this.cars[i].toString();
            temp += carDescription + "\n";
        }
        return temp;
    }

    // Deep Copying
    public Car getCar(int index) {
        Car copy = new Car(this.cars[index]);
        return copy;
    }

    public void setCar(int index, Car newCar) {
        // copy constructor
        Car copy = new Car(newCar);
        this.cars[index] = copy;
    }

        
    

}