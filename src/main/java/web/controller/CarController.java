package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.Car;
import web.service.CarService;

import java.util.List;

@Controller
public class CarController {
    private static List<Car> tmpCars;
    @Autowired
    private CarService carService;

    @GetMapping(value = "/cars")
    public String printCars(ModelMap model, @RequestParam("locale") String locale) {
        if (locale.equalsIgnoreCase("ru")) {
            model.addAttribute("message", "МАШИНЫ");
        } else {
            model.addAttribute("message", "CARS");
        }
        model.addAttribute("cars", carService.getCars());
        return "carsList";
    }

    @RequestMapping(value = "/saveCar", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute Car car, BindingResult errors, Model model) {
        tmpCars.add(car);
        return "OK!";
    }
}