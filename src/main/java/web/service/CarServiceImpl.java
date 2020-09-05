package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Override
    public List<Car> getCars() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(1L, "BMW", 5));
        cars.add(new Car(2L, "Mercedes", 2));
        cars.add(new Car(3L, "Horse", 11));
        return cars;
    }
}
