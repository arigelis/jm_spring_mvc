package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    public static List<Car> tmpCars = new ArrayList<>();
    //В условии задачи не говорилось что нужно делать базу и подключать CRUDjpa)
    @Override
    public List<Car> getCars() {
        if (tmpCars.size() < 3) {
            tmpCars.add(new Car(1L, "BMW", 5));
            tmpCars.add(new Car(2L, "Mercedes", 2));
            tmpCars.add(new Car(3L, "Horse", 11));
        }
        return tmpCars;
    }

    @Override
    public void addCar(Car car) {
        tmpCars.add(car);
    }


}
