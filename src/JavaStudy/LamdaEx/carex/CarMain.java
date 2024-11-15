package JavaStudy.LamdaEx.carex;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class CarMain {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        for(int i=0;i<5;i++){
            cars.add(new Car("no"+i,true));
        }
        List<Car> diseselCars = findCars(cars,c->c.isGasoline());
        System.out.println(diseselCars);
    }
    public static List<Car> findCars(List<Car> cars, Predicate<Car> cp) {
        List<Car> carsFound = new ArrayList<Car>();
        for (Car car : cars) {
            if (cp.test(car)) {
                carsFound.add(car);
            }
        }
        return carsFound;
    }
}
