package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarServiceImp;
import java.util.List;

@Controller
public class CarController {

    private final CarServiceImp carService;

    @Autowired
    public CarController(CarServiceImp carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String showListCars(@RequestParam(value = "count", required = false, defaultValue = "5") int count, Model model) {

        List<Car> carList = carService.getCarList(count);
        model.addAttribute("carList", carList);

        return "cars";
    }
}