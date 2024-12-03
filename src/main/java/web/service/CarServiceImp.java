package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImp implements CarService {

    private final List<Car> carList = new ArrayList<>();

    public CarServiceImp() {
        carList.add(new Car("model1", "color1", 1));
        carList.add(new Car("model2", "color2", 2));
        carList.add(new Car("model3", "color3", 3));
        carList.add(new Car("model4", "color4", 4));
        carList.add(new Car("model5", "color5", 5));
    }

    @Override
    public List<Car> getCarList(int count) {

        if (count >= 5 || count < 0) {
            return carList;
        } else {
            return carList.stream().limit(count).toList();
        }
    }
}