package model;

import java.util.ArrayList;

public class CarDealership {
    private ArrayList<Car> cars;

    public CarDealership(){
        this.cars = new ArrayList<>();
    }

    public Car getCar(int index){
        return new Car(this.cars.get(index));
    }

    public void setCar(Car car, int index) {
        this.cars.set(index, new Car(car));
    }

    public void addCar(Car newCar) {
        this.cars.add(new Car(newCar));
    }
}